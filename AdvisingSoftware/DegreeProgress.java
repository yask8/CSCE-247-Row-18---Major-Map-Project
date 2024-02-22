package AdvisingSoftware;

import java.util.ArrayList;
import java.util.HashMap;
// TODO JAVA DOC AUTHOR GARRETT SPILLMAN
public class DegreeProgress {
    private String major;
    private ArrayList<Course> majorCourses;
    private ArrayList<Course> electiveCourses;
    private ArrayList<Course> minorCourses;
    private ArrayList<Course> carolinaCoreCourses;
    private ArrayList<Course> completeCourses;
    private ArrayList<Course> incompleteCourses;

    public DegreeProgress(String major, ArrayList<Course> majorCourses, ArrayList<Course> electiveCourses,
                          ArrayList<Course> minorCourses, ArrayList<Course> carolinaCoreCourses,
                          ArrayList<Course> completeCourses, ArrayList<Course> incompleteCourses) {
        this.major = major;
        this.majorCourses = majorCourses;
        this.electiveCourses = electiveCourses;
        this.minorCourses = minorCourses;
        this.carolinaCoreCourses = carolinaCoreCourses;
        this.completeCourses = completeCourses;
        this.incompleteCourses = incompleteCourses;
    }

    public String displayProgress(MajorMap majorMap, HashMap<String, ArrayList<Course>> completedCourses) {
        return ""; 
    }
}