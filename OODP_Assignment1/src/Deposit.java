import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JOptionPane;

class Deposit implements Command {
		double amount;
		int accId;
		String type;
		HashMap<User, ArrayList<Account>> users;
		User loggedInUser;
		Calendar rightNow;
		
		public Deposit(double amount, int accId, String type, HashMap<User, ArrayList<Account>> users, User loggedInUser, Calendar rightNow){
			this.accId = accId;
			this.amount = amount;
			this.type = type;
			this.users = users;
			this.loggedInUser = loggedInUser;
			this.rightNow = rightNow;
		}
		@Override
		public void Execute() {
			// TODO Auto-generated method stub
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
				JOptionPane.showMessageDialog(null, "Deposit SuccessFull || Account ID : " + accId + ", Amount deposited : $" + amount +", NewBalance : $ " + obj.getBalance() + ", Type : " + type);  //shows a dollar sign
				loggedInUser.Spend(accId, amount, type);
			} else {
				JOptionPane.showMessageDialog(null, "Deposit failed!!");
			}
		}
	}