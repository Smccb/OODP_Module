import java.util.Calendar;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BankController {
	public void createUser(String name, String password) {
		User user = new User(name, password);
		Vector<Account> list = new Vector<Account>();
		users.put(user, list);
	}

	public static void createAccount(double balance, String type, int accId) {
		if (users.get(loggedInUser).size() <= 5) {
			boolean check = true;
			for (Vector<Account> array : users.values()) {
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

	public static void deleteAccount(int accId)

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

	public static void deposit(double amount, int accId, String type) {
		Account obj = null;
		boolean check = false;
		for (Vector <Account> array : users.values()) {
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

	public static void withDraw(double amount, int accId, String type) {
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

	public static void showAccount(int accId) {
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
	
	public class Main {
		public static void main(String args[]) {
			Bank b1 = new Bank();
			b1.showLoginMenu();
		}
	}
}
