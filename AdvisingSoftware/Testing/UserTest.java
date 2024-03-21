package AdvisingSoftware.Testing;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import AdvisingSoftware.User;



public class UserTest {

    @Test
    public void testConstructorWithAdvisorData() {
        UUID uscID = UUID.fromString("af593075-ea9e-4ed7-be74-4604863b702b");
        User advisor = new User("Michael", "Flanagan", "FlanaganMichael@gmail.com",
                uscID, "philly$Gr33n", "ADVISOR");

        assertEquals("Michael", advisor.getFirstName());
        assertEquals("Flanagan", advisor.getLastName());
        assertEquals("FlanaganMichael@gmail.com", advisor.getEmail());
        assertEquals("philly$Gr33n", advisor.getPassword());
        assertEquals("ADVISOR", advisor.getUserType());
        assertEquals(uscID, advisor.getID());
    }

    @Test
    public void testConstructorWithRandomID() {
        User user = new User("John", "Doe", "johndoe@example.com", "p@ssw0rd", "STUDENT");
        assertNotNull(user.getID());
    }

    @Test
    public void testEditFirstName() {
        User user = new User("Alice", "Johnson", "alice.johnson@example.com", "password789", "Staff");

        user.editFirstName("Alison");
        assertEquals("Alison", user.getFirstName());
    }

    @Test
    public void testEditLastName() {
        User user = new User("Bob", "Brown", "bob.brown@example.com", "passwordabc", "ADMIN");

        user.editLastName("Barker");
        assertEquals("Barker", user.getLastName());
    }

    @Test
    public void testEditEmail() {
        User user = new User("Eva", "Green", "eva.green@example.com", "pass123", "STUDENT");

        user.editEmail("eva.green@gmail.com");
        assertEquals("eva.green@gmail.com", user.getEmail());
    }

    @Test
    public void testEditPassword() {
        User user = new User("Chris", "Lee", "chris.lee@example.com", "oldpass", "STUDENT");

        user.editPassword("newpass");
        assertEquals("newpass", user.getPassword());
    }

    @Test
    public void testLookUpCourse() {
        // This test is just to cover the method, since it has no return value or state change
        User user = new User("Sam", "Wilson", "sam.wilson@example.com", "passwordxyz", "STUDENT");
        assertDoesNotThrow(() -> user.lookUpCourse("CMW"));
    }


    @Test
    public void testNullFirstName() {
        // Test editing with null first name
        User user = new User("John", "Doe", "johndoe@example.com", "password123", "STUDENT");
        assertThrows(IllegalArgumentException.class, () -> user.editFirstName(null));
    }

    @Test
    public void testNullLastName() {
        // Test editing with null last name
        User user = new User("Jane", "Smith", "janesmith@example.com", "password456", "ADMIN");
        assertThrows(IllegalArgumentException.class, () -> user.editLastName(null));
    }

    @Test
    public void testNullEmail() {
        // Test editing with null email
        User user = new User("Sarah", "Adams", "sarahadams@example.com", "password789", "STUDENT");
        assertThrows(IllegalArgumentException.class, () -> user.editEmail(null));
    }

    @Test
    public void testInvalidEmailFormat() {
        // Test editing with invalid email format
        User user = new User("Alex", "Johnson", "alexjohnson@example.com", "password321", "ADMIN");
        assertThrows(IllegalArgumentException.class, () -> user.editEmail("invalid-email-format"));
    }

    @Test
    public void testNullPassword() {
        // Test editing with null password
        User user = new User("Max", "Wilson", "maxwilson@example.com", "oldpassword", "STUDENT");
        assertThrows(IllegalArgumentException.class, () -> user.editPassword(null));
    }

    @Test
    public void testEmptyUserType() {
        // Test constructor with empty user type
        User user = new User("Empty", "UserType", "emptyusertype@example.com", "password123", "");
        assertEquals("", user.getUserType()); // UserType should be empty string
    }

    @Test
    public void testLookUpCourseNullCode() {
        // Test lookUpCourse with null course code
        User user = new User("Look", "Up", "look.up@example.com", "passwordxyz", "Student");
        assertDoesNotThrow(() -> user.lookUpCourse(null)); // Should not throw exception
    }

}
