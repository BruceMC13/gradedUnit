package SimplyRugby;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class Controller {

	/**
	 * constructor - this is the start of the program, a splash/loading screen will be displayed and then the login screen will be displayed to the user
	 */
	public Controller() {
		
		/**
		 * creates new splash screen object
		 */
		SplashScreen splash = new SplashScreen();
		
		/**
		 * sets splash screen to be visible to the user
		 */
		splash.setVisible(true);
		
		/**
		 * calls progress bar method inside of splash screen object - will display the progress bar on the splash screen
		 */
		splash.progressBar();
		
		/**
		 * after progress bar reaches 100% splash screen is disposed
		 */
		splash.dispose();
		
		/**
		 * calls show login method
		 */
		showLogin();
			
	}
	
	/**
	 * this method is for displaying the login screen to the user
	 */
	public static void showLogin() {
		
		/**
		 *  Model is initialised - this will pre-populate data for the program - Model also holds methods dealing with data etc
		 */
		@SuppressWarnings("unused")
		Model simplyRugby = new Model();
		
		/**
		 * login screen is initialised - this will create an object of loginScreen class
		 */
		LoginScreen loginScreen = new LoginScreen();
		
		/**
		 * sets the login screen visible to the user
		 */
		loginScreen.setVisible(true);
		
		/**
		 * pulls focus away from the first text box so the temp text can be seen
		 */
		loginScreen.requestFocus();
	}
	
	/**
	 * This method is used when a user enters login details and hits login - this method checks if the login details are valid or not
	 * @param username username is passed in which the user has entered
	 * @param password password is passed in which the user has entered
	 * @return result true or false - either the login request is accepted or it is denied
	 */
	public static boolean loginRequest(String username, char[] password) {
		
		/**
		 * Arraylist of coaches is initialised and reads in coaches from the Model class
		 */
		ArrayList<Coach> coaches = Model.readCoaches();
		
		/**
		 * password input is converted into a string and saved in passwordInput
		 */
		String passwordInput = String.valueOf(password);
		
		/**
		 * boolean result is initialised as false 
		 */
		boolean result = false;
		
		/**
		 * loops for each coach as c
		 */
		for(Coach c: coaches){
			
			/**
			 * if current coach has the same username and password as the username and password the user has entered then the following code will run
			 */
			if(c.getUsername().equals(username) && BCrypt.checkpw(passwordInput, c.getPassword())) {
				
				/**
				 * result is set to true
				 */
				result = true;
				
				/**
				 * if found the loop is broken
				 */
				break;

			}
		}
		
		/**
		 * returns result to where the method has been called - true = valid login, false = invalid login
		 */
		return result;
		
	}
	
	/**
	 * This method is for displaying the main menu to the user
	 * @param coach coach is the current coach who is logged in
	 */
	public static void showMainMenu(Coach coach) {
		
		/**
		 * main menu is  creating a new main menu object passing in coach as a parameter  
		 */
		MainMenu mainMenu = new MainMenu(coach);
		
		/**
		 * main menu is set visible to the user
		 */
		mainMenu.setVisible(true);
		
	}
	
	/**
	 * This method is for displaying the View Player screen to the user
	 * @param playerName playerName is the name of the player who is going to be viewed on the view player screen
	 * @param coach coach is the current logged in coach
	 */
	public static void showViewPlayer(String playerName, Coach coach) {
		
		/**
		 * viewPlayer is initialised - creating a new view player object passing in playerName and coach object
		 */
		ViewPlayer viewPlayer = new ViewPlayer(playerName, coach);
		
		/**
		 * viewPlayer screen is set visible for the user
		 */
		viewPlayer.setVisible(true);
		
	}
	
	/**
	 * readPlayerNames is a method which is used when you want to see all of the player names in a squad
	 * @param coach coach object is passed in so all players in this coaches squad can have their names read and returned
	 * @return playerNames list of player names
	 */
	public static ArrayList<String> readPlayerNames(Coach coach) {
		
		/**
		 * arrayList squads is initialised - using the Model all squads are read into this arrayList
		 */
		ArrayList<Squad> squads = Model.readSquads();
		
		/**
		 * playerNames arrayList is initialised as new ArrayList which holds strings
		 */
		ArrayList<String> playerNames = new ArrayList<String>();

		/**
		 * for each member is squads ArrayList this loop will loop - s is each squad
		 */
		for(Squad s: squads){
			
			/**
			 * if squad name is the same as the logged in coaches squad name then the following will happen
			 */
			if(s.getName().equals(coach.getSquadName())) {
				
				/**
				 * for each player (taken from squad player list) the following loop will run p being current player
				 */
				for(Player p: s.getPlayers()) {
					
					/**
					 * playerNames list has player first and last name combined and then added to it
					 */
					playerNames.add(p.getFirstName() + " " + p.getLastName());
				}
			}
		}
		
		/**
		 * returns playerNames ArrayList to where method was called
		 */
		return playerNames;
		
	}
	
	/**
	 * getSkills is a method used to get all the skills of a certain player - these skills are then returned to where the method has been called
	 * @param playerName playerName is the name of the player which to get all of the stored skills from 
	 * @param currentTab currentTab is the name of the current tab which is being viewed on the View Player screen (skill category name)
	 * @return skills list of skills will be returned
	 */
	public static ArrayList<Skill> getSkills(String playerName, String currentTab) {
		
		/**
		 * initialises squads as arrayList which holds squad objects
		 */
		ArrayList<Squad> squads = new ArrayList<Squad>();
		
		/**
		 * initialises players as arrayList which holds player objects
		 */
		ArrayList<Player> players = new ArrayList<Player>();
		
		/**
		 * initialises skillCategories as arrayList which holds skillCategory objects
		 */
		ArrayList<SkillCategory> skillCategories = new ArrayList<SkillCategory>();
		
		/**
		 * initialises skills as arrayList which holds Skill objects
		 */
		ArrayList<Skill> skills = new ArrayList<Skill>();
		
		/**
		 * selectedPlayer is initialised as null
		 */
		Player selectedPlayer = null;
		
		/**
		 * squads are read in via model
		 */
		squads = Model.readSquads();
		
		/**
		 * for each squad the loop will run s being current squad
		 */
		for(Squad s: squads){
			
			/**
			 * all players from all squads will be added to the player list
			 */
			players.addAll(s.getPlayers());
		}
		
		/**
		 * for each player the loop will run - p being current player
		 */
		for(Player p: players){
			
			/**
			 * if current player name is the same as the passed in playername the following will run
			 */
			if((p.getFirstName() + " " + p.getLastName()).equals(playerName)) {

				/**
				 * selected player is set to current player
				 */
				selectedPlayer = p;
				
				/**
				 * loop is broken as player has been found
				 */
				break;
			}
		}
		
		/**
		 * skillCategories is set to the selectedPlayers skillCategories
		 */
		skillCategories = selectedPlayer.getSkillCategories();
		
		/**
		 * for each skill category within the player the following will run - s being current skill category
		 */
		for(SkillCategory s: skillCategories){
			
			/**
			 * if the current tab that the user is on has the same name as the skillCategory then the following will run
			 */
			if(s.getName().equals(currentTab)) {
				
				/**
				 * skills are set to the current skillCategory list of skills
				 */
				skills = s.getSkills();
				
				/**
				 * loop is broken as skill category was found
				 */
				break;
			}
		}
		
		/**
		 * skills list is returned to where method is called
		 */
		return skills;
		
	}
	
	/**
	 * getSkillCategories is a method which is used to get all skill categories of a certain player
	 * @param playerName name of the player is passed in 
	 * @return skillCategories returns list of skill categories
	 */
	public static ArrayList<SkillCategory> getSkillCategories(String playerName) {
		
		/**
		 * initialises squads as arrayList which holds squad objects
		 */
		ArrayList<Squad> squads = new ArrayList<Squad>();
		
		/**
		 * initialises players as arrayList which holds player objects
		 */
		ArrayList<Player> players = new ArrayList<Player>();
		
		/**
		 * initialises skillCategories as arrayList which holds skillCategory objects
		 */
		ArrayList<SkillCategory> skillCategories = new ArrayList<SkillCategory>();
		
		/**
		 * initialises selectedPlayer as null
		 */
		Player selectedPlayer = null;
		
		/**
		 * squads is set to all squads read in via Model
		 */
		squads = Model.readSquads();
		
		/**
		 * for each squad the following loop runs - s being current squad
		 */
		for(Squad s: squads){
			
			/**
			 * all players from all squads are added to the players list
			 */
			players.addAll(s.getPlayers());
		}
		
		/**
		 * for all players the following loop runs - p being current player
		 */
		for(Player p: players){
			
			/**
			 * if current player has the same name as the passed in playerName then the following code runs
			 */
			if((p.getFirstName() + " " + p.getLastName()).equals(playerName)) {
				
				/**
				 * sleectedPlayer is set to current player in list
				 */
				selectedPlayer = p;
				
				/**
				 * loop is broken as player is found
				 */
				break;
			}
		}
		
		/**
		 * skillCategories is set to selectedPlayers skill categories
		 */
		skillCategories = selectedPlayer.getSkillCategories();
		
		/**
		 * skillCategories are returned to where the method is called
		 */
		return skillCategories;
		
	}
	
	/**
	 * saveTableData is a method which saves all data which is in the table found within the viewPlayer screen
	 * @param playerName name of the player currently being edited/viewed
	 * @param coach coach of the player being viewed
	 * @param dataFromTable this is the data which is inside of the table which needs saved
	 * @param newNoteData this is the notes section of the skill category which needs saved
	 * @param currentTab the current skill category being viewed on the ViewPlayer screen
	 */
	public static void saveTableData(String playerName, Coach coach, Map<String, String> dataFromTable, String newNoteData, String currentTab) {
		
		/**
		 * initialises squads as arrayList which holds squad objects
		 */
		ArrayList<Squad> squads = Model.readSquads();
		
		/**
		 * initialises players as arrayList which holds player objects
		 */
		ArrayList<Player> players = new ArrayList<Player>();
		
		/**
		 * initialises tempSkillCat as arrayList which holds SkillCategory objects
		 */
		ArrayList<SkillCategory> tempSkillCat = new ArrayList<SkillCategory>();
		
		/**
		 * initialises tempSkill as arrayList which holds Skill objects
		 */
		ArrayList<Skill> tempSkill = new ArrayList<Skill>();
		
		/**
		 * initialises invalid as false
		 */
		boolean invalid = false;
		
		/**
		 * for each squad the following loop runs - s being current squad
		 */
		for(Squad s: squads){
			
			/**
			 * if passed in coach has the same squad name as the current squads name the following will run
			 */
			if(coach.getSquadName().equals(s.getName())) {
				
				/**
				 * players is set to the player list found within the current squad
				 */
				players = s.getPlayers();
				
				/**
				 * for each player the following loop runs - p being current player
				 */
				for(Player p: players) {
					
					/**
					 * if player name is the same as the passed in player name the following runs
					 */
					if((p.getFirstName() + " " + p.getLastName()).equals(playerName)) {
						
						/**
						 * tempSkillCat is set to current players skillCategories
						 */
						tempSkillCat = p.getSkillCategories();
						
						/**
						 * loop runs for all skill categories within the current player - sc being current skill category
						 */
						for(SkillCategory sc: tempSkillCat) {
							
							/**
							 * temp skill list is set to the skills found within the current skill catgeory
							 */
							tempSkill = sc.getSkills();
							
							/**
							 * if the tab the user is currently on has the same name as the current skill category the following will run
							 */
							if(currentTab.equals(sc.getName())) {
								
								/**
								 * skill category notes are set to the passed in newNoteData 
								 */
								sc.setNotes(newNoteData);
							}
															
							/**
							 * loop will run for each skill within current skill category - sk being current skill
							 */
							for(Skill sk: tempSkill) {

								/**
								 * dataFromTable is a hashmap which uses the skill name as the key and the rating of that skill is the value of that key
								 * dataFromTable gets the current skillname and checks for hashmap key which has the same name
								 * if this key exists and data is not null then the following code will run
								 */
								if(dataFromTable.get(sk.getName()) != null) {
									
									/**
									 * checks if data from table is valid - only key values acceoted are numbers 1 - 5, if the values are valid the following code runs
									 */
									if(dataFromTable.get(sk.getName()).equals("1") || dataFromTable.get(sk.getName()).equals("2")
											|| dataFromTable.get(sk.getName()).equals("3") || dataFromTable.get(sk.getName()).equals("4")
											|| dataFromTable.get(sk.getName()).equals("5")) {
										
										/**
										 * current skill is set to value stored within dataFromTable hashmap using the skillname as the key
										 */
										sk.setRating(dataFromTable.get((String)sk.getName()));
										
									/**
									 * if value is not 1 - 5 the following code runs
									 */
									} else {
										
										/**
										 * invalid is set to true
										 */
										invalid = true;
										
										/**
										 * loop is broken as there was an invalid input detected
										 */
										break;
									}
								} 


							}
							
							
						}

					}
				}
				
			}
		}
		
		/**
		 * if invalid is true the following code runs
		 */
		if(invalid) {
			
			/**
			 * message box is shown to the user letting them know that a value is invalid
			 */
			JOptionPane.showMessageDialog(null, "Invalid Input detected - make sure rating is between 1 and 5");
			
		/**
		 * if values are all valid the following code runs
		 */
		} else {

			/**
			 * squads are saved via model passing in squads list
			 */
			Model.saveSquads(squads);
			
			/**
			 * user is alerted that to ensure any values they changed are to be saved they must press enter after entering the new value
			 */
			JOptionPane.showMessageDialog(null, "To ensure save was successful press enter after editing the skill value!");
			
			/**
			 * user is alerted that the save has been complete
			 */
			JOptionPane.showMessageDialog(null, "Save Successful");
		}
		
	}
	
	/**
	 * newSkillCategory is a method which is used when a coach wants to add a new skillCategory to a player
	 * @param playerName name of the player getting a new skillCategory
	 * @param categoryName name of the new category
	 * @param coach coach of the current player being edited
	 */
	public static void newSkillCategory(String playerName, String categoryName, Coach coach) {
		
		/**
		 * initialises skillCategories as arrayList which reads in skillCategories from getSkillCategories method - sending playerName as a parameter
		 */
		ArrayList<SkillCategory> skillCategories = getSkillCategories(playerName);
		
		/**
		 * initialises skills as arrayList which holds Skill objects
		 */
		ArrayList<Skill> skills = new ArrayList<Skill>();
		
		/**
		 * boolean valid is initialised as true
		 */
		boolean valid = true;
		
		/**
		 * for each skill category the following loop runs - s being current skill category
		 */
		for(SkillCategory s: skillCategories) {
			
			/**
			 * if current skillCategory has the same name as the category name passed in then the following code runs
			 */
			if(s.getName().toLowerCase().equals(categoryName.toLowerCase())) {
				
				/**
				 * valid is set to false
				 */
				valid = false;
				
				/**
				 * loop is broken as category name already exists
				 */
				break;
			}
		}
		
		/**
		 * if valid then the category will be created - the following code will run
		 */
		if(valid) {
			
			/**
			 * newCategory is initialised as a new skillCategory passing in category name and the empty skills list
			 */
			SkillCategory newCategory = new SkillCategory(categoryName, skills);
			
			/**
			 * skillCategories adds the newCategory to the Skill category List
			 */
			skillCategories.add(newCategory);
			
			/**
			 * squads is initialised and reads in all squads via the Model
			 */
			ArrayList<Squad> squads = Model.readSquads();
			
			/**
			 * for each squad the following loop will run - s being current squad
			 */
			for(Squad s: squads) {
				
				/**
				 * initialises players as arrayList which holds player objects
				 */
				ArrayList<Player> players = new ArrayList<Player>();
				
				/**
				 * players adds all players from all squads
				 */
				players.addAll(s.getPlayers());
				
				/**
				 * for all players in the player list the following loop runs - p being current player
				 */
				for(Player p: players) {
					
					/**
					 * if current player has the same name as passed in playerName the following code will run
					 */
					if((p.getFirstName() + " " + p.getLastName()).equals(playerName)) {
						
						/**
						 * current player skillCategories are set to the skillCategories list from this method
						 */
						p.setSkillCategories(skillCategories);
					}
				}
				
			}
			
			/**
			 * squads are saved via Model
			 */
			Model.saveSquads(squads);
			
			/**
			 * showViewPlayer is called again passing in playerName and coach (this is because the view was disposed when calling this method - essentially this updates the view and shows the new category)
			 */
			showViewPlayer(playerName, coach);
			
			/**
			 * if valid = false the following code will run
			 */
		} else {
			
			/**
			 * the viewPlayerScreen is loaded for the user again passing in playerName and coach object
			 */
			showViewPlayer(playerName, coach);
			
			/**
			 * user is alerted they are trying to create a category which already exists
			 */
			JOptionPane.showMessageDialog(null, "Error: Category already exists");
		}
		
		
		
	}
	
	/**
	 * newSkill method will be used to add new skills to a player
	 * @param playerName name of the player
	 * @param skillName new skill name
	 * @param currentTab current skill category which the new skill will be added to
	 * @param coach coach of the player being edited
	 */
	public static void newSkill(String playerName, String skillName, String currentTab, Coach coach) {
		
		/**
		 * initialises skillCategories as arrayList which holds skillCategories of the current player (name passed in as a parameter)
		 */
		ArrayList<SkillCategory> skillCategories = getSkillCategories(playerName);	
		
		/**
		 * initialises skills as arrayList which holds skill objects
		 */
		ArrayList<Skill> skills = new ArrayList<Skill>();
		
		/**
		 * initialises squads as arrayList which holds squad objects read in via model
		 */
		ArrayList<Squad> squads = Model.readSquads();
		
		/**
		 * boolean valid is initialised as true
		 */
		boolean valid = true;
		
				/**
				 * for each skill category the following loop runs - s being current skillCategory
				 */
				for(SkillCategory s: skillCategories) {
					
					/**
					 * all skills from all categories are added to the skills list
					 */
					skills.addAll(s.getSkills());
					
					/**
					 * for each skill in skills this loop will run - sk being current skill
					 */
					for(Skill sk: skills) {
						
						/**
						 * if skill name is the same as the passed in skill name the following code runs
						 */
						if(sk.getName().toLowerCase().equals(skillName.toLowerCase())) {
							
							/**
							 * valid is set to false as user is trying to add a skill which already exists
							 */
							valid = false;
							
							/**
							 * loop breaks as invalid input detected
							 */
							break;
						} 

						
					}
							
				}
		
		/**
		 * if valid is true the skill is created - the following code will run
		 */
		if(valid) {
			
			/**
			 * for each squad the loop runs - sq being current squad
			 */
			for(Squad sq: squads) {
				
				/**
				 * initialises players as arrayList which holds player objects
				 */
				ArrayList<Player> players = new ArrayList<Player>();
				
				/**
				 * all players are added to players list from current squad
				 */
				players.addAll(sq.getPlayers());
				
				/**
				 * for each player this loop will run - p being current player
				 */
				for(Player p: players) {
					
					/**
					 * if current player has the same name as the passed in name then the following will run
					 */
					if((p.getFirstName() + " " + p.getLastName()).equals(playerName)) {
						
						/**
						 * for each skillCategory the following loop will run - s being current skillCategory
						 */
						for(SkillCategory s: skillCategories) {
							
							/**
							 * all skills from current category are added to the skills list
							 */
							skills.addAll(s.getSkills());
							
							/**
							 * new skill is created using passed in skillName and the rating is set to a default of 1
							 */
							Skill newSkill = new Skill(skillName, "1");
							
							/**
							 * if currentTab has the same name as the current skill Category then the following code will run
							 */
							if(currentTab.equals(s.getName())) {
								
								/**
								 * current Skill category will have the new skill added to it
								 */
								s.addSkills(newSkill);
								
								/**
								 * current player will have their skillCategories set to the updated skillCategories list
								 */
								p.setSkillCategories(skillCategories);	
								break;
							}

						}
						
					}
				}
				
			}
			
			/**
			 * squads are saved via Model
			 */
			Model.saveSquads(squads);
			
			/**
			 * showviewPlayer method is called again to show the viewPalyer GUI to the user again - called again as this view was disposed when the add skill button was clicked - essentially this was a refresh to show new skills
			 */
			showViewPlayer(playerName, coach);
			
		/**
		 * if invalid the following code runs
		 */
		} else {
			
			/**
			 * showViewPlayer method is called to show the user the view player GUI again
			 */
			showViewPlayer(playerName, coach);
			
			/**
			 * user is shown an error which lets them know that this skill name already exists
			 */
			JOptionPane.showMessageDialog(null, "Error: Skill name already exists");
		}
	
	}
}
