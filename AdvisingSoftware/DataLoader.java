package AdvisingSoftware;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * The DataLoader class provides methods to load data from JSON files into Java
 * objects.
 * 
 * TODO List
 * Add LoadDegreeProgress method and implememnt into LoadStudents
 * Add LoadCoursePlanner method and implememnt into LoadStudents
 * Add LoadNotes method and implement into loadStudents + LoadAdvisor
 * 
 * @author @Spillmag
 */
public class DataLoader extends DataConstants {

    /**
     * Main method to test DataLoader methods.
     */
    public static void main(String[] args) {
        // testLoadingAdmins();

        testLoadingStudents();

        // testLoadingAdvisors();

        // testLoadingCourses();

        // testLoadingMajorMaps();

        // LoadUsers();
    }

    /**
     * Loads users (students, admins, advisors) and puts them into a single
     * list.
     *
     * @return An ArrayList of User objects containing instances of user types.
     */
    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();

        // Load students
        ArrayList<Student> students = loadStudents();
        if (students != null) {
            users.addAll(students);
        }

        // Load admins
        ArrayList<Admin> admins = loadAdmin();
        if (admins != null) {
            users.addAll(admins);
        }

        // Load advisors
        ArrayList<Advisor> advisors = loadAdvisors();
        if (advisors != null) {
            users.addAll(advisors);
        }

        return users;
    }

    /**
     * Loads students from a JSON file.
     * 
     * @return An ArrayList of Student objects loaded from the JSON file.
     */
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentArray = (JSONArray) parser.parse(reader);

            for (int i = 0; i < studentArray.size(); i++) {
                JSONObject studentObj = (JSONObject) studentArray.get(i);
                String firstName = (String) studentObj.get(USER_FIRST_NAME);
                String lastName = (String) studentObj.get(USER_LAST_NAME);
                String email = (String) studentObj.get(USER_EMAIL);
                String uscIDString = (String) studentObj.get(USER_USCID);
                UUID uscID = UUID.fromString(uscIDString);
                String password = (String) studentObj.get(USER_PASSWORD);
                String userType = (String) studentObj.get(USER_TYPE);
                String year = (String) studentObj.get(STUDENT_CLASS);
                String major = (String) studentObj.get(STUDENT_MAJOR);
                int creditHours = ((Long) studentObj.get(STUDENT_CREDITHOURS)).intValue();
                @SuppressWarnings("unchecked")
                ArrayList<Course> completedCourses = (ArrayList<Course>) studentObj.get(STUDENT_COMPLETED_COURSES);
                double gpa = (double) studentObj.get(STUDENT_GPA);

                JSONObject coursePlannerObj = (JSONObject) studentObj.get(STUDENT_COURSE_PLANNER);
                CoursePlanner coursePlanner = null;
                if (coursePlannerObj != null) {
                    coursePlanner = loadCoursePlannerFromJSON(coursePlannerObj);
                }

                // Load DegreeProgress
                JSONObject degreeProgressObj = (JSONObject) studentObj.get(STUDENT_DEGREE_PROGRESS);
                DegreeProgress degreeProgress = null;
                if (degreeProgressObj != null) {
                    degreeProgress = loadDegreeProgressFromJSON(degreeProgressObj);
                }

                // Load Advisor Notes
                @SuppressWarnings("unchecked")
                ArrayList<Note> advisorNotes = (ArrayList<Note>) studentObj.get(STUDENT_ADVISOR_NOTES);

                Student student = new Student(firstName, lastName, email, uscID, password, userType, year,
                        major, creditHours, completedCourses, gpa, coursePlanner, degreeProgress,
                        advisorNotes);
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads degree progress from a JSON object.
     * 
     * @param degreeProgressObj The JSON object containing degree progress data.
     * @return The DegreeProgress object loaded from the JSON object, or null if the
     *         input object is null.
     */
    private static DegreeProgress loadDegreeProgressFromJSON(JSONObject degreeProgressObj) {
        if (degreeProgressObj == null) {
            return null;
        }
        String major = (String) degreeProgressObj.get("major");
        @SuppressWarnings("unchecked")
        ArrayList<Course> majorCourses = (ArrayList<Course>) degreeProgressObj.get(DEGREE_PLANNER_MAJOR_COURSES);
        @SuppressWarnings("unchecked")
        ArrayList<Course> electiveCourses = (ArrayList<Course>) degreeProgressObj.get(DEGREE_PLANNER_ELECTIVES);
        @SuppressWarnings("unchecked")
        ArrayList<Course> carolinaCoreCourses = (ArrayList<Course>) degreeProgressObj.get(DEGREE_PLANNER_CC);
        @SuppressWarnings("unchecked")
        ArrayList<Course> completeCourses = (ArrayList<Course>) degreeProgressObj.get(DEGREE_PLANNER_C_COURSES);
        @SuppressWarnings("unchecked")
        ArrayList<Course> incompleteCourses = (ArrayList<Course>) degreeProgressObj.get(DEGREE_PLANNER_IC_COURSES);

        DegreeProgress degreeProgress = new DegreeProgress(major, majorCourses, electiveCourses, carolinaCoreCourses,
                completeCourses, incompleteCourses);

        return degreeProgress;
    }

    private static CoursePlanner loadCoursePlannerFromJSON(JSONObject coursePlannerObj) {
        if (coursePlannerObj == null) {
            return null;
        }
    
        CoursePlanner coursePlanner = new CoursePlanner();
        JSONArray semestersArray = (JSONArray) coursePlannerObj.get(COURSE_PLANNER_SEMESTERS);
    
        for (int i = 0; i < semestersArray.size(); i++) {
            JSONArray semesterCoursesArray = (JSONArray) semestersArray.get(i);
    
            for (int j = 0; j < semesterCoursesArray.size(); j++) {
                JSONObject courseObj = (JSONObject) semesterCoursesArray.get(j);
                Course course = parseCourseFromJSONObject(courseObj);
                if (course != null) {
                    coursePlanner.addCourse(i + 1, course);
                }
            }
        }
    
        return coursePlanner;
    }
    /**
     * Loads a course planner from a JSON object.
     * 
     * @param coursePlannerObj The JSON object containing course planner data.
     * @return The CoursePlanner object loaded from the JSON object, or null if the
     *         input object is null.
     */
    /**
     * Parses a Course object from a JSON object representation.
     * 
     * @param courseJson The JSON object containing course data.
     * @return The Course object parsed from the JSON object, or null if the input
     *         object is null.
     */
    private static Course parseCourseFromJSONObject(JSONObject courseJson) {
        if (courseJson == null) {
            return null;
        }

        String id = (String) courseJson.get(COURSE_ID);
        String name = (String) courseJson.get(COURSE_NAME);
        String code = (String) courseJson.get(COURSE_CODE);
        String description = (String) courseJson.get(COURSE_DESCRIPTION);
        int creditHours = ((Long) courseJson.get(COURSE_CREDIT_HOURS)).intValue();
        String subject = (String) courseJson.get(COURSE_SUBJECT);
        char passGrade = ((String) courseJson.get(COURSE_PASS_GRADE)).charAt(0);
        boolean elective = (boolean) courseJson.get(COURSE_ELECTIVE);
        boolean carolinaCore = (boolean) courseJson.get(COURSE_CAROLINA_CORE);

        JSONArray preReqsArray = (JSONArray) courseJson.get(COURSE_PREREQUISITES);
        ArrayList<Course> preReqs = new ArrayList<>();
        if (preReqsArray != null) {
            for (Object preReq : preReqsArray) {
                if (preReq instanceof String) {
                    // Assuming preReq is the course ID
                    String courseId = (String) preReq;
                    Course preReqCourse = findCourseByCode(courseId);
                    if (preReqCourse != null) {
                        preReqs.add(preReqCourse);
                    }
                }
            }
        }

        String semester = (String) courseJson.get(COURSE_SEMESTER);
        String year = (String) courseJson.get(COURSE_YEAR);

        return new Course(id, name, code, description, creditHours, subject, passGrade, elective, carolinaCore, preReqs,
                semester, year);
    }

    /**
     * Loads admins from a JSON file.
     * 
     * @return An ArrayList of Admin objects loaded from the JSON file.
     */
    public static ArrayList<Admin> loadAdmin() {
        ArrayList<Admin> admins = new ArrayList<>();

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

                JSONArray changesMadeJSON = (JSONArray) adminOBJ.get(ADMIN_CHANGES_MADE);
                ArrayList<String> changesMade = new ArrayList<>();
                if (changesMadeJSON != null) {
                    for (Object changeObj : changesMadeJSON) {
                        String change = (String) changeObj;
                        changesMade.add(change);
                    }
                }

                admins.add(new Admin(firstName, lastName, email, uscID, password, userType, changesMade));
            }

            return admins;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Loads advisors from a JSON file.
     * 
     * @return An ArrayList of Advisor objects loaded from the JSON file.
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

                JSONArray listOfAdviseesJSON = (JSONArray) advisorOBJ.get(ADVISOR_LIST_OF_ADVISEES);
                ArrayList<User> listOfAdvisees = new ArrayList<>();
                if (listOfAdviseesJSON != null) {
                    for (Object adviseeObj : listOfAdviseesJSON) {
                    }
                }

                JSONArray listOfFailingStudentsJSON = (JSONArray) advisorOBJ.get(ADVISOR_LIST_OF_FAILING_STUDENTS);
                ArrayList<User> listOfFailingStudents = new ArrayList<>();
                JSONArray listOfAdvisorNotesJSON = (JSONArray) advisorOBJ.get(ADVISOR_LIST_OF_NOTES);
                ArrayList<Note> listOfAdvisorNotes = new ArrayList<>();

                advisors.add(new Advisor(firstName, lastName, email, uscID, password, userType,
                        listOfAdvisees, listOfFailingStudents, listOfAdvisorNotes));
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
     * @return An ArrayList of Course objects loaded from the JSON file
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
     * @return An ArrayList of MajorMap objects loaded from the JSON file
     * 
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

                UUID id = (UUID) majorObj.get(MAJOR_UUID);
                ArrayList<Course> courses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_COURSES));
                ArrayList<Course> electives = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_ELECTIVE));
                ArrayList<Course> coreCourses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_CORE_EDU));
                ArrayList<Course> appAreaCourses = loadCoursesFromJSONArray((JSONArray) majorObj.get(MAJOR_APP_AREA));
                int minHours = ((Long) majorObj.get(MAJOR_MIN_HOURS)).intValue();
                int minGradHours = ((Long) majorObj.get(MAJOR_MIN_GRAD_HOURS)).intValue();
                int ccHours = ((Long) majorObj.get(MAJOR_CC_HOURS)).intValue();
                double minGPA = ((Number) majorObj.get(MAJOR_MIN_GPA)).doubleValue();

                MajorMap major = new MajorMap(id, name, courses, electives, coreCourses, appAreaCourses, minHours,
                        minGradHours, ccHours, minGPA);
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
                }
            }
        }
        return courses;
    }

    /**
     * Helper method to find a course by its code.
     * 
     * @param id The course code.
     * @return The Course object if found.
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

    /*
     * TESTING METHODS
     */
    public static void LoadUsers() {
        ArrayList<User> users = loadUsers();

        if (users != null && !users.isEmpty()) {
            System.out.println("Users loaded successfully:");
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("No users loaded or an error occurred.");
        }
    }

    public static void testLoadingAdmins() {
        ArrayList<Admin> admins = DataLoader.loadAdmin();
        if (admins != null) {
            for (Admin admin : admins) {
                System.out.println(admin.toString());
            }
        } else {
            System.out.println("Failed to load admins from the file.");
        }
    }

    public static void testLoadingMajorMaps() {
        ArrayList<MajorMap> majorMaps = DataLoader.loadMajors();
        if (majorMaps != null) {
            for (MajorMap majorMap : majorMaps) {
                System.out.println(majorMap.toString());
            }
        } else {
            System.out.println("Failed to load major maps from the file.");
        }
    }

    public static void testLoadingCourses() {
        ArrayList<Course> courses = DataLoader.loadCourses();
        if (courses != null) {
            for (Course course : courses) {
                System.out.println(course.toString());
            }
        } else {
            System.out.println("Failed to load courses from the file.");
        }
    }

    public static void testLoadingAdvisors() {
        ArrayList<Advisor> advisors = DataLoader.loadAdvisors();
        if (advisors != null) {
            for (Advisor advisor : advisors) {
                System.out.println(advisor.toString());
            }
        } else {
            System.out.println("Failed to load advisors from the file.");
        }
    }

    public static void testLoadingStudents() {
        ArrayList<Student> students = DataLoader.loadStudents();
        if (students != null) {
            for (Student student : students) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("Failed to load students from the file.");
        }

    }
}