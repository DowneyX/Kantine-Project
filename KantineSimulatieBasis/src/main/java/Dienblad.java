import java.util.Stack;

public class Dienblad {

    /**
     * fields
     */
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
     * METHODS
     */

    /**
     * @return the customer
     */
    public Persoon getKlant() {
        return klant;
    }

    /**
     * @param klant the customer to set
     */
    public void setKlant(Persoon klant) {
        this.klant = klant;
    }

    /**
     * method to bind an artikel to a dienblad
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * method the return a stack of artikelen
     * 
     * @return
     */
    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }
}
