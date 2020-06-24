public class Docent extends Persoon implements KortingskaartHouder {

    /**
     * Fields
     */
    private String acronym;
    private String sector;

    /**
     * CONSTRUCTOR
     * 
     * @param bsn           bsn number
     * @param voornaam      first name
     * @param achternaam    last name
     * @param geboorteDatum date of birth
     * @param geslacht      sec
     * @param acronym       the teachers 4 letter code
     * @param sector        the sector that the teacher works in
     */
    public Docent(int bsn, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, String acronym,
            String sector) {

        super(bsn, voornaam, achternaam, geboorteDatum, geslacht);
        this.sector = sector;
        this.acronym = acronym;

    }

    /**
     * METHODS
     */

    /**
     * gets the docent their acronym
     * 
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * gets the sector the docent works in.
     * 
     * @return the sectot
     */
    public String getSector() {
        return sector;
    }

    /**
     * set the sector the docent works in
     * 
     * @param sector
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * sets the docent their acronym
     * 
     * @param acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Override
    public double geefKortingsPercentage() {
        return 0.25;
    }

    @Override
    public boolean heeftMaximum() {

        return true;
    }

    @Override
    public double geefMaximum() {
        return 1;
    }
}