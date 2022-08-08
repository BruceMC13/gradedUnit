package SimplyRugby;

//imports
import java.util.ArrayList;
import java.util.Date;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//JuniorPlayer extends Player meaning it will inherit all attributes and methods of Player
public class JuniorPlayer extends Player{
	
	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * guardianName is initialised
	 */
	private String guardianName;
	
	/**
	 * guardianNo is initialised
	 */
	private String guardianNo;

	/**
	 * constructor passing in all required info to create the object
	 * @param firstName first name of junior player
	 * @param lastName last name of junior player
	 * @param email email of junior player (or guardian email)
	 * @param DOB date of birth of junior player
	 * @param address address of junior player
	 * @param phoneNumber phone number of junior player
	 * @param skillCategories skill categories of junior player
	 * @param position position of junior player
	 * @param emergencyContactNo emergency contact of junior player
	 * @param nextOfKinNo next of kin number for junior player
	 * @param doctorNo junior player's doctors number
	 * @param guardianName guardians name
	 * @param guardianNo guardians phone number
	 */
	public JuniorPlayer(String firstName, String lastName, String email, Date DOB, String address, String phoneNumber, ArrayList<SkillCategory> skillCategories,
			String position, String emergencyContactNo, String nextOfKinNo, String doctorNo, String guardianName, String guardianNo) {
		
		//superclass is Player - all details that the player class needs are passed in to be initialised
		super(firstName, lastName, email, DOB, address, phoneNumber, skillCategories, position, emergencyContactNo, nextOfKinNo, doctorNo);
		
		//guardianName is set to passed in string 
		this.guardianName = guardianName;
		
		//guardianNo is set to passed in string
		this.guardianNo = guardianNo;
			
	}
	
	/**
	 * getGuardianName returns the objects Guardian Name
	 * @return guardianName 
	 */
	public String getGuardianName() {
		return guardianName;
	}

	/**
	 * setGuardianName sets the objects guardian name to the passed in string
	 * @param guardianName sets name of guardian to passed in string
	 */
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	/**
	 * getGuardianNo will return the objects guardian number
	 * @return guardianNo
	 */
	public String getGuardianNo() {
		return guardianNo;
	}

	/**
	 * setGuradianNo will set the guardian number to the passed in string
	 * @param guardianNo sets guardian number to passed in string
	 */
	public void setGuardianNo(String guardianNo) {
		this.guardianNo = guardianNo;
	}

}
