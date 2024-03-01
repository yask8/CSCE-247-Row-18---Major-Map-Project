package AdvisingSoftware;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * The DataWriter class provides methods to writevdata from the program in JSON
 * files.
 * 
 * @author @Spillmag
 */
public class DataWriter extends DataConstants {

    public static void main(String[] args) {
        // Test saveUsers
        testSaveUsers();

        // Test saveCourses
        // testSaveCourses();

        // Test saveMajorMaps
        // testSaveMajorMaps();
    }

    /**
     * Saves the list of users into a JSON file.
     * Appends new user data to the existing data in the file.
     *
     * @param users The list of users to be saved.
     */
    @SuppressWarnings("unchecked")
    public static void saveUsers(ArrayList<User> users) {
        for (User user : users) {
            String fileName = getFileNameForUser(user);
            JSONArray existingData = readExistingData(fileName);
            JSONObject userJSON = getUserJSON(user);
            String userId = user.getID().toString();
            boolean userExists = false;
    
            for (int i = 0; i < existingData.size(); i++) {
                JSONObject existingUserJSON = (JSONObject) existingData.get(i);
                String existingUserId = (String) existingUserJSON.get(USER_USCID);
                if (existingUserId.equals(userId)) {
                    existingData.set(i, userJSON);
                    userExists = true;
                    break;
                }
            }
    
            if (!userExists) {
                existingData.add(userJSON);
            }
    
            writeJSONToFile(existingData, fileName);
        }
    }

    /**
     * Determines the file name based on the type of users provided.
     *
     * @param users The list of users for which the file name needs to be
     *              determined.
     * @return The file name corresponding to the type of users.
     */
    private static String getFileNameForUser(User user) {
        String userType = user.getUserType().toUpperCase();
    
        switch (userType) {
            case "STUDENT":
                return STUDENT_FILE_NAME;
            case "ADMIN":
                return ADMIN_FILE_NAME;
            case "ADVISOR":
                return ADVISOR_FILE_NAME;
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
    /**
     * Generates a JSON object with the provided user.
     *
     * @param user The user for which the JSON object is generated.
     * @return The JSON user object.
     */
    @SuppressWarnings("unchecked")
    public static JSONObject getUserJSON(User user) {
        JSONObject userJSON = new JSONObject();

        userJSON.put(USER_FIRST_NAME, user.getFirstName());
        userJSON.put(USER_LAST_NAME, user.getLastName());
        userJSON.put(USER_EMAIL, user.getEmail());
        userJSON.put(USER_USCID, user.getID().toString());
        userJSON.put(USER_PASSWORD, user.getPassword());
        userJSON.put(USER_TYPE, user.getUserType());
        {
            if (user.getUserType().equals("STUDENT")) {
                Student student = (Student) user;
                userJSON.put(STUDENT_CLASS, student.getYear());
                userJSON.put(STUDENT_MAJOR, student.getMajor());
                userJSON.put(STUDENT_CREDITHOURS, student.getCreditHours());
                userJSON.put(STUDENT_COMPLETED_COURSES, student.getCompletedCourses());
                userJSON.put(STUDENT_GPA, student.getGpa());
                userJSON.put(STUDENT_COURSE_PLANNER, student.getCoursePlanner());
                userJSON.put(STUDENT_DEGREE_PROGRESS, student.getDegreeProgress());
                userJSON.put(STUDENT_ADVISOR_NOTES, student.getAdvisorNotes());
            }

            if (user.getUserType().equals("ADMIN")) {
                Admin admin = (Admin) user;
                userJSON.put(ADMIN_CHANGES_MADE, admin.getChangesMade());
            }

            if (user.getUserType().equals("ADVISOR")) {
                Advisor advisor = (Advisor) user;
                userJSON.put(ADVISOR_LIST_OF_ADVISEES, advisor.getListOfAdvisees());
                userJSON.put(ADVISOR_LIST_OF_FAILING_STUDENTS, advisor.getListOfFailingStudents());
            }
        }

        return userJSON;
    }

    /**
     * Saves the provided list of courses into a JSON file.
     *
     * @param courses The list of courses to be saved.
     */
    @SuppressWarnings("unchecked")
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

    /**
     * Saves the provided list of major maps into a JSON file.
     *
     * @param majorMaps The list of major maps to be saved.
     */
    @SuppressWarnings("unchecked")
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

    /**
     * Writes the JSON array to a file with the given file name.
     *
     * @param jsonArray The JSON array to be written to the file.
     * @param fileName  The name of the file to which the JSON array is written to.
     */
    private static void writeJSONToFile(JSONArray jsonArray, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if the provided user already exists in the JSON file.
     *
     * @param user The user to check for.
     * @return true if the user exists in the JSON file, false otherwise.
     */
    private static boolean userExists(User user) {
        String fileName = "";
        if (user.getUserType().equals("STUDENT")) {
            fileName = STUDENT_FILE_NAME;
        } else if (user.getUserType().equals("ADMIN")) {
            fileName = ADMIN_FILE_NAME;
        } else if (user.getUserType().equals("ADVISOR")) {
            fileName = ADVISOR_FILE_NAME;
        }
        JSONArray existingData = readExistingData(fileName);

        for (Object obj : existingData) {
            JSONObject jsonObject = (JSONObject) obj;
            String userId = (String) jsonObject.get(USER_USCID);
            if (userId.equals(user.getID().toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reads the existing data from the JSON file with the given file name.
     *
     * @param fileName The name of the JSON file to read data from.
     * @return A JSON array containing the existing data from the file.
     */
    private static JSONArray readExistingData(String fileName) {
        JSONArray existingData = new JSONArray();
        try {
            String data = new String(Files.readAllBytes(Paths.get(fileName)));
            existingData = (JSONArray) JSONValue.parse(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return existingData;
    }

    public static void testSaveUsers() {
        // Creating sample users
        ArrayList<User> users = new ArrayList<>();

        // Generate UUIDs for uscID
        UUID studentUscID = UUID.randomUUID();
        UUID adminUscID = UUID.randomUUID();
        UUID advisorUscID = UUID.randomUUID();

        Student student = new Student("Test", "1", "Test1@example.com", studentUscID, "12345", "STUDENT", "Sophomore",
                "Computer Science", 60, new ArrayList<Course>(), 3.5, null, null, null);
        Admin admin = new Admin("Test1", "2", "Test2@example.com", adminUscID, "54321", "ADMIN",
                new ArrayList<String>());
        Advisor advisor = new Advisor("Test", "3", "Test3@example.com", advisorUscID, "98765", "ADVISOR",
                new ArrayList<User>(), new ArrayList<User>());

        // Adding users to the list
        users.add(student);
        users.add(admin);
        users.add(advisor);

        // Saving users
        DataWriter.saveUsers(users);
        System.out.println("Users saved successfully.");
    }

    public static void testSaveCourses() {

        ArrayList<Course> courses = new ArrayList<>();
        Course course1 = new Course("TEST 1", "Introduction to Computer Science", "CSCE", "Introductory course", 3, "A",
                'A', false, true, new ArrayList<Course>(), "Fall", "2022");
        Course course2 = new Course("TEST 2", "Calculus", "MATH", "Calculus course", 4, "B", 'B', false, true,
                new ArrayList<Course>(), "Fall", "2022");

        courses.add(course1);
        courses.add(course2);

        DataWriter.saveCourses(courses);
        System.out.println("Courses saved successfully.");
    }

    public static void testSaveMajorMaps() {

        ArrayList<MajorMap> majorMaps = new ArrayList<>();
        MajorMap majorMap1 = new MajorMap("Test Major 1", new ArrayList<Course>(), new ArrayList<Course>(),
                new ArrayList<Course>(), new ArrayList<Course>(), 0, 0, 0, null);
        MajorMap majorMap2 = new MajorMap("Test Major 2", new ArrayList<Course>(), new ArrayList<Course>(),
                new ArrayList<Course>(), new ArrayList<Course>(), 0, 0, 0, null);

        majorMaps.add(majorMap1);
        majorMaps.add(majorMap2);

        DataWriter.saveMajorMaps(majorMaps);
        System.out.println("Major maps saved successfully.");
    }
}
