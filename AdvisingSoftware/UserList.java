package AdvisingSoftware;

import java.util.ArrayList;
import java.util.UUID;

/**
 * UserList class for managing users.
 * This class implements the Singleton design pattern.
 */
public class UserList {

    private static UserList userList;
    private ArrayList<User> users;
    private boolean loaded;

    /**
     * Private constructor for UserList.
     * Initializes the list of users.
     */
    private UserList() {
        users = new ArrayList<>();
        loaded = false;
    }

    /**
     * Get the singleton instance of UserList.
     *
     * @return The singleton instance of UserList.
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
            if (!userList.isLoaded()) {
                ArrayList<User> userData = DataLoader.loadUsers();
                for (User user : userData) {
                    userList.addUser(user);
                }
                userList.setLoaded(true);
            }
        }
        return userList;
    }

    /**
     * Get a user by their USC ID.
     *
     * @param uscID The USC ID of the user.
     * @return The user with the specified USC ID
     */
    public User getUser(UUID uscID) {
        for (User user : users) {
            if (user.getID().equals(uscID)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get a user by their email and password.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return The user with the specified email and password.
     */
    public User getUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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
    public void addUser(String firstName, String lastName, String email, UUID uscID, String password, String userType) {
        User user = new User(firstName, lastName, email, uscID, password, userType);
        users.add(user);
    }

    /**
     * Add a new user to the list.
     *
     * @param user The user object to add.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Remove a user from the list by their USC ID.
     *
     * @param uscID The USC ID of the user to be removed.
     */
    public void removeUser(UUID uscID) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getID().equals(uscID)) {
                users.remove(i);
                break;
            }
        }
    }

    /**
     * Get all users in the list.
     *
     * @return The list of users.
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets the flag indicating whether userList is loaded with data.
     *
     * @param loaded Boolean indicating if userList is loaded
     */
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * Checks if userList is loaded.
     *
     * @return True if userList is loaded, false otherwise
     */
    public boolean isLoaded() {
        return loaded;
    }
}
