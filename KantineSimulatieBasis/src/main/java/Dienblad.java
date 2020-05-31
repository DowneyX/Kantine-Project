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

    public Stack<Artikel> getArtikelen() {
        return artikelen;
    }
}
