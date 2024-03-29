import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.awt.Color;
import java.awt.FileDialog;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class Bank extends Frame implements ActionListener {

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
	private String accType;
	private double balance;
	private int accId;
	private JFrame jCreateAcc;

	private HashMap<User, ArrayList<Account>> users;
	private User loggedInUser;
	private Calendar rightNow;
	private int hour;
	private boolean student;
	private String currency;
	
	//used for tracking instance of Bank class
	private static Bank firstInstance = null;

	public Bank() {
		users = new HashMap<User, ArrayList<Account>>();
		loggedInUser = null;
		rightNow = Calendar.getInstance();
		student = false;
		currency = "dollar";
	}

	//singleton code to make sure only one instance of bank exists at a time
	public static Bank getInstance() {
		
		if(firstInstance == null)
			firstInstance = new Bank();
		
		return firstInstance;
		
	}
	
//main menu
	public void showMainMenu() {

		jMenu = new JFrame();
		JPanel mainPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        jMenu.add(mainPanel,BorderLayout.CENTER);
        

		JLabel heading = new JLabel();
		heading.setText(" Hi  " + tfUserName.getText()
				+ " what would you like to do:  ");
		heading.setFont(new Font("Serif", Font.PLAIN, 50));
		mainPanel.add(heading);

		transfer = new JButton();
		transfer.setFont(new Font("Serif", Font.PLAIN, 30));
		transfer.setText(" 1.  Transfer ");
		transfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j4 = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        j4.add(mainPanel,BorderLayout.CENTER);

		        mainPanel.add(new JLabel("Account ID to tranfer from :"));
				transFromAccId = new TextField();
				mainPanel.add(transFromAccId);

				mainPanel.add(new JLabel("Account ID to Tranfer into: "));
				transInAccId = new TextField();
				mainPanel.add(transInAccId);

				mainPanel.add(new JLabel("Amount: "));
				transAmount = new TextField();
				mainPanel.add(transAmount);

				transTranfer = new JButton("Transfer");
				transTranfer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//executeCommand(new transfer());
						try {
							int accFrom = Integer.parseInt(transFromAccId.getText());
							int accTO = Integer.parseInt(transInAccId.getText());
							int amount = Integer.parseInt(transAmount.getText());
							
							//pass in[ acc1, acc2, amount, user hashmap, loggedInUser, accwith, j4]
							//call transfer command here
							executeCommand(new Transfer(accFrom, accTO, amount, users, loggedInUser, j4, hour, rightNow, accWith));
						}
						catch (Exception e5) {
							JOptionPane.showMessageDialog(null,
									"Tranfer failed : Invalid Input");
						}
					}
				});
				mainPanel.add(transTranfer);
				j4.setTitle("Transfer");
				j4.setSize(500, 500);
				j4.setLocationRelativeTo(null);
				j4.setVisible(true);
				j4.pack();

			}
		});
		mainPanel.add(transfer);

		createAccount = new JButton();
		createAccount.setFont(new Font("Serif", Font.PLAIN, 30));
		createAccount.setText(" 2.  createAccount");
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCreateAcc = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        newCreateAcc.add(mainPanel,BorderLayout.CENTER);

				JRadioButton checking = new JRadioButton("Checking");
				JRadioButton saving = new JRadioButton("Saving");

				ButtonGroup group = new ButtonGroup();
				group.add(checking);
				group.add(saving);

				mainPanel.add(new Label(" Create your Account :  "+ loggedInUser.getName()));

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
				
				//when clicked change currency to euro or dollar
				JButton currencyEuro = new JButton("euro");
				currencyEuro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currency = "euro";
					}
				});
				JButton currencyDollar = new JButton("dollar");
				currencyDollar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currency = "dollar";
					}
				});
				
				mainPanel.add(saving);

				mainPanel.add(new Label("Amount to be added: "));
				tfBal = new TextField(10);
				mainPanel.add(tfBal);

				mainPanel.add(new Label("AccountNumber: "));
				tfAccId = new TextField(10);
				mainPanel.add(tfAccId);
				mainPanel.add(currencyDollar);
				mainPanel.add(currencyEuro);
				JButton create = new JButton("Create Account");

				create.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							double balance = Double.parseDouble(tfBal.getText());
							int accId = Integer.parseInt(tfAccId.getText());
							executeCommand(new CreateAccount(balance, accType, accId, users, loggedInUser, currency));
							newCreateAcc.dispose();
						} catch (Exception E) {
							JOptionPane.showMessageDialog(null,
									" User Account not Created !!!");
							newCreateAcc.dispose();
						}
					}
				});

				mainPanel.add(create);

				newCreateAcc.setTitle("Creating Account"); // "super" Frame sets
															// title
				newCreateAcc.setSize(500, 500);
				newCreateAcc.setLocationRelativeTo(null);// "super" Frame sets
															// initial
															// window size
				newCreateAcc.setVisible(true);// "super" Frame shows
				newCreateAcc.pack();

			}
		});
		mainPanel.add(createAccount);

		deleteAccount = new JButton();
		deleteAccount.setFont(new Font("Serif", Font.PLAIN, 30));
		deleteAccount.setText(" 3.  deleteAccount");
		deleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j1 = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        j1.add(mainPanel,BorderLayout.CENTER);

		        mainPanel.add(new JLabel("Add Account ID  to be deleted : "));
				delAccId = new TextField();
				mainPanel.add(delAccId);

				JButton del = new JButton();
				del.setFont(new Font("Serif", Font.PLAIN, 15));
				del.setText(" Confirm ");
				del.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int accId = Integer.parseInt(delAccId.getText());
							System.out.println((users.get(loggedInUser)).get(0)
									.getAccId());
							executeCommand(new DeleteAccount(accId, users, loggedInUser));
							j1.dispose();
						} catch (Exception e1) {
							JOptionPane
									.showMessageDialog(null, "Invalid AccId");
						}
					}
				});
				mainPanel.add(del);

				j1.setTitle("ATM Machine");
				j1.setSize(500, 500);
				j1.setLocationRelativeTo(null);
				mainPanel.setBackground(Color.blue);
				j1.setVisible(true);
				j1.pack();

			}
		});
		mainPanel.add(deleteAccount);

		deposit = new JButton();
		deposit.setFont(new Font("Serif", Font.PLAIN, 30));
		deposit.setText("4.   deposit ");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				depositF = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        depositF.add(mainPanel,BorderLayout.CENTER);

		        mainPanel.add(new JLabel("Account number: "));
				depAccId = new TextField();
				mainPanel.add(depAccId);

				mainPanel.add(new JLabel("Amount: "));
				depAmount = new TextField();
				mainPanel.add(depAmount);

				mainPanel.add(new JLabel("Deposit Type: "));
				depType = new TextField();
				mainPanel.add(depType);

				depBut = new JButton("DEPOSIT");
				depBut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							double amount = Double.parseDouble(depAmount.getText());
							int depID = Integer.parseInt(depAccId.getText());
							executeCommand(new Deposit(amount, depID, depType.getText(), users, loggedInUser, rightNow));
							depositF.dispose();
						} catch (NumberFormatException e2) {
							JOptionPane
									.showMessageDialog(null, "Invalid Input");
						}
					}
				});
				mainPanel.add(depBut);

				depositF.setTitle("ATM Machine");
				depositF.setSize(500, 500);
				depositF.setLocationRelativeTo(null);
				mainPanel.setBackground(Color.GREEN);
				depositF.setVisible(true);
				depositF.pack();

			}
		});
		mainPanel.add(deposit);

		withDraw = new JButton();
		withDraw.setFont(new Font("Serif", Font.PLAIN, 30));
		withDraw.setText("5.   withDraw ");
		withDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j2 = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        j2.add(mainPanel,BorderLayout.CENTER);

		        mainPanel.add(new JLabel("Enter AccID "));
				withAccId = new TextField(10);
				mainPanel.add(withAccId);

				mainPanel.add(new JLabel("Enter Amount"));
				withAmount = new TextField(10);
				mainPanel.add(withAmount);

				mainPanel.add(new JLabel("WithDrawal type : "));
				withType = new TextField(10);
				mainPanel.add(withType);

				withWithDraw = new JButton();
				withWithDraw.setFont(new Font("Serif", Font.PLAIN, 30));
				withWithDraw.setText(" WithDraw ");
				withWithDraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int accId = Integer.parseInt(withAccId.getText());
							double amount = Double.parseDouble(withAmount.getText());
							executeCommand(new WithDraw(amount, accId, withType.getText(), users, loggedInUser, hour, rightNow));
							j2.dispose();

						} catch (Exception e4) {
							JOptionPane.showMessageDialog(null,
									"Transaction Failed : Invalid Input");
						}
					}

				});
				mainPanel.add(withWithDraw);

				j2.setTitle("ATM Machine");
				j2.setSize(500, 500);
				j2.setLocationRelativeTo(null);
				mainPanel.setBackground(Color.ORANGE);
				j2.setVisible(true);
				j2.pack();

			}

		});
		mainPanel.add(withDraw);

		showAcc = new JButton();
		showAcc.setFont(new Font("Serif", Font.PLAIN, 30));
		showAcc.setText("6. showAccount ");
		showAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j3 = new JFrame();
				JPanel mainPanel = new JPanel();

		        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		        j3.add(mainPanel,BorderLayout.CENTER);

		        mainPanel.add(new JLabel("Enter AccID: "));
				showAccId = new TextField();
				mainPanel.add(showAccId);

				show = new JButton();
				show.setFont(new Font("Serif", Font.PLAIN, 30));
				show.setText(" Show TRANS LOG ");
				show.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int accId = Integer.parseInt(showAccId.getText());
							executeCommand(new ShowAccount(accId, users, loggedInUser, j3));
						} catch (Exception e5) {
							JOptionPane
									.showMessageDialog(null, "Invalid Input");
						}
					}
				});
				mainPanel.add(show);
				j3.setTitle("ATM Machine");
				j3.setSize(500, 500);
				j3.setLocationRelativeTo(null);
				mainPanel.setBackground(Color.blue);
				j3.setVisible(true);
				j3.pack();

			}
		});
		mainPanel.add(showAcc);

		showAllAcc = new JButton();
		showAllAcc.setFont(new Font("Serif", Font.PLAIN, 30));
		showAllAcc.setText("7.  showAllAccount ");
		showAllAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeCommand(new ShowAllAcc(users, loggedInUser));
			}
		});
		mainPanel.add(showAllAcc);

		delUser = new JButton();
		delUser.setFont(new Font("Serif", Font.PLAIN, 30));
		delUser.setText("8.  deleteUser ");
		delUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executeCommand(new DeleteUser(users, loggedInUser, jMenu));
			}
		});
		mainPanel.add(delUser);

		logOut = new JButton();
		logOut.setFont(new Font("Serif", Font.PLAIN, 30));
		logOut.setText("9.  LogOut ");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfPass.setText("");
				jMenu.dispose();
			}
		});
		mainPanel.add(logOut);

		quit = new JButton();
		quit.setFont(new Font("Serif", Font.PLAIN, 30));
		quit.setText("10.  Quit ");
		quit.setBackground(Color.red);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainPanel.add(quit);

		jMenu.setTitle("ATM Machine"); // "super" Frame sets title
		jMenu.setSize(300, 600);
		jMenu.setLocationRelativeTo(null);// "super" Frame sets initial window
											// size
		
		jMenu.setVisible(true);// "super" Frame shows
		jMenu.pack();
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
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCreateAccMenu();						//user and account created here
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

	// creates first user and account
	public void showCreateAccMenu() {

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
		
		//handels check if student user to make student user account
		 JCheckBox cbStudent = new JCheckBox("Student User?", false);
		 cbStudent.addItemListener(new ItemListener() {    
             public void itemStateChanged(ItemEvent e) {                 
            	 if (e.getStateChange() == 1)
            		 student = true;   
            	 
            	 else
            		 student = false;    
            	 
            	 System.out.println("student? " + student);
             }    
          }); 
		 
		mainPanel.add(cbStudent);

		JCreateUser = new JButton("Create User");			//press here creates initial user
		mainPanel.add(JCreateUser);
		JCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfUserName.getText().length() != 0 && tfUserPass.getText().length() != 0) {
					
					//create new account frame opens
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

					//when clicked change currency to euro or dollar
					JButton currencyEuro = new JButton("euro");
					currencyEuro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currency = "euro";
						}
					});
					JButton currencyDollar = new JButton("dollar");
					currencyDollar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currency = "dollar";
						}
					});
						
					JButton create = new JButton("Create Account"); //triggers account creation code
					create.addActionListener(new ActionListener() { //>>>>here
						public void actionPerformed(ActionEvent e) {
							User newUser;
							//User newUser = new User(tfUserName.getText(),tfUserPass.getText()); //User type object created here
							if(student) {
								newUser = UserBuilderDirector.getStudentUser(tfUserName.getText(),tfUserPass.getText());
							}
							else {
								newUser = UserBuilderDirector.getRegularUser(tfUserName.getText(),tfUserPass.getText());
							}
								
							try {
								double d1 = Double.parseDouble(tfBal.getText());
								int i1 = Integer.parseInt(tfAccId.getText());
								
								Account newAccount = new Account(d1, accType, i1, currency);  //Account type object created here
								
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
								newList.add(newAccount);						//copys account to new accounts arraylist
								users.put(newUser, newList);				//in users hashmap puts the newUser array and the newAccounts arraylist stored here
								
								//run depending on account currency
								String contentSting = "Account Created || UserName : " + tfUserName.getText() + ", Account ID : " + tfAccId.getText() + ", Type : " + accType;
								String bal = tfBal.getText();
								if(currency == "euro") {
									EuroDecorator decorator = new EuroDecorator(bal, new Currency(contentSting));
									//currencyString = decorator.show();
									decorator.show();
									//JOptionPane.showMessageDialog(null, contentSting);
								}
								else {
									DollarDecorator decorator = new DollarDecorator(bal, new Currency(contentSting));
									//currencyString = decorator.show();
									decorator.show();
									//JOptionPane.showMessageDialog(null, contentSting);
								}
								 
								  //shows a dollar sign
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
					mainPanel.add(currencyDollar);
					mainPanel.add(currencyEuro);
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

	

	
	
	//execute method runs execute in command class
	private void executeCommand(Command command){
		// We could keep a command history in a stack here
		command.Execute();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}

	
	