/**
 * Description
 * @author ykennedy
 */
package AdvisingSoftware;

public class GraduationRequirements {
    protected String major;
    protected int minTotalHours;
    protected int minGradHours;
    protected int caroCoreHours;
    protected Double minGPA;

    public GraduationRequirements(String Major){
        this.major = Major;
        setMinTotalHours(minTotalHours);
        setMinGradHours(minGradHours);
        setCaroCoreHours(caroCoreHours);
        setMinGPA(minGPA);
    }
    public int getMinTotalHours(){
        return minTotalHours;
    }
    public int getMinGradHours(){
        return minGradHours;
    }
    public int getCaroCoreHours(){
        return caroCoreHours;
    }
    public Double getMinGPA(){
        return minGPA;
    }
    public void setMinTotalHours(int minTotalHr){
        if( minTotalHr > 0){
            this.minTotalHours = minTotalHr;
        }
    }
    public void setMinGradHours(int minGradHr){
        if(minGradHr > 0){
            this.minGradHours = minGradHr;
        }
    }
    public void setCaroCoreHours(int minCaroCoreHr){
        if(minCaroCoreHr > 0){
            this.caroCoreHours = minCaroCoreHr;
        }
    }
    public void setMinGPA(Double minGPA){
        if(minGPA > 0){
            this.minGPA = minGPA;
        }
    }
}
