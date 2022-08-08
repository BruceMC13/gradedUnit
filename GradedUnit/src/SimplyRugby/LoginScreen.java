package SimplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class LoginScreen extends JFrame {

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * content pane is initialised
	 */
	private JPanel contentPane;
	
	/**
	 * userNameInput textField is initialised
	 */
	private JTextField userNameInput;
	
	/**
	 * passwordInput passwordField is initialised
	 */
	private JPasswordField passwordInput;

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		
		/**
		 * sets title to Login
		 */
		setTitle("Login");
		
		/**
		 * does not allow user to resize window
		 */
		setResizable(false);
		
		/**
		 * program will exit on close
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * sets bounds
		 */
		setBounds(100, 100, 450, 300);
		
		/**
		 * centres the application on screen
		 */
		setLocationRelativeTo(null);
		
		/**
		 * sets content pane to new jPanel
		 */
		contentPane = new JPanel();
		
		/**
		 * sets border
		 */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/**
		 * sets layout to null - allowing free placement of elements by developer
		 */
		contentPane.setLayout(null);
		
		/**
		 * sets content pane to the content pane
		 */
		setContentPane(contentPane);		
		
		
		/**
		 * creates label and adds it to GUI
		 */
		JLabel lblTitle = new JLabel("Simply Rugby");
		lblTitle.setBounds(177, 63, 105, 16);
		contentPane.add(lblTitle);
		
		/**
		 * username input field is created and added to GUI
		 */
		userNameInput = new JTextField();
		userNameInput.setText("Username");
		userNameInput.addFocusListener(new FocusAdapter() {

			/**
			 * when username input box focus is lost the following code will run
			 */
			@Override
			public void focusLost(FocusEvent e) {
				
				/**
				 * if the text in the username input box is empty then the following code will run
				 */
				if(userNameInput.getText().equals("")) {
					
					/**
					 * the text for the username input box is set to "Username"
					 */
					userNameInput.setText("Username");
				} 
			}
			
			/**
			 * if username input box gains focus the following code will run
			 */
			@Override
			public void focusGained(FocusEvent e) {
				
				/**
				 * if the text is "Username" the following code will run
				 */
				if(userNameInput.getText().equals("Username")) {
					
					/**
					 * the inputbox text is set to blank
					 */
					userNameInput.setText("");
				}
				
			}
		});
		
		/**
		 * sets toolTip
		 */
		userNameInput.setToolTipText("Enter Username");
		
		/**
		 * sets position of username inputbox
		 */
		userNameInput.setBounds(152, 91, 130, 26);
		
		/**
		 * adds usernameInput box to the content pane
		 */
		contentPane.add(userNameInput);
		userNameInput.setColumns(10);
		
		/**
		 * passwordInput is set to a new password field
		 */
		passwordInput = new JPasswordField();
		passwordInput.addFocusListener(new FocusAdapter() {

			/**
			 * if the focus is lost from password input box the following code will run
			 */
			@Override
			public void focusLost(FocusEvent e) {
				
				/**
				 * if the password box is left empty
				 */
				if(Arrays.equals(passwordInput.getPassword(), new char[]{})) {
					
					/**
					 * temp text will then be returned to the password input
					 */
					passwordInput.setText("Password");
				} 
		
			}
			
			/**
			 * when the password input gains focus the following code will run
			 */
			@Override
			public void focusGained(FocusEvent e) {
				
				/**
				 * if the password box contains the temp text still the following code will run
				 */
				if(Arrays.equals(passwordInput.getPassword(), new char[]{'P','a','s','s','w','o','r','d'})) {
					
					/**
					 * text in the inputbox is set to blank - removing the temp text
					 */
					passwordInput.setText("");
				}
				
			}
		});
		
		/**
		 * on application launch password input is set to the temp text
		 */
		passwordInput.setText("Password");
		
		/**
		 * password input box position is set
		 */
		passwordInput.setBounds(152, 129, 130, 26);
		
		/**
		 * password input box is added to content pane
		 */
		contentPane.add(passwordInput);
		passwordInput.setColumns(10);
		
		/**
		 * login button is created with text "Login"
		 */
		JButton loginBtn = new JButton("Login");
		loginBtn.addKeyListener(new KeyAdapter() {
			
			/**
			 * if the enter key is pressed while button is in focus the login button will click
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					loginBtn.doClick();
				}
			}
		});
		
		
		loginBtn.addActionListener(new ActionListener() {
			
			/**
			 * if button is clicked the following code will run
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * result is initialised and set to the return of validateInput
				 */
				boolean result = validateInput();
				
				/**
				 * if result is true the following code will run
				 */
				if(result) {
					
					/**
					 * if loginRequest method from controller returns true then the following code will run
					 */
					if(Controller.loginRequest(userNameInput.getText(), passwordInput.getPassword())) {
						
						/**
						 * user is alerted that the login was successful
						 */
						JOptionPane.showMessageDialog(null, "Login Successful");
						
						/**
						 * GUI is disposed
						 */
						dispose();
						
						/**
						 * ArrayList of coaches is initialised - set to read all coaches - read in via Model
						 */
						ArrayList<Coach> coaches = Model.readCoaches();
						
						/**
						 * coach is initialised
						 */
						Coach coach;
						
						/**
						 * for all coaches the following will loop - c is current coach
						 */
						for(Coach c: coaches){
							
							/**
							 * if current coach username is the same as the username input box text the following code will run
							 */
							if(c.getUsername().equals(userNameInput.getText())) {
								
								/**
								 * coach is set to current coach object
								 */
								coach = c;
								
								/**
								 * showMainMenu method is called from Controller passing in coach as a parameter
								 */
								Controller.showMainMenu(coach);
								
								/**
								 * if found the loop is broken
								 */
								break;
							}
						}
						
					/**
					 * if loginRequest is invalid the following code runs
					 */
					} else {
						
						/**
						 * user is alerted that the username or password was incorrect
						 */
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					}
				/**
				 * if result is false then the following code will run
				 */
				} else {
					
					/**
					 * user is alerted that they must fill in both input boxes
					 */
					JOptionPane.showMessageDialog(null, "You must enter a Username and a Password");
				}
				
			}
			
		});
		
		/**
		 * login button dimensions/position is set
		 */
		loginBtn.setBounds(169, 178, 95, 29);
		
		/**
		 * content pane adds login button
		 */
		contentPane.add(loginBtn);
		
		
		
	}
	
	/**
	 * method for checking if login inputs are in a valid format
	 * @return result 
	 */
	public boolean validateInput() {
		
		/**
		 * boolean result is initialised to false
		 */
		boolean result = false;
		
		/**
		 * if the input box text for either input boxes is left as default temp text the following code will run
		 */
		if(userNameInput.getText().equals("") || Arrays.equals(passwordInput.getPassword(), new char[]{}) || userNameInput.getText().equals("Username") || Arrays.equals(passwordInput.getPassword(), new char[]{'P','a','s','s','w','o','r','d'})) {
			
			/**
			 * result will be set to false
			 */
			result = false;
			
		/**
		 * if input box text is not left as default temp text the following will run
		 */
		} else {
			
			/**
			 * result will be set to true
			 */
			result = true;
		}
		
		/**
		 * result is returned to where this method has been called
		 */
		return result;
		
	}
}
