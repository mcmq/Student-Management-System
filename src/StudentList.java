import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a list of students.
 */
public class StudentList {
    // Instance variable to store a list of subjects
    private final ArrayList<Student> studentArrayList;
    private final Scanner scanner;

    /**
     * Constructs a new StudentList object.
     */
    public StudentList() {
        studentArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new student to the list.
     *
     * @author Mouse Mohamed
     */
    public void addStudent() {
        // Prompt user to enter student information
        System.out.print("Enter student information separated by comma (name, age, nationality): ");

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid input format.");
            return;
        }
        // Split the information separated by comma to get name, age, and nationality
        String[] information = input.split(",");
        // Check if user entered valid data
        if (information.length < 3) {
            Console.error("Sorry! Please enter a valid input format.");
            return;
        }
        String name = information[0].trim();
        int age = 0;
        try {
            age = Integer.parseInt(information[1].trim());
            if (age < 0) {
                Console.error("Sorry! Age must be a non-negative integer.");
                return;
            }
            String nationality = information[2].trim();
            Student student = new Student(name, age, nationality);
            studentArrayList.add(student);
            Console.success(student.getID() + " - " + student.getName() + ", is added successfully.");
        } catch (NumberFormatException e) {
            Console.error("Sorry! Please enter a valid integer age.");
        }
    }

    /**
     * Views details of a specific student.
     *
     * @author Hange Ugas
     */
    public void viewStudent() {
        System.out.print("Enter student ID: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid integer ID.");
            return;
        }

        try {
            int ID = Integer.parseInt(input);
            Student student = findStudent(ID);
            if (student != null) {
                ArrayList<Student> arr = new ArrayList<>();
                arr.add(student);
                Console.displayStudentTable(arr);
                return;
            }
            Console.error("Sorry! Student not found.");
        } catch (NumberFormatException e) {
            Console.error("Sorry! Please enter a valid Integer ID.");
        }
    }

    /**
     * Removes a student from the list.
     *
     * @author Mouse Mohamed
     */
    public void removeStudent() {
        System.out.print("Enter student ID: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid integer ID.");
            return;
        }

        try {
            int ID = Integer.parseInt(input);
            Student student = findStudent(ID);
            if (student != null) {
                studentArrayList.remove(student);
                Console.success(student.getID() + " - " + student.getName() + ", is removed successfully.");
            } else {
                Console.error("Sorry! Student not found.");
            }
        } catch (InputMismatchException e) {
            Console.error("Sorry! Please enter a valid Integer ID.");
        }
    }

    /**
     * Lists details of all students.
     *
     * @author Hange Ugas
     */
    public void listAllStudents() {
        if (!studentArrayList.isEmpty()) {
            Console.displayStudentTable(studentArrayList);
            return;
        }
        Console.error("Sorry! No students found.");
    }

    /**
     * Updates details of a student.
     *
     * @author Mouse Mohamed
     */
    public void updateStudent() {
        System.out.print("Enter student ID: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid integer ID.");
            return;
        }

        try {
            int ID = Integer.parseInt(input);
            Student student = findStudent(ID);
            if (student != null) {
                ArrayList<Student> arr = new ArrayList<>();
                arr.add(student);
                Console.displayStudentTable(arr);

                System.out.print("Enter the updated student information separated by comma (name, age, nationality): ");
                if (scanner.hasNextLine()) {
                    String information = scanner.nextLine();
                    // Split the information separated by comma to get name, age, and nationality
                    String[] splitInformation = information.split(",");
                    // Check if user entered valid data
                    if (splitInformation.length < 3) {
                        Console.error("Sorry! Please enter a valid input format and try again.");
                        return;
                    }
                    String name = splitInformation[0].trim();
                    int age = 0;
                    // Making sure if the provided age is integer
                    try {
                        age = Integer.parseInt(splitInformation[1].trim());
                        if (age < 0) {
                            Console.error("Sorry! Age must be a non-negative integer.");
                            return;
                        }
                        String nationality = splitInformation[2].trim();
                        student.update(name, age, nationality);
                        Console.success(student.getID() + " - " + student.getName() + ", is updated successfully.");
                    } catch (NumberFormatException e) {
                        Console.error("Sorry! Please enter a valid integer age.");
                    }
                    return;
                }
                Console.error("Sorry! Please enter a valid input format.");
                return;
            }
            Console.error("Sorry! No student found.");
        } catch (NumberFormatException e) {
            Console.error("Sorry! Please enter a valid integer ID.");
        }
    }

    /**
     * Searches for a student with the given ID from the list
     *
     * @param ID student ID
     * @return student if found else null
     * @author Mouse Mohamed
     */
    public Student findStudent(int ID) {
        // Iterate through the students list to find the one with the matching ID
        for (Student student : studentArrayList) {
            // Return student immediately if found
            if (student.getID() == ID) {
                return student;
            }
        }
        // Return null if student not found
        return null;
    }

    /**
     * Closes the scanner associated with this class.
     *
     * @author Mouse Mohamed
     */
    public void closeScanner() {
        scanner.close();
    }
}
