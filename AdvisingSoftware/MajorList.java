/**
 * MajorList class for managing majors
 * @author yask8(Yasmine Kennedy)
 */
package AdvisingSoftware;

import java.util.ArrayList;

public class MajorList {
    /**
     * Attributes
     */
    private static MajorList majorList;
    private ArrayList<MajorMap> majors;
    private boolean loaded;
    /**
     * Private constructor for MajorList
     * Initializes the list of majors
     */
    private MajorList() {
        majors = new ArrayList<MajorMap>();
        loaded = false;
    }
    /**
     * Get all of the majors in the list
     * @return The list of majors
     */
    public ArrayList<MajorMap> getMajors() {
        return majors;
    }
    /**
     * Get the singleton instance of MajorList and ensures the list is loaded
     * into the dataloader.
     * @return the singleton instance of MajorList
     */
    public static MajorList getInstance(){
        if(majorList == null){
            majorList = new MajorList();
            if(!majorList.isLoaded()) {
                ArrayList<MajorMap> majorData = DataLoader.loadMajors();
                for(MajorMap majorInData : majorData){
                    majorList.addMajor( majorInData.getMajor(),
                                        majorInData.getMajorCourses(),
                                        majorInData.getElectives(),
                                        majorInData.getCoreEdu(),
                                        majorInData.getAppArea());
                }
                majorList.setLoaded(true);
            }
        }
        return majorList;
    }
    /**
     * Get a major by the name from the Major Map
     * @param major the major from the Major Map
     * @return The major or null if not found
     */
    public MajorMap getMajorByName(String major){
        for(MajorMap existingMajor : majors){
            if(existingMajor.getMajor().equals(major)){
                return existingMajor;
            }
        }
        return null;
    }
    /**
     * Add a major to the list
     * @param majorName The name of the major
     * @param majorCourses The courses offered by the major
     * @param majorElectives The electives offered by the major
     * @param coreEdu The Carolina Core Classes
     * @param appArea The Application Area Classes
     */
    public void addMajor(
     String majorName,
     ArrayList<Course> majorCourses, 
     ArrayList<Course> majorElectives,
     ArrayList<Course> coreEdu, 
     ArrayList<Course> appArea){
        MajorMap newMajor = new MajorMap(majorName, 
        majorCourses, 
        majorElectives,
        coreEdu, 
        appArea);
        majors.add(newMajor);

    }
    /**
     * Removes a major from the list of majors by their name
     * @param major The name of the major
     */
    public void removeMajor(String major){
        for(MajorMap existingMajors :  majors){
            if(existingMajors.getMajor().equals(major)){
                majors.remove(existingMajors);
            } else if (major == null){
                System.out.println(major + " does not exist.");
            }
        }
    }
    /**
     * Sets the value to indicate if the list is loaded
     * @param loaded Boolean that indicates if the list is loaded
     */
    public void setLoaded(boolean loaded){
        this.loaded = loaded;
    }
    /**
     * Checks if the majorList is loaded
     * @return True(if list is loaded) or False(if list is not loaded)
     */
    public boolean isLoaded(){
        return loaded;
    }
    /**
     * Testing purposes
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<MajorMap> majors = DataLoader.loadMajors();
        for(MajorMap map : majors){
            System.out.println(map);
        }
    }
}