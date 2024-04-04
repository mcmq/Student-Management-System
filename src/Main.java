import java.util.Scanner;

/****************************************************************************
 *                  Student Information Management System                   *
 * @since 1.0                                                               *
 * @author Mouse Mohamed                                                    *
 * @author Hange Ugas                                                       *
 * @author Mohamed Mustafa                                                  *
 * @author Abdelmalik Hassan                                                *
 * @author Siraad Yahye                                                     *
 * @brief This program demonstrates a simple student management system.     *
 * Managers can perform various actions such as adding, updating, removing, *
 * students, and also recording attendance and assigning grades.            *
 ***************************************************************************/
public class Main {
    // Flag to determine whether program runs or not
    static boolean isRunning = true;
    // User input scanner for the main menu
    static Scanner scanner = new Scanner(System.in);
    // Manages students
    static StudentList students = new StudentList();
    // Stores attendance data
    static AttendanceList attendance = new AttendanceList();
    // Stores subjects data
    static SubjectList subjects = new SubjectList();
    // Stores grades data
    static GradeList grades = new GradeList();

    public static void main(String[] args) {
        // Display welcome message when program runs for the first time
        System.out.printf("%s%s*** Student Information Management System ***%s\n", "\u001B[43m", "\u001B[97m", "\u001B[0m");

        while(isRunning) {
            // Display main menu whenever the user finishes an action
            displayMainMenu();

            String input = scanner.nextLine().trim();
            try {
                // Process user input
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> students.addStudent();
                    case 2 -> students.viewStudent();
                    case 3 -> students.updateStudent();
                    case 4 -> students.removeStudent();
                    case 5 -> students.listAllStudents();
                    case 6 -> subjects.viewAllSubjects();
                    case 7 -> grades.assignGrades(students, subjects);
                    case 8 -> grades.viewGrades();
                    case 9 -> attendance.recordAttendance(students);
                    case 10 -> attendance.viewAttendance();
                    case 0 -> isRunning = false;
                    default -> Console.error("Sorry! Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                Console.error("Sorry! Please enter only numbers.");
            }
        }
        // Close all input scanners
        scanner.close();
        students.closeScanner();
        grades.closeScanner();
        attendance.closeScanner();
    }

    // Display the main menu options
    private static void displayMainMenu() {
        String[] menuOptions = {
                "\nMain Menu:",
                "1. Add Student",
                "2. View Student Information",
                "3. Update Student Information",
                "4. Remove Student",
                "5. View All Students",
                "6. View All Subjects",
                "7. Assign Grades",
                "8. View Grades",
                "9. Record Attendance",
                "10. View Attendance Data",
                "0. Exit\n"
        };
        Console.displayMainMenuOptions(menuOptions);
        System.out.print("Enter your choice: ");
    }
}