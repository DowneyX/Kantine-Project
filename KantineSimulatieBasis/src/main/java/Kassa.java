import java.util.Iterator;
import java.util.Stack;
import java.lang.Math;

public class Kassa {

    // fields
    private int hoeveelheidArtikelen;
    private double hoeveelheidGeld;

    /**
     * Constructor
     * 
     * @param kassarij
     */
    public Kassa() {
        hoeveelheidArtikelen = 0;
        hoeveelheidGeld = 0;

    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de
     * controletotalen die voor de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
        double teBetalen;
        double korting = 0;

        // ask teacher for a better way of doing this. because this is just fucking
        // rediculous
        if (klant.getKlant() instanceof KortingskaartHouder) {
            KortingskaartHouder kortingkaartHouder = (KortingskaartHouder) klant.getKlant();
            korting = getTotaalPrijs(klant) * kortingkaartHouder.geefKortingsPercentage();
            if (kortingkaartHouder.heeftMaximum()) {
                if (korting > kortingkaartHouder.geefMaximum()) {
                    korting = kortingkaartHouder.geefMaximum();
                }
            }
        }
        teBetalen = getTotaalPrijs(klant) - korting;

        try {
            betaalwijze.betaal(teBetalen);
        } catch (TeWeinigGeldException e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("        " + klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam()
                    + "did not have enough money");
        }
        hoeveelheidGeld = Math.round(hoeveelheidGeld + teBetalen);
        hoeveelheidArtikelen += getAantalArtikelen(klant);

    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment
     * dat de methode resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int getHoeveelheidArtikelen() {
        return hoeveelheidArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kassa zijn gepasseerd, vanaf
     * het moment dat de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double getHoeveelheidGeldInKassa() {
        return hoeveelheidGeld;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale
     * hoeveelheid geld in de kassa.
     */
    public void resetKassa() {
        hoeveelheidArtikelen = 0;
        hoeveelheidGeld = 0;
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen(Dienblad klant) {
        Stack<Artikel> artikelen = klant.getArtikelen();
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs(Dienblad klant) {
        double value = 0;
        Stack<Artikel> artikelen = klant.getArtikelen();
        for (Artikel art : artikelen) {
            value += art.getPrijs();
        }
        return value;
    }

}
