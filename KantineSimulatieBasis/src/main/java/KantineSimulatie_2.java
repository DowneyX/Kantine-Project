import java.util.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen = new String[] { "Koffie", "Broodje pindakaas", "Broodje kaas",
            "Appelsap" };

    // prijzen
    private static double[] artikelprijzen = new double[] { 1.50, 2.10, 1.65, 1.65 };

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 12;
    private static final int MAX_ARTIKELEN_PER_SOORT = 21;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    // voornamen
    private String[] voornamen = { "Charlie", "Remy", "Skyler", "Jamie", "Casey", "Rory", "Parker", "Alex", "Riley",
            "Robin", "anne", "noah", "bo" };

    // achternamen
    private String[] achternamen = { "klip", "kant", "van dijk", "leeuwol", "brouwer", "bakker", "smith", "boomstra",
            "hekman", };

    // per dag totaal Omzet
    double[] perDagOmzet = new double[Main.DAGEN];

    // per dag aantal artikelen
    int[] perDagArtikelen = new int[Main.DAGEN];

    // per dag aantal personen
    int[] perDagPersonen = new int[Main.DAGEN];

    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden = getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de
     * gegeven lengte te genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * methode voor een random boolean alue te genereren.
     * 
     * @return
     */
    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de
     * bijhorende array van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];
        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for (int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                // maak persoon en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt

                Persoon persoon = getRandomPerson();
                Dienblad dienblad = new Dienblad(persoon);

                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen array
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN - 1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

                // prints who is taking items + their role
                System.out.println("---------------------------------------------------");
                System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam());
                System.out.println(persoon.toString());
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen

            perDagOmzet[i] = kantine.getKassa().getHoeveelheidGeldInKassa();
            perDagArtikelen[i] = kantine.getKassa().getHoeveelheidArtikelen();
            perDagPersonen[i] = aantalpersonen;

            // prints information about the current day
            printDagInfo(i);

            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }

        // prints all the average numbers of the information gathered during the
        // simulation
        printTotalInfo();
    }

    /**
     * prints all the average numbers of the information gathered during the
     * simulation
     */
    public void printTotalInfo() {

        double[] gemideldeweekdagOmzet = Administratie.berekenDagOmzet(perDagOmzet);
        double gemideldePersonen = Administratie.berekenGemiddeldAantal(perDagPersonen);
        double gemideldeArtikelen = Administratie.berekenGemiddeldAantal(perDagArtikelen);
        double gemideldeOmzet = Administratie.berekenGemiddeldeOmzet(perDagOmzet);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("gemidelde aantal personen           : " + gemideldePersonen);
        System.out.println("gemidelde aantal artikelen verkocht : " + gemideldeArtikelen);
        System.out.println("gemidelde aantal omzet              : " + gemideldeOmzet);
        System.out.println("gemidelde aantal omzet maandag      : " + gemideldeweekdagOmzet[0]);
        System.out.println("gemidelde aantal omzet dinsdag      : " + gemideldeweekdagOmzet[1]);
        System.out.println("gemidelde aantal omzet woensdag     : " + gemideldeweekdagOmzet[2]);
        System.out.println("gemidelde aantal omzet donderdag    : " + gemideldeweekdagOmzet[3]);
        System.out.println("gemidelde aantal omzet vrijdag      : " + gemideldeweekdagOmzet[4]);
        System.out.println("gemidelde aantal omzet zaterdag     : " + gemideldeweekdagOmzet[5]);
        System.out.println("gemidelde aantal omzet zondag       : " + gemideldeweekdagOmzet[6]);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    /**
     * prints information about a specific day
     * 
     * @param dag the day you need information about
     */
    public void printDagInfo(int dag) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("dag:            " + dag + 1);
        System.out.println("geld:           " + perDagOmzet[dag]);
        System.out.println("artikelen:      " + perDagArtikelen[dag]);
        System.out.println("aantal peronen: " + perDagPersonen[dag]);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    /**
     * deze methode zorgt voor een uniek persoon
     * 
     * @return een random persooon
     */
    public Persoon getRandomPerson() {
        Persoon persoon;

        int ocupationChance = getRandomValue(0, 100);
        char geslacht;
        int bsn = getRandomValue(100000000, 999999999);
        String voornaam = voornamen[getRandomValue(0, (voornamen.length - 1))];
        String achternaam = achternamen[getRandomValue(0, (achternamen.length - 1))];
        Datum geboorteDatum = new Datum(12, 12, 2001);

        if (getRandomBoolean()) {
            geslacht = 'M';
        } else {
            geslacht = 'V';
        }

        if (ocupationChance == 100) {
            int employeeNumber = getRandomValue(100, 999);
            boolean isCashier = getRandomBoolean();
            persoon = new kantinemedewerker(bsn, voornaam, achternaam, geboorteDatum, geslacht, employeeNumber,
                    isCashier);
        } else if (ocupationChance >= 90) {
            String acronym = "XXXX";
            String sector = "ICT";
            persoon = new Docent(bsn, voornaam, achternaam, geboorteDatum, geslacht, acronym, sector);
        } else if (ocupationChance <= 89) {
            int studentNumber = getRandomValue(100000, 999999);
            String study = "HBO-ICT:SE";
            persoon = new Student(bsn, voornaam, achternaam, geboorteDatum, geslacht, studentNumber, study);
        } else {
            persoon = new Persoon(bsn, voornaam, achternaam, geboorteDatum, geslacht);
        }
        Betaalwijze betaalwijze = new Contant();
        betaalwijze.setSaldo(6);
        persoon.setBetaalwijze(betaalwijze);
        return persoon;
    }
}
