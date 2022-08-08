package SimplyRugby;

import java.io.Serializable;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//Skill implements Serializable so i can save objects of Skill in files
public class Skill implements Serializable{

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Skill name is initialised
	 */
	private String name;
	
	/**
	 * rating is initialised
	 */
	private String rating;
	
	/**
	 * constructor - passing in required info for creating an object of this class
	 * @param name name of the skill
	 * @param rating rating of the skill
	 */
	public Skill(String name, String rating) {
		
		//sets name of skill to passed in string
		this.name = name;
		
		//sets skill rating to the passed in string
		this.rating = rating;
	}
	
	/**
	 * getName returns the name of the skill
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName will set the name of the skill to the passed in string
	 * @param name sets name of skill to passed in string
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getRating will return the rating of the current skill
	 * @return rating 
	 */
	public String getRating() {
		return rating;
	}
	
	/**
	 * setRating will set the current rating to the passed in string
	 * @param rating rating of skill will be set to passed in string
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
