import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Logic {
	public static  void transfer(int acc1, int acc2, boolean check1, boolean check2, HashMap<User, ArrayList<Account>>users, User loggedInUser, Account accWith, JFrame j4, int amount, Calendar rightNow) {
		try {
			for (Account i : users.get(loggedInUser)) {
				if (acc1 == i.getAccId()) {
					check1 = true;
					 accWith = i;
				}
			}
			for (ArrayList<Account> array : users.values()) {
				for (Account i : array) {
					if (acc2 == i.getAccId()) {
						check2 = true;
					}
				}
			}

			if (check1 && check2) {
				if (amount <= accWith.getBalance()) {
					withDraw(amount, acc1, "Transfer", loggedInUser, users, rightNow, amount);
					deposit(amount, acc2, "Transfer", loggedInUser, users, rightNow);
					JOptionPane.showMessageDialog(null,
							"Tranfer successful");
					j4.dispose();

				} else {
					JOptionPane
							.showMessageDialog(null,
									"Tranfer failed : in suffiecent balance");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Tranfer failed : Account not found ");
			}
		} catch (Exception e5) {
			JOptionPane.showMessageDialog(null,
					"Tranfer failed : Invalid Input");
		}

	}
	
	public void createUser(String name, String password, HashMap<User, ArrayList<Account>>users) {
		User user = new User(name, password);
		ArrayList<Account> list = new ArrayList<Account>();
		users.put(user, list);
	}

	
	public static void createAccount(double balance, String type, int accId, User loggedInUser, HashMap<User, ArrayList<Account>>users) {
		if (users.get(loggedInUser).size() <= 5) {
			boolean check = true;
			for (ArrayList<Account> array : users.values()) {
				for (Account i : array) {
					if (accId == i.getAccId()) {
						JOptionPane.showMessageDialog(null, " Account ID Exists !!");
						check = false;
						break;
					}
				}
			}
			if (check) {
				Account acc = new Account(balance, type, accId);
				users.get(loggedInUser).add(acc);
				JOptionPane.showMessageDialog(null, "Account Created !! || Account ID : " + accId + ", Balance : $" + balance + ", Type : " + type);
			}
		} else {
			JOptionPane.showMessageDialog(null, " No more accounts can be created");
		}

	}

	
	public void deleteAccount(int accId, User loggedInUser, HashMap<User, ArrayList<Account>>users)

	{
		boolean check = true;
		for (Account i : users.get(loggedInUser)) {
			if (accId == i.getAccId()) {
				users.get(loggedInUser).remove(i);
				check = false;
				JOptionPane.showMessageDialog(null, "Account deleted !! || Account Id : " + accId );
				break;
			}

		}
		if (check) {
			JOptionPane.showMessageDialog(null, "Account does not exist!!");
		}
		return;
	}

	
	public static void deposit(double amount, int accId, String type, User loggedInUser, HashMap<User, ArrayList<Account>>users, Calendar rightNow) {
		Account obj = null;
		boolean check = false;
		for (ArrayList <Account> array : users.values()) {
			for(Account i : array){
			if (accId == i.getAccId()) {
				check = true;
				obj = i;
			}
		  }
		}
		if (check) {
			obj.setBalance(obj.getBalance() + amount);
			int time1 = rightNow.get(Calendar.MINUTE);
			obj.doTransaction(amount, time1, type);
			JOptionPane.showMessageDialog(null, "Deposit SuccessFull || Account ID : " + accId + ", Amount deposited : $" + amount +", NewBalance : $ " + obj.getBalance() + ", Type : " + type);
			loggedInUser.Spend(accId, amount, type);
		} else {
			JOptionPane.showMessageDialog(null, "Deposit failed!!");
		}
	}

	
	public static void withDraw(double amount, int accId, String type, User loggedInUser, HashMap<User, ArrayList<Account>>users, Calendar rightNow, int hour) {
		boolean check = true;
		Account found = null;
		for (Account i : users.get(loggedInUser)) {
			if (i.getAccId() == accId) {
				check = false;
				found = i;
				break;
			}
		}
		if (check) {
			JOptionPane.showMessageDialog(null, "Account not found !!");
		} else {
			if (found.getBalance() < amount) {
				JOptionPane.showMessageDialog(null, "In Sufficint balance");
			} else {
				hour = rightNow.get(Calendar.MINUTE);
				found.setBalance(found.getBalance() - amount);
				found.doTransaction(amount, hour, type);
				JOptionPane
						.showMessageDialog(
								null,
								"Acc ID: "
										+ found.getAccId()
										+ " . Withdrawal complete. Amount withDrawn : $" + amount + ". Remaining balance : $"
										+ found.getBalance());
				loggedInUser.Spend(accId, amount, type);
			}
		}
	}

	
	public void showAccount(int accId, HashMap<User, ArrayList<Account>>users, User loggedInUser, JFrame j3) {
		boolean check = true;
		Account obj = null;
		for (Account i : users.get(loggedInUser)) {
			if (i.getAccId() == accId) {
				check = false;
				obj = i;
				break;
			}
		}
		if (check) {
			JOptionPane.showMessageDialog(null, "Account ID not found !!");
		} else {
			obj.printTransLog();
			JOptionPane.showMessageDialog(null, "Account ID " + accId + ". Transcaction written to the text file (TrabsLog.txt)");
			j3.dispose();

		}
	}
	
	 
}
