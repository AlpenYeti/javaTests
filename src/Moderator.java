/**
 *
 */
public class Moderator extends User {
    int accreditation;

    /**
     * Moderator Constructor
     *
     * @param fname
     * @param lname
     * @param birthdate
     * @param accreditation
     */
    public Moderator(String fname, String lname, String birthdate,int accreditation) {
        super(fname, lname, birthdate);
        this.accreditation = accreditation;
    }
}
