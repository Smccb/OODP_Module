//builds a general window using window class that uses the mac or windows specific classes

//Client
public class GUIBuilder{
  public void buildWindow(AbstractWidgetFactory widgetFactory, String title){
    Window window = widgetFactory.createWindow(title);
    window.repaint();
  }
}




