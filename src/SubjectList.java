import java.util.ArrayList;

/**
 * The SubjectList class represents a list of subjects available in a school curriculum.
 *
 * @author Siraad Yahye
 */
public class SubjectList {
    // Instance variable to store a list of subjects
    private final ArrayList<Subject> subjectArrayList;

    /**
     * Constructs a new SubjectList object.
     */
    public SubjectList() {
        subjectArrayList = new ArrayList<>();

        // Predefined subjects' details
        String[] codes = {"BIT1053", "BIT1073", "BIT1103", "BMUC2112", "MPU3193"};
        String[] names = {"Computer Programming", "Software Engineering", "Operating Systems", "English for Academic Purposes", "Falsafah dan Isu Semasa"};
        int[] credits = {3, 3, 3, 2, 3};

        for (int i = 0; i < codes.length; i++) {
            Subject newSubject = new Subject(codes[i], names[i], credits[i]);
            subjectArrayList.add(newSubject);
        }
    }

    /**
     * Finds and returns the subject with the given code.
     *
     * @param code the code of the subject to find
     * @return the subject object if found, otherwise null
     */
    public Subject findSubject(String code) {
        for (Subject subject : subjectArrayList) {
            if (subject.getCode().equalsIgnoreCase(code.trim())) {
                return subject;
            }
        }
        return null;
    }

    /**
     * Displays details of all subjects in the subject list.
     *
     * @author Siraad Yahye
     */
    public void viewAllSubjects() {
        if (!subjectArrayList.isEmpty()) {
            Console.displaySubjectTable(subjectArrayList);
            return;
        }
        Console.error("Sorry! No subjects data.");
    }
}
