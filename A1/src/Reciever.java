import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Reciever implements BankCommands{

	@Override
	public void transfer() {
		// TODO Auto-generated method stub
		try {
			
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
					withDraw(amount, acc1, "Transfer");
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
		} catch (Exception e5) {
			JOptionPane.showMessageDialog(null,
					"Tranfer failed : Invalid Input");
		}
	}

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withDraw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ShowAllAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Quit() {
		// TODO Auto-generated method stub
		
	}
	
}
