package SimplyRugby;

//imports
import java.io.Serializable;
import java.util.ArrayList;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

//Squad implements Serializable so i can save objects of squad in files
public class Squad implements Serializable{

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * name is initialised as string
	 */
	private String name;
	
	/**
	 * ArrayList which will hold Players is initialised 
	 */
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * constructor - passing in required info for creating an object of this class
	 * @param name name of squad
	 * @param players list of players in squad
	 */
	public Squad(String name, ArrayList<Player> players) {
		
		/**
		 * name of squad is set to the name which is passed in
		 */
		this.name = name;
		
		/**
		 * players is set to the ArrayList which is passed in
		 */
		this.players = players;
	}

	/**
	 * getName returns the name of the squad
	 * @return name 
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName will set the name of the squad to the passed in string
	 * @param name name of squad will be set to passed in string
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getPlayers will return the ArrayList of players held within the object
	 * @return players 
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * setPlayers will set the player ArrayList to the passed in ArrayList of players
	 * @param players sets players to passed in arrayList of players
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	/**
	 * addPlayers will add the passed in player to the current ArrayList of players
	 * @param player adds passed in player to player ArrayList
	 */
	public void addPlayers(Player player) {
		this.players.add(player);
	}
}
