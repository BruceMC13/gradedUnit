package SimplyRugby;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;

/**
*
* @author Name: Bruce McKenzie Student Number: 1733612
* 
*/

public class SplashScreen extends JFrame {

	/**
	 * default serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * content pane is initialised
	 */
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		
		/**
		 * application will exit on close
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/**
		 * application size is set
		 */
		setBounds(100, 100, 450, 153);
		
		/**
		 * sets the GUI to appear in the middle of the users screen
		 */
		setLocationRelativeTo(null);
		
		/**
		 * makes the GUI unable to be resized
		 */
		setResizable(false);
		
		/**
		 * content pane is set to new Jpanel
		 */
		contentPane = new JPanel();
		
		/**
		 * border is set
		 */
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		/**
		 * layout is set to null so developer can place elements freely in design view
		 */
		contentPane.setLayout(null);
		
		/**
		 * content pane is set to content pane
		 */
		setContentPane(contentPane);
		
		/**
		 * title label is created with text "Simply Rugby"
		 */
		JLabel lblTitleLabel = new JLabel("Simply Rugby");
		
		/**
		 * font is set - style is set - size is set
		 */
		lblTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		/**
		 * label position and size is set
		 */
		lblTitleLabel.setBounds(146, 11, 146, 42);
		
		/**
		 * label is added to content pane
		 */
		contentPane.add(lblTitleLabel);
		
		
	}
	
	/**
	 * visual only progress bar gives the illusion that the program is loading
	 */
	public void progressBar() {
		
		/**
		 * progress bar is created
		 */
		JProgressBar progressBar = new JProgressBar();
		
		/**
		 * progress bar size and position is set
		 */
		progressBar.setBounds(49, 79, 336, 24);
		
		/**
		 * shows % on progress bar
		 */
		progressBar.setStringPainted(true);
		
		/**
		 * sets colour of progress bar to black
		 */
		progressBar.setForeground(Color.black);
		
		/**
		 * progress bar is added to content pane
		 */
		contentPane.add(progressBar);
		
		/**
		 * progress bar is purely visual
		 */
		
		/**
		 * progress bar is set to value of 18
		 */
		progressBar.setValue(18);
		
		/**
		 * delay is created
		 */
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * progress bar value is updated
		 */
		progressBar.setValue(29);
		
		/**
		 * delay again
		 */
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * progress bar value updated
		 */
		progressBar.setValue(78);
		
		/**
		 * delay
		 */
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * progress bar value is updated
		 */
		progressBar.setValue(100);
	}
	
	
}
