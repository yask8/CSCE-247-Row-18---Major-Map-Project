package AdvisingSoftware.Testing;

import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

public class DataWriterTest {
   private static UserList user = UserList.getInstance();
   private ArrayList<User> userList = user.getUsers();

   @BeforeEach
   public void setUp() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers(userList);
   }

   @AfterEach
   public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers(userList);
   }
   
   @Test
   void testWritingZeroUsers() {
        userList = DataLoader.loadUsers();
        assertEquals(0, userList.size());
   }
    
    
}
