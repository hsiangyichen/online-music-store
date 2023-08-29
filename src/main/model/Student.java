package model;

/*
 * Represents a student.
 */
public class Student {
    private String userName; // the user's name
    private double discount = 0.9; // set the discount

    // Constructs a student
    // EFFECTS: student has a name as user name
    public Student(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public double getDiscount() {
        return discount;
    }

}