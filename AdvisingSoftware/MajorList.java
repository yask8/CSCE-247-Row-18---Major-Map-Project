/**
 * MajorList class for managing majors
 * @author yask8(Yasmine Kennedy)
 */
package AdvisingSoftware;

import java.util.ArrayList;

public class MajorList {

  /**
   * Attributes
   */
  private static MajorList majorList;
  private ArrayList<MajorMap> majors;

  /**
   * Private constructor for MajorList
   * Initializes the list of majors
   */
  private MajorList() {
    majors = new ArrayList<MajorMap>();
  }

  /**
   * Get the singleton instance of MajorList
   * @return the singleton instance of MajorList
   */
  public static MajorList getInstance() {
    if (majorList == null) {
      majorList = new MajorList();
    }
    return majorList;
  }

  /**
   * Get a major by the name from the Major Map
   * @param major the major from the Major Map
   * @return The major or null if not found
   */
  public MajorMap getMajor(String major) {
    for (MajorMap existingMajor : majors) {
      if (existingMajor.getMajor().equals(major)) {
        return existingMajor;
      }
    }
    return null;
  }

  /**
   * Add a major to the list
   * @param majorName The name of the major
   * @param majorCourses The courses offered by the major
   * @param majorElectives The electives offered by the major
   * @param minorElectives The electives offered by the minor
   * @param coreEdu The Carolina Core Classes
   * @param appArea The Application Area Classes
   */
  public void addMajor(
    String majorName,
    ArrayList<Course> majorCourses,
    ArrayList<Course> majorElectives,
    ArrayList<Course> minorElectives,
    ArrayList<Course> coreEdu,
    ArrayList<Course> appArea
  ) {
    MajorMap newMajor = new MajorMap(
      majorName,
      majorCourses,
      majorElectives,
      minorElectives,
      coreEdu,
      appArea
    );
    majors.add(newMajor);
  }

  /**
   * Removes a major from the list of majors by their name
   * @param major The name of the major
   */
  public void removeMajor(String major) {
    for (MajorMap existingMajors : majors) {
      if (existingMajors.getMajor().equals(major)) {
        majors.remove(major);
      } else if (major == null) {
        System.out.println(major + " does not exist.");
      }
    }
  }
}
