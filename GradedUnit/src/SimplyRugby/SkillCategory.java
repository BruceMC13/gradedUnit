package SimplyRugby;

//imports
import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//SkillCategory implements Serializable so i can save objects of SkillCategory in files
public class SkillCategory implements Serializable{

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * category name is initialised
	 */
	private String name;
	
	/**
	 * notes are initialised 
	 */
	private String notes;
	
	/**
	 * ArrayList which will hold skills is initialised 
	 */
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	
	/**
	 * constructor - passing in all required info for creating an object of this class
	 * @param name name of skillCategory
	 * @param notes notes of skillCategory
	 * @param skills skills within skillCategory
	 */
	public SkillCategory(String name, String notes, ArrayList<Skill> skills) {
		
		//sets category name to the name passed in when creating a new object
		this.name = name;
		
		//sets notes to the string passed in when creating a new object
		this.notes = notes;
		
		//sets skills to the skills ArrayList passed in when creating a new object
		this.skills = skills;
	}
	
	/**
	 * constructor which leaves notes as blank
	 * @param name name of skillCategory
	 * @param skills skills wihin skillCategory
	 */
	public SkillCategory(String name, ArrayList<Skill> skills) {
		
		//sets category name to the name passed in when creating a new object
		this.name = name;
		
		//sets notes to blank
		this.notes = "";
		
		//sets skills to the skills ArrayList passed in when creating a new object
		this.skills = skills;
	}
	
	/**
	 * getName will return the name of the SkillCategory
	 * @return name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName will set the name of the SkillCategory to the name which is passed in
	 * @param name will set name of Category to the passed in string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getNotes will return the text which is stored in the notes variable
	 * @return notes 
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * setNotes will set the notes to the string which is being passed in
	 * @param notes sets notes to passed in string
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * getSkills will return the ArrayList of skills
	 * @return skills 
	 */
	public ArrayList<Skill> getSkills() {
		return skills;
	}

	/**
	 * set skills will set skills to the ArrayList of skills which has been passed in
	 * @param skills will set skills to passed in list of skills
	 */
	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	/**
	 * addSkills allows for new skills to be added to the current SkillList
	 * @param skill will add skill to current skill list
	 */
	public void addSkills(Skill skill) {
		this.skills.add(skill);
	}
	
	
}
