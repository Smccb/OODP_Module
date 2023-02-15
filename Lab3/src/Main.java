//driver class

public class Main{
	  public static void main(String[] args){
	    GUIBuilder builder = new GUIBuilder();
	    AbstractWidgetFactory widgetFactory = null;
	    
	    //String s= "mac"; //testing
	    String s= "unix"; //testing
	    //String s = "windows";//testing
	    
	    //check what platform we're on
	    //System.getProperty("os.name").toLowerCase().contains("mac")
	    //System.getProperty("os.name").toLowerCase().contains("windows")
	    
	    if (s == "mac"){
	      widgetFactory  = new MacOSXWidgetFactory();
	    } 
	    
	    else if(s == "windows") {
	      widgetFactory  = new MsWindowsWidgetFactory();
	    }
	    
	    else {
	    	widgetFactory = new UnixWidgetFactory();
	    }
	    builder.buildWindow(widgetFactory, "New Window");
	  }
	}



