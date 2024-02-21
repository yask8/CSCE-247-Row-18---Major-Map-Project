/**
 * Description
 * @author ykennedy
 */
package AdvisingSoftware;

public class MajorList {
    /**
     * Attributes
     */
    static private MajorList majorList;
    private ArrayList<MajorMap> majors;

    private MajorList(){
        majorList = new MajorList();
        majors = new ArrayList<MajorMap>;
    }

    static public MajorList getInstance(){
        return majorList;
    }
    public MajorMap getMajor(String major){
        return majors.getMajor(major);
    }
    public void addMajor(String majorName, ArrayList<Course> majorCourses, ArrayList<Course> majorElectives, ArrayList<Course> minorElectives, ArrayList<Course> coreEdu, ArrayList<Course> appArea){
        majors.add(majorName, majorCourses,majorElectives,minorElectives,coreEdu,appArea);
    }
    public void removeMajor(String major){
        majors.remove(major);
    }


}
