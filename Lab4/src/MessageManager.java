
class MessageManager{
	// This will be the one and only MessageManager instance
	private static MessageManager messageManager;
	private MessageManager(){
		// Private constructor that does nothing
	}
	// Public synchronized method which returns a
	// MessageManager
	public static synchronized MessageManager getManager(){
		// If true then we need to create an instance of
		// WindowManager
		if (messageManager == null)
			messageManager = new MessageManager();

		return messageManager;
	}
	// Test method so we can ensure that our
	// object works
	public void print(String message){
		System.out.println(message);
	}
}










