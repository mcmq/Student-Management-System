/**
 * The Grade class represents a grade for a student in a specific subject.
 *
 * @author Abdelmalik Hassan
 */
public class Grade {
    // Instance variables to store student, subject, and grade
    private final Student student;
    private final Subject subject;
    private final double grade;

    /**
     * Constructs a new Grade object with the given student, subject, and grade.
     *
     * @param student the student associated with the grade
     * @param subject the subject for which the grade is assigned
     * @param grade   the grade obtained by the student in the subject
     */
    public Grade(Student student, Subject subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    /**
     * Retrieves the student associated with the grade.
     *
     * @return the student object
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Retrieves the subject for which the grade is assigned.
     *
     * @return the subject code or name
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Retrieves the grade obtained by the student in the subject.
     *
     * @return the grade value
     */
    public double getGrade() {
        return grade;
    }
}
