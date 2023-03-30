

public class UserBuilderDirector {
	//create a regular user
    public static User getRegularUser(String username, String password) {
        // Build and return regular user
        return new User.Builder(username, password).build();
    }

    //create more detailed student user
    public static User getStudentUser(String username, String password) {
        // Build and return student user
        return new User.Builder(username, password).setIsStudentUser(true).build();
    }
}