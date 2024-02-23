package AdvisingSoftware;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The DataLoader class provides methods to load data from JSON files into Java
 * objects.
 * 
 * @author @Spillmag
 */
public class DataLoader extends DataConstants {

    /**
     * Main method to test DataLoader methods.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // load users
        ArrayList<User> users = DataLoader.loadUsers();
        if (users != null) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Failed to load users from the file.");
        }
        //load admin
        ArrayList<Admin> admins = DataLoader.loadAdmin();
        if (admins != null) {
            for (Admin admin : admins) {
                System.out.println(admin.toString());
            }
        } else {
            System.out.println("Failed to load admins from the file.");
        }
        // Load major maps
        // ArrayList<MajorMap> majorMaps = DataLoader.loadMajors();
        // if (majorMaps != null) {
        //     for (MajorMap majorMap : majorMaps) {
        //         System.out.println(majorMap.toString());
        //     }
        // } else {
        //     System.out.println("Failed to load major maps from the file.");
        // }

        // // Load courses
        // ArrayList<Course> courses = DataLoader.loadCourses();
        // if (courses != null) {
        //     for (Course course : courses) {
        //         System.out.println(course.toString());
        //     }
        // } else {
        //     System.out.println("Failed to load courses from the file.");
        //}
    }

    /**
     * Loads users from a JSON file.
     * 
     * @return An ArrayList of User objects loaded from the JSON file, or null if an
     *         error occurs.
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < userJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) userJSON.get(i);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String email = (String) personJSON.get(USER_EMAIL);
                UUID uscID = UUID.fromString((String) personJSON.get(USER_USCID));
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
     * Loads students from a JSON file.
     * 
     * @return An ArrayList of Student objects loaded from the JSON file, or null if
     *         an error occurs.
     */
    
     // TODO Add student loader

    /**
     * Loads admins from a JSON file.
     * 
     * @return An ArrayList of Admin objects loaded from the JSON file, or null if
     *         an error occurs.
     */
public static ArrayList<Admin> loadAdmin() {
    ArrayList<Admin> admin = new ArrayList<>();

    try {
        FileReader reader = new FileReader(ADMIN_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray adminJSON = (JSONArray) parser.parse(reader);

        for (int i = 0; i < adminJSON.size(); i++) {
            JSONObject adminOBJ = (JSONObject) adminJSON.get(i);
            String firstName = (String) adminOBJ.get(USER_FIRST_NAME);
            String lastName = (String) adminOBJ.get(USER_LAST_NAME);
            String email = (String) adminOBJ.get(USER_EMAIL);
            String uscIDString = (String) adminOBJ.get(USER_USCID);
            UUID uscID = UUID.fromString(uscIDString); 
            String password = (String) adminOBJ.get(USER_PASSWORD);
            String userType = (String) adminOBJ.get(USER_TYPE);
            ArrayList<String> changesMade = (ArrayList<String>) adminOBJ.get(ADMIN_CHANGES_MADE);

            admin.add(new Admin(firstName, lastName, email, uscID, password, userType, changesMade));
        }

        return admin;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    /**
     * Loads advisors from a JSON file.
     * 
     * @return An ArrayList of Advisor objects loaded from the JSON file, or null if
     *         an error occurs.
     */
    public static ArrayList<Advisor> loadAdvisors() {
        ArrayList<Advisor> advisors = new ArrayList<>();

        try {
            FileReader reader = new FileReader(ADVISOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray advisorJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < advisorJSON.size(); i++) {
                JSONObject advisorOBJ = (JSONObject) advisorJSON.get(i);
                String firstName = (String) advisorOBJ.get(USER_FIRST_NAME);
                String lastName = (String) advisorOBJ.get(USER_LAST_NAME);
                String email = (String) advisorOBJ.get(USER_EMAIL);
                String uscIDString = (String) advisorOBJ.get(USER_USCID);
                UUID uscID = UUID.fromString(uscIDString);
                String password = (String) advisorOBJ.get(USER_PASSWORD);
                String userType = (String) advisorOBJ.get(USER_TYPE);
                @SuppressWarnings("unchecked")
                ArrayList<Student> listOfAdvisees = (ArrayList<Student>) advisorOBJ.get(ADVISOR_LIST_OF_ADVISEES);
                @SuppressWarnings("unchecked")
                ArrayList<Student> listOfFailingStudents = (ArrayList<Student>) advisorOBJ
                        .get(ADVISOR_LIST_OF_FAILING_STUDENTS);

                advisors.add(new Advisor(firstName, lastName, email, uscID, password, userType, listOfAdvisees,
                        listOfFailingStudents));
            }

            return advisors;

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
                @SuppressWarnings("unchecked")
                /*
                 * Start out with an ArrayList of Strings for Course Prerequistes
                 * Now imagine, after courses have been loaded up, they will have to be
                 * converted to actual course objects
                 * So, basically an attribute is going to be needed to keep track of courses
                 * Suggestion: put null in for difficult stuff and test everything, tests are
                 * not extensive enough because line below
                 * should have broke
                 * Make sure all of constructors of done and then make a toString in each class
                 * and then loop through those to print to
                 * the console
                 * Doing great so far
                 */
                ArrayList<Course> prerequisites = (ArrayList<Course>) courseObj.get(COURSE_PREREQUISITES);
                String semester = (String) courseObj.get(COURSE_SEMESTER);
                String year = (String) courseObj.get(COURSE_YEAR);

                Course course = new Course(id, name, code, description, creditHours, subject, passGrade, elective,
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

    /**
     * Helper method to find a course by its code.
     * 
     * @param id The course code.
     * @return The Course object if found, or null if not found.
     */
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