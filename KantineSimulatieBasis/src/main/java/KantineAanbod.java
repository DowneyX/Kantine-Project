import java.util.*;

public class KantineAanbod {
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, Double> prijzen;
    private HashMap<String, Double> kortingen;

    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen, het tweede
     * argument is eenlijst met prijzen en het derde argument is een lijst met
     * hoeveelheden. Let op: de dimensies van de drie arrays moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid, double[] korting) {
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        startVoorraad = new HashMap<String, Integer>();
        prijzen = new HashMap<String, Double>();
        kortingen = new HashMap<String, Double>();

        for (int i = 0; i < artikelnaam.length; i++) {
            ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
            for (int j = 0; j < hoeveelheid[i]; j++) {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i], korting[i]));
            }
            startVoorraad.put(artikelnaam[i], hoeveelheid[i]);
            prijzen.put(artikelnaam[i], prijs[i]);
            aanbod.put(artikelnaam[i], artikelen);
            kortingen.put(artikelnaam[i], korting[i]);
        }
    }

    private void vulVoorraadAan(String productnaam) {
        ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
        int startHoeveelheid = startVoorraad.get(productnaam);
        int huidigeHoeveelheid = huidigeVoorraad.size();
        double prijs = prijzen.get(productnaam);
        double korting = kortingen.get(productnaam);

        for (int j = huidigeHoeveelheid; j < startHoeveelheid; j++) {
            huidigeVoorraad.add(new Artikel(productnaam, prijs, korting));
        }

        aanbod.put(productnaam, huidigeVoorraad);
    }

    /*
     * Private methode om de lijst van artikelen te krijgen op basis van de naam van
     * het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
        return aanbod.get(productnaam);
    }

    public void addKorting(String productnaam, double kortingPercent) {

        ArrayList<Artikel> artikelen = getArrayList(productnaam);
        Double korting = getArtikel(productnaam).getPrijs() * kortingPercent;
        kortingen.put(productnaam, korting);
        for (Artikel artikel : artikelen) {
            artikel.setKorting(korting);
        }
    }

    public void resetKorting(String productnaam) {
        ArrayList<Artikel> artikelen = getArrayList(productnaam);
        kortingen.put(productnaam, 0.0);
        for (Artikel artikel : artikelen) {
            artikel.setKorting(0);
        }
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken.
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel == null) {
            return null;
        }
        if (stapel.size() == 0) {
            return null;
        } else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            if (stapel.size() <= 10)
                vulVoorraadAan(a.getNaam());
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken. Retouneert
     * null als artikel niet bestaat of niet op voorraad is.
     *
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {

        return getArtikel(getArrayList(productnaam));
    }

    /**
     * @return the startVoorraad
     */
    public HashMap<String, Integer> getStartVoorraad() {
        return startVoorraad;
    }
}
