//creates a MC window, using the bluprint of the abstract window for general window details,
//created by the windows widget factory class

// Concrete product A
public class MSWindow extends Window{
  MSWindow(String text){this.title = text;}

//repain overriden polymorphism example
  public void repaint(){
    //MS Windows specific behaviour
    System.out.println("Title: " + title);
    System.out.println("Window style: MS Windows.");
  }
}






