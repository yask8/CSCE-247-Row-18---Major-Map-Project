package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Admin;
import AdvisingSoftware.Course;
import AdvisingSoftware.CourseList;
import AdvisingSoftware.UserList;

public class AdminTest {

    private Admin admin;
    private UUID uuid = UUID.randomUUID();

    @BeforeEach
    public void setUp() {
        admin = new Admin("John", "Doe", "john@example.com", uuid, "password", "Admin", new ArrayList<>());
        CourseList.getInstance().getCourses().clear();
    }

    @AfterEach
    public void tearDown() {

        admin = null;
        CourseList.getInstance().clear();
        UserList.getInstance().removeUser(uuid);
    }

    // ADD COURSES TESTS
    @Test
    public void testAddValidCourse() {
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", 3, "MATH", 'A', true, false, new ArrayList<>(),
                "2024", "Spring");
        assertEquals(1, CourseList.getInstance().getAllCourses().size());
    }

    @Test
    public void testAddCourseEmptyName() {
        admin.addCourse("", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false, new ArrayList<>(),
                "2024", "Spring");
        assertEquals(0, CourseList.getInstance().getAllCourses().size());
    }

    @Test
    public void testAddCourseDuplicateName() {
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false,
                new ArrayList<>(), "2024", "Spring");
        admin.addCourse("Math 101", "MATH102", "Introduction to Advanced Math", 3, "Mathematics", 'A', true, false,
                new ArrayList<>(), "2024", "Spring");
        assertEquals(1, CourseList.getInstance().getAllCourses().size());
    }

    @Test
    public void testAddCourseNegativeCreditHours() {
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", -3, "Mathematics", 'A', true, false,
                new ArrayList<>(), "2024", "Spring");
        assertEquals(0, CourseList.getInstance().getAllCourses().size());
    }

    @Test
    public void testAddCourseNullPrerequisites() {
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false, null, "2024",
                "Spring");
        assertEquals(1, CourseList.getInstance().getAllCourses().size());
    }

    @Test
    public void testAddCourseValidWithEmptyAttributes() {
        admin.addCourse("Math 101", "MATH101", "", 0, "", '\0', false, false, new ArrayList<>(), "", "");
        assertEquals(1, CourseList.getInstance().getAllCourses().size());
    }

    // EDIT COURSE TESTS

    @Test
    public void testEditCourseValid() {
        // Add a course first
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false,
                new ArrayList<>(), "2024", "Spring");

        // Now edit the course
        boolean result = admin.editCourse("MATH101", "Calculus 101", "Introduction to Calculus", 4, "Mathematics", 'B',
                false, true, new ArrayList<>(), "2024", "Fall");

        assertTrue(result);

        Course editedCourse = CourseList.getInstance().getCourse("MATH101");
        assertNotNull(editedCourse);
        assertEquals("Calculus 101", editedCourse.getName());
        assertEquals("Introduction to Calculus", editedCourse.getDescription());
        assertEquals(4, editedCourse.getCreditHours());
        assertEquals("Mathematics", editedCourse.getSubject());
        assertEquals('B', editedCourse.getPassGrade());
        assertFalse(editedCourse.isElective());
        assertTrue(editedCourse.isCarolinaCore());
        assertEquals("2024", editedCourse.getYear());
        assertEquals("Fall", editedCourse.getSemester());
    }

    @Test
    public void testEditNonExistentCourse() {
        boolean result = admin.editCourse("NONEXISTENT", "Calculus 101", "Introduction to Calculus", 4, "Mathematics",
                'B',
                false, true, new ArrayList<>(), "2024", "Fall");

        assertFalse(result);
    }

    @Test
    public void testEditCourseEmptyName() {
        admin.addCourse("Math 101", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false,
                new ArrayList<>(), "2024", "Spring");

        boolean result = admin.editCourse("MATH101", "", "Introduction to Calculus", 4, "Mathematics", 'B',
                false, true, new ArrayList<>(), "2024", "Fall");

        assertFalse(result);
    }

    @Test
    public void testEditCourseInvalidID() {
        boolean result = admin.editCourse(null, "Calculus 101", "Introduction to Calculus", 4, "Mathematics", 'B',
                false, true, new ArrayList<>(), "2024", "Fall");

        assertFalse(result);
    }
}
