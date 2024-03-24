package AdvisingSoftware.Testing;

import AdvisingSoftware.Advisor;
import AdvisingSoftware.Note;
import AdvisingSoftware.Student;
import AdvisingSoftware.UserList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class AdvisorTest {

    private Advisor advisor;
    private UserList userList;

    @BeforeEach
    public void setUp() {
        ArrayList<UUID> listOfAdvisees = new ArrayList<>();
        ArrayList<UUID> listOfFailingStudents = new ArrayList<>();
        UUID advisorId = UUID.randomUUID();
        advisor = new Advisor("John", "Smith", "john.smith@example.com", advisorId, "password", "ADVISOR",
                listOfAdvisees, listOfFailingStudents);
        userList = UserList.getInstance();
    }

    @AfterEach
    public void tearDown() {
        advisor = null;
        userList.clear();
    }

    @Test
    public void testAddStudentToListOfAdvisees() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student);
        advisor.addStudent(studentId);
        assertTrue(advisor.addStudentToListOfAdvisees(studentId));
        assertEquals(1, advisor.getListOfAdvisees().size());
    }

    @Test
    public void testAddDuplicateStudentToListOfAdvisees() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student);
        advisor.addStudentToListOfAdvisees(studentId);
        UUID studentId2 = UUID.randomUUID();
        Student student2 = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
        "Sophomore", "Computer Science", "Application Area", 60,
        new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student2);
        assertFalse(advisor.addStudentToListOfAdvisees(studentId));
        assertEquals(1, advisor.getListOfAdvisees().size());
    }

    @Test
    public void testAddNoteToStudentAdvisor() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student);

        advisor.addStudent(studentId);
        advisor.addNoteToStudentAdvisor(studentId, "Meeting went well.", userList);

        ArrayList<Note> advisorNotes = student.getAdvisorNotes();
        assertEquals(1, advisorNotes.size());
        assertEquals("Meeting went well.", advisorNotes.get(0).getNote());
    }

    @Test
    public void testBlankAddNoteToStudentAdvisor() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student);

        advisor.addStudent(studentId);
        advisor.addNoteToStudentAdvisor(studentId, "", userList);

        ArrayList<Note> advisorNotes = student.getAdvisorNotes();
        assertEquals(1, advisorNotes.size());
        assertEquals("", advisorNotes.get(0).getNote());
    }

    @Test
    public void testAddNoteToNonAdvisee() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 3.8, null, null, new ArrayList<>());
        userList.addUser(student);

        advisor.addNoteToStudentAdvisor(studentId, "Meeting went well.", userList);

        ArrayList<Note> advisorNotes = student.getAdvisorNotes();
        assertEquals(0, advisorNotes.size());
    }

    @Test
    public void testAddNoteSpecialCharacters() {
    UUID studentId = UUID.randomUUID();
    Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
            "Sophomore", "Computer Science", "Application Area", 60,
            new ArrayList<>(), 3.8, null, null, new ArrayList<>());
    userList.addUser(student);

    advisor.addStudent(studentId);
    String specialNote = "!@#$%^&*()_+-=[]{};':\"\\|,.<>/?"; // Special characters note
    advisor.addNoteToStudentAdvisor(studentId, specialNote, userList);

    ArrayList<Note> advisorNotes = student.getAdvisorNotes();
    assertEquals(1, advisorNotes.size());
    assertEquals(specialNote, advisorNotes.get(0).getNote());
    }



    
    @Test
    public void testCheckStudentFailStatusFailing() {
        double gpa = 2.5;
        double minGPA = 3.0;
        boolean result = advisor.checkStudentFailStatus(gpa, minGPA);
        assertFalse(result);
    }

    @Test
    public void testCheckStudentFailStatusPassing() {
        double gpa = 3.5;
        double minGPA = 3.0;
        boolean result = advisor.checkStudentFailStatus(gpa, minGPA);
        assertTrue(result);
    }

    @Test
    public void testCheckStudentFailStatusEqualMinimumGPA() {
        double gpa = 3.0;
        double minGPA = 3.0;
        boolean result = advisor.checkStudentFailStatus(minGPA, minGPA);
        assertTrue(result);
    }

    @Test
    public void testAddStudentRiskOfFailure() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 2.5, null, null, new ArrayList<>());
        userList.addUser(student);

        advisor.addStudentToListOfAdvisees(studentId);
        advisor.addStudentRiskOfFailure();

        ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();
        assertTrue(failingStudents.contains(studentId));
    }

    @Test
    public void testAddStudentRiskOfFailureNonAdvisee() {
        UUID studentId = UUID.randomUUID();
        Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
                "Sophomore", "Computer Science", "Application Area", 60,
                new ArrayList<>(), 2.5, null, null, new ArrayList<>());
        userList.addUser(student);

        advisor.addStudentRiskOfFailure();

        ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();
        assertFalse(failingStudents.contains(studentId));
    }

    @Test
public void testAddStudentRiskOfFailureMinimumGPA() {
    UUID studentId = UUID.randomUUID();
    Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
            "Sophomore", "Computer Science", "Application Area", 60,
            new ArrayList<>(), 1.0, null, null, new ArrayList<>()); // Minimum GPA
    userList.addUser(student);

    advisor.addStudentToListOfAdvisees(studentId);
    advisor.addStudentRiskOfFailure();

    ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();
    assertTrue(failingStudents.contains(studentId));
}

@Test
public void testAddStudentRiskOfFailureMaximumGPA() {
    UUID studentId = UUID.randomUUID();
    Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
            "Sophomore", "Computer Science", "Application Area", 60,
            new ArrayList<>(), 4.0, null, null, new ArrayList<>()); // Maximum GPA
    userList.addUser(student);

    advisor.addStudentToListOfAdvisees(studentId);
    advisor.addStudentRiskOfFailure();

    ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();
    assertTrue(failingStudents.contains(studentId));
}

@Test
public void testRemoveStudentRiskOfFailureAfterGPAImprovement() {
    // Create a student with an initial GPA of 2.5
    UUID studentId = UUID.randomUUID();
    Student student = new Student("Jane", "Doe", "jane.doe@example.com", studentId, "password", "STUDENT",
            "Sophomore", "Computer Science", "Application Area", 60,
            new ArrayList<>(), 2.5, null, null, new ArrayList<>());
    userList.addUser(student);

    // Add the student to the list of advisees
    advisor.addStudentToListOfAdvisees(studentId);

    // Add the student to the risk of failure list
    advisor.addStudentRiskOfFailure();

    // Simulate improvement in GPA by creating a new student object with improved GPA
    Student improvedStudent = new Student(
            student.getFirstName(), student.getLastName(), student.getEmail(), student.getStudentsID(),
            student.getPassword(), student.getUserType(), student.getYear(), student.getMajor(),
            student.getApplicationArea(), student.getCreditHours(), student.getCompletedCourses(),
            3.5, null, null, null); // Create new Student object with improved GPA

    // Remove the old student from the risk of failure list and add the improved student
    advisor.removeStudent(studentId);
    advisor.addStudentToListOfAdvisees(improvedStudent.getStudentsID());
    advisor.addStudentRiskOfFailure(); // Student with improved GPA is added to risk of failure list

    ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();

    // The student with improved GPA should not be in the failing students list
    assertFalse(failingStudents.contains(improvedStudent.getStudentsID()));
}



    

    @Test
    public void testRemoveStudentFromListOfAdvisees() {
        UUID studentId = UUID.randomUUID();
        advisor.addStudentToListOfAdvisees(studentId);

        advisor.removeStudent(studentId);

        ArrayList<UUID> advisees = advisor.getListOfAdvisees();
        assertEquals(0, advisees.size());
        assertFalse(advisees.contains(studentId));
    }

    @Test
    public void testRemoveNonExistentStudentFromListOfAdvisees() {
        UUID studentId = UUID.randomUUID();

        advisor.removeStudent(studentId);

        ArrayList<UUID> advisees = advisor.getListOfAdvisees();
        assertEquals(0, advisees.size());
        assertFalse(advisees.contains(studentId));
    }

    @Test
    public void testRemoveFromEmptyListOfAdvisees() {
    // Removing from an empty list of advisees
    UUID studentId = UUID.randomUUID();
    advisor.removeStudent(studentId);

    ArrayList<UUID> advisees = advisor.getListOfAdvisees();
    assertEquals(0, advisees.size());
    assertFalse(advisees.contains(studentId));
    }

    @Test
    public void testRemoveStudentFromListOfAdviseesAfterRiskOfFailure() {
        UUID studentId1 = UUID.randomUUID();
        UUID studentId2 = UUID.randomUUID();

        advisor.addStudentToListOfAdvisees(studentId1);
        advisor.addStudentToListOfAdvisees(studentId2);

        advisor.addStudentRiskOfFailure();

        advisor.removeStudent(studentId1);

        ArrayList<UUID> advisees = advisor.getListOfAdvisees();
        ArrayList<UUID> failingStudents = advisor.getListOfFailingStudents();

        assertEquals(1, advisees.size());
        assertEquals(1, failingStudents.size());
        assertFalse(advisees.contains(studentId1));
        assertTrue(advisees.contains(studentId2));
        assertTrue(failingStudents.contains(studentId2));
    }
}
