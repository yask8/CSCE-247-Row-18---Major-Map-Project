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

  /**
   * Methods to Test
   * + checkPass(double courseGrade): String
   */

  // Testing checkPass method
  @Test
  public void testCheckPassValidNum() {}

  @Test
  public void testCheckPassZero() {}

  @Test
  public void testCheckPassNegativeNum() {}

  @Test
  public void testCheckPassNonDoubleInput() {}

  @Test
  public void testCheckPassEmpty() {}

  @Test
  public void testCheckPassNull() {}
}
