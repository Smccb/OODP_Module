//created by the AbstractWidegetFactory and creates the product MS window

//ConcreteFactory1
public class MsWindowsWidgetFactory extends AbstractWidgetFactory{
  //create an MSWindow
	//polymorphism, overrides the createWindow method in AbstrctWidgetFactory
  public Window createWindow(String title){
    MSWindow window = new MSWindow(title);
    return window;
  }
}





