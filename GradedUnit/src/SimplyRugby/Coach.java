package SimplyRugby;

//imports
import java.util.Date;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//Coach will extend member as a coach is a member - this will mean coach will inherit all attributes and methods from the Member class
public class Coach extends Member{
	
	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * username String is initialised
	 */
	private String username;
	
	/**
	 * password string is initialised
	 */
	private String password;
	
	/**
	 * squadName string is initialised
	 */
	private String squadName;

	/**
	 * constructor passing in all required info for creating an object of this class
	 * @param firstName first name of Coach
	 * @param lastName last name of coach	
	 * @param email email of coach
	 * @param DOB date of birth of coach
	 * @param address address of coach
	 * @param phoneNumber phone number of coach
	 * @param username username of coach
	 * @param password password of coach
	 * @param squadName squad name the coach coaches
	 */
	public Coach(String firstName, String lastName, String email, Date DOB, String address, String phoneNumber, String username, String password, String squadName) {
		
		//superclass is Member - all details that the member class needs are passed in to be initialised
		super(firstName, lastName, email, DOB, address, phoneNumber);
		
		//username is set to passed in username
		this.username = username;
		
		//password is set to passed in password
		this.password = password;
		
		//squadName is set to passed in squad name
		this.squadName = squadName;
		
	}

	/**
	 * getUsername will return the username of the coach
	 * @return username 
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set username will set the username of the coach
	 * @param username will set the username of the coach to the passed in string
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * get password will get the password of the coach (will be hashed)
	 * @return password 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setPassword will set the password of the coach
	 * @param password will set the password of the coach to the passed in string
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getSquadName will return the squad name set within the coach
	 * @return squadName 
	 */
	public String getSquadName() {
		return squadName;
	}

	/**
	 * setSquadName will set the squadName for the coach
	 * @param squadName set the squadName for the coach to the passed in string
	 */
	public void setSquadName(String squadName) {
		this.squadName = squadName;
	}

}
