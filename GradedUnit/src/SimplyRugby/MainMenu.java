package SimplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class MainMenu extends JFrame {

	/**
	 * Default serial Verion ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * contentPane is initialised 
	 */
	private JPanel contentPane;
	

	/**
	 * generates the Main Menu
	 * @param coach coach which has been logged in
	 */
	public MainMenu(Coach coach) {
		
		/**
		 * title is set to Main Menu
		 */
		setTitle("Main Menu");
		
		/**
		 * application is set so that it cannot be resized
		 */
		setResizable(false);
		
		/**
		 * program will exit on close
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * application bounds are set
		 */
		setBounds(100, 100, 508, 370);
		
		/**
		 * application is set to centre on screen
		 */
		setLocationRelativeTo(null);
		
		/**
		 * content pane is set to new jpane
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/**
		 * layout is set as null allowing developer to place elements freely in design view
		 */
		contentPane.setLayout(null);
		
		/**
		 * contentPane is set to content pane
		 */
		setContentPane(contentPane);
		
		/**
		 * label is created for coach name
		 */
		JLabel lblCoachNameTitle = new JLabel("Coach Name: ");
		
		/**
		 * position is set
		 */
		lblCoachNameTitle.setBounds(159, 57, 101, 20);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblCoachNameTitle);
		
		/**
		 * label for coach is created using the coaches first and last name
		 */
		JLabel lblCoach = new JLabel(coach.getFirstName() + " " + coach.getLastName());
		
		/**
		 * position is set
		 */
		lblCoach.setBounds(270, 57, 178, 20);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblCoach);
		
		/**
		 * label for squad name title is created
		 */
		JLabel lblSquadNameTitle = new JLabel("Squad Name: ");
		
		/**
		 * position is set
		 */
		lblSquadNameTitle.setBounds(159, 82, 101, 20);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblSquadNameTitle);
		
		/**
		 * lable for squad name is created - using squad name found in the coach object
		 */
		JLabel lblSquadName = new JLabel(coach.getSquadName());
		
		/**
		 * position for label is set
		 */
		lblSquadName.setBounds(270, 82, 178, 20);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblSquadName);
		
		/**
		 * combo box is created which will hold strings
		 */
		JComboBox<String> comboBox = new JComboBox<String>();
		
		/**
		 * sets combo box position / size
		 */
		comboBox.setBounds(148, 139, 147, 20);
		
		/**
		 * adds combo box to content pane
		 */
		contentPane.add(comboBox);
		
		/**
		 * Initialises players as arrayList and reads playerNames passing in coach object as parameter
		 */
		ArrayList<String> players = Controller.readPlayerNames(coach);
		
		/**
		 * for each player the loop will run - p being current player
		 */
		for(String p: players){
			
			/**
			 * player name will be added to combo box
			 */
			comboBox.addItem(p);
		}
		
		/**
		 * new button is created using text "Edit"
		 */
		JButton btnEditButton = new JButton("Edit");
		btnEditButton.addActionListener(new ActionListener() {
			
			/**
			 * if button is pressed the following code will run
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * if the combo box selection is not null the following code will run
				 */
				if((String) comboBox.getSelectedItem() != null) {
					
					/**
					 * mainMenu is disposed
					 */
					dispose();
					
					/**
					 * showPlayer is called passing in the selected player name along with coach object
					 */
					Controller.showViewPlayer((String) comboBox.getSelectedItem(), coach);
					
				/**
				 * if combo box selection is null the following code runs
				 */
				} else {
					
					/**
					 * user is alerted that there are no players to edit
					 */
					JOptionPane.showMessageDialog(null, "No player to edit!");
				}
				
				
	
			}
			
		});
		
		/**
		 * button position / size is set
		 */
		btnEditButton.setBounds(305, 139, 101, 20);
		
		/**
		 * button is added to content pane
		 */
		contentPane.add(btnEditButton);
		
		/**
		 * exit button is created using text "exit"
		 */
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			
			/**
			 * if button is pressed the following code will run
			 */
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * application exits
				 */
				System.exit(0);
			}
		});
		
		/**
		 * exit button size and position is set
		 */
		exitBtn.setBounds(206, 245, 89, 23);
		
		/**
		 * exit button is added to the content pane
		 */
		contentPane.add(exitBtn);
		
		/**
		 * new button is created using text "Logout"
		 */
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			
			/**
			 * if button is pressed the following will happen
			 */
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * MainMenu is disposed
				 */
				dispose();
				
				/**
				 * login screen is shown again
				 */
				Controller.showLogin();
			}
		});
		
		/**
		 * logout button size and position is set
		 */
		logoutBtn.setBounds(206, 211, 89, 23);
		
		/**
		 * logout button is added to content pane
		 */
		contentPane.add(logoutBtn);
	}
	

	
}
