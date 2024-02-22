package AdvisingSoftware;

import java.util.ArrayList;

/**
 * UserList class for managing users.
 * @author @spillmag
 */
public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    /**
     * Private constructor for UserList.
     * Initializes the list of users.
     */
    private UserList() {
        users = new ArrayList<>();
    }

    /**
     * Get the singleton instance of UserList.
     *
     * @return The singleton instance of UserList.
     */
    public static UserList getInstance() {
        return userList;
    }

    /**
     * Get a user by their USC ID.
     *
     * @param uscID The USC ID of the user.
     * @return The user with the specified USC ID, or null if not found
     */
    public User getUser(String uscID) {
        return null;
    }

    /**
     * Get a user by their email and password.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return The user with the specified email and password, or null if not found.
     */
    public User getUser(String email, String password) {
        User user = new User(null, email, password, password, password, password);
        return user;
    }

    /**
     * Add a new user to the list.
     *
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param email     The email of the user.
     * @param uscID     The USC ID of the user.
     * @param password  The password of the user.
     * @param userType  The type of the user.
     */
    public void addUser(String firstName, String lastName, String email, String uscID, String password, String userType) {
    }

    /**
     * Remove a user from the list by their USC ID.
     *
     * @param uscID The USC ID of the user to be removed.
     */
    public void removeUser(String uscID) {
    }
}
