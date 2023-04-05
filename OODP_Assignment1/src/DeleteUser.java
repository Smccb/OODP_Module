import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DeleteUser implements Command{

	HashMap<User, ArrayList<Account>> users;
	User loggedInUser;
	JFrame jMenu;
	
	public DeleteUser(HashMap<User, ArrayList<Account>> users, User loggedInUser, JFrame jMenu) {
	this.jMenu = jMenu;
	this.users = users;
	this.loggedInUser = loggedInUser;
	}
	
	@Override
	public void Execute() {
		// TODO Auto-generated method stub
		users.remove(loggedInUser);
		JOptionPane.showMessageDialog(null, "User Deleted !!");
		jMenu.dispose();
	}

}
