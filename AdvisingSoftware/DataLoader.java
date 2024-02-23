package AdvisingSoftware;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

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
        // Test loading users
        // testLoadUsers();

        // Test loading students
        testLoadStudents();

        // Test loading admins
        testLoadAdmin();

        // Test loading advisors
        testLoadAdvisors();

        // Test loading courses
        //testLoadCourses();

        // Test loading majors
        //testLoadMajors();
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
     * Loads students from a JSON file.
     * 
     * @return An ArrayList of Student objects loaded from the JSON file, or null if
     *         an error occurs.
     */
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < studentJSON.size(); i++) {
                JSONObject studentOBJ = (JSONObject) studentJSON.get(i);
                String firstName = (String) studentOBJ.get(USER_FIRST_NAME);
                String lastName = (String) studentOBJ.get(USER_LAST_NAME);
                String email = (String) studentOBJ.get(USER_EMAIL);
                String uscID = (String) studentOBJ.get(USER_USCID);
                String password = (String) studentOBJ.get(USER_PASSWORD);
                String userType = (String) studentOBJ.get(USER_TYPE);
                String year = (String) studentOBJ.get(STUDENT_CLASS);
                String major = (String) studentOBJ.get(STUDENT_MAJOR);
                int creditHours = ((Long) studentOBJ.get(STUDENT_CREDITHOURS)).intValue();
                @SuppressWarnings("unchecked")
                HashMap<Course, Character> completedCourses = (HashMap<Course, Character>) studentOBJ.get(STUDENT_COMPLETED_COURSES);
                double gpa = Double.parseDouble((String) studentOBJ.get(STUDENT_GPA));
                CoursePlanner coursePlanner = (CoursePlanner) studentOBJ.get(STUDENT_COURSE_PLANNER);
                DegreeProgress degreeProgress = (DegreeProgress) studentOBJ.get(STUDENT_DEGREE_PROGRESS);
                @SuppressWarnings("unchecked")
                ArrayList<String> advisorNotes = (ArrayList<String>) studentOBJ.get(STUDENT_ADVISOR_NOTES);

                students.add(new Student(firstName, lastName, email, uscID, password, userType, year, major,
                        creditHours, completedCourses, gpa, coursePlanner, degreeProgress, advisorNotes));
            }

            return students;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

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
                JSONObject AdminOBJ = (JSONObject) adminJSON.get(i);
                String firstName = (String) AdminOBJ.get(USER_FIRST_NAME);
                String lastName = (String) AdminOBJ.get(USER_LAST_NAME);
                String email = (String) AdminOBJ.get(USER_EMAIL);
                String uscID = (String) AdminOBJ.get(USER_USCID);
                String password = (String) AdminOBJ.get(USER_PASSWORD);
                String userType = (String) AdminOBJ.get(USER_TYPE);
                @SuppressWarnings("unchecked")
                ArrayList<String> changesMade = (ArrayList<String>) AdminOBJ.get(ADMIN_CHANGES_MADE);

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
                String uscID = (String) advisorOBJ.get(USER_USCID);
                String password = (String) advisorOBJ.get(USER_PASSWORD);
                String userType = (String) advisorOBJ.get(USER_TYPE);
                @SuppressWarnings("unchecked")
                ArrayList<Student> listOfAdvisees = (ArrayList<Student> )advisorOBJ.get(ADVISOR_LIST_OF_ADVISEES);
                @SuppressWarnings("unchecked")
                ArrayList<Student>  listOfFailingStudents = (ArrayList<Student>) advisorOBJ.get(ADVISOR_LIST_OF_FAILING_STUDENTS);

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

    /**
     * Helper method to test loading of users.
     */
    private static void testLoadUsers() {
        ArrayList<User> users = loadUsers();

        if (users != null) {
            System.out.println("Loaded " + users.size() + " users:");
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Failed to load users.");
        }
    }

    /**
     * Helper method to test loading of students.
     */
    private static void testLoadStudents() {
        ArrayList<Student> students = loadStudents();

        if (students != null) {
            System.out.println("Loaded " + students.size() + " students:");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("Failed to load students.");
        }
    }

    /**
     * Helper method to test loading of admins.
     */
    private static void testLoadAdmin() {
        ArrayList<Admin> admins = loadAdmin();

        if (admins != null) {
            System.out.println("Loaded " + admins.size() + " admins:");
            for (Admin admin : admins) {
                System.out.println(admin);
            }
        } else {
            System.out.println("Failed to load admins.");
        }
    }

    /**
     * Helper method to test loading of advisors.
     */
    private static void testLoadAdvisors() {
        ArrayList<Advisor> advisors = loadAdvisors();

        if (advisors != null) {
            System.out.println("Loaded " + advisors.size() + " advisors:");
            for (Advisor advisor : advisors) {
                System.out.println(advisor);
            }
        } else {
            System.out.println("Failed to load advisors.");
        }
    }

    /**
     * Helper method to test loading of courses.
     */
    private static void testLoadCourses() {
        ArrayList<Course> courses = loadCourses();

        if (courses != null) {
            System.out.println("Loaded " + courses.size() + " courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("Failed to load courses.");
        }
    }

    /**
     * Helper method to test loading of majors.
     */
    private static void testLoadMajors() {
        ArrayList<MajorMap> majors = loadMajors();

        if (majors != null) {
            System.out.println("Loaded " + majors.size() + " majors:");
            for (MajorMap major : majors) {
                System.out.println(major);
            }
        } else {
            System.out.println("Failed to load majors.");
        }
    }
}