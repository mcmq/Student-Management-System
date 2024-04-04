import java.util.Random;

/**
 * Student class represents a student with a unique ID, name, age, and nationality.
 *
 * @author Mouse Mohamed
 */
public class Student {
    // Instance variables to store student information
    private final int ID;
    private String name;
    private int age;
    private String nationality;

    /**
     * Student class constructor
     *
     * @param name        student's full name
     * @param age         student's age
     * @param nationality student's nationality
     */
    public Student(String name, int age, String nationality) {
        this.ID = generateId();
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    /**
     * Generates a random unique identifier for the student.
     *
     * @return ID a random unique identifier
     */
    private int generateId() {
        Random random = new Random();
        // Minimum value of the unique identifier
        int min = 1000;
        // Maximum value of the unique identifier
        int max = 9999;
        // Generate the random unique identifier
        return min + ((int) (random.nextDouble() * (max - min + 1)));
    }

    /**
     * Retrieves the student's unique ID.
     *
     * @return ID the student's unique identifier
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Retrieves the student's name.
     *
     * @return name the student's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the student's age.
     *
     * @return age the student's age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Retrieves the student's nationality.
     *
     * @return nationality the student's nationality
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * Updates the student's information.
     *
     * @param name        student's new name
     * @param age         student's new age
     * @param nationality student's new nationality
     */
    public void update(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
}