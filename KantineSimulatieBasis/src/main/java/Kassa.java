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
        // System.out.println("person checking out");
        hoeveelheidGeld = Math.round(hoeveelheidGeld + getTotaalPrijs(klant));
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
