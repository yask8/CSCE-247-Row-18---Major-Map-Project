package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

public class MajorMap {

  private UUID id;
  private String major;
  private ArrayList<String> semester1;
  private ArrayList<String> semester2;
  private ArrayList<String> semester3;
  private ArrayList<String> semester4;
  private ArrayList<String> semester5;
  private ArrayList<String> semester6;
  private ArrayList<String> semester7;
  private ArrayList<String> semester8;
  private int minTotalHours;
  private int minGradHours;
  private int caroCoreHours;
  private Double minGPA;

  public MajorMap(
      UUID id,
      String major,
      ArrayList<String> semester1,
      ArrayList<String> semester2,
      ArrayList<String> semester3,
      ArrayList<String> semester4,
      ArrayList<String> semester5,
      ArrayList<String> semester6,
      ArrayList<String> semester7,
      ArrayList<String> semester8,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = id;
    this.major = major;
    this.semester1 = semester1;
    this.semester2 = semester2;
    this.semester3 = semester3;
    this.semester4 = semester4;
    this.semester5 = semester5;
    this.semester6 = semester6;
    this.semester7 = semester7;
    this.semester8 = semester8;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  public MajorMap(
      String major,
      ArrayList<String> semester1,
      ArrayList<String> semester2,
      ArrayList<String> semester3,
      ArrayList<String> semester4,
      ArrayList<String> semester5,
      ArrayList<String> semester6,
      ArrayList<String> semester7,
      ArrayList<String> semester8,
      int minTotalHours,
      int minGradHours,
      int caroCoreHours,
      Double minGPA) {
    this.id = UUID.randomUUID();
    this.major = major;
    this.semester1 = semester1;
    this.semester2 = semester2;
    this.semester3 = semester3;
    this.semester4 = semester4;
    this.semester5 = semester5;
    this.semester6 = semester6;
    this.semester7 = semester7;
    this.semester8 = semester8;
    this.minTotalHours = minTotalHours;
    this.minGradHours = minGradHours;
    this.caroCoreHours = caroCoreHours;
    this.minGPA = minGPA;
  }

  public void deleteMajor(String major) {
    if (this.major.equals(major)) {
      this.major = null;
      this.semester1 = null;
      this.semester2 = null;
      this.semester3 = null;
      this.semester4 = null;
      this.semester5 = null;
      this.semester6 = null;
      this.semester7 = null;
      this.semester8 = null;
      this.id = null;
      this.minTotalHours = 0;
      this.minGradHours = 0;
      this.caroCoreHours = 0;
      this.minGPA = 0.0;
    }
  }

  public ArrayList<String> getCoursesForMajor(String major) {
    if (this.major.equalsIgnoreCase(major)) {
      ArrayList<String> allCourses = new ArrayList<>();
      allCourses.addAll(semester1);
      allCourses.addAll(semester2);
      allCourses.addAll(semester3);
      allCourses.addAll(semester4);
      allCourses.addAll(semester5);
      allCourses.addAll(semester6);
      allCourses.addAll(semester7);
      allCourses.addAll(semester8);
      return allCourses;
    } else {
      return new ArrayList<>();
    }
  }

  public void displayMajorMap(String major) {
    if (this.major.equals(major)) {
      System.out.println("\n************ Major Map *************");
      System.out.println("Major: " + this.major);
      System.out.println("MajorMap ID: " + this.id);
      System.out.println("Semester 1: " + this.semester1);
      System.out.println("Semester 2: " + this.semester2);
      System.out.println("Semester 3: " + this.semester3);
      System.out.println("Semester 4: " + this.semester4);
      System.out.println("Semester 5: " + this.semester5);
      System.out.println("Semester 6: " + this.semester6);
      System.out.println("Semester 7: " + this.semester7);
      System.out.println("Semester 8: " + this.semester8);
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
        "\n********* By Semester Details *********\n" +
        "\n********* Year 1 *********\n" +
        "Semester 1: " + this.semester1 + "\n" +
        "Semester 2: " + this.semester2 + "\n" +
        "\n********* Year 2 *********\n" +
        "Semester 3: " + this.semester3 + "\n" +
        "Semester 4: " + this.semester4 + "\n" +
        "\n********* Year 3 *********\n" +
        "Semester 5: " + this.semester5 + "\n" +
        "Semester 6: " + this.semester6 + "\n" +
        "\n********* Year 4 *********\n" +
        "Semester 7: " + this.semester7 + "\n" +
        "Semester 8: " + this.semester8 + "\n";
  }

  public UUID getId() {
    return id;
  }

  public String getMajor() {
    return major;
  }

  public ArrayList<String> getSemester1() {
    return semester1;
  }

  public ArrayList<String> getSemester2() {
    return semester2;
  }

  public ArrayList<String> getSemester3() {
    return semester3;
  }

  public ArrayList<String> getSemester4() {
    return semester4;
  }

  public ArrayList<String> getSemester5() {
    return semester5;
  }

  public ArrayList<String> getSemester6() {
    return semester6;
  }

  public ArrayList<String> getSemester7() {
    return semester7;
  }

  public ArrayList<String> getSemester8() {
    return semester8;
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

  public void setMinTotalHours(int minTotalHr) {
    if (minTotalHr > 0) {
      this.minTotalHours = minTotalHr;
    }
  }

  public void setMinGradHours(int minGradHr) {
    if (minGradHr > 0) {
      this.minGradHours = minGradHr;
    }
  }

  public void setCaroCoreHours(int minCaroCoreHr) {
    if (minCaroCoreHr > 0) {
      this.caroCoreHours = minCaroCoreHr;
    }
  }

  public void setMinGPA(Double minGPA) {
    if (minGPA > 0) {
      this.minGPA = minGPA;
    }
  }

  public boolean containsCourse(String courseName) {
    return semester1.contains(courseName) || semester2.contains(courseName) ||
        semester3.contains(courseName) || semester4.contains(courseName) ||
        semester5.contains(courseName) || semester6.contains(courseName) ||
        semester7.contains(courseName) || semester8.contains(courseName);
  }
}
