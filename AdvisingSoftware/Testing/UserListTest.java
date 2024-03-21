package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;
import AdvisingSoftware.UserList;
import AdvisingSoftware.User;


class UserListTest {

    private UserList userList;

    @BeforeEach
    public void setUp() {
        userList = UserList.getInstance();
        userList.setLoaded(true);  
    }

    @AfterEach
    public void tearDown() {
        userList.getUsers().clear(); 
    }

    @Test
    public void testAddStudent() {
        int initialSize = userList.getUsers().size();

        userList.addStudent("John", "Doe", "johndoe@example.com", UUID.randomUUID(), "password",
                "STUDENT", "Sophomore", "Computer Science", "Undeclared");

        int newSize = userList.getUsers().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testAddAdmin() {
        int initialSize = userList.getUsers().size();

        userList.addAdmin("Admin", "User", "admin@example.com", UUID.randomUUID(), "password", "ADMIN");

        int newSize = userList.getUsers().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testAddAdvisor() {
        int initialSize = userList.getUsers().size();

        userList.addAdvisor("Advisor", "One", "advisor@example.com", UUID.randomUUID(), "password", "ADVISOR");

        int newSize = userList.getUsers().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testRemoveUser() {
        userList.addStudent("Jane", "Smith", "janesmith@example.com", UUID.randomUUID(), "password",
                "STUDENT", "Junior", "Biology", "Undeclared");
        int initialSize = userList.getUsers().size();

        UUID userId = userList.getIDByName("Jane", "Smith");
        if (userId != null) {
            userList.removeUser(userId);
        }

        int newSize = userList.getUsers().size();
        assertEquals(initialSize - 1, newSize);
    }



    @Test
    public void testEmailExists() {
        assertTrue(userList.emailExists("rio.farrah2004@gmail.com"));
        assertFalse(userList.emailExists("nonexistent@example.com"));
    }

    @Test
    public void testSignUpSuccess() {
        int initialSize = userList.getUsers().size();

        assertTrue(userList.signUp("New", "User", "newuser@example.com", "password", "STUDENT"));

        int newSize = userList.getUsers().size();
        assertEquals(initialSize + 1, newSize);
    }

    @Test
    public void testSignUpExistingEmail() {
        int initialSize = userList.getUsers().size();

        assertFalse(userList.signUp("Jane", "Smith", "janesmith@example.com", "password", "STUDENT"));

        int newSize = userList.getUsers().size();
        assertEquals(initialSize, newSize);
    }


    @Test
    public void testNullUserType() {
        userList.addStudent("John", "Doe", "johndoe@example.com", UUID.randomUUID(), "password",
                null, "Sophomore", "Computer Science", "Undeclared");

        User lastUser = userList.getUsers().get(userList.getUsers().size() - 1);
        assertEquals("UNKNOWN", lastUser.getUserType());
    }

    @Test
    public void testEmptyEmail() {
        userList.addStudent("John", "Doe", "", UUID.randomUUID(), "password",
                "STUDENT", "Sophomore", "Computer Science", "Undeclared");

        User lastUser = userList.getUsers().get(userList.getUsers().size() - 1);
        assertEquals("", lastUser.getEmail());
    }

    @Test
    public void testNullEmail() {
        userList.addStudent("John", "Doe", null, UUID.randomUUID(), "password",
                "STUDENT", "Sophomore", "Computer Science", "Undeclared");

        User lastUser = userList.getUsers().get(userList.getUsers().size() - 1);
        assertNull(lastUser.getEmail());
    }

    @Test
    public void testEmptyPassword() {
        userList.addStudent("John", "Doe", "johndoe@example.com", UUID.randomUUID(), "",
                "STUDENT", "Sophomore", "Computer Science", "Undeclared");

        User lastUser = userList.getUsers().get(userList.getUsers().size() - 1);
        assertEquals("", lastUser.getPassword());
    }

    @Test
    public void testNullPassword() {
        userList.addStudent("John", "Doe", "johndoe@example.com", UUID.randomUUID(), null,
                "STUDENT", "Sophomore", "Computer Science", "Undeclared");

        User lastUser = userList.getUsers().get(userList.getUsers().size() - 1);
        assertNull(lastUser.getPassword());
    }
}