import java.util.ArrayList;

public class Registry {
	
	private static ArrayList<Registry> registryAL = new ArrayList<Registry>();
	


	private static Registry registryManager;
	
	private Registry() {
	}
	
	public static synchronized Registry getManager() {
		
		
		if (registryManager == null)
			registryManager = new Registry();
		return registryManager;
	}
	
	public void print(String message){
		System.out.println(message);
	}
}