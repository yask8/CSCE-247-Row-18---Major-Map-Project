package AdvisingSoftware.Testing;

/**
 * @author Lia Zhao
 */
import static org.junit.jupiter.api.Assertions.*;

import AdvisingSoftware.Grades;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradesTest {

  private Grades testCourse;

  /**
   * Methods to Test
   * + checkPass(double courseGrade): String
   */

  @BeforeEach
  public void setUp() {}

  @AfterEach
  public void tearDown() {}

  // Testing checkPass method
  @Test
  public void testCheckPassValidNum() {
    double courseGrade = 94.3;
    testCourse = new Grades("CSCE145", courseGrade);
    assertEquals("PASS", testCourse.checkPass(courseGrade));
  }

  @Test
  public void testCheckPassZero() {
    double courseGrade = 0;
    testCourse = new Grades("CSCE145", courseGrade);
    assertEquals("FAIL", testCourse.checkPass(courseGrade));
  }

  @Test
  public void testCheckPassNegativeNum() {
    double courseGrade = -94.3;
    testCourse = new Grades("CSCE145", courseGrade);
    assertEquals("FAIL", testCourse.checkPass(courseGrade));
  }
  // @Test
  // public void testCheckPassNullNum() {
  //   setUp(null);
  //   assertEquals("N/A", testCourse.checkPass(null));
  // }
}
