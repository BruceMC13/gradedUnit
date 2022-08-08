package SimplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class ViewPlayer extends JFrame {
	
	/**
	 * default serial version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * confirm dialog in frame is initialised and set to null
	 */
	protected static final Component ConfirmDialogInFrame = null;
	
	/**
	 * content pane is initialised 
	 */
	private static JPanel contentPane; 

	
    /**
    * This constructor takes name string and coach object - these are needed as they are fundamental to the building of the view player screen
    * @param playerName is the name of the player who is being viewed
    * @param coach is the coach who is currently in charge of the squad of the member who is being viewed
    */
	public ViewPlayer(String playerName, Coach coach) {
		
		/**
		 * title is set
		 */
		setTitle("View Player");
		
		/**
		 * program does not allow GUI to be resized
		 */
		setResizable(false);
		
		/**
		 * sets program to close on exit
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * bounds are set
		 */
		setBounds(100, 100, 794, 514);
		
		/**
		 * sets GUI to centre on screen
		 */
		setLocationRelativeTo(null);
		
		/**
		 * content pane is set to new Jpanel
		 */
		contentPane = new JPanel();
		
		/**
		 * border is set
		 */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/**
		 * layout is set to null to allow developer to freely place elements in design view
		 */
		contentPane.setLayout(null);
		
		/**
		 * content pane is set to content pane
		 */
		setContentPane(contentPane);
		
		/**
		 * generate panes method is called passing in playerName and coach as parameters 
		 */
		generatePanes(playerName, coach);
		
		/**
		 * label is created for player Name
		 */
		JLabel lblPlayerTitle = new JLabel("Player Name:");
		
		/**
		 * label bounds are set
		 */
		lblPlayerTitle.setBounds(271, 30, 122, 14);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblPlayerTitle);
		
		/**
		 * new label is created which will display the passed in player name
		 */
		JLabel lblPlayerName = new JLabel(playerName);
		
		/**
		 * bounds are set
		 */
		lblPlayerName.setBounds(403, 30, 252, 14);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblPlayerName);
		
		/**
		 * back button is created with text "Back"
		 */
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			
			/**
			 * if button is pressed the following code runs
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * input is initialised as joptionpane
				 */
				int input = JOptionPane.showConfirmDialog( 
						
						/**
						 * text will be shown and two options will be shown - yes and no - yes = 0 and no = 1
						 */
		                ConfirmDialogInFrame, "Are You Sure? progress may be lost", " ", 
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				/**
				 * if input is 0 the user clicked yes and they wish to go back
				 */
				if(input == 0) {
					
					/**
					 * GUI is disposed
					 */
					dispose();
					
					/**
					 * main menu is shown again (passing in coach object)
					 */
					Controller.showMainMenu(coach);
				} 

			}
		});
		
		/**
		 * sets back button bounds
		 */
		backBtn.setBounds(336, 399, 89, 23);
		
		/**
		 * back button is added to the content pane
		 */
		contentPane.add(backBtn);
		
		/**
		 * logout button is created with text "Logout"
		 */
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			
			/**
			 * if button is pressed the following code is run
			 */
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * input is initialised as joptionpane
				 */
				int input = JOptionPane.showConfirmDialog( 
						
						/**
						 * text will be shown and two options will be shown - yes and no - yes = 0 and no = 1
						 */
		                ConfirmDialogInFrame, "Are You Sure? progress may be lost", " ", 
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				/**
				 * if input is 0 the user clicked yes and they wish to go back
				 */
				if(input == 0) {
					
					/**
					 * GUI is disposed
					 */
					dispose();
					
					/**
					 * login screen is shown again to the user
					 */
					Controller.showLogin();
				} 
				
				
			}
		});
		
		/**
		 * logout button bounds are set
		 */
		logoutBtn.setBounds(336, 433, 89, 23);
		
		/**
		 * logout button is added to content pane
		 */
		contentPane.add(logoutBtn);
		
		/**
		 * new button is created for new category - with text "New Category"
		 */
		JButton btnNewCategory = new JButton("New Category");
		btnNewCategory.addActionListener(new ActionListener() {
			
			/**
			 * if this button is pressed the following code runs
			 */
			public void actionPerformed(ActionEvent arg0) {

				/**
				 * categoryName is initialised and the user is asked for a new skill category name
				 */
				String categoryName = JOptionPane.showInputDialog("Enter New Skill Category Name");   
				
				
				/**
				 * checks if the input box is blank
				 */
				if(!(categoryName != null)) {	
				} else if(categoryName.trim().isEmpty()) {
					
					/**
					 * user is given an error message if the input box is blank
					 */
					JOptionPane.showMessageDialog(null, "Please fill in the field");
					
				/**
				 *  if input box is not empty the following code runs
				 */					
				} else {
					
					/**
					 * GUI is disposed
					 */
					dispose();
					
					/**
					 * newSkillCategory method is run from controller - passing in playerName categoryName and coach object
					 */
					Controller.newSkillCategory(playerName, categoryName, coach);
				}
				
				
				
			}
		});
		
		/**
		 * new category button bounds are set
		 */
		btnNewCategory.setBounds(10, 26, 122, 23);
		
		/**
		 * new category button is added to content pane
		 */
		contentPane.add(btnNewCategory);
		

	}	
	
	/**
	 * generatePanes is a method which generates the tabbed panes for viewPlayer GUI
	 * @param playerName name of player who is being viewed
	 * @param coach current logged in coach
	 */
	private void generatePanes(String playerName, Coach coach) {
		
		/**
		 * tabbed pane is initialised and set to new JTabbedPane
		 */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);	
		
		/**
		 * tabbed pane bounds are set
		 */
		tabbedPane.setBounds(10, 55, 744, 336);
		
		/**
		 * tabbed pane is added to contentPane
		 */
		contentPane.add(tabbedPane);
		
		/**
		 * layout is set to null
		 */
		contentPane.setLayout(null);

		/**
		 * skillCateghories are set to the skill categories of the current player being viewed
		 */
		ArrayList<SkillCategory> skillCategories = Controller.getSkillCategories(playerName);
		
		/**
		 * loop will run for each skillCategory - current skill category is s
		 */
		for(SkillCategory s: skillCategories) {
			
			/**
			 * JPanel is initialised as new JPanel
			 */
			JPanel currentPanel = new JPanel();
			
			/**
			 * tabbedPane adds tab with the current skillCategory name along with new blank JPanel
			 */
			tabbedPane.addTab(s.getName(), null, currentPanel, null);
			
			/**
			 * layout is set to null
			 */
			currentPanel.setLayout(null);
			
			/**
			 * tableScrollPane is initialised as new JScrollPane
			 */
			JScrollPane tableScrollPane = new JScrollPane();
			
			/**
			 * bounds are set 
			 */
			tableScrollPane.setBounds(22, 31, 379, 225);
			
			/**
			 * tableScrollPane is added to current Panel
			 */
			currentPanel.add(tableScrollPane);
			
			/**
			 * notesScrollPane is initialised as new JScrollPane
			 */
			JScrollPane notesScrollPane = new JScrollPane();
			
			/**
			 * bounds are set for notesScrollPane
			 */
			notesScrollPane.setBounds(436, 31, 293, 259);
			
			/**
			 * notes scorll pane is added to current panel
			 */
			currentPanel.add(notesScrollPane);
			
			/**
			 * editorPaneNotes is initialised as new JEditorPane
			 */
			JEditorPane editorPaneNotes = new JEditorPane();
			
			/*
			 * editorPaneNotes text is set to the text stored within current skillCategory
			 */
			editorPaneNotes.setText(s.getNotes());
			
			/**
			 * new label is created from the notes title
			 */
			JLabel lblNotes = new JLabel("Notes");
			
			/**
			 * bounds are set for label
			 */
			lblNotes.setBounds(566, 11, 33, 14);
			
			/**
			 * label for notes is added to current panel
			 */
			currentPanel.add(lblNotes);
			
			/**
			 * ViewPortView is set to ediotPaneNotes
			 */
			notesScrollPane.setViewportView(editorPaneNotes);
			
			/**
			 * ArrayList of skill is initialised and stores skills which are stored in current player
			 */
			ArrayList<Skill> skills = Controller.getSkills(playerName, s.getName());
			
			/**
			 * header is created which holds the column titles for the table
			 */
			String[] header = {"Skill", "Rating"};
			
			/**
			 * tableModel is initialised passing in column titles as a  along with 0 for the row count
			 */
			DefaultTableModel tableModel = new DefaultTableModel(header, 0);
			
			/**
			 * loop for amount of skills that are stored within the skills arrayList
			 */
			for (int i = 0; i < skills.size(); i++){
				
				/**
				 * rows are added to the table - skillName and rating fo that skill
				 */
			    tableModel.addRow(new Object[]{skills.get(i).getName(), skills.get(i).getRating()});
			    			    
			}
			
			/**
			 * table is initialised using tableModel
			 */
			JTable table = new JTable(tableModel);
			
			/**
			 * tableScrollPane adds table - making the table scrollable
			 */
			tableScrollPane.setViewportView(table);
			
			/**
			 * addSkillBtn is initialised as new JButton with text "Add Skill"
			 */
			JButton addSkillBtn = new JButton("Add Skill");
			addSkillBtn.addActionListener(new ActionListener() {
				
				/**
				 * if button is pressed the following code will run
				 */
				public void actionPerformed(ActionEvent e) {
					
					/**
					 * skillName is initialised and takes user input for the new skill name
					 */
					String skillName = JOptionPane.showInputDialog("Enter New Skill Name");   
					
					/**
					 * tabTitle is initialised and is set to the current tab title (skillCategoryName)
					 */
					String tabTitle = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
					
					/**
					 * if user inputs nothing the following code will run
					 */
					if(!(skillName != null)) {	
					} else if(skillName.trim().isEmpty()) {
						
						/**
						 * user is given an error saying they cannot leave the input box blank
						 */
						JOptionPane.showMessageDialog(null, "Please fill in the field");
						
					/**
					 * if the user has entered a skill name the following code runs
					 */
					} else {
						
						/**
						 * GUI is disposed
						 */
						dispose();
						
						/**
						 * new skill is added via controller method - playerName, skillName, tabTitle and coach object are passed in as parameters 
						 */
						Controller.newSkill(playerName, skillName, tabTitle, coach);
					}
						

					
				}
			});
			
			/**
			 * addSkillBtn bounds are set
			 */
			addSkillBtn.setBounds(235, 267, 89, 23);
			
			/**
			 * addSkill button is added to current Panel
			 */
			currentPanel.add(addSkillBtn);

			/**
			 * saveBtn is initialised as new JButton with text "Save"
			 */
			JButton saveBtn = new JButton("Save");
			saveBtn.addActionListener(new ActionListener() {
				
				/**
				 * if the button is pressed the following happens
				 */
				public void actionPerformed(ActionEvent e) {
					
					/**
					 * dataFromTable is initialised as new HashMap - key is string and value is string
					 */
					Map<String, String> dataFromTable = new HashMap<String, String>();
					
					/**
					 * tabTitle is initialised and stores title of current tabbed pane
					 */
					String tabTitle = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
					
					/**
					 * if table has more columns than 0 then the following code runs
					 */
					if(table.getColumnCount() > 0) {
						
						/**
						 * loops for total row count (r being row count)
						 */
						for (int r = 0; r < table.getRowCount(); r++) {
							
							/**
							 * loops for column count (c being column count)
							 */
							for (int c = 0; c < table.getColumnCount(); c++) {
								
								/**
								 * data from table is saved into HashMap
								 */
								dataFromTable.put(tableModel.getValueAt(r, 0).toString(), tableModel.getValueAt(r, 1).toString());
								
							}
						   
						}	
					}
					
					/**
					 * newNoteData is initialised and reads text that is in the editor pane
					 */
					String newNoteData = editorPaneNotes.getText();
					
					/**
					 * table data is saved to player - then saved to file
					 */
					Controller.saveTableData(playerName, coach, dataFromTable, newNoteData, tabTitle);
					
					
				}
			});
			
			/**
			 * save button bounds are set
			 */
			saveBtn.setBounds(100, 267, 89, 23);
			
			/**
			 * save button is added to current panel
			 */
			currentPanel.add(saveBtn);

		}	
	
	}
	
}
