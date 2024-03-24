package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.DataWriter;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Tester class for DataWriter
 * @author Yasmine Kennedy (yas8)
 */
public class DataWriterTest {
     
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
     public void tearDown() {

          users.clear();

          DataWriter.saveUsers(users);
     }

     /**
      * @author Yasmine Kennedy (yask8)
      */
     @Test
     void testWritingZeroUsers() {
         assertEquals(0, users.size());
     }    
     
      /**
      * @author Yasmine Kennedy (yask8)
      */
     @Test
     void testWritingOneUser() {
          users.add(new User("Bobby", "Jones", "bigBob@gmail.com", "Westy@1#", "Student"));
          assertEquals(1, users.size());
     }

      /**
      * @author Garrett Spillman (Spillmag)
      */
     @Test
     void testWritingTwoUsers() {
          
          users.add(new User("User1", null, null, null, null));
          users.add(new User("User2", null, null, null, null));
      
          assertEquals(2, users.size());
      } 

     /**
      * @author Yasmine Kennedy (yask8)
      */
      @Test
      void testWritingNullUser(){
          users.add(new User(null, "", "", "", ""));
          assertEquals(null, users.get(0).getFirstName());
      }

     /**
      * @author Yasmine Kennedy (yask8)
      */
      @Test
      void testWritingNoDuplicateUsers() {
          users.add(new User("Sam", "Smith", "ss@email.sc.edu", "hithere", "Student"));
          users.add(new User("Sam", "Smith", "ss@email.sc.edu", "hithere", "Student"));
          assertEquals("ss@email.sc.edu", users.get(0).getEmail());
          assertEquals("User already exists", users.get(1).getEmail());
      }
      
     /**
      * @author Yasmine Kennedy (yask8)
      */
      @Test
      void testWritingNoDuplicateEmailWithDifferentUserTypes() {
          users.add(new User("Rain", "Webster", "rw@email.sc.edu", "lostinsauce@3", "Advisor"));
          users.add(new User("Ross", "Williams", "rw@email.sc.edu", "wafflesisgood@4", "Admin"));
          assertEquals("rw@email.sc.edu", users.get(0).getEmail());
          assertEquals("Email already exists", users.get(1).getEmail());
      }

     /**
      * @author Yasmine Kennedy (yask8)
      */
      @Test
      void testWritingEmptyUser() {
          users.add(new User("", "", "", null, ""));
          assertEquals("", users.get(0).getFirstName());
      }

     /**
      * @author Yasmine Kennedy (yask8)
      */
      @Test
      void testWritingDuplicateLastNamesUsers() {
          users.add(new User("Tom", "Holland", "tholland@email.sc.edu", "spidermanrules#", "Advisor"));
          users.add(new User("James", "Holland", "jamesh@email.sc.edu", "123hagotyou", "Advisor"));
          assertEquals("Tom", users.get(0).getFirstName());
          assertEquals("Holland", users.get(0).getLastName());
          assertEquals("James", users.get(1).getFirstName());
          assertEquals("Holland", users.get(1).getLastName());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testNoGivenUserType() {
        users.add(new User("Jack", "Spark", "jspark@gmail.com", "JohnWins", null));
        assertEquals(null, users.get(0).getUserType());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testAddingUserWithUSCID() {
        UUID uscID = UUID.randomUUID();
        users.add(new User("John", "Stamos", "js@email.sc.edu", uscID, "fullhou3213", "Advisor"));
        assertEquals(1, users.size());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test 
      void testRetrievingUserUSCID() {
        UUID uscID = UUID.randomUUID();
        users.add(new User("Felix", "Sponge", "fs@email.sc.edu", uscID, "123455", "Advisor"));
        if(uscID != null){
            assertEquals(uscID, users.get(0).getID());
        }
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testRetrievingUserNullUSCID() {
        users.add(new User("Felix", "Sponge", "fs@email.sc.edu", null, "123455", "Advisor"));
        assertEquals(null, users.get(0).getID());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testEditingUserEmail() {
        UUID uscID = UUID.randomUUID();
        users.add(new User("Felix", "Sponge", "fs@email.sc.edu", uscID, "123455", "Advisor"));
        users.get(0).editEmail("felixsponge@email.sc.edu");
        DataWriter.saveUsers(users);
        assertEquals("felixsponge@email.sc.edu", users.get(0).getEmail());
        assertEquals(1, users.size());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testCreatingPersonalizedUUID() {
        UUID uscId = UUID.fromString("abd9e938-df99-44cf-a924-a631f1482ef7");
        users.add(new User("Felix", "Sponge", "fs@email.sc.edu", uscId, "123455", "Advisor"));
        assertEquals(uscId, users.get(0).getID());
      }

      /**
       * @author Yasmine Kennedy (yask8)
       */
      @Test
      void testRemovingUser(){
        UUID sc = UUID.randomUUID();
        users.add(new User("Felix", "Sponge", "fs@email.sc.edu", sc, "123455", "Advisor"));
        users.add(new User("Bobby", "Flay", "beatBobbyFlay@email.sc.edu", sc, "noWAYHOME######", "Admin"));
        users.add(new User("Kenneth", "Kenny", "kjk@email.sc.edu", sc, "justvibe@45", "Student"));
        assertEquals(3, users.size());
        users.remove(1);
        assertEquals(2, users.size());
      }

}
