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
                         ArrayList<Course> carolinaCoreCourses,ArrayList<Course> completeCourses, ArrayList<Course> incompleteCourses) {
        this.major = major;
        this.majorCourses = majorCourses;
        this.electiveCourses = electiveCourses;
        this.carolinaCoreCourses = carolinaCoreCourses;
        this.completeCourses = completeCourses;
        this.incompleteCourses = incompleteCourses;
    }

    public String displayProgress(MajorMap majorMap, ArrayList<Course> completedCourses) {
       //Check if courses are completed and print it in toString
       // MajorMap gets the courses
       // completed course bring in a list of courses
       String courseDone = "";
       String notDone = "";
       for(Course done : completedCourses){
            courseDone = "Course Code: "+ done.getCode() 
                        + "\nCourse Name: " + done.getName() + "\n";
       }
       // For loop to check aganist the courses they have done
       return "-----Degree Progress-----"
       + "\nCurrent Major: " + this.major + "\nCompleted Courses: " +
       courseDone;
    }
    
}