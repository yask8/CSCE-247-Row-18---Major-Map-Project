package AdvisingSoftware;

import java.util.UUID;

/**
 * @author Owen Shumate Represents the User
 */
public class User {

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
   * Allows user to edit given first name
   *
   * @param firstName edited first name
   */
  public void editFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Allows user to edit given last name
   *
   * @param lastName edited last name
   */
  public void editLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Allows user to edit given email
   *
   * @param email edited email
   */
  public void editEmail(String email) {
    this.email = email;
  }

  /**
   * Allows user to edit given password
   *
   * @param password edited password
   */
  public void editPassword(String password) {
    this.password = password;
  }

  /**
   * Allows user to search for a specific course
   *
   * @param code course specific code to identify
   */
  public void lookUpCourse(String code) {
  }

  /**
   * To string to view user details
   * 
   * @author @Spillmag
   */
  public String toString() {
    return ("firstName: " +
        firstName +
        '\n' +
        "lastName: " +
        lastName +
        '\n' +
        "email: " +
        email +
        '\n' +
        "uscID: " +
        uscID +
        '\n' +
        "password: " +
        password +
        '\n' +
        "userType: " +
        userType +
        '\n');
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

  /**
   * Get the unique identifier of the user.
   *
   * @return The unique identifier of the user.
   */
  public UUID getID() {
    return uscID;
  }
}
