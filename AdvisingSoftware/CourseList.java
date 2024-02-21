import java.util.ArrayList;

/**
 * Represents a list of courses in the system.
 * @author Stephon Johnson
 */
public class CourseList {
    private static CourseList courseListInstance;
    private ArrayList<Course> courses;

    /**
     * Private constructor
     * Initializes the list of courses.
     */
    private CourseList() {
        courses = new ArrayList<>();
    }

    /**
     * Returns an instance of the CourseList class.
     *
     * @return The CourseList instance.
     */
    public static CourseList getInstance() {
        return null;
    }

    /**
     * Gets a course based on the given course code.
     *
     * @param code The course code to search for.
     */
    public void getCourse(String code) {
    }

    /**
     * Removes a course from the course list based on the given course code.
     *
     * @param code The course code to remove.
     */
    public void removeCourse(String code) {
    }

    /**
     * Adds a new course to the course list.
     *
     * @param name         The name of the course.
     * @param code         The code of the course.
     * @param description  The description of the course.
     * @param creditHours  The credit hours of the course.
     * @param subject      The subject of the course.
     * @param passGrade    The passing grade of the course.
     * @param elective     Indicates if the course is elective.
     * @param carolinaCore Indicates if the course is part of Carolina Core.
     * @param prereqs      The prerequisites of the course.
     */
    public void addCourse(String name, String code, String description, int creditHours, String subject, char passGrade, Boolean elective, Boolean carolinaCore, ArrayList<Course> prereqs) {
    }
}

