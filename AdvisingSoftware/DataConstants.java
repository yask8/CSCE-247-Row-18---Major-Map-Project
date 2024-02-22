package AdvisingSoftware;
// TO DO ADD FILE NAME TO COURSE AND MAJOR and make major and course PROTECTCTED STATIC
public class DataConstants {
    // User Constants
    protected static final String USER_FILE_NAME = "/Json/users.json";
	protected static final String USER = "userList";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_PHONE_EMAIL = "email";
    protected static final String USER_USCID = "uscID";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_TYPE = "userType";

    // Student Constants
	protected static final String STUDENT_CLASS = "class";
	protected static final String STUDENT_MAJOR = "major";
	protected static final String STUDENT_CREDITHOURS = "creditHours";
    protected static final String STUDENT_COMPLETED_COURSES = "completedCourses";
    protected static final String STUDENT_COURSE_PLANNER = "coursePlanner";
    protected static final String STUDENT_DEGREE_PROGRESS = "degreeProgess";
    protected static final String STUDENT_ADVISOR_NOTES = "advisorNotes";

    //Advisor Constants
    protected static final String ADVISOR_LIST_OF_ADVISEES = "listOfAdivsees";
	protected static final String ADVISOR_LIST_OF_FAILING_STUDENTS = "listOfFailingStudents";

    //Admin Constants
    protected static final String ADMIN_CHANGES_MADE = "changesMade";

    // Course Constants
    protected static final String COURSE_FILE_NAME = "/Json/courses.json";
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
    protected static final String MAJOR_FILE_NAME = "/Json/majors.json";
    protected static final String MAJOR_UUID = "id";
    protected static final String MAJOR_NAME = "major";
    protected static final String MAJOR_COURSES = "majorCourses";
    protected static final String MAJOR_ELECTIVE = "majorElective";
    protected static final String MAJOR_CORE_EDU = "coreEdu";
    protected static final String MAJOR_APP_AREA = "appArea";
}
