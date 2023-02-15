//the driver class, decides mac or windows system being used and creates appropriate window

public class Main{
  public static void main(String[] args){
    GUIBuilder builder = new GUIBuilder();
    AbstractWidgetFactory widgetFactory = null;
    
    //check what platform we're on
    if (System.getProperty("os.name").toLowerCase().contains("mac")){
      widgetFactory  = new MacOSXWidgetFactory();
    } else {
      widgetFactory  = new MsWindowsWidgetFactory();
    }
    builder.buildWindow(widgetFactory, "New Window");
  }
}



