public class Artikel {
    private String naam;
    private double prijs;

    public Artikel(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public double getPrijs() {
        return prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}