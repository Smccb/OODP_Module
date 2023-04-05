import java.util.ArrayList;
import java.util.HashMap;

public class CreateUser implements Command{
	String name;
	String password;
	HashMap<User, ArrayList<Account>> users;
	boolean student;

	public CreateUser(String name, String password, boolean student, HashMap<User, ArrayList<Account>> users){
		this.name = name;
		this.password = password;
		this.users = users;
		this.student = student;
	}
	
	@Override
	public void Execute() {
		User user;
		if(student) {
			user = UserBuilderDirector.getStudentUser(name ,password);
		}
		else {
			user = UserBuilderDirector.getRegularUser(name,password);
		}
		
		ArrayList<Account> list = new ArrayList<Account>();		//create arraylist of accounts
		users.put(user, list);					//store the user and account into the users hashmap of arraylists
	}
	
}
