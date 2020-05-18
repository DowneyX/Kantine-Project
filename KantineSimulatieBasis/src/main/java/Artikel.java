public class Artikel {

    // fields
    private String naam;
    private double prijs;

    // constructor
    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    // methods
    /**
     * @return the prijs
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param prijs the prijs to set
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
}