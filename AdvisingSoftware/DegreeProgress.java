package AdvisingSoftware;

import java.util.ArrayList;
import java.util.HashMap;

// TODO JAVA DOC AUTHOR GARRETT SPILLMAN
public class DegreeProgress {
    private String major;
    private ArrayList<Course> majorCourses;
    private ArrayList<Course> electiveCourses;
    private ArrayList<Course> carolinaCoreCourses;
    private ArrayList<Course> completeCourses;
    private ArrayList<Course> incompleteCourses;

    public DegreeProgress(String major, ArrayList<Course> majorCourses, ArrayList<Course> electiveCourses,
            ArrayList<Course> carolinaCoreCourses, ArrayList<Course> completeCourses,
            ArrayList<Course> incompleteCourses) {

        this.major = major;
        this.majorCourses = majorCourses;
        this.electiveCourses = electiveCourses;
        this.carolinaCoreCourses = carolinaCoreCourses;
        this.completeCourses = completeCourses;
        this.incompleteCourses = incompleteCourses;
    }

    public String displayProgress(MajorMap majorMap, HashMap<String, ArrayList<Course>> completedCourses) {
        // Check if courses are completed and print it in toString
        // Check if courses are not completed and print it in toString
        return "-----Degree Progress-----"
                + "Current Major: " + this.major;
    }

    /**
     * Searches for a course by its ID in all course lists.
     * Returns the first occurrence of the course with the given ID,
     * or null if not found.
     * 
     * @param courseId The ID of the course to search for.
     * @return The Course object if found, null otherwise.
     */
    public Course findCourseById(String courseId) {
        for (Course course : majorCourses) {
            if (course.getID().equals(courseId)) {
                return course;
            }
        }
        for (Course course : electiveCourses) {
            if (course.getID().equals(courseId)) {
                return course;
            }
        }
        for (Course course : carolinaCoreCourses) {
            if (course.getID().equals(courseId)) {
                return course;
            }
        }
        for (Course course : completeCourses) {
            if (course.getID().equals(courseId)) {
                return course;
            }
        }
        for (Course course : incompleteCourses) {
            if (course.getID().equals(courseId)) {
                return course;
            }
        }
        return null; // Course not found
    }

    public String toString() {
        String result = "\n";
        result += "Current Major: " + this.major + "\n";

        result += "\n********* Major Courses *********\n";
        if (majorCourses.isEmpty()) {
            result += "No major courses specified.\n";
        } else {
            result += "Major Courses: " + this.majorCourses + "\n";
        }

        result += "\n********* Elective Courses *********\n";
        if (electiveCourses.isEmpty()) {
            result += "No elective courses specified.\n";
        } else {
            result += "Elective Courses: " + this.electiveCourses + "\n";
        }

        result += "\n********* Carolina Core *********\n";
        if (carolinaCoreCourses.isEmpty()) {
            result += "No Carolina Core courses specified.\n";
        } else {
            result += "Carolina Core Courses: " + this.carolinaCoreCourses + "\n";
        }

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

    public ArrayList<Course> getMajorCourses() {
        return majorCourses;
    }

    public ArrayList<Course> getElectiveCourses() {
        return electiveCourses;
    }

    public ArrayList<Course> getCarolinaCoreCourses() {
        return carolinaCoreCourses;
    }

    public ArrayList<Course> getCompleteCourses() {
        return completeCourses;
    }

    public ArrayList<Course> getIncompleteCourses() {
        return incompleteCourses;

    }
}