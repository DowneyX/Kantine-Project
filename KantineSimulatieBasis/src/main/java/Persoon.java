
public class Persoon {

    // fields
    private int bsn;
    private String voornaam;
    private String achternaam;
    private Datum geboorteDatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    // constructor
    public Persoon(int bsn, String voornaam, String achternaam, Datum geboorteDatum, char geslacht) {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboorteDatum = geboorteDatum;
        setGeslacht(geslacht);
    }

    // methods
    /**
     * @param bsn the bsn to set
     */
    public void setBsn(int bsn) {
        this.bsn = bsn;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    public Betaalwijze getBetaalwijze() {
        return betaalwijze;
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * @param geboorteDatum the geboorteDatum to set
     */
    public void setGeboorteDatum(Datum geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    /**
     * @param geslacht the geslacht to set
     */
    public void setGeslacht(char geslacht) {

        if (geslacht == 'M' || geslacht == 'V') {
            this.geslacht = geslacht;
            return;
        }
        if (geslacht == 'm') {
            this.geslacht = 'M';
            return;
        }
        if (geslacht == 'v') {
            this.geslacht = 'V';
            return;
        }
        this.geslacht = 'O';
    }

    /**
     * @return the bsn
     */
    public int getBsn() {
        return bsn;
    }

    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * @return the geboorteDatum
     */
    public String getGeboorteDatum() {
        return geboorteDatum.getDatumAsString();
    }

    /**
     * @return the geslacht
     */
    public String getGeslacht() {

        if (geslacht == 'M') {
            return "Man";
        }
        if (geslacht == 'V') {
            return "Vrouw";
        } else
            return "Onbekend";
    }
}