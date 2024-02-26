package AdvisingSoftware;

/**
 * @author Lia Zhao (zhaolia9)
 *         - facade: Facade
 *         + run(): void
 *         - displayMainMenu(): void
 */
public class Driver {

  private Facade facade;

  Driver() {
    facade = new Facade();
  }

  public void run() {
    scenario1();
    scenario2();
    scenario3();
    scenario4();
    scenario5();
  }

  public void scenario1() {
    System.out.println("Scenario 1: Login");

    // Hardcoded email and password
    String email = "thebillybob@gmail.com";
    String password = "Guiy#ghawe";

    facade.user = facade.login(email, password);

    if (facade.user != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(facade.user.toString());
    } else {
      System.out.println("Login failed. Incorrect email or password.");
    }
  }

  public void scenario2() {
    System.out.println();
  }

  public void scenario3() {
    System.out.println();
  }

  public void scenario4() {
    System.out.println();
  }

  public void scenario5() {
    System.out.println();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
