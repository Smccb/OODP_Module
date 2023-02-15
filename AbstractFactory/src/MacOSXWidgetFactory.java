//these are created by AbstractWidgetFactory and create the product macwindow

//ConcreteFactory2
public class MacOSXWidgetFactory extends AbstractWidgetFactory{
  //create a MacOSXWindow
	//polymorphism createwindow overrided here from abstrctWidgetFactory
  public Window createWindow(String title){
    MacOSXWindow window = new MacOSXWindow(title);
    return window;
  }
}






