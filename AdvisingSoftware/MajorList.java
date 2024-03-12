/**
 * MajorList class for managing majors
 * @author yask8(Yasmine Kennedy)
 */
package AdvisingSoftware;
import java.util.ArrayList;
import java.util.UUID;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<MajorMap> majors;
    private boolean loaded;

    private MajorList() {
        majors = new ArrayList<>();
        loaded = false;
    }

    public ArrayList<MajorMap> getMajors() {
        return majors;
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
            if (!majorList.isLoaded()) {
                ArrayList<MajorMap> majorData = DataLoader.loadMajors();
                for (MajorMap majorInData : majorData) {
                    majorList.addMajor(majorInData.getMajor(),
                            majorInData.getMajorCourses(),
                            majorInData.getProgramCourses(),
                            majorInData.getCoreEdu(),
                            majorInData.getAppArea(),
                            majorInData.getMinTotalHours(),
                            majorInData.getMinGradHours(),
                            majorInData.getCaroCoreHours(),
                            majorInData.getMinGPA());
                }
                majorList.setLoaded(true);
            }
        }
        return majorList;
    }

    public MajorMap getMajorByName(String major) {
        for (MajorMap existingMajor : majors) {
            if (existingMajor.getMajor().equals(major)) {
                return existingMajor;
            }
        }
        return null;
    }

    public MajorMap getMajorMapbyID(UUID id) {
        for (MajorMap existingMajor : majors) {
            if (existingMajor.getId().equals(id)) {
                return existingMajor;
            }
        }
        return null;
    }

    public void addMajor(
            String majorName,
            ArrayList<String> majorCourses,
            ArrayList<String> majorElectives,
            ArrayList<String> coreEdu,
            ArrayList<String> appArea,
            int minTotalHours,
            int minGradHours,
            int caroCoreHours,
            double minGPA) {
        MajorMap newMajorMap = new MajorMap(
                majorName,
                majorCourses,
                majorElectives,
                coreEdu,
                appArea,
                minTotalHours,
                minGradHours,
                caroCoreHours,
                minGPA);
        majors.add(newMajorMap);
    }

    public void removeMajor(String major) {
        for (MajorMap existingMajor : majors) {
            if (existingMajor.getMajor().equals(major)) {
                majors.remove(existingMajor);
                return; 
            }
        }
        System.out.println(major + " does not exist.");
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return loaded;
    }
}