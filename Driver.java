import java.util.Scanner;

/**
 * @author Lia Zhao
 * - facade: Facade
 * + run(): void
 * - displayMainMenu(): void
 */
public class Driver {

  private Facade facade;

  Driver() {
    facade = new Facade();
  }

  public void run() {
    scenario1();
    scenario2();
    //scenario3();
    //scenario4();
    //scenario5();
  }

  public void scenario1() {
    System.out.println();

    if (!facade.login("asmith", "12345")) {
      System.out.println("Sorry we couldn't login.");
      return;
    }

    System.out.println("Amy Smith is now logged in");

    if (!facade.findItem("The Cat in the Hat")) {
      System.out.println("Sorry, we don't have that book");
    }
    System.out.println("'The Cat in the Hat' is in the System");

    if (!facade.checkout("The Cat in the Hat")) {
      System.out.println("Sorry, you were not able to checkout that book");
    }
    System.out.println(
      "You have successfully checked out 'The Cat in the Hat'"
    );
  }

  public void scenario2() {
    System.out.println();

    if (!facade.login("bsmith", "12345")) {
      System.out.println("Sorry we couldn't login.");
      return;
    }
    System.out.println("Bobby Smith is now logged in");

    if (!facade.payFine(5)) {
      System.out.println("The fine was not successfully paid.");
    }
    System.out.println("Fine was successfully paid.");

    if (!facade.rateItem("The Wizard of Oz", 3)) {
      System.out.println("Didn't successfully rate the 'Wizard of Oz'");
    }
    System.out.println("The Wizard of Oz was successfully rated.");
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
