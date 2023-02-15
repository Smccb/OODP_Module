
public class UnixWidgetFactory extends AbstractWidgetFactory{
  //create an Unix window
  public Window createWindow(String title){
    UnixWindow window = new UnixWindow(title);
    return window;
  }
}