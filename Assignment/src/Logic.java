import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Logic {
	
	
	private double balance;
	private int accId;
	private HashMap<User, ArrayList<Account>> users;
	private User loggedInUser;
	private Calendar rightNow;
	private int hour;
	
	
	public Logic() {
		users = new HashMap<User, ArrayList<Account>>();
		loggedInUser = null;
		rightNow = Calendar.getInstance();

	}
	
	
	public void createUser(String name, String password) {
		User user = new User(name, password);
		ArrayList<Account> list = new ArrayList<Account>();
		users.put(user, list);
	}
	
	public void createAccount(double balance, String type, int accId) {
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
}
