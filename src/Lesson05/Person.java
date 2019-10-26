package Lesson05;

public class Person {
    private final int CURRENT_YEAR = 2019;

    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private float salary;
    private int birthYear;

    /**
     * Constructor that fills up parameters when the object is initialized
     * @param fullName
     * @param position
     * @param email
     * @param phoneNumber
     * @param salary
     * @param birthYear
     */
    public Person (String fullName, String position, String email, String phoneNumber, int salary, int birthYear) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    /**
     * Method that calculates and returns age of the employee
     * @return
     */
    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    /**
     * Method that returns full info about an employee
     * @return
     */
    public String getInfo() {
        return
                this.fullName + ", " +
                        this.getAge() + " years old, " +
                        this.position + ", " +
                        this.email + ", " +
                        this.phoneNumber + ". Salary is: " +
                        this.salary + " RUB.";
    }
}
