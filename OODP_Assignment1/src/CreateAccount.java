import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

class CreateAccount implements Command {		
		String type;
		int accId;
		double balance;
		HashMap<User, ArrayList<Account>> users;
		User loggedInUser;
		String currency;
		
		CreateAccount(double balance, String type, int accId, HashMap<User, ArrayList<Account>> users, User loggedInUser, String currency){
			this.type = type;
			this.accId = accId;
			this.balance = balance;
			this.users = users;
			this.loggedInUser = loggedInUser;
			this.currency = currency;
		}
		@Override
		public void Execute() {
			// TODO Auto-generated method stub
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
					Account acc = new Account(balance, type, accId, currency);		//new account object created here
					users.get(loggedInUser).add(acc);		//adds created Account object to user object using user hashmap
					
					JOptionPane.showMessageDialog(null, "Account Created !! || Account ID : " + accId + ", Balance : $" + balance + ", Type : " + type);
				}
			} else {
				JOptionPane.showMessageDialog(null, " No more accounts can be created");
			}
		}
	}