import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ShowAllAcc implements Command{
	
	HashMap<User, ArrayList<Account>> users;
	User loggedInUser;
	
	public ShowAllAcc(HashMap<User, ArrayList<Account>> users, User loggedInUser) {
	this.users = users;
	this.loggedInUser = loggedInUser;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		for (Account i : users.get(loggedInUser)) {
			System.out.println("Account ID: " + i.getAccId() + " "
					+ "Balance : $" + i.getBalance() + " " + "Type: "
					+ i.getType());
		}
		JOptionPane.showMessageDialog(null,"Accounts data printed to the Console!!");
	}

}
