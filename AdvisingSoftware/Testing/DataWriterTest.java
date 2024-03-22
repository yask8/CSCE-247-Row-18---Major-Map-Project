package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import AdvisingSoftware.DataWriter;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;
import AdvisingSoftware.DataLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
/**
 * Tester class for DataWriter
 * @author Yasmine Kennedy (yas8) and Garrett Spillman (Spillmag)
 */
public class DataWriterTest {
     
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
     public void tearDown() {

          users.clear();

          DataWriter.saveUsers(users);
     }

     /**
      * @author Yasmine Kennedy
      */
     @Test
     void testWritingZeroUsers() {
         assertEquals(0, users.size());
     }    
     
      /**
      * @author Yasmine Kennedy
      */
     @Test
     void testWritingOneUser() {
          users.add(new User("Bobby", "Jones", "bigBob@gmail.com", "Westy@1#", "Student"));
          assertEquals(1, users.size());
     }

      /**
      * @author Garrett Spillman
      */
     @Test
     void testWritingTwoUsers() {
          
          users.add(new User("User1", null, null, null, null));
          users.add(new User("User2", null, null, null, null));
      
          assertEquals(2, users.size());
      } 

     /**
      * @author Yasmine Kennedy
      */
      @Test
      void testWritingNullUser(){
          users.add(new User(null, "", "", "", ""));
          assertEquals(null, users.get(0).getFirstName());
      }

     /**
      * @author Yasmine Kennedy
      */
      @Test
      void testWritingNoDuplicateUsers() {
          users.add(new User("Sam", "Smith", "ss@email.sc.edu", "hithere", "Student"));
          users.add(new User("Sam", "Smith", "ss@email.sc.edu", "hithere", "Student"));
          assertEquals("ss@email.sc.edu", users.get(0).getEmail());
          assertEquals("User already exists", users.get(1).getEmail());
      }
      
     /**
      * @author Yasmine Kennedy
      */
      @Test
      void testWritingNoDuplicateEmailWithDifferentUserTypes() {
          users.add(new User("Rain", "Webster", "rw@email.sc.edu", "lostinsauce@3", "Advisor"));
          users.add(new User("Ross", "Williams", "rw@email.sc.edu", "wafflesisgood@4", "Admin"));
          assertEquals("rw@email.sc.edu", users.get(0).getEmail());
          assertEquals("Email already exists", users.get(1).getEmail());
      }

     /**
      * @author Yasmine Kennedy
      */
      @Test
      void testWritingEmptyUser() {
          users.add(new User("", "", "", null, ""));
          assertEquals("", users.get(0).getFirstName());
      }

     /**
      * @author Yasmine Kennedy
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
}
