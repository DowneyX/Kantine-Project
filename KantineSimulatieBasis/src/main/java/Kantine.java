public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa();
    }

    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats deze op het dienblad. Tenslotte
     * sluit de Persoon zich aan bij de rij voor de kassa.
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {

        // prints who is taking items and going to the check out
        System.out.println("---------------------------------------------------");
        System.out.println(dienblad.getKlant().getVoornaam() + " " + dienblad.getKlant().getAchternaam());

        for (String naam : artikelnamen) {
            dienblad.voegToe(kantineAanbod.getArtikel(naam));

            // prints the artikle and price of the artikle that is put on the tray
            System.out.println(naam + ": " + kantineAanbod.getArtikel(naam).getPrijs());
        }
        kassarij.sluitAchteraan(dienblad);

    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            Dienblad eersteKlant = kassarij.eerstePersoonInRij();
            kassa.rekenAf(eersteKlant);
        }
    }

    public Kassa getKassa() {
        return kassa;
    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt"
     * de inhoud van de kassa.
     */
    public void resetKassa() {
        kassa.resetKassa();

    }

    /**
     * @return the kantineAanbod
     */
    public KantineAanbod getKantineAanbod() {
        return kantineAanbod;
    }

    /**
     * @param kantineAanbod the kantineAanbod to set
     */
    public void setKantineAanbod(KantineAanbod kantineAanbod) {
        this.kantineAanbod = kantineAanbod;
    }
}
