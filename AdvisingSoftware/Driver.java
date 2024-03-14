package AdvisingSoftware;

import java.util.ArrayList;

/**
 * @author Lia Zhao (zhaolia9)

 */
public class Driver {

  private Facade facade;

  Driver() {
    facade = new Facade();
  }

  public void run() {
    //Testing Scenarios
    //scenarioTesting();
    scenarioAddingSem1Courses();
    scenarioAddingSem2Courses();

    // Portias Scenarios
    // scenario1();
     //scenario2();

  }

  /*
   * @author @Spillmag
   * Tests login method
   */
  public void scenarioTesting() {
    System.out.println("\nScenario 1: Login and Signout");

    // Hardcoded email and password
    String email = "rio.farrah2004@gmail.com";
    String password = "Real?dejaneir0";

    facade.login(email, password);

    if (facade.getUser() != null) {
      System.out.println("Login successful!");
      System.out.println("Current user:");
      System.out.println(facade.getUser());
    } else {
      System.out.println("Login failed. Incorrect email or password.");
    }
    System.out.println("Student checks degree progress\n");
    System.out.println(facade.getStudentDegreeProgress());

    System.out.println("Student look at all courses in data base\n");
    System.out.println(facade.getCourseList());

    System.out.println("\nStudent did not see BIOL101 and looks it up\n");
    System.out.println(facade.getCourseById("BIOL101"));
    System.out.println("\nStudent did not see HIST101 and looks it up\n");
    System.out.println(facade.getCourseById("HIST101"));

    System.out.println("\nStudent adds BIOL101 into the course planner for semester 2\n");
    facade.getStudentCoursePlanner().addCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
        "\nStudent wants to switch from BIOL101 and trys to remove it from semester 2 but makes a typo and inputs the wrong semester\n");
    facade.getStudentCoursePlanner().removeCourse(1, "BIOL101");

    System.out.println("\nStudent wants to switch from BIOL101 and removes it from the course planner semester 2\n");
    facade.getStudentCoursePlanner().removeCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println("\nStudent Signs out and changes are saved during sign out\n");
    facade.signOut();
  }

  /**
   * 
   * @author Yasmine Kennedy (yask8) and Garrett Spillman (Spillmag)
   */
  public void scenario2() {
    
    facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    System.out.println("Login Successful. \nCurrent User: " + facade.getUser().toString());

    System.out.println("\nSearching for Student and adding to list");
    facade.addStudentToListOfAdvisees(facade.getCurrentUserId(),facade.getUserIdByName("Tawnie", "Hill"));

    System.out.println("\nStudent found and added to list");
    System.out.println(facade.getListOfAdvisees().toString());
    System.out.println("\nOsbert looks at Tawnie's current degree progress and sees two stat classes");
    System.out.println(facade.getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill")).getDegreeProgress().toString());

    System.out.println("\nObsert goes to add the note to her profile\nList of notes before not added\n");
    System.out.println(facade.getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill")).getAdvisorNotes());
    System.out.println("\nNote added");
    facade.addNoteToStudentAdvisor((facade.getUserIdByName("Tawnie", "Hill")), "Make Stats Your Application Area");
    System.out.println("\nList of notes after note is made\n");
    System.out.println(facade.getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill")).getAdvisorNotes()+"\n");

    facade.signOut();

  }

  public void scenarioAddingSem1Courses() {
    // ENG 101
    String ENG101 = "Intruction in strategies for critically reading and analyzing" +
    " literature and non-literary texts; structured, sustained practice in composing" + 
    " expository and analytical essays.";
    ArrayList<String> re = new ArrayList<String>();
    facade.getCourseList().addCourse("ENGL 101 Critical Reading and Composition", 
                                      "CMW", 
                                      ENG101, 
                                      3, 
                                      "ENGL", 
                                      'C', 
                                      false, 
                                      true, 
                                      re, 
                                      "1", 
                                      "1");
    // MATH 141
    String name = "MATH 141 Calculus I";
    String code = "ARP";
    String description = 
          "Functions, limits, derivatives, introduction to integrals," + 
          " the Fundamental Theorem of Calculus, applications of derivatives " +
          "integrals.";
    int creditHours = 4;
    String subject = "MATH";
    char passGrade = 'C';
    boolean elective = false;
    boolean carolinaCore = true;
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 112";
    String pre2 = "MATH 115";
    String pre3 = "MATH 116";
    preReqs.add(pre1);
    preReqs.add(pre2);
    preReqs.add(pre3);
    String year = "1";
    String semester = "1";

    facade.getCourseList().addCourse(name, code, description, creditHours, subject, passGrade, elective, carolinaCore,
        preReqs, year, semester);

    // CSCE 145
    String CSCE145 = "Problem-solving, algorithmic design, and programming.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "MATH 111";
    String preRe = "MATH 115";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 145 Algorithmic Design I", 
                                      "PR", 
                                      CSCE145, 
                                      4, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "1", 
                                      "1");
    // CSCE 190
    String CSCE190 = "An introduction to the field of computing; trends in" + 
    " computing technology, the profession, and careers; subdisciplines in computing;"+
    " the nature of research and development";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "CSCE 145";
    String r = "CSCE 204";
    String e = "CSCE 205";
    String z = "CSCE 206";
    preRequirement.add(p);
    preRequirement.add(r);
    preRequirement.add(e);
    preRequirement.add(z);

      facade.getCourseList().addCourse("CSCE 190 Computing in the Modern World", 
                                      "PR", 
                                      CSCE190, 
                                      1, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "1", 
                                      "1");
    // Carolina Core AIU 1
    String CCA1 = "Introduction to art appreciation. Elements and " + 
    "principles of the visual arts, with examples from the history of art.";
    ArrayList<String> pre = new ArrayList<String>();

    facade.getCourseList().addCourse("ARTE 101 Introduction to Art", 
                                    "AIU", 
                                    CCA1, 
                                    3, 
                                    "ARTE", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "1", 
                                    "1");
    // Carolina Core AIU 2
    String CCA2 = "Introuduction to the critical study of film and media." +
    " Students will closely analyze moving images and develop written arguments" +
    " about film and media.";
    ArrayList<String> require = new ArrayList<String>();

    facade.getCourseList().addCourse("FAMS 240 Film and Media Analysis", 
                                    "AIU", 
                                    CCA2, 
                                    3, 
                                    "FAMS", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "1", 
                                    "1");
    facade.saveCourses();
  }

  public void scenarioAddingSem2Courses() {
    // MATH 142
    String MATH142 = 
          "Methods of integration, sequences and series, approximations.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 141";
    preReqs.add(pre1);

    facade.getCourseList().addCourse("MATH 142 Calculus II", 
                                     "ARP", 
                                     MATH142, 
                                     4, 
                                     "MATH", 
                                     'C', 
                                     false, 
                                     true,
                                     preReqs, 
                                     "1", 
                                     "2");

    // CHEM 111
    String CHEM111 = "Survey of the principles that underlie all chemistry with applications" +
    " illustrating these principles.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "MATH 111";
    String preRe = "MATH 115";
    String preReq = "MATH 122";
    String preRequ = "MATH 141";
    preRequire.add(preR);
    preRequire.add(preRe);
    preRequire.add(preReq);
    preRequire.add(preRequ);

    facade.getCourseList().addCourse("CHEM 111 General Chemistry I", 
                                      "SCI", 
                                      CHEM111, 
                                      3, 
                                      "CHEM", 
                                      'C', 
                                      false, 
                                      true, 
                                      preRequire, 
                                      "1", 
                                      "2");
    // CHEM 111L
    String CHEM111L = "Introduction to the principles and techniques of experimental" +
    " chemistry with emphasis on formula investigations, equations, elementary statistics," +
    " chemical reactivity.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 111";
    String r = "MATH 115";
    preRequirement.add(p);
    preRequirement.add(r);

      facade.getCourseList().addCourse("CHEM 111L General Chemistry I Lab", 
                                      "SCI", 
                                      CHEM111L, 
                                      1, 
                                      "CHEM", 
                                      'C', 
                                      false, 
                                      true, 
                                      preRequirement, 
                                      "1", 
                                      "2");
    // PHYS 211
    String PHYS211 = "Classical mechanics and wave motion. Calculus-level course"+
    " for students of science and engineering";
    ArrayList<String> pre = new ArrayList<String>();
    String a = "MATH 111";
    String b = "MATH 115";
    String c = "MATH 122";
    String d = "MATH 141";
    pre.add(a);
    pre.add(b);
    pre.add(c);
    pre.add(d);

    facade.getCourseList().addCourse("PHYS 211 Essentials of Physics I", 
                                    "SCI", 
                                    PHYS211, 
                                    3, 
                                    "PHYS", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "1", 
                                    "2");
    // PHYS 211L
    String PHYS211L = "Experiments, excerises, and demonstrations to accompany PHYS 211.";
    ArrayList<String> require = new ArrayList<String>();
    String j = "MATH 111";
    String k = "MATH 115";
    require.add(j);
    require.add(k);

    facade.getCourseList().addCourse("PHYS 211L Essentials of Physics I Lab", 
                                    "SCI", 
                                    PHYS211L, 
                                    1, 
                                    "PHYS", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "1", 
                                    "2");

    // CSCE 146
    String CSCE146 = 
        "Continuation of CSCE 145. Rigorous development of " +
        "algorithms and computer programs; elementary data structures.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String v = "CSCE 145";
    String f = "MATH 122";
    String s = "MATH 141";
    requiredpre.add(v);
    requiredpre.add(f);
    requiredpre.add(s);
    
    facade.getCourseList().addCourse("CSCE 146 Algorithmic Design II", 
                                     "PR", 
                                     CSCE146,
                                     4, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false, 
                                     requiredpre, 
                                     "1", 
                                     "2");
    // CSCE 215
    String CSCE215 =
        "UNIX operating system, user-level system commands," +
        " programming tools. UNIX scripting languages.";
    ArrayList<String> requires = new ArrayList<String>();
    String g = "CSCE 145";
    requires.add(g);

    facade.getCourseList().addCourse("CSCE 215 UNIX/Linux Fundamentals", 
                                     "PR", 
                                     CSCE215, 
                                     1, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false, 
                                     requires, 
                                     "1", 
                                     "2");
    facade.saveCourses();
  }

  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}