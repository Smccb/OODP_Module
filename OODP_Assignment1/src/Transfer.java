import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Transfer extends JFrame implements Command {

		int acc1;
		int acc2;
		int amount;
		HashMap<User, ArrayList<Account>> users;
		User loggedInUser;
		JFrame j4;
		int hour;
		Calendar rightNow;
		Account accWith;
		
		public Transfer(int from, int inTo, int amount, HashMap<User, ArrayList<Account>> users, User loggedInUser, JFrame j4, int hour, Calendar rightNow, Account accWith) {
			// TODO Auto-generated constructor stub
			this.acc1 = from;
			this.acc2= inTo;
			this.amount = amount;
			this.users = users;
			this.loggedInUser = loggedInUser;
			this.j4 = j4;
			this.hour = hour;
			this.rightNow = rightNow;
			this.accWith = accWith;
		}
		@Override
		public void Execute() {
			// TODO Auto-generated method stub
			boolean check1 = false;
			boolean check2 = false;
			
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
					executeCommand(new WithDraw(amount, acc1, "Transfer", users, loggedInUser, hour, rightNow));
					executeCommand(new Deposit(amount, acc2, "Transfer", users, loggedInUser, rightNow));
					//deposit(amount, acc2, "Transfer");
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
		}
		private void executeCommand(Command command){
			// We could keep a command history in a stack here
			command.Execute();
		}
	} 
