package SimplyRugby;

//imports
import java.util.ArrayList;
import java.util.Date;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//Player extends Member - this will mean player will inherit all attributes and methods from the Member class
public class Player extends Member {
	
	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * initialises an arrayList which will contain skillCategory objects
	 */
	private ArrayList<SkillCategory> skillCategories = new ArrayList<SkillCategory>();
	
	/**
	 * position string is initialised
	 */
	private String position;
	
	/**
	 * emergencyContactNo string is initialised
	 */
	private String emergencyContactNo;
	
	/**
	 * nextOfKinNo string is initialised
	 */
	private String nextOfKinNo;
	
	/**
	 * doctorNo string is initialised
	 */
	private String doctorNo;

	/**
	 * constructor - passing in all required info for creating an object of this class
	 * @param firstName first name of the player
	 * @param lastName last name of the player
	 * @param email email of the player
	 * @param DOB date of birth of the player
	 * @param address address of the player
	 * @param phoneNumber phone number of the player
	 * @param skillCategories skillCategories of the player
	 * @param position position of the player
	 * @param emergencyContactNo emergency contact number of the player
	 * @param nextOfKinNo next of kin phone number
	 * @param doctorNo doctor number
	 */
	public Player(String firstName, String lastName, String email, Date DOB, String address, String phoneNumber, ArrayList<SkillCategory> skillCategories, String position, String emergencyContactNo,
			String nextOfKinNo, String doctorNo) {
		
		//superclass is Member - all details that the member class needs are passed in to be initialised
		super(firstName, lastName, email, DOB, address, phoneNumber);
		
		//skillCategories is set to the passed in ArrayList
		this.skillCategories = skillCategories;
		
		//position is set to passed in string
		this.position = position;
		
		//emergencyContactNo is set to passed in string
		this.emergencyContactNo = emergencyContactNo;
		
		//nextOfKinNo is set to the passed in string
		this.nextOfKinNo = nextOfKinNo;
		
		//doctorNo is set to the passed in string
		this.doctorNo = doctorNo;
		
	}

	/**
	 * getSkillCategories returns the ArrayList of skillCategories
	 * @return skillCategories list of player skill categories
	 */
	public ArrayList<SkillCategory> getSkillCategories() {
		return skillCategories;
	}

	/**
	 * setSkillCategories sets skillCategories to the passed in ArrayList of skillCategories
	 * @param skillCategories list of player skill categories
	 */
	public void setSkillCategories(ArrayList<SkillCategory> skillCategories) {
		this.skillCategories = skillCategories;
	}
	
	/**
	 * addSkillCategories allows a skillCategory to be added to the current list of skill Categories
	 * @param skillCategory one player skill category
	 */
	public void addSkillCategories(SkillCategory skillCategory) {
		this.skillCategories.add(skillCategory);
	}

	/**
	 * getPosition returns the position 
	 * @return position player position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * setPosition will set the position to the passed in string
	 * @param position sets position to passed in string
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * getEmergencyContactNo will return the emergency contact number
	 * @return emergencyContactNo emergency contact number
	 */
	public String getEmergencyContactNo() {
		return emergencyContactNo;
	}

	/**
	 * setEmergencyContactNo will set the emergency contact number to the passed in string
	 * @param emergencyContactNo contact number will be set to passed in string
	 */
	public void setEmergencyContactNo(String emergencyContactNo) {
		this.emergencyContactNo = emergencyContactNo;
	}

	/**
	 * getNextOfKinNo will return the next of kin number
	 * @return nextOfKinNo number for next of kin
	 */
	public String getNextOfKinNo() {
		return nextOfKinNo;
	}

	/**
	 * setNextOfKinNo will set the next of kin number to the string that is passed in
	 * @param nextOfKinNo sets number for next of kin to passed in string
	 */
	public void setNextOfKinNo(String nextOfKinNo) {
		this.nextOfKinNo = nextOfKinNo;
	}

	/**
	 * getDoctorNo will return the doctor number which is stored
	 * @return doctorNo doctors number
	 */
	public String getDoctorNo() {
		return doctorNo;
	}

	/**
	 * setDoctorNo will set the doctor number to the passed in string
	 * @param doctorNo sets doctors number to passed in string
	 */
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}


}
