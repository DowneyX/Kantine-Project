public class Artikel {

    /**
     * FIELDS
     */
    private String naam;
    private double prijs;
    private double korting;

    /**
     * CONSTRUCTOR
     * 
     * @param naam    name of the atikel
     * @param prijs   price of the artikel
     * @param korting value of korting
     */
    public Artikel(String naam, double prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }

    /**
     * METHODS
     */

    /**
     * get the korting value
     * 
     * @return
     */
    public double getKorting() {
        return korting;
    }

    /**
     * sets the value of korting
     * 
     * @param korting
     */
    public void setKorting(double korting) {
        this.korting = korting;
    }

    /**
     * @return the price
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * @return the name
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param prijs the price to set
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    /**
     * @param naam the name to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }
}