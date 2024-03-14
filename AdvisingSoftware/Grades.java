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
     * Checks if grade is passing or failing
     * @author Lia Zhao(zhaolia9)
     * @param courseGrade the grade received
     * @return PASS or FAIL depending on grade
     */
    public String checkPass(double courseGrade) {
        boolean gradeDPlus = (courseGrade <= 65 && courseGrade >= 69.99);
        boolean gradeD = (courseGrade <= 60 && courseGrade >= 64.99);
        boolean gradeF = courseGrade < 59.99;
    
        if ((gradeDPlus) || (gradeD) || (gradeF)) {
          return "FAIL";
        } else {
          return "PASS";
        }
      }
    /**
     * Displays the course and the grade with a comma
     * @return The course and the grade
     */
    public String toString(){
       return courseName + ": " + grade + " --> " + checkPass(grade);
    }

    public static void main(String[] args) {
        String courseName = "CSCE 132";
        double grade = 92.8;
        Grades g = new Grades(courseName, grade);
        
        System.out.println(g.toString());

    }
}
