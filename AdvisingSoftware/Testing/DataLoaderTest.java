package AdvisingSoftware.Testing;

import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.DataWriter;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Tester class for DataLoader
 * @author Yasmine Kennedy (yask8)
 */
public class DataLoaderTest {

    private UserList userList;
    private ArrayList<User> users;

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @BeforeEach
    public void setUp() {
        userList = UserList.getInstance();
        users = userList.getUsers();

        users.clear();

        DataWriter.saveUsers(users);
    }

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @AfterEach
    public void tearDown(){
        users.clear();

        DataWriter.saveUsers(users);
    }

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @Test
    void testUsersSize() {
        users.add(new User("Owew", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        users.add(new User("Portia", "Plante", "pplante@email.sc.edu", "luvocding340", "Advisor"));
        users.add(new User("Micheal", "Jackson", "bigmike@email.sc.edu", "neverlandsucks9", "Student"));
        assertEquals(3, users.size());
    }

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @Test
    void testUsersSizeZero() {
        assertEquals(0, users.size());
    }

    /**
     * @author Yasmine Kennedy(yask8)
     */
    @Test
    void testUserFirstUserName() {
        users.add(new User("Owen", "Shumate", "oshumate@email.sc.edu", "oooriley$4", "Admin"));
        users.add(new User("Portia", "Plante", "pplante@email.sc.edu", "luvocding340", "Advisor"));
        users.add(new User("Micheal", "Jackson", "bigmike@email.sc.edu", "neverlandsucks9", "Student"));
        assertEquals("Owen", users.get(0).getFirstName());
    }

    /**
     * @author Yasmine Kennedy (yask8)
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
    
    /**
     * @author Yasmine Kennedy (yask8)
     */
    @Test
    void testUsersWithUSCIDs() {
        UUID uscID = UUID.randomUUID();
        users.add(new User("Marshall", "Nick", "mnick@email.sc.edu", uscID, "pawpatrol@3", "Student"));
        users.add(new User("Chase", "Eloden", "celoden@email.sc.edu", uscID, "doubletrouble4", "Student"));
        users.add(new User("Sky", "Puppy", "spuppy@email.sc.edu", uscID, "thispuppygottafly@4", "Student"));
        assertEquals(3, users.size());
    }

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @Test
    void testUserUSCID() {
        UUID uscID = UUID.randomUUID();
        users.add(new User("Marshall", "Nick", "mnick@email.sc.edu", uscID, "pawpatrol@3", "Student"));
        users.add(new User("Chase", "Eloden", "celoden@email.sc.edu", uscID, "doubletrouble4", "Student"));
        users.add(new User("Sky", "Puppy", "spuppy@email.sc.edu", uscID, "thispuppygottafly@4", "Student"));
        assertEquals(uscID, users.get(1).getID());
    }

    /**
     * @author Yasmine Kennedy (yask8)
     */
    @Test
    void nullUser(){
        users.add(new User(null, null, null, null, null, null));
        assertEquals(null,users.get(0).getFirstName());
        assertEquals(1, users.size());
        users.remove(0);
        assertEquals(0, users.size());
    }
}
