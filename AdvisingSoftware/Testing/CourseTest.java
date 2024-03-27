package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Course;

/*
 * Tested by @oshumate Owen Shumate
 */

public class CourseTest {

    private Course testCourse;

    @BeforeEach
    public void setUp() {
        testCourse = new Course("CSCE145", "Algorithmic Design 1", "CSCE145", "CSCE145 description", 3,
                "Computer Science", 'A', true, true, new ArrayList<String>(), "2024", "Spring");
    }

    @Test
    public void editCourse_CourseDetails() {
        Course editedTestCourse = testCourse.editCourse(
            "CSCE 146 Algorithmic Design II", // Provide full course name including code
            "PR",
            "Continuation of CSCE 145. Rigorous development of algorithms and computer programs; elementary data structures.",
            3,
            "CSCE",
            'C',
            false,
            false,
            null,
            "1",
            "2"
        );
    
        assertEquals("PR", editedTestCourse.getCode());
        assertEquals("CSCE 146 Algorithmic Design II", editedTestCourse.getName());
        assertEquals("CSCE146", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("CSCE", editedTestCourse.getSubject());
        assertEquals('C', editedTestCourse.getPassGrade());
        assertFalse(editedTestCourse.isElective());
        assertFalse(editedTestCourse.isCarolinaCore());
    }
    
    @Test
    public void editCourse_CourseCode() {
        Course editedTestCourse = testCourse.editCourse(
            "CSCE 146 Algorithmic Design II", // Provide full course name including code
            "CSCE215",
            "Continuation of CSCE 145. Rigorous development of algorithms and computer programs; elementary data structures.",
            3,
            "CSCE",
            'C',
            false,
            false,
            null,
            "1",
            "2"
        );
    
        assertEquals("CSCE215", editedTestCourse.getCode());
        assertEquals("CSCE 146 Algorithmic Design II", editedTestCourse.getName());
        assertEquals("CSCE146", editedTestCourse.getID());
        assertEquals(3, editedTestCourse.getCreditHours());
        assertEquals("CSCE", editedTestCourse.getSubject());
        assertEquals('C', editedTestCourse.getPassGrade());
        assertFalse(editedTestCourse.isElective());
        assertFalse(editedTestCourse.isCarolinaCore());
    }
    
    @Test
public void editCourse_CourseNameAndSubject() {
    Course editedTestCourse = testCourse.editCourse(
        "CSCE146", // Provide the new course code
        "CSCE146",
        "Continuation of CSCE 145. Rigorous development of algorithms and computer programs; elementary data structures.",
        3,
        "CSCE",
        'C',
        false,
        false,
        null,
        "1",
        "2"
    );

    assertEquals("CSCE146", editedTestCourse.getCode());
    assertEquals("CSCE146", editedTestCourse.getName()); // Corrected to match the expected edited course name
    assertEquals("CSCE", editedTestCourse.getSubject());
    assertEquals("CSCE146", editedTestCourse.getID());
    assertEquals(3, editedTestCourse.getCreditHours());
    assertEquals('C', editedTestCourse.getPassGrade());
    assertFalse(editedTestCourse.isElective());
    assertFalse(editedTestCourse.isCarolinaCore());
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