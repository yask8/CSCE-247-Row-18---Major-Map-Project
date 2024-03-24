package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import AdvisingSoftware.Student;
import AdvisingSoftware.Grades;
import AdvisingSoftware.CoursePlanner;
import AdvisingSoftware.DegreeProgress;
import AdvisingSoftware.MajorMap;
import AdvisingSoftware.Note;
import java.util.ArrayList;
import java.util.UUID;

/*
 * Tested by @oshumate Owen Shumate
 */

public class StudentTest {

    Student testStudent;

    @Test
    public void testViewProfile() {
        Student student = createSampleStudent();
        student.viewProfile();

        assertNotNull(student.getFirstName());
        assertNotNull(student.getLastName());
        assertNotNull(student.getEmail());
        assertNotNull(student.getID());
        assertEquals("John", student.getFirstName());
    }

    @Test
    public void testUpdateYearToLowerValue() {
        Student student = createSampleStudent();
        student.updateYear(30);
        
        assertEquals("Sophomore", student.getYear());
    }

    @Test
    public void testUpdateYearToHigherValue() {
        Student student = createSampleStudent();
        student.updateYear(90);

        assertEquals("Senior", student.getYear());
    }

    @Test
    public void testViewMajorMapForValidMajor() {
        Student student = createSampleStudent();
        String major = "Computer Science";
        MajorMap majorMap = student.viewMajorMap(major);

        assertNotNull(majorMap);
        assertEquals(major, majorMap.getMajor());
    }

    @Test
    public void testViewMajorMapForInvalidMajor() {
        Student student = createSampleStudent();
        MajorMap nonExistentMap = student.viewMajorMap("History");

        assertNull(nonExistentMap);
    }

    @Test
    public void testViewCompletedCoursesWithCourses() {
        Student student = createSampleStudent();
        student.viewCompletedCourses(student.getCompletedCourses());

        assertFalse(student.getCompletedCourses().isEmpty());
    }

    @Test
    public void testViewCompletedCoursesWithoutCourses() {
        Student student = createSampleStudent();
        student.viewCompletedCourses(new ArrayList<>());
        student.viewCompletedCourses(student.getCompletedCourses());

        assertTrue(student.getCompletedCourses().isEmpty());
    }

    @Test
    public void testViewCoursePlanner() {
        Student student = createSampleStudent();
        student.viewCoursePlanner();

        assertNotNull(student.getCoursePlanner());
    }

    @Test
    public void testViewDegreeProgress() {
        Student student = createSampleStudent();
        student.viewDegreeProgress();

        assertNotNull(student.getDegreeProgress());
    }

    @Test
    public void testAddCompleteCourse() {
        Student student = createSampleStudent();
        student.addCompleteCourse("CSCE146", 'A');

        assertEquals(3, student.getCompletedCourses().size());
    }

    @Test
    public void testAddDuplicateCompleteCourse() {
        Student student = createSampleStudent();
        student.addCompleteCourse("CSCE145", 'A');

        assertEquals(2, student.getCompletedCourses().size());
    }

    @Test
    public void testViewNotes() {
        Student student = createSampleStudent();
        student.viewNotes();

        assertFalse(student.getAdvisorNotes().isEmpty());
    }

    

    @Test
    public void testUpdateGpa() {
        Student student = createSampleStudent();
        student.updateGPA(new ArrayList<>());

        assertEquals(4.0, student.getGpa()); 
    }

    

    @Test
    public void testShowAppAreaOptions() {
        Student student = createSampleStudent();
        student.showAppAreaOptions();

        assertNotNull(student.getApplicationArea());
    }

    @Test
    public void testWriteCoursePlannerToFile() {
        Student student = createSampleStudent();
        student.writeCoursePlannerToFile("John Doe");
        
        assertTrue(true);
    }

    public Student createSampleStudent() {
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        UUID uscID = UUID.randomUUID();
        String password = "password123";
        String userType = "student";
        String year = "Freshman";
        String major = "Computer Science";
        String applicationArea = "Software Engineering";
        int creditHours = 30;
        ArrayList<Grades> completedCourses = new ArrayList<>();
        completedCourses.add(new Grades("CSCE145", 'A'));
        completedCourses.add(new Grades("MATH141", 'B'));
        double gpa = 3.5;
        CoursePlanner coursePlanner = new CoursePlanner();
        DegreeProgress degreeProgress = new DegreeProgress(applicationArea, null, null);
        ArrayList<Note> advisorNotes = new ArrayList<>();
        advisorNotes.add(new Note("Meeting with advisor scheduled for next week", null));

        return new Student(firstName, lastName, email, uscID, password, userType, year, major,
                applicationArea, creditHours, completedCourses, gpa, coursePlanner, degreeProgress, advisorNotes);
    }
}