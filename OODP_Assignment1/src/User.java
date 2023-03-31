import java.util.ArrayList;

public class User {
	
	//required parameters 
	private String name;
	private String password;
	private int userID;
	private static int count = 1;
	private ArrayList<String> userTrans;
	
	//optional prarmeters 
	private boolean isStudentUser; 
	
	public void Spend(int accID, double amount, String type)
    {   	
    	String s1 = accID + " " +  amount + " " + type;
    	userTrans.add(s1);  	
    }
	
	public int getUID(){
		return this.userID;
	}
	
	public ArrayList<String> getUserTrans()
    {
    	return userTrans;
    }
	
	 //constructor for Computer class
	 public User(Builder builder) {
	        this.name = builder.name;
	        this.password = builder.password;
	        this.userID = builder.count;
	        this.userTrans = new ArrayList<String>();
	        count++;
	        this.isStudentUser = builder.isStudentUser;
	    }
	 
	//inner class Builder starts here
	 public static class Builder {
		//required parameters
		 private String name;
		 private String password;
		 private int userID;
		 private static int count = 1;
		 private ArrayList<String> userTrans;
		//optional parameters
		 private boolean isStudentUser;
		 
		 //builder constructor
		 public Builder(String name, String password){
	            this.name = name;
	            this.password = password;
	        }
		 
		 //setters for using build class and setting the details to create object
			public Builder setName(String name) {
				this.name = name;
				return this;
			}
			public Builder setPassword(String password) {
				this.password = password;
				return this;
			}
			
			public Builder setIsStudentUser(boolean isStudentUser) {
				this.isStudentUser = isStudentUser;
				return this;
			}
			
			//build method for creating the computer object
			public User build() {
	            return new User(this);
	        }
	 }
	 public String getName() {
			return this.name;
	}
	 public String getPassword() {
			return this.password;
	}
}