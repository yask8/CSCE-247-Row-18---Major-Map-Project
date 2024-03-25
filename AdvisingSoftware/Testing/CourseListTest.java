package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;

/*
 * Tested by @oshumate Owen Shumate
 */

class CourseListTest {

    private CourseList courseList;

    @BeforeEach
    void setUp() {
        courseList = CourseList.getInstance();
        courseList.setLoaded(true);
    }

    @AfterEach
    void tearDown() {
        courseList.clear();
    }

    @Test
    void testAddCourse() {
        int initialSize = courseList.getCourses().size();

        courseList.addCourseNoYearorSem("Algorithmic Design 1", "CSCE145", "Introduction to algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>());

        int newSize = courseList.getCourses().size();

        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void testRemoveCourse() {
        courseList.addCourseNoYearorSem("Algorithmic Design 1", "CSCE145", "Introduction to algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>());
        int initialSize = courseList.getCourses().size();

        assertTrue(courseList.removeCourse("CSCE145"));

        int newSize = courseList.getCourses().size();

        assertEquals(initialSize - 1, newSize);
    }

    @Test
    void testAddCourseNoYearorSem() {
        int initialSize = courseList.getCourses().size();

        courseList.addCourseNoYearorSem("Algorithmic Design 1", "CSCE145", "Introduction to algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>());

        int newSize = courseList.getCourses().size();

        assertEquals(initialSize + 1, newSize);
    }

    @Test
    void testAddNullCourse() {
        assertThrows(NullPointerException.class, () -> {
            courseList.addCourse(null, null, null, 0, null, ' ', true, true, null, null, null);
        });
    }

    @Test
    void testAddEmptyCourse() {
        int initialSize = courseList.getCourses().size();

        courseList.addCourse("", "", "", 0, "", ' ', true, true, new ArrayList<>(), "", "");

        int newSize = courseList.getCourses().size();

        assertEquals(initialSize, newSize);
    }

    @Test
    void testRemoveNullCourse() {
        assertThrows(NullPointerException.class, () -> {
            courseList.removeCourse(null);
        });
    }

    @Test
    void testRemoveEmptyCourse() {
        int initialSize = courseList.getCourses().size();

        assertFalse(courseList.removeCourse(""));

        int newSize = courseList.getCourses().size();
        
        assertEquals(initialSize, newSize);
    }

    @Test
    void testCourseExistsById() {
        Course course = new Course("Algorithmic Design 1", "CSCE145", "Introduction to algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>(), null, null);
        courseList.addCourseObject(course);

        assertTrue(courseList.courseExistsById(course.getID()));
    }

    @Test
    void testCourseExistsByNullId() {
        assertFalse(courseList.courseExistsById(null));
    }

    @Test
    void testCourseExistsByEmptyId() {
        assertFalse(courseList.courseExistsById(""));
    }

    @Test
    void testShowCoursesByCode() {
        
        courseList.addCourseNoYearorSem("Algorithmic Design 1", "CSCE", "Introduction to algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>());
        courseList.addCourseNoYearorSem("Algorithmic Design 2", "CSCE", "Advanced topics in algorithmic design",
                3, "Computer Science", 'C', true, false, new ArrayList<>());

        
        courseList.showCoursesByCode("CSCE");

        
        String output = courseList.toString();

        assertTrue(output.contains("***********CSCE145 Courses***********"));
        assertTrue(output.contains("Algorithmic Design 1"));
        assertTrue(output.contains("CSCE"));
        assertFalse(output.contains("Algorithmic Design 2"));
        assertFalse(output.contains("CSCE"));
    }
}