import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Grade class represents a grade for a student in a specific subject.
 *
 * @author Abdelmalik Hassan
 */
public class GradeList {
    // Instance variable to store a list of subjects
    private final ArrayList<Grade> gradeArrayList;
    private final Scanner scanner;

    public GradeList() {
        gradeArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Assigns a grade to a student for a specific subject.
     *
     * @param students the StudentList object containing the list of students
     * @param subjects the SubjectList object containing the list of subjects
     * @author Abdelmalik Hassan
     */
    public void assignGrades(StudentList students, SubjectList subjects) {
        // Prompt user to enter grade information
        System.out.print("Enter information separated by comma (Student ID, Subject Code, Grade): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid input format.");
            return;
        }

        String[] information = input.split(",");
        if (information.length < 3) {
            Console.error("Invalid format! Please enter information correctly.");
            return;
        }

        try {
            int ID = Integer.parseInt(information[0].trim());
            String subjectCode = information[1];
            Subject subject = subjects.findSubject(subjectCode);
            Student student = students.findStudent(ID);
            double grade = Double.parseDouble(information[2]);
            if (student != null) {
                if (subject != null) {
                    // Create a new grade object and add it to the list of grades
                    Grade newGrade = new Grade(student, subject, grade);
                    gradeArrayList.add(newGrade);
                    Console.success("Grade sat successfully for " +
                            newGrade.getStudent().getID() + " - " + newGrade.getStudent().getName());
                    return;
                }
                Console.error("Sorry! No subject with the provided code name found.");
                return;
            }
            // Print message if student not found
            Console.error("Sorry! Student not found.");
        } catch (NumberFormatException e) {
            Console.error("Sorry! Please make sure student ID and grade are valid integers.");
        }
    }

    /**
     * Displays all grades stored in the GradeList.
     *
     * @author Abdelmalik Hassan
     */
    public void viewGrades() {
        if (!gradeArrayList.isEmpty()) {
            Console.displayGradeTable(gradeArrayList);
            return;
        }
        Console.error("No grades found!");
    }

    /**
     * Finds and returns the grade for a specific student ID.
     *
     * @param ID the ID of the student
     * @return the Grade object if found, otherwise null
     */
    public Grade findGrade(int ID) {
        for (Grade grade : gradeArrayList) {
            if (grade.getStudent().getID() == ID) {
                return grade;
            }
        }
        return null;
    }

    /**
     * Closes the scanner associated with this GradeList.
     */
    public void closeScanner() {
        scanner.close();
    }
}
