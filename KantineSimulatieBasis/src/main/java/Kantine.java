public class Kantine {

    /**
     * FIELDS
     */
    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;

    /**
     * CONSTUCTOR
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa();
    }

    /**
     * METHODS
     */

    /**
     * in this method a customer wil put artikelen on his tray and then join the
     * queue at the cash register
     * 
     * @param dienblad
     * @param artikelnamen
     */
    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        for (String naam : artikelnamen) {
            Artikel artikel = kantineAanbod.getArtikel(naam);
            dienblad.voegToe(artikel);
            System.out.println("naam artikel: " + artikel.getNaam());
            System.out.println("korting artikel: " + artikel.getKorting());
        }
        kassarij.sluitAchteraan(dienblad);
    }

    /**
     * this method handles the queue
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            Dienblad eersteKlant = kassarij.eerstePersoonInRij();
            kassa.rekenAf(eersteKlant);
        }
    }

    /**
     * gets the cash register
     * 
     * @return the kassa
     */
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
