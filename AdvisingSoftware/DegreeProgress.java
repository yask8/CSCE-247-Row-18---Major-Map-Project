package AdvisingSoftware;

import java.util.ArrayList;
import java.util.HashMap;

// TODO JAVA DOC AUTHOR GARRETT SPILLMAN
public class DegreeProgress {
    private String major;
    private ArrayList<String> completeCourses;
    private ArrayList<String> incompleteCourses;

    public DegreeProgress(String major, ArrayList<String> completeCourses, ArrayList<String> incompleteCourses) {
        this.major = major;
        this.completeCourses = completeCourses;
        this.incompleteCourses = incompleteCourses;
    }

    public String displayProgress(MajorMap majorMap, HashMap<String, ArrayList<Course>> completedCourses) {
        return "-----Degree Progress-----"
                + "Current Major: " + this.major;
    }

    public String toString() {
        String result = "\n";
        result += "Current Major: " + this.major + "\n";

        result += "\n********* Completed Courses *********\n";
        if (completeCourses.isEmpty()) {
            result += "No completed courses specified.\n";
        } else {
            result += "Completed Courses: " + this.completeCourses + "\n";
        }

        result += "\n********* Incomplete Courses *********\n";
        if (incompleteCourses.isEmpty()) {
            result += "No incomplete courses specified.\n";
        } else {
            result += "Incomplete Courses: " + this.incompleteCourses + "\n";
        }

        return result;
    }

    public String getMajor() {
        return major;
    }

    public ArrayList<String> getCompleteCourses() {
        return completeCourses;
    }

    public ArrayList<String> getIncompleteCourses() {
        return incompleteCourses;
    }
}