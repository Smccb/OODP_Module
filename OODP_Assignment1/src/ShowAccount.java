import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class ShowAccount extends JFrame implements Command{
	
	int accId;
	HashMap<User, ArrayList<Account>> users;
	User loggedInUser;
	JFrame j3;
	
	public ShowAccount(int accId, HashMap<User, ArrayList<Account>> users, User loggedInUser, JFrame j3) {
		// TODO Auto-generated constructor stub
		this.accId = accId;
		this.loggedInUser = loggedInUser;
		this.j3 = j3;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
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
