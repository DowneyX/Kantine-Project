import java.util.ArrayList;
import java.util.Stack;

public class Dienblad {

    // fields
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad(Persoon klant) {
        artikelen = new Stack<Artikel>();
        this.klant = klant;
    }

    /**
     * @return the klant
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * @param klant the klant to set
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double value = 0;
        for (Artikel art : artikelen) {
            value += art.getPrijs();
        }
        return value;
    }
}
