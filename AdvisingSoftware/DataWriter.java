package AdvisingSoftware;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        // testSaveUsers();

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

        if (user.getUserType().equals("STUDENT")) {
            Student student = (Student) user;
            userJSON.put(STUDENT_CLASS, student.getYear());
            userJSON.put(STUDENT_MAJOR, student.getMajor());
            userJSON.put(STUDENT_CREDITHOURS, student.getCreditHours());

            // Convert completed courses to JSON array
            JSONArray completedCoursesArray = new JSONArray();
            for (Grades grade : student.getCompletedCourses()) {
                JSONObject completedCourseJSON = new JSONObject();
                completedCourseJSON.put(GRADES_COURSE_NAME, grade.getCourseName());
                completedCourseJSON.put(GRADES_GRADE, grade.getGrade());
                completedCoursesArray.add(completedCourseJSON);
            }
            userJSON.put(STUDENT_COMPLETED_COURSES, completedCoursesArray);
            userJSON.put(STUDENT_GPA, student.getGpa());

            // Convert degree progress to JSON object
            JSONObject degreeProgressJSON = new JSONObject();
            degreeProgressJSON.put(DEGREE_PROGRESS_MAJOR, student.getDegreeProgress().getMajor());
            degreeProgressJSON.put(DEGREE_PROGRESS_ELECTIVE_COURSES, student.getDegreeProgress().getElectiveCourses());
            degreeProgressJSON.put(DEGREE_PROGRESS_INCOMPLETE_COURSES,
                    student.getDegreeProgress().getIncompleteCourses());
            degreeProgressJSON.put(DEGREE_PROGRESS_CAROLINA_CORE_COURSES,
                    student.getDegreeProgress().getCarolinaCoreCourses());
            degreeProgressJSON.put(DEGREE_PROGRESS_MAJOR_COURSES, student.getDegreeProgress().getMajorCourses());
            degreeProgressJSON.put(DEGREE_PROGRESS_COMPLETE_COURSES, student.getDegreeProgress().getCompleteCourses());
            userJSON.put(STUDENT_DEGREE_PROGRESS, degreeProgressJSON);

            // Convert advisor notes to JSON array
            JSONArray advisorNotesArray = new JSONArray();
            for (Note note : student.getAdvisorNotes()) {
                JSONObject advisorNoteJSON = new JSONObject();
                // Format date as string
                String formattedDate = formatDate(note.getDate());
                advisorNoteJSON.put(NOTE_DATE, formattedDate);
                advisorNoteJSON.put(NOTE_NOTE, note.getNote());
                advisorNotesArray.add(advisorNoteJSON);
            }
            userJSON.put(STUDENT_ADVISOR_NOTES, advisorNotesArray);

            // Convert course planner to JSON object
            JSONObject coursePlannerJSON = new JSONObject();
            JSONArray semestersArray = new JSONArray();
            for (List<Course> semester : student.getCoursePlanner().getSemesters()) {
                JSONArray semesterCoursesArray = new JSONArray();
                for (Course course : semester) {
                    JSONObject courseJSON = new JSONObject();
                    courseJSON.put(COURSE_CREDIT_HOURS, course.getCreditHours());
                    courseJSON.put(COURSE_PREREQUISITES, course.getPreReqs());
                    courseJSON.put(COURSE_CODE, course.getCode());
                    courseJSON.put(COURSE_ELECTIVE, course.isElective());
                    courseJSON.put(COURSE_YEAR, course.getYear());
                    courseJSON.put(COURSE_SUBJECT, course.getSubject());
                    courseJSON.put(COURSE_NAME, course.getName());
                    courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
                    courseJSON.put(COURSE_SEMESTER, course.getSemester());
                    courseJSON.put(COURSE_ID, course.getID());
                    courseJSON.put(COURSE_PASS_GRADE, String.valueOf(course.getPassGrade()));
                    courseJSON.put(COURSE_CAROLINA_CORE, course.isCarolinaCore());
                    semesterCoursesArray.add(courseJSON);
                }
                semestersArray.add(semesterCoursesArray);
            }
            coursePlannerJSON.put(COURSE_PLANNER_SEMESTERS, semestersArray);
            userJSON.put(STUDENT_COURSE_PLANNER, coursePlannerJSON);
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

        return userJSON;
    }

    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * Saves the provided list of courses into a JSON file.
     * If a course with the same ID already exists, it updates the existing course.
     *
     * @param courses The list of courses to be saved.
     */
    @SuppressWarnings("unchecked")
    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray coursesArray = new JSONArray();
        JSONArray existingData = readExistingData(COURSE_FILE_NAME);

        // Add existing courses to coursesArray
        for (Object obj : existingData) {
            coursesArray.add(obj);
        }

        // Update existing courses or add new courses
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

            // Check if the course with the same ID already exists
            boolean courseExists = false;
            for (int i = 0; i < coursesArray.size(); i++) {
                JSONObject existingCourseJSON = (JSONObject) coursesArray.get(i);
                String existingCourseID = (String) existingCourseJSON.get(COURSE_ID);
                if (existingCourseID.equals(course.getID())) {
                    // Update the existing course
                    coursesArray.set(i, courseJSON);
                    courseExists = true;
                    break;
                }
            }

            // If the course doesn't exist, add it to the coursesArray
            if (!courseExists) {
                coursesArray.add(courseJSON);
            }
        }

        // Write coursesArray to the file
        writeJSONToFile(coursesArray, COURSE_FILE_NAME);
    }

    /**
     * Saves the provided list of major maps into a JSON file.
     * If a major map with the same name already exists, it updates the existing
     * major map.
     *
     * @param majorMaps The list of major maps to be saved.
     */
    @SuppressWarnings("unchecked")
    public static void saveMajorMaps(ArrayList<MajorMap> majorMaps) {
        JSONArray majorMapsArray = new JSONArray();
        JSONArray existingData = readExistingData(MAJOR_FILE_NAME);

        // Add existing major maps to majorMapsArray
        for (Object obj : existingData) {
            majorMapsArray.add(obj);
        }

        // Update existing major maps or add new ones
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

            // Check if the major map with the same name already exists
            boolean majorMapExists = false;
            for (int i = 0; i < majorMapsArray.size(); i++) {
                JSONObject existingMajorMapJSON = (JSONObject) majorMapsArray.get(i);
                String existingMajorMapName = (String) existingMajorMapJSON.get(MAJOR_NAME);
                if (existingMajorMapName.equals(majorMap.getMajor())) {
                    // Update the existing major map
                    majorMapsArray.set(i, majorMapJSON);
                    majorMapExists = true;
                    break;
                }
            }

            // If the major map doesn't exist, add it to the majorMapsArray
            if (!majorMapExists) {
                majorMapsArray.add(majorMapJSON);
            }
        }

        // Write majorMapsArray to the file
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
                "Computer Science", 60, new ArrayList<Grades>(), 3.5, null, null, null);
        Admin admin = new Admin("Test", "2", "Test2@example.com", adminUscID, "54321", "ADMIN",
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
