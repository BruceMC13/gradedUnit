package SimplyRugby;

//imports
import java.io.Serializable;
import java.util.Date;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//Member implements Serializable so i can save objects of Member in files
public class Member implements Serializable{

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * first name is initialised
	 */
	private String firstName;
	
	/**
	 * last name is initialised
	 */
	private String lastName;
	
	/**
	 * email is initialised
	 */
	private String email;
	
	/**
	 * DOB is initialised
	 */
	private Date DOB;
	
	/**
	 * address is initialised
	 */
	private String address;
	
	/**
	 * phoneNumber is initialised
	 */
	private String phoneNumber;
	
	
    /**
     * constructor - passing in all required info for creating an object of this class
     * @param firstName will be the first name of the Member
     * @param lastName will be the last name of the Member
     * @param email will be the email of the Member
     * @param DOB will be the date of birth of the Member
     * @param address will be the address of the Member
     * @param phoneNumber  will be the phone number of the Member
     */
	public Member(String firstName, String lastName, String email, Date DOB, String address, String phoneNumber) {
		
		//sets first name to passed in string
		this.firstName = firstName;
		
		//sets last name to passed in string
		this.lastName = lastName;
		
		//sets email to passed in string
		this.email = email;
		
		//sets DOB to passed in Date
		this.DOB = DOB;
		
		//sets address to passed in string
		this.address = address;
		
		//sets phone number to passed in string
		this.phoneNumber = phoneNumber;
		
	}

    /**
    * getFirstName will return the first name of the Member
    * @return firstName 
    */
	public String getFirstName() {
		return firstName;
	}

	/** 
	 * will set the Member firstName to the passed in String
	 * @param firstName name of member is set to the passed in string
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * getLastName will return the Member last name
	 * @return lastName 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * setLastName will set the member last name to the passed in string
	 * @param lastName last name of member is set to the passed in string
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * getEmail will return the member email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail will set the member email to the passed in string
	 * @param email email of the member is set to the passed in string
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getDOB will return the users Date of Birth
	 * @return DOB 
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * setDOB will set the members date of birth to the passed in date
	 * @param DOB date of birth of the member is set to the passed in date
	 */
	public void setDOB(Date DOB) {
		this.DOB = DOB;
	}

	/**
	 * getAddress will return the address of the member
	 * @return address 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * setAddress will set the address of the member to the passed in string
	 * @param address address of the member is set to the passed in string
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * getPhoneNumber will return the member phone number
	 * @return phoneNumber 
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setPhoneNumber will set the member phone number to the passed in string
	 * @param phoneNumber phone number of the member is set to the passed in string
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
