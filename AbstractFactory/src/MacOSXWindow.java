//created by the factorys1 or 2 using the abstract window attraibutes through inheretence

// Concrete product B
//Inheritance extends window
public class MacOSXWindow extends Window{
  MacOSXWindow(String text){this.title = text;}

  //repaint overridden polymorphism example
  public void repaint(){
    //Mac OSX specific behaviour
    System.out.println("Title: " + title);
    System.out.println("Window style: Mac OSX.");
  }
}






