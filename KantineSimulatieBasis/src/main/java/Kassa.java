import java.util.Stack;
import java.lang.Math;
import java.time.LocalDate;

public class Kassa {

    /**
     * FIELDS
     */
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
     * METHODS
     */

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de
     * controletotalen die voor de kassa worden bijgehouden. De implementatie wordt
     * later vervangen door een echte betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        Factuur factuur = new Factuur(klant, LocalDate.now());
        Betaalwijze betaalwijze = klant.getKlant().getBetaalwijze();
        double teBetalen = factuur.getTotaal();

        try {
            betaalwijze.betaal(teBetalen);
        } catch (TeWeinigGeldException e) {
            System.out.println(klant.getKlant().getVoornaam() + " " + klant.getKlant().getAchternaam()
                    + " did not have enough money");
            e.getMessage();
            e.printStackTrace();

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

    /**
     * 
     * public double getTotaalPrijs(Dienblad klant) { double value = 0;
     * Stack<Artikel> artikelen = klant.getArtikelen(); for (Artikel art :
     * artikelen) {
     * 
     * double Dagkorting = art.getKorting(); double kaartKorting = 0;
     * 
     * if (Dagkorting == 0) { if (klant.getKlant() instanceof KortingskaartHouder) {
     * KortingskaartHouder kortingkaartHouder = (KortingskaartHouder)
     * klant.getKlant(); double KortingsPercentage =
     * kortingkaartHouder.geefKortingsPercentage(); kaartKorting = art.getPrijs() *
     * KortingsPercentage; if (kortingkaartHouder.heeftMaximum()) { if (kaartKorting
     * > kortingkaartHouder.geefMaximum()) { kaartKorting =
     * kortingkaartHouder.geefMaximum(); } } } value += art.getPrijs() -
     * kaartKorting; } else { value += art.getPrijs() - Dagkorting; } } return
     * value; }
     */

}
