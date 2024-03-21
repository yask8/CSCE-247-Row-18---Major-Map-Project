package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
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
     private UserList userList;
     private ArrayList<User> users;

     @BeforeEach
     public void setUp() {
          userList = UserList.getInstance();
          users = userList.getUsers();

          users.clear();

          DataWriter.saveUsers(users);
     }

     @AfterEach
     public void tearDown() {

          users.clear();

          DataWriter.saveUsers(users);
     }

     @Test
     void testWritingZeroUsers() {

          users = DataLoader.loadUsers();
          assertEquals(0, users.size());
     }
}
