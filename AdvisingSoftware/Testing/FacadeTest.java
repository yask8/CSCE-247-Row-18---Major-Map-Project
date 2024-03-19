package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.CourseList;
import AdvisingSoftware.MajorList;
import AdvisingSoftware.User;
import AdvisingSoftware.UserList;

public class FacadeTest {
    private User user = null;
	private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
    private MajorList majorList = MajorList.getInstance();

    
}
