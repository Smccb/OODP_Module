import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class WithDraw implements Command{
	double amount;
	int accId;
	String type;
	HashMap<User, ArrayList<Account>> users;
	User loggedInUser;
	int hour;
	Calendar rightNow;
	
	public WithDraw(double aount, int accId, String type, HashMap<User, ArrayList<Account>> users, User loggedInUser, int hour, Calendar rightNow){
		this.amount = aount;
		this.accId = accId;
		this.type = type;
		this.users = users;
		this.loggedInUser = loggedInUser;
		this.rightNow = rightNow;
		this.hour = hour;
	}
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
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
										+ " . Withdrawal complete. Amount withDrawn : $" + amount + ". Remaining balance : $"  //shows a dollar sign
										+ found.getBalance());
				loggedInUser.Spend(accId, amount, type);
			}
		}
	}
}
