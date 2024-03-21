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
        assertTrue(advisor.addStudentToListOfAdvisees(studentId));
        assertEquals(1, advisor.getListOfAdvisees().size());
    }

    @Test
    public void testAddDuplicateStudentToListOfAdvisees() {
        UUID studentId = UUID.randomUUID();
        advisor.addStudentToListOfAdvisees(studentId);
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
