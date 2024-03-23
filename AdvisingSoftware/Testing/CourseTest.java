package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Course;

public class CourseTest {

    private Course testCourse;

    @BeforeEach
    public void setUp() {
        testCourse = new Course("CS101", "Introduction to Computer Science", "CS101", "Introduction to CS", 3,
                "Computer Science", 'A', true, true, new ArrayList<String>(), "2024", "Spring");
    }

    @Test
    public void editCourse_CourseDetails() {
        Course editedTestCourse = testCourse.editCourse("CS102");

        assertEquals("CS102", editedTestCourse.getCode());
        assertEquals("Introduction to Computer Science", editedTestCourse.getName());
        assertEquals("CS101", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("Computer Science", editedTestCourse.getSubject());
        assertEquals('A', editedTestCourse.getPassGrade());
        assertTrue(editedTestCourse.isElective());
        assertTrue(editedTestCourse.isCarolinaCore());
    }

    @Test
    public void editCourse_CourseCode() {
        Course editedTestCourse = testCourse.editCourse("CS102");

        assertEquals("CS102", editedTestCourse.getCode());
        assertEquals("Introduction to Computer Science", editedTestCourse.getName());
        assertEquals("CS101", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("Computer Science", editedTestCourse.getSubject());
        assertEquals('A', editedTestCourse.getPassGrade());
        assertTrue(editedTestCourse.isElective());
        assertTrue(editedTestCourse.isCarolinaCore());
    }

    @Test
    public void editCourse_CourseNameAndSubject() {
        Course editedTestCourse = testCourse.editCourse("CS101");

        assertEquals("CS101", editedTestCourse.getCode());
        assertEquals("Introduction to Advanced Computer Science", editedTestCourse.getName());
        assertEquals("Advanced Computer Science", editedTestCourse.getSubject());
        assertEquals("CS101", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals('A', editedTestCourse.getPassGrade());
        assertTrue(editedTestCourse.isElective());
        assertTrue(editedTestCourse.isCarolinaCore());
    }

    @Test
    public void isElectiveReturnTrue() {
        assertTrue(testCourse.isElective());
    }

    @Test
    public void isElectiveReturnFalse() {
        Course nonElectiveCourse = new Course("MATH101", "Introduction to Mathematics", "MATH101", "Introduction to Math", 3,
                "Mathematics", 'A', false, true, new ArrayList<String>(), "2024", "Spring");

        assertFalse(nonElectiveCourse.isElective());
    }

    @Test
    public void isCarolinaCoreReturnTrue() {
        assertTrue(testCourse.isCarolinaCore());
    }

    @Test
    public void isCarolinaCoreReturnFalse() {
        Course nonCarolinaCoreCourse = new Course("CS101", "Introduction to Computer Science", "CS101", "Introduction to CS", 3,
                "Computer Science", 'A', true, false, new ArrayList<String>(), "2024", "Spring");

        assertFalse(nonCarolinaCoreCourse.isCarolinaCore());
    }
}