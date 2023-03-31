import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*class Transfer implements Command{
	      
	BankCommands transfer;
	
   Transfer(BankCommands newTransfer){
	   transfer = newTransfer;
   }

	@Override
	public void Execute() {
	// TODO Auto-generated method stub
		transfer.transfer();
	}
}*/
import javax.swing.JFrame;

class Transfer extends JFrame implements Command {

	int acc1;
	int acc2;
	int amount;
	HashMap<User, ArrayList<Account>> users;
	User loggedInUser;
	Account accWith;
	JFrame j4;
	
	public Transfer(int acc1, int acc2, int amount, HashMap<User, ArrayList<Account>> users, User loggedInUser,
			Account accWith, JFrame j4) {
		// TODO Auto-generated constructor stub
		
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
				executeCommand(new WithDraw(amount, acc1, "Transfer");
				deposit(amount, acc2, "Transfer");
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
}