/**
 * The Subject class represents a subject in a school curriculum.
 * Each subject has a code, name, and credit associated with it.
 *
 * @author Siraad Yahye
 */
public class Subject {
    // Instance variables to store subject information
    private final String code;
    private final String name;
    private final int credit;

    /**
     * Constructs a new Subject object with the given code, name, and credit.
     *
     * @param code   the code of the subject
     * @param name   the name of the subject
     * @param credit the credit hours of the subject
     */
    public Subject(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    /**
     * Returns the code of the subject.
     *
     * @return the code of the subject
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the name of the subject.
     *
     * @return the name of the subject
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the credit hours of the subject.
     *
     * @return the credit hours of the subject
     */
    public int getCredit() {
        return credit;
    }
}
