package AdvisingSoftware;

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
  }

  public void scenario2() {
    System.out.println();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
