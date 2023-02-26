
public class LogManager {
	// This will be the one and only WindowManager instance
		private static LogManager logManager;
		private LogManager(){
			// Private constructor that does nothing
		}
		// Public synchronized method which will return a
		// WindowManager
		public static synchronized LogManager getManager(){
			// If true then we need to create an instance of
			// WindowManager
			if (logManager == null)
				logManager = new LogManager();
			return logManager;
		}
		// Test method so we can ensure that our
		// object works
		public void print(String message){
			System.out.println(message);
		}
}
