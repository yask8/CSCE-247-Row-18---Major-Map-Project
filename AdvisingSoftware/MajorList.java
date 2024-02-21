/**
 * MajorList class for managing majors
 * @author yask8(ykennedy)
 */
package AdvisingSoftware;

import java.util.ArrayList;

public class MajorList {
    /**
     * Attributes
     */
    static private MajorList majorList;
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
    static public MajorList getInstance(){
        return majorList;
    }
    /**
     * Get a major by the name from the Major Map
     * @param major the major from the Major Map
     * @return The major or null if not found
     */
    public MajorMap getMajor(String major){
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
    public void addMajor(String majorName, ArrayList<Course> majorCourses, ArrayList<Course> majorElectives, ArrayList<Course> minorElectives, ArrayList<Course> coreEdu, ArrayList<Course> appArea){
    }
    /**
     * Removes a major from the list of majors by their name
     * @param major The name of the major
     */
    public void removeMajor(String major){
    }
}
