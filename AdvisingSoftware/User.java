import java.util.UUID;

/**
 * @author Owen Shumate
 * Represents the User
 */
public class User{

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String uscID;
    private String password;
    private String userType;

    /**
     * User contructor
     * @param id UUID of the user
     * @param firstName User's first name
     * @param lastName User's last name
     * @param email User's email
     * @param uscID User's uscID
     * @param password User's password
     */
    public User(UUID id, String firstName, String lastName, String email, String uscID, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.uscID = uscID;
        this.password = password;
    }

    /**
     * User constructor
     * @param firstName  First name of the user
     * @param lastName  Last name of the user
     * @param email User's email
     * @param uscID User's uscID
     * @param password User's password
     */
    public User(String firstName, String lastName, String email, String uscID, String password){
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.uscID = uscID;
        this.password = password;
    }

    /**
     * Allows user to edit given first name
     * @param firstName edited first name
     */
    void editFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Allows user to edit given last name
     * @param lastName edited last name
     */
    void editLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Allows user to edit given email
     * @param email edited email
     */
    void editEmail(String email){
        this.email = email;
    }

    /**
     * Allows user to edit given password
     * @param password edited password
     */
    void editPassword(String password){
        this.password = password;
    }

    /**
     * Allows user to search for a specific course
     * @param code course specific code to identify 
     */
    void lookUpCourse(String code){

    }

}

