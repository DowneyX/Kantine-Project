public class Student extends Persoon {

    private int studentNumber;
    private String study;

    /**
     * constructor
     * 
     * @param stedentNumber
     * @param study
     * @param bsn
     * @param voornaam
     * @param achternaam
     * @param geboorteDatum
     * @param geslacht
     */

    public Student(int bsn, String voornaam, String achternaam, Datum geboorteDatum, char geslacht, int studentNumber,
            String study) {
        super(bsn, voornaam, achternaam, geboorteDatum, geslacht);
        this.study = study;
        this.studentNumber = studentNumber;
    }

    /**
     * get the study.
     * 
     * @return the study.
     */
    public String getStudy() {
        return study;
    }

    /**
     * gets the student nuber.
     * 
     * @return the student number.
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * sets the student number.
     * 
     * @param studentNumber
     */
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * sets the study.
     * 
     * @param study
     */
    public void setStudy(String study) {
        this.study = study;
    }
}