import java.util.Random;

public class KantineSimulatie_1 {

    private Kantine kantine;
    private Random rand;

    // voornamen
    private String[] voornamen = { "Charlie", "Remy", "Skyler", "Jamie", "Casey", "Rory", "Parker", "Alex", "Riley",
            "Robin", "anne", "noah", "bo" };

    // achternamen
    private String[] achternamen = { "klip", "kant", "van dijk", "leeuwol", "brouwer", "bakker", "smith", "boomstra",
            "hekman", };

    /**
     * Constructor
     */
    public KantineSimulatie_1() {
        rand = new Random();
        kantine = new Kantine();
    }

    private int getRandomValue(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    private boolean getRandomBoolean() {
        return rand.nextBoolean();
    }

    /**
     * Deze methode simuleert een aantal dagen in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {

        // herhaal voor elke dag
        for (int i = 0; i < dagen; i++) {

            // per dag nu even vast 10 + i personen naar binnen
            // laten gaan, wordt volgende week veranderd...
            // for lus voor personen

            for (int j = 0; j < (10 + i); j++) {
                Persoon persoon = getRandomPerson();
                Dienblad dienblad = new Dienblad(persoon);
                String[] artikelen = { kantine.getArtikelNaam(getRandomValue(0, kantine.getArtikelNamen().length - 1)),
                        kantine.getArtikelNaam(getRandomValue(0, kantine.getArtikelNamen().length - 1)) };

                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // toon dagtotalen (artikelen en geld in kassa)
            System.out.println("---------------------------------------------------");
            System.out.println("dag:       " + (i + 1));
            System.out.println("geld:      " + kantine.getKassa().getHoeveelheidGeldInKassa());
            System.out.println("artikelen: " + kantine.getKassa().getHoeveelheidArtikelen());

            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }
    }

    /**
     * deze methode zorgt voor een uniek persoon
     * 
     * @return een random persooon
     */
    public Persoon getRandomPerson() {
        char geslacht;
        int bsn = 0;
        String voornaam = voornamen[getRandomValue(0, (voornamen.length - 1))];
        String achternaam = achternamen[getRandomValue(0, (achternamen.length - 1))];
        Datum geboortedatum = new Datum(12, 12, 2001);

        if (getRandomBoolean()) {
            geslacht = 'M';
        } else {
            geslacht = 'V';
        }

        return new Persoon(bsn, voornaam, achternaam, geboortedatum, geslacht);
    }
}
