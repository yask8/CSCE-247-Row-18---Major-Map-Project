package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

public class MajorMap {

  private UUID id;
  private String major;
  private ArrayList<String> majorCourses;
  private ArrayList<String> programCourses;
  private ArrayList<String> coreEdu;
  private ArrayList<String> appArea;
  private int minTotalHours;
  private int minGradHours;
  private int caroCoreHours;
  private Double minGPA;

  public MajorMap(
      UUID id,
      String major,
      ArrayList<String> majorCourses,
      ArrayList<String> programCourses,
      ArrayList<String> coreEdu,
      ArrayList<String> appArea,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = id;
    this.major = major;
    this.majorCourses = majorCourses;
    this.programCourses = programCourses;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  public MajorMap(
      String major,
      ArrayList<String> majorCourses,
      ArrayList<String> programCourses,
      ArrayList<String> coreEdu,
      ArrayList<String> appArea,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = UUID.randomUUID();
    this.major = major;
    this.majorCourses = majorCourses;
    this.programCourses = programCourses;
    this.coreEdu = coreEdu;
    this.appArea = appArea;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  public void deleteMajor(String major) {
    if (this.major.equals(major)) {
      this.major = null;
      this.majorCourses = null;
      this.programCourses = null; 
      this.coreEdu = null;
      this.appArea = null;
      this.id = null;
      this.minTotalHours = 0;
      this.minGradHours = 0;
      this.caroCoreHours = 0;
      this.minGPA = 0.0;
    }
  }

  public void displayMajorMap(String major) {
    if (this.major.equals(major)) {
      System.out.println("\n************ Major Map *************");
      System.out.println("Major: " + this.major);
      System.out.println("MajorMap ID: " + this.id);
      System.out.println("Major Courses: " + this.majorCourses);
      System.out.println("Program Courses: " + this.programCourses); 
      System.out.println("Carolina Core: " + this.coreEdu);
      System.out.println("Application Area: " + this.appArea);
      System.out.println("Minimum Total Hours: " + this.minTotalHours);
      System.out.println("Minimum Grad Hours: " + this.minGradHours);
      System.out.println("Carolina Core Hours: " + this.caroCoreHours);
      System.out.println("Minimum GPA: " + this.minGPA);
    } else {
      System.out.println("No matching major found.");
    }
  }

  public String toString() {
    return "\n********* MAJOR MAP *********\n" +
          "Major: " + this.major + "\n" +
          "MajorMap ID: " + this.id + "\n" +
          "\n********* Minimum Requirements *********\n" +
          "Minimum Total Hours: " + this.minTotalHours + "\n" +
          "Minimum Grad Hours: " + this.minGradHours + "\n" +
          "Carolina Core Hours: " + this.caroCoreHours + "\n" +
          "Minimum GPA: " + this.minGPA + "\n" +
          "\n********* Major Courses *********\n" +
          "Major Courses: " + this.majorCourses + "\n" +
          "\n********* Program Courses *********\n" +
          "Program Courses: " + this.programCourses + "\n" + 
          "\n********* Carolina Core *********\n" +
          "Carolina Core: " + this.coreEdu + "\n" +
          "\n********* Application Area *********\n" +
          "Application Area: " + this.appArea + "\n";
  }

  public UUID getId() {
    return id;
  }

  public String getMajor() {
    return major;
  }

  public ArrayList<String> getMajorCourses() {
    return majorCourses;
  }

  public ArrayList<String> getProgramCourses() {
    return programCourses;
  }

  public ArrayList<String> getCoreEdu() {
    return coreEdu;
  }

  public ArrayList<String> getAppArea() {
    return appArea;
  }

  public int getMinTotalHours() {
    return minTotalHours;
  }

  public int getMinGradHours() {
    return minGradHours;
  }

  public int getCaroCoreHours() {
    return caroCoreHours;
  }

  public Double getMinGPA() {
    return minGPA;
  }

  public void setMinTotalHours(int minTotalHr){
      if( minTotalHr > 0){
          this.minTotalHours = minTotalHr;
      }
  }

  public void setMinGradHours(int minGradHr){
      if(minGradHr > 0){
          this.minGradHours = minGradHr;
      }
  }

  public void setCaroCoreHours(int minCaroCoreHr){
    if(minCaroCoreHr > 0){
        this.caroCoreHours = minCaroCoreHr;
    }
  }

  public void setMinGPA(Double minGPA){
    if(minGPA > 0){
        this.minGPA = minGPA;
    }
  }

  public boolean containsCourse(String courseName) {
    return majorCourses.contains(courseName) || programCourses.contains(courseName) || 
           coreEdu.contains(courseName) || appArea.contains(courseName);
  }
}
