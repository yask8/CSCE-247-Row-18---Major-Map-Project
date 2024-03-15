package AdvisingSoftware;

import java.util.ArrayList;

public class AppArea {

  /**
   * Attributes
   */
  private String appAreaName;
  private ArrayList<String> majorElectives = new ArrayList<String>();
  private ArrayList<String> appAreaCourses = new ArrayList<String>();
  private ArrayList<String> appAreaOptions = new ArrayList<String>();

  public AppArea(String appAreaName) {
    appAreaOptions.add("Science");
    appAreaOptions.add("Math");
    appAreaOptions.add("Digital Design");
    appAreaOptions.add("Robotics");
    appAreaOptions.add("Speech");
    if (appAreaOptions.contains(appAreaName)) {
      this.appAreaName = appAreaName;
    }
    setMajorElectives(appAreaName);
    setAppAreaCourses(appAreaName);
  }

  public String showAppAreaOptions() {
    String appAreaOptions = "*******Application Areas*******\n";
    for (String appArea : this.appAreaOptions) {
      appAreaOptions += appArea + ", ";
    }
    return appAreaOptions + "and more to come...";
  }

  public ArrayList<String> getAppAreaOptions() {
    return appAreaOptions;
  }

  public ArrayList<String> getmajorElectives() {
    return majorElectives;
  }

  public ArrayList<String> getAppAreaCourses() {
    return appAreaCourses;
  }

  public void setMajorElectives(String appAreaName) {
    if (appAreaName.equalsIgnoreCase("Science")) {
      majorElectives.add("CSCE520");
      majorElectives.add("CSCE580");
      majorElectives.add("CSCE582");
      majorElectives.add("CSCE567");
      majorElectives.add("CSCE578");
    }

    if (appAreaName.equalsIgnoreCase("Math")) {
      majorElectives.add("CSCE564");
      majorElectives.add("CSCE565");
      majorElectives.add("CSCE567");
      majorElectives.add("CSCE569");
    }
    if (appAreaName.equalsIgnoreCase("Digital Design")) {
      majorElectives.add("CSCE520");
      majorElectives.add("CSCE552");
      majorElectives.add("CSCE564");
      majorElectives.add("CSCE565");
      majorElectives.add("CSCE567");
    }
    if (appAreaName.equalsIgnoreCase("Robotics")) {
      majorElectives.add("CSCE574");
      majorElectives.add("CSCE580");
    }
    if (appAreaName.equalsIgnoreCase("Speech")) {
      majorElectives.add("CSCE520");
      majorElectives.add("CSCE531");
      majorElectives.add("CSCE587");
      majorElectives.add("CSCE580");
    }
  }

  public void setAppAreaCourses(String appAreaName) {
    if (appAreaName.equalsIgnoreCase("Science")) {
      appAreaCourses.add("STAT530");
      appAreaCourses.add("STAT511");
      appAreaCourses.add("STAT535");
      appAreaCourses.add("STAT511");
      appAreaCourses.add("STAT512");
      appAreaCourses.add("STAT513");
    }
    if (appAreaName.equalsIgnoreCase("Math")) {
      appAreaCourses.add("MATH242");
      appAreaCourses.add("MATH300");
      appAreaCourses.add("MATH520");
      appAreaCourses.add("MATH546");
      appAreaCourses.add("MATH554");
      appAreaCourses.add("MATH574");
    }
    if (appAreaName.equalsIgnoreCase("Digital Design")) {
      appAreaCourses.add("MART201");
      appAreaCourses.add("MART210");
      appAreaCourses.add("MART371");
      appAreaCourses.add("MART380");
    }
    if (appAreaName.equalsIgnoreCase("Robotics")) {
      appAreaCourses.add("EMCH535");
      appAreaCourses.add("ELCT331");
      appAreaCourses.add("ELCT531");
    }
    if (appAreaName.equalsIgnoreCase("Speech")) {
      appAreaCourses.add("LING340");
      appAreaCourses.add("LING421");
      appAreaCourses.add("LING440");
      appAreaCourses.add("LING565");
      appAreaCourses.add("LING567");
    }
  }

  public String toString() {
    String appAreaText = "";
    appAreaText += "\n*******Application Area*******\n";
    appAreaText += appAreaName;

    appAreaText += "\n*******Major Electives*******\n";
    for (String electiveM : majorElectives) {
      appAreaText += electiveM;
      appAreaText += "\n";
    }

    appAreaText += "\n*******Application Area Courses*******\n";
    for (String appAreaC : appAreaCourses) {
      appAreaText += appAreaC;
      appAreaText += "\n";
    }
    return appAreaText;
  }
}
