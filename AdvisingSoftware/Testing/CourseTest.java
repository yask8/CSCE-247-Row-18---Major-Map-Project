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
        testCourse = new Course("CSCE145", "Algorithmic Design 1", "CSCE145", "CSCE145 description", 3,
                "Computer Science", 'A', true, true, new ArrayList<String>(), "2024", "Spring");
    }

    @Test
    public void editCourse_CourseDetails() {
        Course editedTestCourse = testCourse.editCourse("CSCE146");

        assertEquals("CSCE146", editedTestCourse.getCode());
        assertEquals("Algorithmic Design 1", editedTestCourse.getName());
        assertEquals("CSCE145", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("Computer Science", editedTestCourse.getSubject());
        assertEquals('A', editedTestCourse.getPassGrade());
        assertTrue(editedTestCourse.isElective());
        assertTrue(editedTestCourse.isCarolinaCore());
    }

    @Test
    public void editCourse_CourseCode() {
        Course editedTestCourse = testCourse.editCourse("CSCE146");

        assertEquals("CSCE146", editedTestCourse.getCode());
        assertEquals("Algorithmic Design 1", editedTestCourse.getName());
        assertEquals("CSCE145", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("Computer Science", editedTestCourse.getSubject());
        assertEquals('A', editedTestCourse.getPassGrade());
        assertTrue(editedTestCourse.isElective());
        assertTrue(editedTestCourse.isCarolinaCore());
    }

    @Test
    public void editCourse_CourseNameAndSubject() {
        Course editedTestCourse = testCourse.editCourse("CSCE145");

        assertEquals("CSCE145", editedTestCourse.getCode());
        assertEquals("Introduction to Advanced Algorithmic Design 1", editedTestCourse.getName());
        assertEquals("Advanced Algorithmic Design 1", editedTestCourse.getSubject());
        assertEquals("CSCE145", editedTestCourse.getID());
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
        Course nonElectiveCourse = new Course("MATH141", "Calculus 1", "MATH141", "MATH141 description", 3,
                "Mathematics", 'A', false, true, new ArrayList<String>(), "2024", "Spring");

        assertFalse(nonElectiveCourse.isElective());
    }

    @Test
    public void isCarolinaCoreReturnTrue() {
        assertTrue(testCourse.isCarolinaCore());
    }

    @Test
    public void isCarolinaCoreReturnFalse() {
        Course nonCarolinaCoreCourse = new Course("CSCE145", "Algorithmic Design 1", "CSCE145", "CSCE145 description", 3,
                "Computer Science", 'A', true, false, new ArrayList<String>(), "2024", "Spring");

        assertFalse(nonCarolinaCoreCourse.isCarolinaCore());
    }
}