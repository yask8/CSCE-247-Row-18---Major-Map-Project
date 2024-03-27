package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.MajorMap;

/*
 * Tested by @Spillmag Garrett Spillman
 */
public class MajorMapTest {

    private MajorMap majorMap;

    @BeforeEach
    public void setUp() {

        majorMap = new MajorMap(UUID.randomUUID(), "Computer Science",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
    }

    @AfterEach
    public void tearDown() {

        majorMap = null;
    }

    @Test
    public void testEmptyMajorName() {
        try {
            new MajorMap(UUID.randomUUID(), "",
                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Major name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void testNullMajorName() {
        try {
            new MajorMap(UUID.randomUUID(), null,
                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                    new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Major name cannot be null or empty", e.getMessage());
        }
    }

    @Test
    public void testNegativeTotalHours() {
        MajorMap negativeTotalHoursMap = new MajorMap(UUID.randomUUID(), "Physics",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), -10, 0, 0, 0.0);
        assertEquals(0, negativeTotalHoursMap.getMinTotalHours());
    }

    @Test
    public void testNegativeGradHours() {
        MajorMap negativeGradHoursMap = new MajorMap(UUID.randomUUID(), "Biology",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, -5, 0, 0.0);
        assertEquals(0, negativeGradHoursMap.getMinGradHours());
    }

    @Test
    public void testNegativeCarolinaCoreHours() {
        MajorMap negativeCaroCoreHoursMap = new MajorMap(UUID.randomUUID(), "Chemistry",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, -20, 0.0);
        assertEquals(0, negativeCaroCoreHoursMap.getCaroCoreHours());
    }

    @Test
    public void testNegativeMinimumGPA() {
        MajorMap negativeMinGPAMap = new MajorMap(UUID.randomUUID(), "Mathematics",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, -1.5);
        assertEquals(0.0, negativeMinGPAMap.getMinGPA());
    }

    @Test
    public void testInvalidSemesterNumber() {
        MajorMap invalidSemesterNumberMap = new MajorMap(UUID.randomUUID(), "English",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            invalidSemesterNumberMap.getSemester(9);
        });
    }

    @Test
    public void testContainsCourse() {
        ArrayList<String> semester1Courses = new ArrayList<>();
        semester1Courses.add("MATH101");
        semester1Courses.add("PHYS101");
        semester1Courses.add("CHEM101");

        MajorMap containsCourseMap = new MajorMap(UUID.randomUUID(), "Engineering",
                semester1Courses, new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        assertTrue(containsCourseMap.containsCourse("MATH101"));
        assertFalse(containsCourseMap.containsCourse("ENGL101"));
    }

    @Test
    public void testUniqueId() {
        MajorMap map1 = new MajorMap(UUID.randomUUID(), "Math",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        MajorMap map2 = new MajorMap(UUID.randomUUID(), "Physics",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0.0);
        assertNotEquals(map1.getId(), map2.getId());
    }

    @Test
    public void testAddCourseToSemester() {

        majorMap.getSemester1().add("CSCI101");
        assertTrue(majorMap.getSemester1().contains("CSCI101"));
    }

    @Test
    public void testRemoveCourseFromSemester() {

        majorMap.getSemester2().add("CSCI102");
        assertTrue(majorMap.getSemester2().contains("CSCI102"));
        majorMap.getSemester2().remove("CSCI102");
        assertFalse(majorMap.getSemester2().contains("CSCI102"));
    }

    @Test
    public void testAddCourseWithWhitespaceToSemester() {

        majorMap.addCourseToSemester("    CSCI101   ", 1);
        assertTrue(majorMap.getSemester1().contains("CSCI101"));
    }

    @Test
    public void testRemoveCourseWithWhitespaceFromSemester() {

        majorMap.addCourseToSemester("   CSCI102  ", 2);
        assertTrue(majorMap.getSemester2().contains("CSCI102"));
        majorMap.removeCourseFromSemester("   CSCI102  ", 2);
        assertFalse(majorMap.getSemester2().contains("CSCI102"));
    }

    @Test
    public void testRemoveCourseWrongSemester() {

        majorMap.addCourseToSemester("CSCI102", 2);
        assertTrue(majorMap.getSemester2().contains("CSCI102"));
        majorMap.removeCourseFromSemester("CSCI102", 1);
        assertTrue(majorMap.getSemester2().contains("CSCI102"));
    }

    @Test
    public void testAddNullCourseToSemester() {
        majorMap.addCourseToSemester(null, 1);
        ;
        assertFalse(majorMap.getSemester1().contains(null));
    }

    @Test
    public void testAddDuplicateCourseToSemester() {
        majorMap.addCourseToSemester("CSCI104", 3);
        assertTrue(majorMap.getSemester3().contains("CSCI104"));

        majorMap.addCourseToSemester("CSCI104", 3);

        assertEquals(1, Collections.frequency(majorMap.getSemester3(), "CSCI104"));
    }

    @Test
    public void testGetCoursesForValidMajor() {
        majorMap.addCourseToSemester("CSCI101", 1);
        majorMap.addCourseToSemester("CSCI102", 2);
        majorMap.addCourseToSemester("CSCI201", 3);

        assertEquals(List.of("CSCI101", "CSCI102", "CSCI201"), majorMap.getCoursesForMajor("Computer Science"));
    }

    @Test
    public void testGetCoursesForMajorCaseInsensitivity() {
        majorMap.addCourseToSemester("CSCI101", 1);
        majorMap.addCourseToSemester("CSCI102", 2);
        majorMap.addCourseToSemester("CSCI201", 3);

        assertEquals(List.of("CSCI101", "CSCI102", "CSCI201"), majorMap.getCoursesForMajor("computer Science"));
    }

    @Test
    public void testGetCoursesForMatchingMajor() {
        majorMap.addCourseToSemester("CSCI101", 1);
        majorMap.addCourseToSemester("CSCI102", 2);
        majorMap.addCourseToSemester("CSCI201", 3);
        majorMap.addCourseToSemester("CSCI202", 4);

        List<String> courses = majorMap.getCoursesForMajor("Computer Science");

        assertTrue(courses.contains("CSCI101"));
        assertTrue(courses.contains("CSCI102"));
        assertTrue(courses.contains("CSCI201"));
        assertTrue(courses.contains("CSCI202"));
    }

    @Test
    public void testGetCoursesForNonMatchingMajor() {
        majorMap.addCourseToSemester("CSCI101", 1);
        majorMap.addCourseToSemester("CSCI102", 2);
        majorMap.addCourseToSemester("CSCI201", 3);
        majorMap.addCourseToSemester("CSCI202", 4);

        List<String> courses = majorMap.getCoursesForMajor("Biology");

        assertTrue(courses.isEmpty());
    }
}