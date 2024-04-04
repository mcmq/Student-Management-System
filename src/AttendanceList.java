import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a list of attendance records for students.
 *
 * @author Mohamed Mustafa
 */
public class AttendanceList {
    private final ArrayList<Attendance> attendanceArrayList;
    private final Scanner scanner;

    /**
     * Constructs a new AttendanceList object.
     */
    public AttendanceList() {
        attendanceArrayList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the attendance records.
     *
     * @author Mohamed Mustafa
     */
    public void viewAttendance() {
        if (!attendanceArrayList.isEmpty()) {
            Console.displayAttendanceTable(attendanceArrayList);
            return;
        }
        Console.error("Sorry! No attendance data found.");
    }

    /**
     * Records attendance for a student.
     *
     * @param studentArrayList the list of students
     * @author Mohamed Mustafa
     */
    public void recordAttendance(StudentList studentArrayList) {
        // Prompt user to enter student ID, Status.
        Console.info("Use 0 for attend and 1 for absence.");
        System.out.print("Enter information separated by comma (ID, Status): ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            Console.error("Sorry! Please enter a valid input format.");
            return;
        }
        String[] information = input.split(",");
        if (information.length < 2 ) {
            Console.error("Sorry! Please enter ID and status correctly.");
            return;
        }

        int ID;
        int status;
        try {
            ID = Integer.parseInt(information[0].trim());
            status = Integer.parseInt(information[1].trim());
            if (status != 0 && status != 1) {
                Console.error("Sorry! Attendance status must be 0 or 1.");
                return;
            }
            Student student = studentArrayList.findStudent(ID);
            if (student != null) {
                boolean foundAttendance = false;
                for(Attendance attendance : attendanceArrayList) {
                    if (attendance.getStudent().getID() == ID && attendance.getDate().compareTo(LocalDate.now()) == 0) {
                        System.out.print("This student signed attendance for this date ("
                                + attendance.getDate() + "). Do you want to update it. (y/N): ");
                        String response = scanner.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            int oldAttendanceIndex = attendanceArrayList.indexOf(attendance);
                            Attendance newAttendance = new Attendance(student, status);
                            attendanceArrayList.set(oldAttendanceIndex, newAttendance);
                            ArrayList<Attendance> arr = new ArrayList<>();
                            arr.add(newAttendance);
                            Console.displayAttendanceTable(arr);
                            Console.success("Attendance updated successfully.");
                            return;
                        }
                        Console.info("Attendance not updated.");
                        foundAttendance = true;
                        break;
                    }
                }

                if (!foundAttendance) {
                    Attendance newAttendance = new Attendance(student, status);
                    attendanceArrayList.add(newAttendance);
                    ArrayList<Attendance> arr = new ArrayList<>();
                    arr.add(newAttendance);
                    Console.displayAttendanceTable(arr);
                    Console.success("Attendance recorded successfully.");
                }
                return;
            }
            // Print message if student not found
            Console.error("Sorry! Student not found.");
        } catch (NumberFormatException e) {
            Console.error("Sorry! Please enter a valid integer ID or status.");
        }
    }

    /**
     * Closes the scanner associated with this class.
     */
    public void closeScanner() {
        scanner.close();
    }
}
