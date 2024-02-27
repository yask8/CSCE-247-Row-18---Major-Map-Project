package AdvisingSoftware;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * TODO
 * This thing writes but does not put tje brackets around the json files which fucks it all up
 * It doesnt pull all the users before writer or maybe over writes 
 */

public class DataWriter extends DataConstants {
    
    public static void saveUsers(ArrayList<User> users) {
        for (User user : users) {
            if (user instanceof Student) {
                saveStudent((Student) user);
            } else if (user instanceof Admin) {
                saveAdmin((Admin) user);
            } else if (user instanceof Advisor) {
                saveAdvisor((Advisor) user);
            }
        }
    }
    
    public static void saveStudent(Student student) {
        JSONObject studentJSON = getStudentJSON(student);
        writeJSONToFile(studentJSON, STUDENT_FILE_NAME);
    }
    
    public static void saveAdmin(Admin admin) {
        JSONObject adminJSON = getAdminJSON(admin);
        writeJSONToFile(adminJSON, ADMIN_FILE_NAME);
    }
    
    public static void saveAdvisor(Advisor advisor) {
        JSONObject advisorJSON = getAdvisorJSON(advisor);
        writeJSONToFile(advisorJSON, ADVISOR_FILE_NAME);
    }    
    public static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(USER_FIRST_NAME, student.getFirstName());
        studentDetails.put(USER_LAST_NAME, student.getLastName());
        studentDetails.put(USER_EMAIL, student.getEmail());
        studentDetails.put(USER_USCID, student.getID().toString());
        studentDetails.put(USER_PASSWORD, student.getPassword());
        studentDetails.put(USER_TYPE, student.getUserType());
        studentDetails.put(STUDENT_CLASS, student.getYear());
        studentDetails.put(STUDENT_MAJOR, student.getMajor());
        studentDetails.put(STUDENT_CREDITHOURS, student.getCreditHours());
        studentDetails.put(STUDENT_COMPLETED_COURSES, student.getCompletedCourses());
        studentDetails.put(STUDENT_GPA, student.getGpa());
        studentDetails.put(STUDENT_COURSE_PLANNER, student.getCoursePlanner());
        studentDetails.put(STUDENT_DEGREE_PROGRESS, student.getDegreeProgress());
        studentDetails.put(STUDENT_ADVISOR_NOTES, student.getAdvisorNotes());
        return studentDetails;
    }
    
    public static JSONObject getAdminJSON(Admin admin) {
        JSONObject adminDetails = new JSONObject();
        adminDetails.put(USER_FIRST_NAME, admin.getFirstName());
        adminDetails.put(USER_LAST_NAME, admin.getLastName());
        adminDetails.put(USER_EMAIL, admin.getEmail());
        adminDetails.put(USER_USCID, admin.getID().toString());
        adminDetails.put(USER_PASSWORD, admin.getPassword());
        adminDetails.put(USER_TYPE, admin.getUserType());
        adminDetails.put(ADMIN_CHANGES_MADE, admin.getChangesMade());
        return adminDetails;
    }
    
    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorDetails = new JSONObject();
        advisorDetails.put(USER_FIRST_NAME, advisor.getFirstName());
        advisorDetails.put(USER_LAST_NAME, advisor.getLastName());
        advisorDetails.put(USER_EMAIL, advisor.getEmail());
        advisorDetails.put(USER_USCID, advisor.getID().toString());
        advisorDetails.put(USER_PASSWORD, advisor.getPassword());
        advisorDetails.put(USER_TYPE, advisor.getUserType());
        advisorDetails.put(ADVISOR_LIST_OF_ADVISEES, advisor.getListOfAdvisees());
        advisorDetails.put(ADVISOR_LIST_OF_FAILING_STUDENTS, advisor.getListOfFailingStudents());
        advisorDetails.put(ADVISOR_LIST_OF_NOTES, advisor.getListOfAdvisees());
        return advisorDetails;
    }
    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray coursesArray = new JSONArray();
        for (Course course : courses) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put(COURSE_ID, course.getID());
            courseJSON.put(COURSE_NAME, course.getName());
            courseJSON.put(COURSE_CODE, course.getCode());
            courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
            courseJSON.put(COURSE_CREDIT_HOURS, course.getCreditHours());
            courseJSON.put(COURSE_SUBJECT, course.getSubject());
            courseJSON.put(COURSE_PASS_GRADE, String.valueOf(course.getPassGrade()));
            courseJSON.put(COURSE_ELECTIVE, course.isElective());
            courseJSON.put(COURSE_CAROLINA_CORE, course.isCarolinaCore());
            JSONArray prerequisitesArray = new JSONArray();
            for (Course prerequisite : course.getPreReqs()) {
                prerequisitesArray.add(prerequisite.getID());
            }
            courseJSON.put(COURSE_PREREQUISITES, prerequisitesArray);
            courseJSON.put(COURSE_SEMESTER, course.getSemester());
            courseJSON.put(COURSE_YEAR, course.getYear());
            coursesArray.add(courseJSON);
        }
        writeJSONToFile(coursesArray, COURSE_FILE_NAME);
    }

    public static void saveMajorMaps(ArrayList<MajorMap> majorMaps) {
        JSONArray majorMapsArray = new JSONArray();
        for (MajorMap majorMap : majorMaps) {
            JSONObject majorMapJSON = new JSONObject();
            majorMapJSON.put(MAJOR_NAME, majorMap.getMajor());
            JSONArray coursesArray = new JSONArray();
            for (Course course : majorMap.getMajorCourses()) {
                coursesArray.add(course.getID());
            }
            majorMapJSON.put(MAJOR_COURSES, coursesArray);
            JSONArray electivesArray = new JSONArray();
            for (Course course : majorMap.getElectives()) {
                electivesArray.add(course.getID());
            }
            majorMapJSON.put(MAJOR_ELECTIVE, electivesArray);
            JSONArray coreEduArray = new JSONArray();
            for (Course course : majorMap.getCoreEdu()) {
                coreEduArray.add(course.getID());
            }
            majorMapJSON.put(MAJOR_CORE_EDU, coreEduArray);
            JSONArray appAreaArray = new JSONArray();
            for (Course course : majorMap.getAppArea()) {
                appAreaArray.add(course.getID());
            }
            majorMapJSON.put(MAJOR_APP_AREA, appAreaArray);
            majorMapsArray.add(majorMapJSON);
        }
        writeJSONToFile(majorMapsArray, MAJOR_FILE_NAME);
    }

    private static void writeJSONToFile(JSONObject jsonObject, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void writeJSONToFile(JSONArray jsonArray, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
