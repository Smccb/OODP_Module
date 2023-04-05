import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

class DeleteAccount implements Command {
		int accId;
		HashMap<User, ArrayList<Account>> users;
		User loggedInUser;
		
		public DeleteAccount(int accId, HashMap<User, ArrayList<Account>> users, User loggedInUser){
			this.accId = accId;
			this.users = users;
			this.loggedInUser = loggedInUser;
		}
		@Override
		public void Execute() {
			// TODO Auto-generated method stub
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
}