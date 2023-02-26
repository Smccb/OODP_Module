
public class PrintManager {
	private static PrintManager printManager;
	private PrintManager(){
		// Private constructor that does nothing
	}
	// Public synchronized method which will return a
	// WindowManager
	public static synchronized PrintManager getManager(){
		// If true then we need to create an instance of
		// WindowManager
		if (printManager == null)
			printManager = new PrintManager();
		return printManager;
	}
	// Test method so we can ensure that our
	// object works
	public void print(String message){
		System.out.println(message);
	}
}
