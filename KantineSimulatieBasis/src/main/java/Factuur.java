import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;
import java.io.Serializable;

public class Factuur implements Serializable {

    private Long id;
    private LocalDate datum;
    private ArrayList<FactuurRegel> factuurRegels;
    private double korting;
    private double totaal;

    public Factuur() {
        factuurRegels = new ArrayList<FactuurRegel>();
        totaal = 0;
        korting = 0;
    }

    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;
        verwerkBestelling(klant);
    }

    private void verwerkBestelling(Dienblad klant) {
        Stack<Artikel> artikelen = klant.getArtikelen();
        Double totaalZonderKorting = 0.0;
        for (Artikel art : artikelen) {
            double Dagkorting = art.getKorting();
            double kaartKorting = 0;
            factuurRegels.add(new FactuurRegel(this, art));

            if (Dagkorting == 0) {
                if (klant.getKlant() instanceof KortingskaartHouder) {
                    KortingskaartHouder kortingkaartHouder = (KortingskaartHouder) klant.getKlant();
                    double KortingsPercentage = kortingkaartHouder.geefKortingsPercentage();
                    kaartKorting = art.getPrijs() * KortingsPercentage;
                    if (kortingkaartHouder.heeftMaximum()) {
                        if (kaartKorting > kortingkaartHouder.geefMaximum()) {
                            kaartKorting = kortingkaartHouder.geefMaximum();
                        }
                    }
                }
                totaalZonderKorting += art.getPrijs();
                totaal += art.getPrijs() - kaartKorting;
            } else {
                totaalZonderKorting += art.getPrijs();
                totaal += art.getPrijs() - Dagkorting;
            }

        }
        korting = totaal - totaalZonderKorting;
    }

    public double getTotaal() {
        return totaal;
    }

    public double getKorting() {
        return korting;
    }

    public String toString() {
        String output = "";

        return output;
    }
}