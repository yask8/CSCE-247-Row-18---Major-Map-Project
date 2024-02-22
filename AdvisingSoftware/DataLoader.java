package AdvisingSoftware;

import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

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
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < userJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) userJSON.get(i);
                String id = (String) personJSON.get(USER_UUID);
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

    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < courseJSON.size(); i++) {
                JSONObject courseObj = (JSONObject) courseJSON.get(i);
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

                Course course = new Course(name, code, description, creditHours, subject, passGrade, elective,carolinaCore,prerequisites);
                courses.add(course);
            }

            return courses;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
