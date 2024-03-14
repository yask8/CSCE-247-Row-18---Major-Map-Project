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
    addingSem1Courses();
    addingSem2Courses();

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

    System.out.println(
      "\nStudent adds BIOL101 into the course planner for semester 2\n"
    );
    facade.getStudentCoursePlanner().addCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
      "\nStudent wants to switch from BIOL101 and trys to remove it from semester 2 but makes a typo and inputs the wrong semester\n"
    );
    facade.getStudentCoursePlanner().removeCourse(1, "BIOL101");

    System.out.println(
      "\nStudent wants to switch from BIOL101 and removes it from the course planner semester 2\n"
    );
    facade.getStudentCoursePlanner().removeCourse(2, "BIOL101");
    System.out.println(facade.getStudentCoursePlanner().toString());

    System.out.println(
      "\nStudent Signs out and changes are saved during sign out\n"
    );
    facade.signOut();
  }

  /**
   *
   * @author Yasmine Kennedy (yask8) and Garrett Spillman (Spillmag)
   */
  public void scenario2() {
    facade.login("osberto@mailbox.sc.edu", "h3110m0m!2");
    System.out.println(
      "Login Successful. \nCurrent User: " + facade.getUser().toString()
    );

    System.out.println("\nSearching for Student and adding to list");
    facade.addStudentToListOfAdvisees(
      facade.getCurrentUserId(),
      facade.getUserIdByName("Tawnie", "Hill")
    );

    System.out.println("\nStudent found and added to list");
    System.out.println(facade.getListOfAdvisees().toString());
    System.out.println(
      "\nOsbert looks at Tawnie's current degree progress and sees two stat classes"
    );
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill"))
        .getDegreeProgress()
        .toString()
    );

    System.out.println(
      "\nObsert goes to add the note to her profile\nList of notes before not added\n"
    );
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill"))
        .getAdvisorNotes()
    );
    System.out.println("\nNote added");
    facade.addNoteToStudentAdvisor(
      (facade.getUserIdByName("Tawnie", "Hill")),
      "Make Stats Your Application Area"
    );
    System.out.println("\nList of notes after note is made\n");
    System.out.println(
      facade
        .getStudentByAdvisor(facade.getUserIdByName("Tawnie", "Hill"))
        .getAdvisorNotes() +
      "\n"
    );

    facade.signOut();
  }

  public void addingSem1Courses() {
    // ENG 101
    String ENG101 =
      "Intruction in strategies for critically reading and analyzing" +
      " literature and non-literary texts; structured, sustained practice in composing" +
      " expository and analytical essays.";
    ArrayList<String> re = new ArrayList<String>();
    facade
      .getCourseList()
      .addCourse(
        "ENGL 101 Critical Reading and Composition",
        "CMW",
        ENG101,
        3,
        "ENGL",
        'C',
        false,
        true,
        re,
        "1",
        "1"
      );
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

    facade
      .getCourseList()
      .addCourse(
        name,
        code,
        description,
        creditHours,
        subject,
        passGrade,
        elective,
        carolinaCore,
        preReqs,
        year,
        semester
      );

    // CSCE 145
    String CSCE145 = "Problem-solving, algorithmic design, and programming.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "MATH 111";
    String preRe = "MATH 115";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade
      .getCourseList()
      .addCourse(
        "CSCE 145 Algorithmic Design I",
        "PR",
        CSCE145,
        4,
        "CSCE",
        'C',
        false,
        false,
        preRequire,
        "1",
        "1"
      );
    // CSCE 190
    String CSCE190 =
      "An introduction to the field of computing; trends in" +
      " computing technology, the profession, and careers; subdisciplines in computing;" +
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

    facade
      .getCourseList()
      .addCourse(
        "CSCE 190 Computing in the Modern World",
        "PR",
        CSCE190,
        1,
        "CSCE",
        'C',
        false,
        false,
        preRequirement,
        "1",
        "1"
      );
    // Carolina Core AIU 1
    String CCA1 =
      "Introduction to art appreciation. Elements and " +
      "principles of the visual arts, with examples from the history of art.";
    ArrayList<String> pre = new ArrayList<String>();

    facade
      .getCourseList()
      .addCourse(
        "ARTE 101 Introduction to Art",
        "AIU",
        CCA1,
        3,
        "ARTE",
        'C',
        false,
        true,
        pre,
        "1",
        "1"
      );
    // Carolina Core AIU 2
    String CCA2 =
      "Introuduction to the critical study of film and media." +
      " Students will closely analyze moving images and develop written arguments" +
      " about film and media.";
    ArrayList<String> require = new ArrayList<String>();

    facade
      .getCourseList()
      .addCourse(
        "FAMS 240 Film and Media Analysis",
        "AIU",
        CCA2,
        3,
        "FAMS",
        'C',
        false,
        true,
        require,
        "1",
        "1"
      );
    facade.saveCourses();
  }

  public void addingSem2Courses() {
    // ENGL 102
    String ENGL102 =
      "Instruction and intensice practice in researching, analyzing," +
      " and composing written arguments about academic and public issues.";
    ArrayList<String> req = new ArrayList<String>();
    String w = "ENGL 101";
    req.add(w);

    facade.getCourseList().addCourse("ENGL 102 Rhectoric Composition", 
                                     "CMW", 
                                     ENGL102, 
                                     3, 
                                     "ENGL", 
                                     'C', 
                                     false, 
                                     true,
                                     req, 
                                     "1", 
                                     "1");
    // MATH 142
    String MATH142 =
      "Methods of integration, sequences and series, approximations.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 141";
    preReqs.add(pre1);

    facade
      .getCourseList()
      .addCourse(
        "MATH 142 Calculus II",
        "ARP",
        MATH142,
        4,
        "MATH",
        'C',
        false,
        true,
        preReqs,
        "1",
        "2"
      );

    // CHEM 111
    String CHEM111 =
      "Survey of the principles that underlie all chemistry with applications" +
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

    facade
      .getCourseList()
      .addCourse(
        "CHEM 111 General Chemistry I",
        "SCI",
        CHEM111,
        3,
        "CHEM",
        'C',
        false,
        true,
        preRequire,
        "1",
        "2"
      );
    // CHEM 111L
    String CHEM111L =
      "Introduction to the principles and techniques of experimental" +
      " chemistry with emphasis on formula investigations, equations, elementary statistics," +
      " chemical reactivity.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 111";
    String r = "MATH 115";
    preRequirement.add(p);
    preRequirement.add(r);

    facade
      .getCourseList()
      .addCourse(
        "CHEM 111L General Chemistry I Lab",
        "SCI",
        CHEM111L,
        1,
        "CHEM",
        'C',
        false,
        true,
        preRequirement,
        "1",
        "2"
      );
    // PHYS 211
    String PHYS211 =
      "Classical mechanics and wave motion. Calculus-level course" +
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

    facade
      .getCourseList()
      .addCourse(
        "PHYS 211 Essentials of Physics I",
        "SCI",
        PHYS211,
        3,
        "PHYS",
        'C',
        false,
        true,
        pre,
        "1",
        "2"
      );
    // PHYS 211L
    String PHYS211L =
      "Experiments, excerises, and demonstrations to accompany PHYS 211.";
    ArrayList<String> require = new ArrayList<String>();
    String j = "MATH 111";
    String k = "MATH 115";
    require.add(j);
    require.add(k);

    facade
      .getCourseList()
      .addCourse(
        "PHYS 211L Essentials of Physics I Lab",
        "SCI",
        PHYS211L,
        1,
        "PHYS",
        'C',
        false,
        true,
        require,
        "1",
        "2"
      );

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

    facade
      .getCourseList()
      .addCourse(
        "CSCE 146 Algorithmic Design II",
        "PR",
        CSCE146,
        4,
        "CSCE",
        'C',
        false,
        false,
        requiredpre,
        "1",
        "2"
      );
    // CSCE 215
    String CSCE215 =
      "UNIX operating system, user-level system commands," +
      " programming tools. UNIX scripting languages.";
    ArrayList<String> requires = new ArrayList<String>();
    String g = "CSCE 145";
    requires.add(g);

    facade.getCourseList().addCourse("CSCE 215 UNIX or Linux Fundamentals", 
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
  public void addingSem3Courses() {
    // CSCE 211 
    String CSCE211 = 
          "Number systems, Boolean algebra, logic design, sequential machines.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 141";
    preReqs.add(pre1);

    facade.getCourseList().addCourse("CSCE 211 Digital Logic Design", 
                                     "PR", 
                                     CSCE211, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs, 
                                     "2", 
                                     "3");

    // CSCE 240
    String CSCE240 =
      "Pointers; memory management; advanced programming language structures: operator" +
      " overloading, iterators, multiple inheritance, polymorphism, templates, virtual "+
      "functions; Unix programming environment.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "CSCE 215";
    String preRe = "CSCE 146";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 240 Advanced Programming Techniques", 
                                      "PR", 
                                      CSCE240, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "2", 
                                      "3");
    // MATH 374
    String MATH374 =
      "Propositional and predicate logic; proof techniques; recursion and " +
      "recurrence relations; sets, combinatorics, and probability; functions, relations," +
      "and matrices; algebraic structures.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 142";
    String r = "CSCE 146";
    preRequirement.add(p);
    preRequirement.add(r);

      facade.getCourseList().addCourse("MATH 374 Discrete Structures", 
                                      "PR", 
                                      MATH374, 
                                      3, 
                                      "MATH", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "2", 
                                      "3");
    // CHEM 112
    String CHEM112 =
       "Continuation of CHEM 111. Special emphasis on chemical equilibrium.";
    ArrayList<String> pre = new ArrayList<String>();
    String a = "CHEM 111";
    String b = "CHEM 141";
    String c = "MATH 111";
    String d = "MATH 115";
    String e = "MATH 122";
    String f = "MATH 141";
    pre.add(a);
    pre.add(b);
    pre.add(c);
    pre.add(d);
    pre.add(e);
    pre.add(f);

    facade.getCourseList().addCourse("CHEM 112 General Chemistry II", 
                                    "SCI", 
                                    CHEM112, 
                                    3, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "2", 
                                    "3");
    // CHEM 112L
    String CHEM112L =
      "Continuation of CHEM 111L with emphasis on solution properties," +
      " kinetics, equilibrium, acids and bases, and qualitative analysis.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "CHEM 111";
    String h = "CHEM 111L";
    String i = "CHEM 141";
    require.add(g);
    require.add(h);
    require.add(i);

    facade.getCourseList().addCourse("CHEM 112L General Chemistry II Lab", 
                                    "SCI", 
                                    CHEM112L, 
                                    1, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "2", 
                                    "3");

    // PHYS 212
    String PHYS212 = 
        "Classical electromagnetism and optics.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String j = "CHEM 111";
    String k = "CHEM 141";
    String l = "MATH 111";
    String m = "MATH 115";
    String n = "MATH 122";
    String o = "MATH 141";
    requiredpre.add(j);
    requiredpre.add(k);
    requiredpre.add(l);
    requiredpre.add(m);
    requiredpre.add(n);
    requiredpre.add(o);
    
    facade.getCourseList().addCourse("PHYS 212 Essentials of Physics II", 
                                     "SCI", 
                                     PHYS212,
                                     3, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requiredpre, 
                                     "2", 
                                     "3");
    // PHYS 212L
    String PHYS212L =
        "Experiments, exercises, and demonstrations to accompany PHYS 212";
    ArrayList<String> requires = new ArrayList<String>();
    String t = "PHYS 211";
    String u = "MATH 142";
    requires.add(t);
    requires.add(u);

    facade.getCourseList().addCourse("PHYS 212L Essentials of Physics II Laboratory", 
                                     "SCI", 
                                     PHYS212L, 
                                     1, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requires, 
                                     "2", 
                                     "3");
    // SPCH 140
    String SPCH140 = 
      "Introduction to theory and practice of oral communication in public, social, and institutional" +
      " contexts. Includes foundational and cumulative training in the invention, performance, and critical" +
      " analysis of oral communication, with emphasis on argumentation, persuasion, audience analysis, delivery," +
      " and eithical forms of engagement.";
    ArrayList<String> prer = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 140 Public Communication", 
                                     "CMS", 
                                     SPCH140, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     prer, 
                                     "2", 
                                     "3");
    // SPCH 145
    String SPCH145 =
      "Introduction to theory and practice of live and recorded online spoken communcation" + 
      " in public, social, and institutional contexts. Training in invention, performance, and " +
      "critical analysis of online spoken communication, including audience analysis, persuasion, delivery, "+
      "and ethical engagement. Includes signinficant practice in preparing and presenting live "+
      "online public communication.";
    ArrayList<String> pR = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 145 Online Public Communication", 
                                     "CMS", 
                                     SPCH145, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     pR, 
                                     "2", 
                                     "3");

    // SPCH 230
    String SPCH230 =
      "Fundamentals of oral communication within business and professional settings. Includes performance.";
    ArrayList<String> preRequired = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 230 Business and Professional Speaking", 
                                     "CMS", 
                                     SPCH230, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     preRequired, 
                                     "2", 
                                     "3");
    facade.saveCourses();
  }
  public void addingSem4Courses() {
    // CSCE 212
    String CSCE212 = 
          "Computer architecture, components, and organization; memory addressing;" +
          " Input/Output; instruction sets; interrupts; assembly-language programming. Students" +
          " may not apply both CSCE 210 and CSCE 212 to any minor or major program of study.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "CSCE 211";
    String pre2 = "CSCE 145";
    String pre3 = "CSCE 206";
    preReqs.add(pre1);
    preReqs.add(pre2);
    preReqs.add(pre3);

    facade.getCourseList().addCourse("CSCE 212 Introduction to Computer Architecture", 
                                     "PR", 
                                     CSCE212, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs, 
                                     "2", 
                                     "4");

    // CSCE 247
    String CSCE247 =
      "Fundamentals of software design and development; software implementation strategies; "+
      "object-oriented design techniques; functional design techniques; design patterns; "+
      "design process; source control; testing.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preRe = "CSCE 146";
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 247 Software Engineering", 
                                      "PR", 
                                      CSCE247, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "2", 
                                      "4");
    // Laboratory Science Elective 1
    String ANTH161 =
      "An introduction to the science of biological anthropology, a sub-field of anthropology" +
      " that emphasizes a focus on humanity and its origin from a biological perspective, employing laboratory"+
      " components to complement and reinforce lecture materials.";
    ArrayList<String> preRequirement = new ArrayList<String>();

    facade.getCourseList().addCourse("ANTH 161 - Human Origins: An Introduction to Biological Anthropology", 
                                      "PR", 
                                      ANTH161, 
                                      4, 
                                      "ANTH", 
                                      'C', 
                                      true, 
                                      false, 
                                      preRequirement,
                                      "2", 
                                      "4");
    // Laboratory Science Elective 2
    String BIOL101 =
       "Introduction survey of macromolecules, cell structure and function," +
       " genetics, and molecular biology.";
    ArrayList<String> pre = new ArrayList<String>();

    facade.getCourseList().addCourse("BIOL 101 Biological Principles I", 
                                    "PR", 
                                    BIOL101, 
                                    3, 
                                    "BIOL", 
                                    'C', 
                                    true, 
                                    false, 
                                    pre, 
                                    "2", 
                                    "4");
    // MATH 241
    String MATH241 =
      "Vector algebra, geometry of three-dimensional space; lines, planes, and"+
      " curves in space; polar, cylindrical, and sphericl coordinte systems; partial differentiation,"+
      " max-min theory; multiple and iterated integration, line integrals, and Green's theorem in the plane.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "MATH 142";
    require.add(g);

    facade.getCourseList().addCourse("MATH 241 Vector Calculus", 
                                    "PR", 
                                    MATH241, 
                                    3, 
                                    "MATH", 
                                    'C', 
                                    false, 
                                    false, 
                                    require, 
                                    "2", 
                                    "4");

    // Carolina Core GSS 1
    String SOCY101 = 
        "An introduction to sociological facts and principles: "+
        "an analysis of group-making processes and products.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    
    facade.getCourseList().addCourse("SOCY 101 Introductory Sociology", 
                                     "GSS", 
                                     SOCY101,
                                     3, 
                                     "SOCY", 
                                     'C', 
                                     false, 
                                     true, 
                                     requiredpre,
                                     "2", 
                                     "4");
    // Carolina Core GSS 2
    String CRJU101 =
        "Survey of crime and societal responses to crime, including law"+
        " enforcement, courts, corrections, and the juvenile justice system.";
    ArrayList<String> requires = new ArrayList<String>();

    facade.getCourseList().addCourse("CRJU 101 The American Criminal Justice System", 
                                     "GSS", 
                                     CRJU101, 
                                     3, 
                                     "CRJU", 
                                     'C', 
                                     false, 
                                     true, 
                                     requires, 
                                     "2", 
                                     "4");
    facade.saveCourses();
  }
  public void addingSem5Courses() {
    // CSCE 311
    String CSCE311 = 
          "Operating system structure and function; process implementation, scheduling," +
          " and synchronization; memory management; security; naming protection; resource allocation;"+
          " network file systems.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "CSCE 240";
    String pre2 = "CSCE 210";
    String pre3 = "CSCE 212";
    preReqs.add(pre1);
    preReqs.add(pre2);
    preReqs.add(pre3);

    facade.getCourseList().addCourse("CSCE 311 Operating Systems", 
                                     "MR", 
                                     CSCE311, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs,
                                     "3", 
                                     "5");

    // CSCE 330
    String CSCE330 =
      "Formal specification of syntax and semantics; structure of algorithms; list processing" +
      " and string manipulation languages; statement types, control structures, and interfacing procedures.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "CSCE 240";
    String preRe = "MATH 174";
    String preReq = "MATH 374";
    String preRequ = "MATH 574";
    preRequire.add(preR);
    preRequire.add(preRe);
    preRequire.add(preReq);
    preRequire.add(preRequ);

    facade.getCourseList().addCourse("CSCE 330 Programming Language Structures", 
                                      "MR", 
                                      CSCE330, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "3", 
                                      "5");
    // CSCE 350
    String CSCE350 =
      "Techniques for representing and processing information, including the use of"+
      " lists, trees, and graphs; analysis of algorithms; sorting, searching and hashing techniques.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "CSCE 240";
    String r = "MATH 174";
    String e = "MATH 374";
    String q = "MATH 574";
    preRequirement.add(p);
    preRequirement.add(r);
    preRequirement.add(e);
    preRequirement.add(q);

      facade.getCourseList().addCourse("CSCE 350 Data Structures and Algorithms", 
                                      "MR", 
                                      CSCE350, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "3", 
                                      "5");
    // CSCE 390
    String CSCE390 =
       "Professional issues in the information technology professions; history and social context of" +
       " computing; professional responsibilities; privacy; intellectual property; risks and"+
       " liabilities of computer-based systems.";
    ArrayList<String> pre = new ArrayList<String>();

    facade.getCourseList().addCourse("CSCE 390 Prof. Issues in Computer Science Engr.", 
                                    "VSR", 
                                    CSCE390, 
                                    1, 
                                    "CSCE", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre,
                                    "3", 
                                    "5");
    // ENGL 462
    String ENGL462 =
      "Preparation for and practice in types of writing important to" +
      " scientists, engineers, and computer scientists, from brief technical" +
      " letters to formal articles and reports.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "ENGL 101";
    String h = "ENGL 102";
    require.add(g);
    require.add(h);

    facade.getCourseList().addCourse("ENGL 462 Technical Writing", 
                                    "PR", 
                                    ENGL462, 
                                    3, 
                                    "ENGL", 
                                    'C', 
                                    false, 
                                    false, 
                                    require, 
                                    "3", 
                                    "5");

    // ENGL 463
    String ENGL463 = 
        "Extensive practice in different types of business writing, from"+
        " brief letters to formal articles and reports.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String j = "ENGL 101";
    String k = "ENGL 102";
    requiredpre.add(j);
    requiredpre.add(k);
    
    facade.getCourseList().addCourse("ENGL 463 Business Writing", 
                                     "PR", 
                                     ENGL463,
                                     3, 
                                     "ENGL", 
                                     'C', 
                                     false, 
                                     false, 
                                     requiredpre, 
                                     "3", 
                                     "5");
    //Application Area 1
    String CSCE518 =
        "Fundamental principles and techniques of ethical hacking, including" +
        " penetration testing life cycle, planning and scoping, identifying targerts" +
        " and goals, active and passive reconnaissance, enumeration and scanning, exploitation," + 
        " post-exploitation, and results reporting.";
    ArrayList<String> requires = new ArrayList<String>();
    String t = "CSCE 215";
    requires.add(t);

    facade.getCourseList().addCourse("CSCE 518 Ethical Hacking", 
                                     "PR", 
                                     CSCE518, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false, 
                                     requires, 
                                     "3", 
                                     "5");
    // Application Area 2
    String CSCE526 = 
      "Cooperative information systems and service-oriented computing. Techniques for achieving"+
      " coordinated behavior among a decentralized group of information system components." +
      " Distributed databases, multiagent systems, conceptual modeling, Web services, and applications.";
    ArrayList<String> prer = new ArrayList<String>();
    String l = "CSCE 311";
    prer.add(l);

    facade.getCourseList().addCourse("CSCE 526 Service Oriented Computing ", 
                                     "PR", 
                                     CSCE526, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false, 
                                     prer, 
                                     "3", 
                                     "5");
    facade.saveCourses();
  }
  // ----------------------------- From This point forward course adding is not complete---------------------
  // In Progress do not test these are just the templates
  public void addingSem6Courses() {
    // CSCE 416
    String CSCE416 = 
          "Number systems, Boolean algebra, logic design, sequential machines.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "CSCE 146";
    preReqs.add(pre1);

    facade.getCourseList().addCourse("CSCE 416 Introduction to Computer Networks", 
                                     "MR", 
                                     CSCE416, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs, 
                                     "3", 
                                     "6");

    // CSCE Major Elective 1
    String CSCE240 =
      "Pointers; memory management; advanced programming language structures: operator" +
      " overloading, iterators, multiple inheritance, polymorphism, templates, virtual "+
      "functions; Unix programming environment.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "CSCE 215";
    String preRe = "CSCE 146";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 240 Advanced Programming Techniques", 
                                      "PR", 
                                      CSCE240, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "2", 
                                      "3");
    // CSCE Major Elective 2
    String MATH374 =
      "Propositional and predicate logic; proof techniques; recursion and " +
      "recurrence relations; sets, combinatorics, and probability; functions, relations," +
      "and matrices; algebraic structures.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 142";
    String r = "CSCE 146";
    preRequirement.add(p);
    preRequirement.add(r);

      facade.getCourseList().addCourse("MATH 374 Discrete Structures", 
                                      "PR", 
                                      MATH374, 
                                      3, 
                                      "MATH", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "2", 
                                      "3");
    // STAT 509
    String CHEM112 =
       "Continuation of CHEM 111. Special emphasis on chemical equilibrium.";
    ArrayList<String> pre = new ArrayList<String>();
    String a = "CHEM 111";
    String b = "CHEM 141";
    String c = "MATH 111";
    String d = "MATH 115";
    String e = "MATH 122";
    String f = "MATH 141";
    pre.add(a);
    pre.add(b);
    pre.add(c);
    pre.add(d);
    pre.add(e);
    pre.add(f);

    facade.getCourseList().addCourse("CHEM 112 General Chemistry II", 
                                    "SCI", 
                                    CHEM112, 
                                    3, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "2", 
                                    "3");
    // Liberal Arts Elective 1
    String CHEM112L =
      "Continuation of CHEM 111L with emphasis on solution properties," +
      " kinetics, equilibrium, acids and bases, and qualitative analysis.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "CHEM 111";
    String h = "CHEM 111L";
    String i = "CHEM 141";
    require.add(g);
    require.add(h);
    require.add(i);

    facade.getCourseList().addCourse("CHEM 112L General Chemistry II Lab", 
                                    "SCI", 
                                    CHEM112L, 
                                    1, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "2", 
                                    "3");

    // Liberal Arts Elective 2
    String PHYS212 = 
        "Classical electromagnetism and optics.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String j = "CHEM 111";
    String k = "CHEM 141";
    String l = "MATH 111";
    String m = "MATH 115";
    String n = "MATH 122";
    String o = "MATH 141";
    requiredpre.add(j);
    requiredpre.add(k);
    requiredpre.add(l);
    requiredpre.add(m);
    requiredpre.add(n);
    requiredpre.add(o);
    
    facade.getCourseList().addCourse("PHYS 212 Essentials of Physics II", 
                                     "SCI", 
                                     PHYS212,
                                     3, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requiredpre, 
                                     "2", 
                                     "3");
    // Application Area 1
    String PHYS212L =
        "Experiments, exercises, and demonstrations to accompany PHYS 212";
    ArrayList<String> requires = new ArrayList<String>();
    String t = "PHYS 211";
    String u = "MATH 142";
    requires.add(t);
    requires.add(u);

    facade.getCourseList().addCourse("PHYS 212L Essentials of Physics II Laboratory", 
                                     "SCI", 
                                     PHYS212L, 
                                     1, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requires, 
                                     "2", 
                                     "3");
    // Application Area 2
    String SPCH140 = 
      "Introduction to theory and practice of oral communication in public, social, and institutional" +
      " contexts. Includes foundational and cumulative training in the invention, performance, and critical" +
      " analysis of oral communication, with emphasis on argumentation, persuasion, audience analysis, delivery," +
      " and eithical forms of engagement.";
    ArrayList<String> prer = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 140 Public Communication", 
                                     "CMS", 
                                     SPCH140, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     prer, 
                                     "2", 
                                     "3");
    facade.saveCourses();
  }
  public void addingSem7Courses() {
    // CSCE 490
    String CSCE211 = 
          "Number systems, Boolean algebra, logic design, sequential machines.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 141";
    preReqs.add(pre1);

    facade.getCourseList().addCourse("CSCE 211 Digital Logic Design", 
                                     "PR", 
                                     CSCE211, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs, 
                                     "2", 
                                     "3");

    // CSCE 355
    String CSCE240 =
      "Pointers; memory management; advanced programming language structures: operator" +
      " overloading, iterators, multiple inheritance, polymorphism, templates, virtual "+
      "functions; Unix programming environment.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "CSCE 215";
    String preRe = "CSCE 146";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 240 Advanced Programming Techniques", 
                                      "PR", 
                                      CSCE240, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "2", 
                                      "3");
    // Major Elective 1
    String MATH374 =
      "Propositional and predicate logic; proof techniques; recursion and " +
      "recurrence relations; sets, combinatorics, and probability; functions, relations," +
      "and matrices; algebraic structures.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 142";
    String r = "CSCE 146";
    preRequirement.add(p);
    preRequirement.add(r);

      facade.getCourseList().addCourse("MATH 374 Discrete Structures", 
                                      "PR", 
                                      MATH374, 
                                      3, 
                                      "MATH", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "2", 
                                      "3");
    // Major Elective 2
    String CHEM112 =
       "Continuation of CHEM 111. Special emphasis on chemical equilibrium.";
    ArrayList<String> pre = new ArrayList<String>();
    String a = "CHEM 111";
    String b = "CHEM 141";
    String c = "MATH 111";
    String d = "MATH 115";
    String e = "MATH 122";
    String f = "MATH 141";
    pre.add(a);
    pre.add(b);
    pre.add(c);
    pre.add(d);
    pre.add(e);
    pre.add(f);

    facade.getCourseList().addCourse("CHEM 112 General Chemistry II", 
                                    "SCI", 
                                    CHEM112, 
                                    3, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "2", 
                                    "3");
    // MATH 344
    String CHEM112L =
      "Continuation of CHEM 111L with emphasis on solution properties," +
      " kinetics, equilibrium, acids and bases, and qualitative analysis.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "CHEM 111";
    String h = "CHEM 111L";
    String i = "CHEM 141";
    require.add(g);
    require.add(h);
    require.add(i);

    facade.getCourseList().addCourse("CHEM 112L General Chemistry II Lab", 
                                    "SCI", 
                                    CHEM112L, 
                                    1, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "2", 
                                    "3");

    // MATH 344L
    String PHYS212 = 
        "Classical electromagnetism and optics.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String j = "CHEM 111";
    String k = "CHEM 141";
    String l = "MATH 111";
    String m = "MATH 115";
    String n = "MATH 122";
    String o = "MATH 141";
    requiredpre.add(j);
    requiredpre.add(k);
    requiredpre.add(l);
    requiredpre.add(m);
    requiredpre.add(n);
    requiredpre.add(o);
    
    facade.getCourseList().addCourse("PHYS 212 Essentials of Physics II", 
                                     "SCI", 
                                     PHYS212,
                                     3, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requiredpre, 
                                     "2", 
                                     "3");
    // Application Area 1
    String PHYS212L =
        "Experiments, exercises, and demonstrations to accompany PHYS 212";
    ArrayList<String> requires = new ArrayList<String>();
    String t = "PHYS 211";
    String u = "MATH 142";
    requires.add(t);
    requires.add(u);

    facade.getCourseList().addCourse("PHYS 212L Essentials of Physics II Laboratory", 
                                     "SCI", 
                                     PHYS212L, 
                                     1, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requires, 
                                     "2", 
                                     "3");
    // Application Area 2
    String SPCH140 = 
      "Introduction to theory and practice of oral communication in public, social, and institutional" +
      " contexts. Includes foundational and cumulative training in the invention, performance, and critical" +
      " analysis of oral communication, with emphasis on argumentation, persuasion, audience analysis, delivery," +
      " and eithical forms of engagement.";
    ArrayList<String> prer = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 140 Public Communication", 
                                     "CMS", 
                                     SPCH140, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     prer, 
                                     "2", 
                                     "3");
    facade.saveCourses();
  }
  public void addingSem8Courses() {
    // CSCE 492
    String CSCE211 = 
          "Number systems, Boolean algebra, logic design, sequential machines.";
    ArrayList<String> preReqs = new ArrayList<String>();
    String pre1 = "MATH 141";
    preReqs.add(pre1);

    facade.getCourseList().addCourse("CSCE 211 Digital Logic Design", 
                                     "PR", 
                                     CSCE211, 
                                     3, 
                                     "CSCE", 
                                     'C', 
                                     false, 
                                     false,
                                     preReqs, 
                                     "2", 
                                     "3");

    // Major Elective 1
    String CSCE240 =
      "Pointers; memory management; advanced programming language structures: operator" +
      " overloading, iterators, multiple inheritance, polymorphism, templates, virtual "+
      "functions; Unix programming environment.";
    ArrayList<String> preRequire = new ArrayList<String>();
    String preR = "CSCE 215";
    String preRe = "CSCE 146";
    preRequire.add(preR);
    preRequire.add(preRe);

    facade.getCourseList().addCourse("CSCE 240 Advanced Programming Techniques", 
                                      "PR", 
                                      CSCE240, 
                                      3, 
                                      "CSCE", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequire, 
                                      "2", 
                                      "3");
    // Major Elective 2
    String MATH374 =
      "Propositional and predicate logic; proof techniques; recursion and " +
      "recurrence relations; sets, combinatorics, and probability; functions, relations," +
      "and matrices; algebraic structures.";
    ArrayList<String> preRequirement = new ArrayList<String>();
    String p = "MATH 142";
    String r = "CSCE 146";
    preRequirement.add(p);
    preRequirement.add(r);

      facade.getCourseList().addCourse("MATH 374 Discrete Structures", 
                                      "PR", 
                                      MATH374, 
                                      3, 
                                      "MATH", 
                                      'C', 
                                      false, 
                                      false, 
                                      preRequirement, 
                                      "2", 
                                      "3");
    // Liberal Arts Elective 1
    String CHEM112 =
       "Continuation of CHEM 111. Special emphasis on chemical equilibrium.";
    ArrayList<String> pre = new ArrayList<String>();
    String a = "CHEM 111";
    String b = "CHEM 141";
    String c = "MATH 111";
    String d = "MATH 115";
    String e = "MATH 122";
    String f = "MATH 141";
    pre.add(a);
    pre.add(b);
    pre.add(c);
    pre.add(d);
    pre.add(e);
    pre.add(f);

    facade.getCourseList().addCourse("CHEM 112 General Chemistry II", 
                                    "SCI", 
                                    CHEM112, 
                                    3, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    pre, 
                                    "2", 
                                    "3");
    // Liberal Arts Elective 2
    String CHEM112L =
      "Continuation of CHEM 111L with emphasis on solution properties," +
      " kinetics, equilibrium, acids and bases, and qualitative analysis.";
    ArrayList<String> require = new ArrayList<String>();
    String g = "CHEM 111";
    String h = "CHEM 111L";
    String i = "CHEM 141";
    require.add(g);
    require.add(h);
    require.add(i);

    facade.getCourseList().addCourse("CHEM 112L General Chemistry II Lab", 
                                    "SCI", 
                                    CHEM112L, 
                                    1, 
                                    "CHEM", 
                                    'C', 
                                    false, 
                                    true, 
                                    require, 
                                    "2", 
                                    "3");

    // Liberal Arts Elective 3
    String PHYS212 = 
        "Classical electromagnetism and optics.";
    ArrayList<String> requiredpre = new ArrayList<String>();
    String j = "CHEM 111";
    String k = "CHEM 141";
    String l = "MATH 111";
    String m = "MATH 115";
    String n = "MATH 122";
    String o = "MATH 141";
    requiredpre.add(j);
    requiredpre.add(k);
    requiredpre.add(l);
    requiredpre.add(m);
    requiredpre.add(n);
    requiredpre.add(o);
    
    facade.getCourseList().addCourse("PHYS 212 Essentials of Physics II", 
                                     "SCI", 
                                     PHYS212,
                                     3, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requiredpre, 
                                     "2", 
                                     "3");
    // Liberal Arts Elective 4
    String PHYS212L =
        "Experiments, exercises, and demonstrations to accompany PHYS 212";
    ArrayList<String> requires = new ArrayList<String>();
    String t = "PHYS 211";
    String u = "MATH 142";
    requires.add(t);
    requires.add(u);

    facade.getCourseList().addCourse("PHYS 212L Essentials of Physics II Laboratory", 
                                     "SCI", 
                                     PHYS212L, 
                                     1, 
                                     "PHYS", 
                                     'C', 
                                     false, 
                                     true, 
                                     requires, 
                                     "2", 
                                     "3");
    // Carolina Core GHS 1
    String SPCH140 = 
      "Introduction to theory and practice of oral communication in public, social, and institutional" +
      " contexts. Includes foundational and cumulative training in the invention, performance, and critical" +
      " analysis of oral communication, with emphasis on argumentation, persuasion, audience analysis, delivery," +
      " and eithical forms of engagement.";
    ArrayList<String> prer = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 140 Public Communication", 
                                     "CMS", 
                                     SPCH140, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     prer, 
                                     "2", 
                                     "3");
    // Carolina Core GHS 2
    String SPCH145 =
      "Introduction to theory and practice of live and recorded online spoken communcation" + 
      " in public, social, and institutional contexts. Training in invention, performance, and " +
      "critical analysis of online spoken communication, including audience analysis, persuasion, delivery, "+
      "and ethical engagement. Includes signinficant practice in preparing and presenting live "+
      "online public communication.";
    ArrayList<String> pR = new ArrayList<String>();

    facade.getCourseList().addCourse("SPCH 145 Online Public Communication", 
                                     "CMS", 
                                     SPCH145, 
                                     3, 
                                     "SPCH", 
                                     'C', 
                                     false, 
                                     true, 
                                     pR, 
                                     "2", 
                                     "3");

    // GFL???
    facade.saveCourses();
  }
  public static void main(String[] args) {
    Driver advisingInterface = new Driver();
    advisingInterface.run();
  }
}
