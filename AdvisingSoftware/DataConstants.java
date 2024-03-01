package AdvisingSoftware;

/**
 * This abstract class contains constants used throughout the advising software
 * for various data entities
 * Constants related to file names, field names, and other data attributes are
 * defined here.
 * 
 * TODO List
 * Add DegreeProgress Constants
 * Add CoursePlanner Constants
 * Add Notes Constants
 * 
 * @author @Spillmag
 */
public abstract class DataConstants {

    // User Constants
    protected static final String USER = "userList";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_USCID = "uscID";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_TYPE = "userType";

    // Student Constants
    protected static final String STUDENT_FILE_NAME = "Json/students.json";
    protected static final String STUDENT_CLASS = "class";
    protected static final String STUDENT_MAJOR = "major";
    protected static final String STUDENT_CREDITHOURS = "creditHours";
    protected static final String STUDENT_COMPLETED_COURSES = "completedCourses";
    protected static final String STUDENT_GPA = "gpa";
    protected static final String STUDENT_COURSE_PLANNER = "coursePlanner";
    protected static final String STUDENT_DEGREE_PROGRESS = "degreeProgress";
    protected static final String STUDENT_ADVISOR_NOTES = "advisorNotes";

    // Advisor Constants
    protected static final String ADVISOR_FILE_NAME = "Json/advisors.json";
    protected static final String ADVISOR_LIST_OF_ADVISEES = "listOfAdivsees";
    protected static final String ADVISOR_LIST_OF_FAILING_STUDENTS = "listOfFailingStudents";

    // Admin Constants
    protected static final String ADMIN_FILE_NAME = "Json/admins.json";
    protected static final String ADMIN_CHANGES_MADE = "changesMade";

    // Course Constants
    protected static final String COURSE_FILE_NAME = "Json/courses.json";
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_NAME = "name";
    protected static final String COURSE_CODE = "code";
    protected static final String COURSE_DESCRIPTION = "description";
    protected static final String COURSE_CREDIT_HOURS = "creditHours";
    protected static final String COURSE_SUBJECT = "subject";
    protected static final String COURSE_PASS_GRADE = "passGrade";
    protected static final String COURSE_ELECTIVE = "elective";
    protected static final String COURSE_CAROLINA_CORE = "carolinaCore";
    protected static final String COURSE_PREREQUISITES = "preReqs";
    protected static final String COURSE_SEMESTER = "semester";
    protected static final String COURSE_YEAR = "year";

    // Major Constants
    protected static final String MAJOR_FILE_NAME = "Json/majors.json";
    protected static final String MAJOR_UUID = "id";
    protected static final String MAJOR_NAME = "major";
    protected static final String MAJOR_COURSES = "majorCourses";
    protected static final String MAJOR_ELECTIVE = "majorElective";
    protected static final String MAJOR_CORE_EDU = "coreEdu";
    protected static final String MAJOR_APP_AREA = "appArea";
    protected static final String MAJOR_MIN_HOURS = "minTotalHours";
    protected static final String MAJOR_MIN_GRAD_HOURS = "minGradHours";
    protected static final String MAJOR_CC_HOURS = "caroCoreHours";
    protected static final String MAJOR_MIN_GPA = "minGPA";

    // Course Planner Constants
    protected static final String COURSE_PLANNER_SEMESTERS = "semesters";

    // Degree Progress Contants
    protected static final String DEGREE_PROGRESS_MAJOR = "major";
    protected static final String DEGREE_PROGRESS_ELECTIVE_COURSES = "electiveCourses";
    protected static final String DEGREE_PROGRESS_INCOMPLETE_COURSES = "incompleteCourses";
    protected static final String DEGREE_PROGRESS_CAROLINA_CORE_COURSES = "carolinaCoreCourses";
    protected static final String DEGREE_PROGRESS_MAJOR_COURSES = "majorCourses";
    protected static final String DEGREE_PROGRESS_COMPLETE_COURSES = "completeCourses";

    // Notes Constants
    protected static final String NOTE_NOTE = "note";
    protected static final String NOTE_DATE = "date";

    //Grades Constants
    protected static final String GRADES_COURSE_NAME = "courseName";
    protected static final String GRADES_GRADE = "grade";
}
