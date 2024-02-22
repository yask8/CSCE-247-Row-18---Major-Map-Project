/**
 * Will display the Graduation Requirements for the Majors
 * @author yask8(Yasmine Kennedy)
 */
package AdvisingSoftware;

public class GraduationRequirements {
    /**
     * Attributes
     */
    protected String major;
    protected int minTotalHours;
    protected int minGradHours;
    protected int caroCoreHours;
    protected Double minGPA;

    /**
     * Graduation Requirements that initializes the major and sets the 
     * respected hours
     * @param Major the major, used to separate different requirements
     */
    public GraduationRequirements(String Major){
        this.major = Major;
        setMinTotalHours(minTotalHours);
        setMinGradHours(minGradHours);
        setCaroCoreHours(caroCoreHours);
        setMinGPA(minGPA);
    }
    /**
     * Gets the minimum total hours required to graduate
     * @return the minimum total hours
     */
    public int getMinTotalHours(){
        return minTotalHours;
    }
    /**
     * Gets the minimum total graduation hours requried
     * @return the minimum graduation hours
     */
    public int getMinGradHours(){
        return minGradHours;
    }
    /**
     * Gets the required Carolina Core Hours to graduate 
     * @return the carolina core hours
     */
    public int getCaroCoreHours(){
        return caroCoreHours;
    }
    /**
     * Gets the minimum GPA required to graduate
     * @return the minimum GPA
     */
    public Double getMinGPA(){
        return minGPA;
    }
    /**
     * Sets the minimum total hours
     * @param minTotalHr the hours given
     */
    public void setMinTotalHours(int minTotalHr){
        if( minTotalHr > 0){
            this.minTotalHours = minTotalHr;
        }
    }
    /**
     * Sets the minimum graduation hours
     * @param minGradHr the hours given
     */
    public void setMinGradHours(int minGradHr){
        if(minGradHr > 0){
            this.minGradHours = minGradHr;
        }
    }
    /**
     * Sets the Carolina Core Hours
     * @param minCaroCoreHr the hours given
     */
    public void setCaroCoreHours(int minCaroCoreHr){
        if(minCaroCoreHr > 0){
            this.caroCoreHours = minCaroCoreHr;
        }
    }
    /**
     * Sets the minimum GPA
     * @param minGPA the minimum GPA
     */
    public void setMinGPA(Double minGPA){
        if(minGPA > 0){
            this.minGPA = minGPA;
        }
    }
}