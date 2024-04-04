import java.time.LocalDate;

/**
 * Attendance class represents attendance record with student, date, and status.
 *
 * @author Mohamed Mustafa
 */
public class Attendance {
    private final Student student;
    private final LocalDate date;
    private final int status;

    /**
     * Attendance constructor when date is provided.
     *
     * @param student needed to sign
     * @param date sets date, and uses today's date if date not specified
     * @param status 0 which represents attend or 1 which represents absence
     */
    public Attendance(Student student, LocalDate date, int status) {
        this.student = student;
        this.date = date;
        this.status = status;
    }

    /**
     * Attendance constructor when date is not provided.
     *
     * @param student needed to sign
     * @param status 0 which represents attend or 1 which represents absence
     */
    public Attendance(Student student, int status) {
        this.student = student;
        this.date = LocalDate.now();
        this.status = status;
    }

    /**
     * Gets student from attendance
     *
     * @return student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets date from attendance
     *
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets attendance status from attendance
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }
}
