import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gui extends JFrame implements ActionListener{
	
	private JFrame jSignPage;
	private Label lblInput;
	private Label lblOutput;
	private TextField tfName;
	private TextField tfPass;
	private JButton signUp;
	private JButton signIn;

	private JFrame jMenu;
	private JButton transfer;
	private JFrame j4;
	private TextField transFromAccId;
	private TextField transAmount;
	private TextField transInAccId;
	private JButton transTranfer;
	private Account accWith;
	private JButton createAccount;
	private JFrame newCreateAcc;
	private JButton deleteAccount;
	private TextField delAccId;
	private JFrame j1;
	private JButton delete;
	private JButton deposit;
	private JFrame depositF;
	private TextField depAccId;
	private TextField depAmount;
	private TextField depType;
	private JButton depBut;
	private JButton withDraw;
	private JFrame j2;
	private TextField withAccId;
	private TextField withAmount;
	private TextField withType;
	private JButton withWithDraw;
	private JButton showAcc;
	private JFrame j3;
	private TextField showAccId;
	private JButton show;
	private JButton showAllAcc;
	private JButton delUser;
	private JButton logOut;
	private JButton quit;

	private JFrame jCreatAcc;
	private Label lblName; // Declare input Label
	private Label lblPass; // Declare output Label
	private TextField tfUserName; // Declare input TextField
	private TextField tfUserPass;
	private JButton JCreateUser;
	private TextField tfBal;
	private TextField tfAccId;
	private JFrame jCreateAcc;
	
	public static void Gui() {
	
	
	
	}
	
public void showLoginMenu() {
		

		jSignPage = new JFrame();
		JPanel mainPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        jSignPage.add(mainPanel,BorderLayout.CENTER);
        
       
   
		JLabel heading = new JLabel();
		heading.setText(" Sign up / Login ");
		heading.setFont(new Font("Serif", Font.PLAIN, 25));
		mainPanel.add(heading);

		lblInput = new Label(" ***  Enter UserName: ");
		mainPanel.add(lblInput);

		tfName = new TextField(5);
		mainPanel.add(tfName);

		lblOutput = new Label(" ***  Password");
		mainPanel.add(lblOutput);

		tfPass = new TextField(5);
		mainPanel.add(tfPass);

		
		//sign up page on Main all buttons pannel
		signUp = new JButton("Sign Up");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCreateAccMenu(); //runns the create account
			}
		});
		mainPanel.add(signUp);

		signIn = new JButton("Sign In");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean succ = false;
				for (User key : users.keySet()) {
					if ((key.getName()).equals(tfName.getText())
							&& (key.getPassword()).equals(tfPass.getText())) {
						loggedInUser = key;
						showMainMenu();
						succ = true;
						break;
					}
				}
				if (!succ) {
					JOptionPane.showMessageDialog(null,
							"Incorrect Username or Password");
				}

			}
		});
		mainPanel.add(signIn);
		

		jSignPage.setTitle("ATM Machine"); // "super" Frame sets title
		jSignPage.setSize(500, 250);
		jSignPage.setLocationRelativeTo(null);// "super" Frame sets initial
												// window size
		jSignPage.setVisible(true);// "super" Frame shows
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
