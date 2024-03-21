package AdvisingSoftware.Testing;
import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.AppArea;

import java.util.ArrayList;

public class AppAreaTest {
    /**
     * Methods to Test
     * showAppAreaOptions()
     * 
     */
    private AppArea appArea;
    @Test
    public void testShowAppAreaOptions() {
        appArea = new AppArea("MATH 189");
        appArea.setAppAreaCourses("Purple");
    }
}
