package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Admin;
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
}
