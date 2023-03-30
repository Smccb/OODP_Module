package assignmentV3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Bank extends JFrame implements ActionListener{
	
	private JFrame jSignPage;
	private Label lblInput;
	private Label lblOutput;
	private TextField tfName;
	private TextField tfPass;
	private JButton signUp;
	private JButton signIn;
	
	private HashMap<User, ArrayList<Account>> users;
	private User loggedInUser;
	private Calendar rightNow;
	private int hour;
	
	public Bank() {
		users = new HashMap<User, ArrayList<Account>>();
		loggedInUser = null;
		rightNow = Calendar.getInstance();

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

		signUp = new JButton("Sign Up");
		//signUp.addActionListener(this); 									//edited code
		
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCreateAccMenu();
			}
		});
		
		mainPanel.add(signUp);

		signIn = new JButton("Sign In");
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInCheck();									//removed content to own function
				/*boolean succ = false;
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
				}*/
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
	
	/*if(e.getSource() == signUp) {
		showCreateAccMenu();
	}*/
	
}


//creates first user and account
	public void showCreateAccMenu() {
		System.out.println("hello");
		jCreatAcc = new JFrame();
		JPanel mainPanel = new JPanel();

		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		jCreatAcc.add(mainPanel,BorderLayout.CENTER);

		JLabel heading = new JLabel();
		heading.setText(" Create Your User Account ");
		heading.setFont(new Font("Serif", Font.PLAIN, 25));
		mainPanel.add(heading);

		lblName = new Label(" Enter UserName: "); // Construct Label
		mainPanel.add(lblName); // "super" Frame container adds Label component

		tfUserName = new TextField(10);
		mainPanel.add(tfUserName);

		lblPass = new Label(" Password");
		mainPanel.add(lblPass);

		tfUserPass = new TextField(10);
		mainPanel.add(tfUserPass);

		JCreateUser = new JButton("Create User");
		mainPanel.add(JCreateUser);
		JCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUserName.getText().length() != 0
						&& tfUserPass.getText().length() != 0) {
					jCreateAcc = new JFrame();
					JPanel mainPanel = new JPanel();

			        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			        jCreateAcc.add(mainPanel,BorderLayout.CENTER);

					JRadioButton checking = new JRadioButton("Checking");
					JRadioButton saving = new JRadioButton("Saving");

					ButtonGroup group = new ButtonGroup();
					group.add(checking);
					group.add(saving);

					mainPanel.add(new Label(" Create your Account :  "
							+ tfUserName.getText()));

					mainPanel.add(new Label(" Select your account type : "));
					checking.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							accType = "Checking";
						}
					});
					mainPanel.add(checking);

					saving.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							accType = "Saving";
						}
					});
					mainPanel.add(saving);

					mainPanel.add(new Label("Amount to be added: "));
					tfBal = new TextField(10);
					mainPanel.add(tfBal);

					mainPanel.add(new Label("AccountNumber: "));
					tfAccId = new TextField(10);
					mainPanel.add(tfAccId);

					JButton create = new JButton("Create Account");

					create.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							User newUser = new User(tfUserName.getText(),
									tfUserPass.getText());
							try {
								double d1 = Double.parseDouble(tfBal.getText());
								int i1 = Integer.parseInt(tfAccId.getText());
								Account newAccount = new Account(d1, accType,
										i1);
								boolean check = true;
								for (ArrayList<Account> array : users.values()) {
									for (Account i : array) {
										if (i1 == i.getAccId()) {
											JOptionPane.showMessageDialog(null, " Account exists");
											check = false;
											break;
										}
									}
								}
								if(check)
								{
								ArrayList<Account> newList = new ArrayList<Account>();
								newList.add(newAccount);
								users.put(newUser, newList);
								JOptionPane.showMessageDialog(null,
										"Account Created || UserName : " + tfUserName.getText() + ", Account ID : " + tfAccId.getText() + ", Balance : $" + tfBal.getText() + ", Type : " + accType);
								}
								jCreateAcc.dispose();
								jCreatAcc.dispose();
							} catch (Exception E) {
								JOptionPane.showMessageDialog(null,
										" User Account not Created !!!");
								jCreateAcc.dispose();
							}
						}
					});
				    mainPanel.add(create);

					jCreateAcc.setTitle("Creating Account"); // "super" Frame
																// sets title
					jCreateAcc.setSize(500, 500);
					jCreateAcc.setLocationRelativeTo(null);// "super" Frame sets
															// initial
															// window size
					mainPanel.setBackground(Color.CYAN);
					jCreateAcc.setVisible(true);// "super" Frame shows
					jCreateAcc.pack();

				} else {
					JOptionPane.showMessageDialog(null,
							" Enter password and username");
				}

			}

		});

		jCreatAcc.setTitle("Creating Account"); // "super" Frame sets title
		jCreatAcc.setSize(300, 250);
		jCreatAcc.setLocationRelativeTo(null);// "super" Frame sets initial
												// window size
		jCreatAcc.setBackground(Color.GREEN);
		jCreatAcc.setVisible(true);
		jCreatAcc.pack();
	}



public void showMainMenu() {
	// TODO Auto-generated method stub
	System.out.println("hello2");
}


//sign in button checks if user in hashmap
public void signInCheck() {
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


}
