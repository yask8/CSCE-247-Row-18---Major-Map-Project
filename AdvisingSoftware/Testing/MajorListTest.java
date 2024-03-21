package AdvisingSoftware.Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AdvisingSoftware.MajorList;
import AdvisingSoftware.MajorMap;

public class MajorListTest {

    private MajorList majorList;

    @BeforeEach
    public void setUp() {
        majorList = MajorList.getInstance();
    }

    @AfterEach
    public void tearDown() {
        majorList.clear();
    }

    @Test
    public void testGetInstance() {
        MajorList instance1 = MajorList.getInstance();
        MajorList instance2 = MajorList.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void testGetInstanceEmptyMajorList() {
        majorList.clear();
        assertNotNull(majorList, "MajorList instance should not be null");
        assertTrue(majorList.getMajors().isEmpty(), "MajorList should be empty");
    }

    @Test
    public void testGetInstanceMajorListIsLoaded() {
        MajorList loadedInstance = MajorList.getInstance();
        assertTrue(loadedInstance.isLoaded(), "MajorList should be loaded");
    }

    @Test
    public void testGetInstanceEnsureMajorsAreUnique() {
        MajorList instance1 = MajorList.getInstance();
        instance1.addMajor("Computer Science", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 0, 0, 0, 0.0);
        MajorList instance2 = MajorList.getInstance();
        assertEquals(1, instance2.getMajors().size(), "Majors should be unique");
    }

    @Test
    public void testEmptyMajorList() {
        MajorList emptyMajorList = MajorList.getInstance();
        emptyMajorList.clear();
        assertNull(emptyMajorList.getMajorByName("Computer Science"));
    }

    @Test
    public void testNonexistentMajorName() {
        MajorList populatedMajorList = MajorList.getInstance();
        populatedMajorList.clear();
        assertNull(populatedMajorList.getMajorByName("Nonexistent Major"));
    }

    @Test
    public void testCaseInsensitivity() {
        MajorList populatedMajorList = MajorList.getInstance();
        MajorMap computerScienceMajor = populatedMajorList.getMajorByName("Computer Science");
        assertNotNull(computerScienceMajor);
        assertEquals("Computer Science", computerScienceMajor.getMajor());

        MajorMap computerScienceLowerCase = populatedMajorList.getMajorByName("computer science");
        assertNotNull(computerScienceLowerCase);
        assertEquals("Computer Science", computerScienceLowerCase.getMajor());
    }

    @Test
    public void testLeadingAndTrailingWhitespace() {
        MajorList populatedMajorList = MajorList.getInstance();
        MajorMap computerScienceMajor = populatedMajorList.getMajorByName("Computer Science");
        assertNotNull(computerScienceMajor);
        assertEquals("Computer Science", computerScienceMajor.getMajor());

        MajorMap majorWithWhitespace = populatedMajorList.getMajorByName("  Computer Science  ");
        assertNotNull(majorWithWhitespace);
        assertEquals("Computer Science", majorWithWhitespace.getMajor());
    }

    @Test
    public void testNonexistentMajorId() {
        MajorList populatedMajorList = MajorList.getInstance();
        assertNull(populatedMajorList.getMajorMapById(UUID.randomUUID()));
    }

    @Test
    public void testNullId() {
        MajorList populatedMajorList = MajorList.getInstance();
        assertNull(populatedMajorList.getMajorMapById(null));
    }

    @Test
    public void testAddMajorWithValidParameters() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();
        populatedMajorList.addMajor("Mathematics", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 120, 90, 45, 3.5);
        assertEquals(initialSize + 1, populatedMajorList.getMajors().size(), "Major should be added successfully");
    }

    @Test
    public void testAddMajorWithInvalidParameters() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();

        populatedMajorList.addMajor(null, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 120, 90, 45, 3.5);
        assertEquals(initialSize, populatedMajorList.getMajors().size(), "Major should not be added with null name");

        populatedMajorList.addMajor("Invalid Major", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), -10, 90, 45, 3.5);
        assertEquals(initialSize, populatedMajorList.getMajors().size(),
                "Major should not be added with negative minimum total hours");
    }

    @Test
    public void testAddMajorWithExistingName() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();
        populatedMajorList.addMajor("Computer Science", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 120, 90, 45, 3.5);
        assertEquals(initialSize, populatedMajorList.getMajors().size(),
                "Major with existing name should not be added");
    }

    @Test
    public void testRemoveExistingMajor() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();
        populatedMajorList.addMajor("Physics", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 120, 90, 45, 3.5);
        populatedMajorList.removeMajor("Physics");
        assertEquals(initialSize, populatedMajorList.getMajors().size(), "Existing major should be removed");
    }

    @Test
    public void testRemoveNonExistingMajor() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();

        populatedMajorList.removeMajor("Non-existent Major");
        assertEquals(initialSize, populatedMajorList.getMajors().size(),
                "Non-existing major should not affect the list");
    }

    @Test
    public void testAddMajorWithEmptyName() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();
        populatedMajorList.addMajor("", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), 120, 90, 45, 3.5);
        assertEquals(initialSize, populatedMajorList.getMajors().size(), "Major with empty name should not be added");
    }

    @Test
    public void testRemoveMajorWithNullName() {
        MajorList populatedMajorList = MajorList.getInstance();
        int initialSize = populatedMajorList.getMajors().size();
        populatedMajorList.removeMajor(null);
        assertEquals(initialSize, populatedMajorList.getMajors().size(),
                "Removing major with null name should not affect the list");
    }

    @Test
    public void testGetMajorByNullName() {
        MajorList populatedMajorList = MajorList.getInstance();
        assertNull(populatedMajorList.getMajorByName(null), "Getting major with null name should return null");
    }

    @Test
    public void testIsLoadedAfterFirstGetInstance() {
        MajorList majorList = MajorList.getInstance();
        assertTrue(majorList.isLoaded(), "MajorList should be loaded after the first call to getInstance");
    }

    @Test
    public void testIsLoadedAfterGetInstanceAndClear() {
        MajorList majorList = MajorList.getInstance();
        majorList.clear();
        assertFalse(majorList.isLoaded(),
                "MajorList should not be loaded after calling getInstance() and then clearing");
    }

    @Test
    public void testIsLoadedAfterSetLoadedAndClear() {
        MajorList majorList = MajorList.getInstance();
        majorList.setLoaded(false);
        majorList.clear();
        assertFalse(majorList.isLoaded(),
                "MajorList should not be loaded after setting loaded to false and then clearing");
    }
}