package AdvisingSoftware;
/**
 * Holds the Grades
 * @author yask8(Yasmine Kennedy)
 */
public class Grades {
    /**
     * Attributes
     */
    private double grade;
    private String courseName;
    /**
     * Constructor for Grades
     * @param course The course 
     * @param grade The grade for that course
     */
    public Grades(String course, double grade){
        this.grade = grade;
        courseName = course;
    }
    /**
     * Get the grade
     * @return The grade received
     */
    public Double getGrade(){
        if(grade > 0){
            return this.grade;
        } else {
            return null;
        }
    }
    /**
     * Gets the name of the course
     * @return The name of the course
     */
    public String getCourseName(){
        return courseName;
    }
    /**
     * Sets the grade
     * @param grade The grade recieved for a class
     */
    public void setGrade(double grade){
        this.grade = grade;
    }
    /**
     * Sets the course name
     * @param course The name of the course
     */
    public void setCourseName(String course){
        this.courseName = course;
    }
    /**
     * Displays the course and the grade with a comma
     * @return The course and the grade
     */
    public String toString(){
       return courseName + " : " + grade;
    }
}
