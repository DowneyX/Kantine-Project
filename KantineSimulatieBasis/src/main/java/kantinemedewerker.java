public class kantinemedewerker extends Persoon implements KortingskaartHouder {

    // fields
    private int employeeNumber;
    private boolean isCashier;

    /**
     * constructor
     * 
     * @param bsn
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     */
    public kantinemedewerker(int bsn, String voornaam, String achternaam, Datum geboorteDatum, char geslacht,
            int employeeNumber, boolean isCashier) {
        super(bsn, voornaam, achternaam, geboorteDatum, geslacht);
        this.isCashier = isCashier;
        this.employeeNumber = employeeNumber;
    }

    /**
     * gets the employeenumber
     * 
     * @return the employeenumber
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * checks is this instance is a casher or not
     * 
     * @return isCashier
     */
    public boolean IsCashier() {
        return isCashier;
    }

    /**
     * sets is cashier
     * 
     * @param isCashier
     */
    public void setIsCashier(boolean isCashier) {
        this.isCashier = isCashier;
    }

    /**
     * sets the employee number
     * 
     * @param employeeNumber
     */
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public double geefKortingsPercentage() {
        // TODO Auto-generated method stub
        return 0.35;
    }

    @Override
    public boolean heeftMaximum() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double geefMaximum() {
        // TODO Auto-generated method stub
        return 0;
    }

}