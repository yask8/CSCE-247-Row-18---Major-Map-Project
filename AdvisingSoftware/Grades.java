package AdvisingSoftware;
/**
 * Holds the Grades
 * @author yask8(Yasmine Kennedy)
 */
public class Grades {
    double grade;
    String courseName;
    /**
     * Constructor for Grades
     * @param course the course 
     * @param grade the grade for that course
     */
    public Grades(String course, double grade){
        this.grade = grade;
        courseName = course;
    }
    /**
     * Get the grade
     * @return the grade received
     */
    public Double getGrade(){
        if(grade > 0){
            return this.grade;
        } else {
            return null;
        }
    }
    /**
     * Sets the grade
     * @param grade the grade recieved for a class
     */
    public void setGrade(double grade){
        this.grade = grade;
    }
    /**
     * Displays the course and the grade with a comma
     * @return the course and the grade
     */
    public String displayGrades(){
       return courseName + "," + grade;
    }
    /**
     * Testing purposes
     * @param args
     */
    public static void main(String[] args) {
        Grades test = new Grades("CSCE145",99.5);
        System.out.println(test.displayGrades());
    }
}
