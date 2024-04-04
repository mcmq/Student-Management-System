import java.util.ArrayList;

/**
 * The Console class provides methods for displaying formatted output to the console.
 *
 * @author Mouse Mohamed
 */
public class Console {
    // ANSI escape codes - FOREGROUND
    static String FG_BLACK = "\u001B[30m";
    static String FG_RED = "\u001B[31m";
    static String FG_GREEN = "\u001B[32m";
    static String FG_YELLOW = "\u001B[33m";
    static String FG_BLUE = "\u001B[34m";
    static String FG_MAGENTA = "\u001B[35m";
    static String FG_CYAN = "\u001B[36m";
    static String FG_WHITE = "\u001B[97m";

    // ANSI escape codes - BACKGROUND
    static String BG_BLACK = "\u001B[40m";
    static String BG_RED = "\u001B[41m";
    static String BG_GREEN = "\u001B[42m";
    static String BG_YELLOW = "\u001B[43m";
    static String BG_BLUE = "\u001B[44m";
    static String BG_MAGENTA = "\u001B[45m";
    static String BG_CYAN = "\u001B[46m";
    static String BG_WHITE = "\u001B[97m";

    static String RESET = "\u001B[0m";

    /**
     * Prints a success message in green color.
     *
     * @param msg the success message to be displayed
     */
    public static void success(String msg) {
        System.out.printf("%s" + msg + "%s\n", FG_GREEN, RESET);
    }

    /**
     * Prints an information message in blue color.
     *
     * @param msg the information message to be displayed
     */
    public static void info(String msg) {
        System.out.printf("%s" + msg + "%s\n", FG_BLUE, RESET);
    }

    /**
     * Prints an error message in white color with red background.
     *
     * @param msg the error message to be displayed
     */
    public static void error(String msg) {
        System.out.printf("%s%s" + msg + "%s\n", FG_WHITE, BG_RED, RESET);
    }

    /**
     * Displays a formatted table of student information.
     *
     * @param studentArrayList an ArrayList of Student objects to be displayed
     */
    public static void displayStudentTable(ArrayList<Student> studentArrayList) {
        System.out.printf("%s%s%-10s %-20s %-10s %-15s%s\n", FG_WHITE, BG_BLUE, "ID", "Name", "Age", "Nationality", RESET);
        for (Student student : studentArrayList) {
            System.out.printf("%s%-10s %-20s %-10s %-15s\n", FG_BLUE,
                    student.getID(), student.getName(), student.getAge(), student.getNationality());
        }
    }

    /**
     * Displays a formatted table of attendance information.
     *
     * @param attendanceArrayList an ArrayList of Attendance objects to be displayed
     */
    public static void displayAttendanceTable(ArrayList<Attendance> attendanceArrayList) {
        System.out.printf("%s%s%-10s %-20s %-10s %-15s%s\n", FG_WHITE, BG_BLUE, "ID", "Name", "Status", "Date", RESET);
        for (Attendance attendance : attendanceArrayList) {
            System.out.printf("%s%-10s %-20s %-10s %-15s\n", FG_BLUE,
                    attendance.getStudent().getID(), attendance.getStudent().getName(),
                    attendance.getStatus() == 0 ? "Attend" : "Absence", attendance.getDate());
        }
    }

    /**
     * Displays a formatted table of grade information.
     *
     * @param gradeArrayList an ArrayList of Grade objects to be displayed
     */
    public static void displayGradeTable(ArrayList<Grade> gradeArrayList) {
        System.out.printf("%s%s%-10s %-20s %-15s %-10s%s\n", FG_WHITE, BG_BLUE, "ID", "Name", "Subject", "Grade", RESET);
        for (Grade grade : gradeArrayList) {
            System.out.printf("%s%-10s %-20s %-15s %-10s\n", FG_BLUE,
                    grade.getStudent().getID(), grade.getStudent().getName(), grade.getSubject().getCode(), grade.getGrade());
        }
    }

    /**
     * Displays a formatted table of subject information.
     *
     * @param subjectArrayList an ArrayList of Subject objects to be displayed
     */
    public static void displaySubjectTable(ArrayList<Subject> subjectArrayList) {
        System.out.printf("%s%s%-15s %-40s %-10s%s\n", FG_WHITE, BG_BLUE, "Code", "Name", "Credit", RESET);
        for (Subject subject : subjectArrayList) {
            System.out.printf("%s%-15s %-40s %-10s\n", FG_BLUE,
                    subject.getCode(), subject.getName(), subject.getCredit());
        }
    }

    /**
     * Displays the formatted main menu options.
     *
     * @param options an array of strings representing the menu options
     */
    public static void displayMainMenuOptions(String[] options) {
        for (String option : options) {
            System.out.printf("%s" + option + "%s\n", FG_YELLOW, RESET);
        }
    }
}
