package AdvisingSoftware;

import java.util.UUID;

/**
 * Represents a User 
 * @author Owen Shumate
 * 
 */
public class User {

  // Fields representing user information
  private String firstName;
  private String lastName;
  private String email;
  private UUID uscID;
  private String password;
  private String userType;

  /**
   * Constructor for creating a new user with a specified USC ID.
   *
   * @param firstName First name of the user
   * @param lastName  Last name of the user
   * @param email     User's email
   * @param uscID     User's USC ID
   * @param password  User's password
   * @param userType  User's role
   */
  public User(String firstName, String lastName, String email, UUID uscID, String password, String userType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.uscID = uscID;
    this.password = password;
    this.userType = userType;
  }

  /**
   * Constructor for creating a new user with a randomly generated USC ID.
   *
   * @param firstName First name of the user
   * @param lastName  Last name of the user
   * @param email     User's email
   * @param password  User's password
   * @param userType  User's role
   */
  public User(String firstName, String lastName, String email, String password, String userType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.uscID = UUID.randomUUID();
    this.password = password;
    this.userType = userType;
  }

  /**
   * Allows the user to edit the first name.
   *
   * @param firstName Edited first name
   */
  public void editFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Allows the user to edit the last name.
   *
   * @param lastName Edited last name
   */
  public void editLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Allows the user to edit the email address.
   *
   * @param email Edited email address
   */
  public void editEmail(String email) {
    this.email = email;
  }

  /**
   * Allows the user to edit the password.
   *
   * @param password Edited password
   */
  public void editPassword(String password) {
    this.password = password;
  }

  /**
   * Allows the user to search for a specific course.
   *
   * @param code Course code to identify the course
   */
  public void lookUpCourse(String code) {
    // Implementation to search for a course
  }

  /**
   * Get the first name of the user.
   *
   * @return The first name of the user.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the last name of the user.
   *
   * @return The last name of the user.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the USC ID of the user.
   *
   * @return The USC ID of the user.
   */
  public UUID getID() {
    return uscID;
  }

  /**
   * Get the user type.
   *
   * @return The user type.
   */
  public String getUserType() {
    return userType;
  }

  /**
   * Get the email address of the user.
   *
   * @return The email address of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the password of the user.
   *
   * @return The password of the user.
   */
  public String getPassword() {
    return password;
  }
}
