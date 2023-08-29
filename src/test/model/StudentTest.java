package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Student class.
 */
public class StudentTest {
    private Student testStudent;

    @BeforeEach
    void runBefore() {
        testStudent = new Student("Michelle");
    }

    @Test
    void testGetUserName() {
        assertEquals("Michelle", testStudent.getUserName());
    }

    @Test
    void testGetDiscount() {
        assertEquals(0.9, testStudent.getDiscount());
    }
}
