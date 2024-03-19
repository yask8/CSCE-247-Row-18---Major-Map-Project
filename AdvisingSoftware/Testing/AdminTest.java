package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.Admin;
import AdvisingSoftware.CourseList;

public class AdminTest {

    private Admin admin;

    @BeforeEach
    public void setUp() {
        admin = new Admin("John", "Doe", "john@example.com", UUID.randomUUID(), "password", "Admin", new ArrayList<>());
    }

    @AfterEach
    public void tearDown() {

        admin = null;
        CourseList.getInstance().clear();
    }

    @Test
    public void testAddCourse() {
        assertTrue(admin.addCourse("Math", "MATH101", "Introduction to Math", 3, "Mathematics", 'A', true, false, new ArrayList<>(), "2024", "Spring"));
        assertEquals(1, CourseList.getInstance().getAllCourses().size());
    }
}
