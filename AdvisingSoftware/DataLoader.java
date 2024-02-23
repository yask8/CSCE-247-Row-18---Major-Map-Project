package AdvisingSoftware;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

/**
 * The DataLoader class provides methods to load data from JSON files into Java
 * objects.
 * 
 * @author @Spillmag
 */
public class DataLoader extends DataConstants {

    public static void main(String[] args) {
        // Load users from the file path provided
        ArrayList<User> users = loadUsers();

        // Print the list of users
        if (users != null) {
            System.out.println("List of Users:");
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Failed to load users.");
        }

        // Load courses from the file path provided
        ArrayList<Course> courses = loadCourses();

        // Print the list of courses
        if (courses != null) {
            System.out.println("\nList of Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("Failed to load courses.");
        }

        // Load majors from the file path provided
        ArrayList<MajorMap> majors = loadMajors();

        // Print the list of majors
        if (majors != null) {
            System.out.println("\nList of Majors:");
            for (MajorMap major : majors) {
                System.out.println(major.toString());
            }
        } else {
            System.out.println("Failed to load majors.");
        }
    }

    /**
     * Loads users from a JSON file.
     * 
     * @return An ArrayList of User objects loaded from the JSON file, or null if an
     *         error occurs.
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < userJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) userJSON.get(i);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                String uscID = (String) personJSON.get(USER_USCID);
                String password = (String) personJSON.get(USER_PASSWORD);
                String userType = (String) personJSON.get(USER_TYPE);

                users.add(new User(firstName, lastName, email, uscID, password, userType));
            }

            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads courses from a JSON file.
     * 
     * @return An ArrayList of Course objects loaded from the JSON file, or null if
     *         an error occurs.
     */
    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < courseJSON.size(); i++) {
                JSONObject courseObj = (JSONObject) courseJSON.get(i);
                String id = (String) courseObj.get(COURSE_ID);
                String name = (String) courseObj.get(COURSE_NAME);
                String code = (String) courseObj.get(COURSE_CODE);
                String description = (String) courseObj.get(COURSE_DESCRIPTION);
                int creditHours = ((Long) courseObj.get(COURSE_CREDIT_HOURS)).intValue();
                String subject = (String) courseObj.get(COURSE_SUBJECT);
                char passGrade = ((String) courseObj.get(COURSE_PASS_GRADE)).charAt(0);
                boolean elective = (Boolean) courseObj.get(COURSE_ELECTIVE);
                boolean carolinaCore = (Boolean) courseObj.get(COURSE_CAROLINA_CORE);
                ArrayList<Course> prerequisites = (ArrayList<Course>) courseObj.get(COURSE_PREREQUISITES);
                String semester = (String) courseObj.get(COURSE_SEMESTER);
                String year = (String) courseObj.get(COURSE_YEAR);

                Course course = new Course(id,name, code, description, creditHours, subject, passGrade, elective,
                        carolinaCore, prerequisites, semester, year);
                courses.add(course);
            }

            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads majors from a JSON file.
     * 
     * @return An ArrayList of MajorMap objects loaded from the JSON file, or null
     *         if an error occurs.
     */
    public static ArrayList<MajorMap> loadMajors() {
        ArrayList<MajorMap> majors = new ArrayList<>();

        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray majorJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < majorJSON.size(); i++) {
                JSONObject majorObj = (JSONObject) majorJSON.get(i);
                String name = (String) majorObj.get(MAJOR_NAME);

                ArrayList<Course> courses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_COURSES));
                ArrayList<Course> electives = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_ELECTIVE));
                ArrayList<Course> coreCourses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_CORE_EDU));
                ArrayList<Course> appAreaCourses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_APP_AREA));

                MajorMap major = new MajorMap(name, courses, electives, coreCourses, appAreaCourses);
                majors.add(major);
            }
            return majors;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Helper method to load courses from a JSONArray.
     * 
     * @param courseArray The JSONArray containing course data.
     * @return An ArrayList of Course objects loaded from the JSONArray.
     */
    private static ArrayList<Course> loadCoursesFromJSONArray(JSONArray courseArray) {
        ArrayList<Course> courses = new ArrayList<>();
        if (courseArray != null) {
            for (Object courseObj : courseArray) {
                String courseId = (String) courseObj;
                Course course = findCourseByCode(courseId);
                if (course != null) {
                    courses.add(course);
                } else {
                    System.out.println("Course not found for code: " + courseId);
                }
            }
        }
        return courses;
    }


    private static Course findCourseByCode(String id) {
        ArrayList<Course> allCourses = loadCourses();
        if (allCourses != null) {
            for (Course course : allCourses) {
                if (course.getID().toString().equals(id)) { 
                    return course;
                }
            }
        }
        return null;
    }
}
