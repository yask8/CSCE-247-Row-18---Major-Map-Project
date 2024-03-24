package AdvisingSoftware.Testing;

import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.DataWriter;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;

import java.util.ArrayList;

/**
 * @author Yasmine Kennedy
 */
public class DataLoaderTest {

    private UserList userList;
    private ArrayList<User> users;

    /**
     * @author Yasmine Kennedy
     */
    @BeforeEach
    public void setUp() {
        userList = UserList.getInstance();
        users = userList.getUsers();

        users.clear();

        DataWriter.saveUsers(users);
    }

    /**
     * @author Yasmine Kennedy
     */
    @AfterEach
    public void tearDown(){
        users.clear();

        DataWriter.saveUsers(users);
    }

    /**
     * @author Yasmine Kennedy
     */
    @Test
    void testUsersSize() {
        users.add(new User("Owew", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        users.add(new User("Portia", "Plante", "pplante@email.sc.edu", "luvocding340", "Advisor"));
        users.add(new User("Micheal", "Jackson", "bigmike@email.sc.edu", "neverlandsucks9", "Student"));
        assertEquals(3, users.size());
    }

    /**
     * @author Yasmine Kennedy
     */
    @Test
    void testUsersSizeZero() {
        assertEquals(0, users.size());
    }

    /**
     * @author Yasmine Kennedy
     */
    @Test
    void testUserFirstUserName() {
        users.add(new User("Owen", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        users.add(new User("Portia", "Plante", "pplante@email.sc.edu", "luvocding340", "Advisor"));
        users.add(new User("Micheal", "Jackson", "bigmike@email.sc.edu", "neverlandsucks9", "Student"));
        assertEquals("Owen", users.get(0).getFirstName());
    }

    /**
     * @author Yasmine Kennedy
     */
    @Test
    void testDuplicateUsers() {
        users.add(new User("Owen", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        users.add(new User("Portia", "Plante", "pplante@email.sc.edu", "luvocding340", "Advisor"));
        users.add(new User("Micheal", "Jackson", "bigmike@email.sc.edu", "neverlandsucks9", "Student"));
        users.add(new User("Owen", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        assertEquals("oshumate@email.sc.edu", users.get(0).getEmail());
        assertEquals("User already exists", users.get(3).getEmail());
    }

  
}
