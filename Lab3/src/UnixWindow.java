
public class UnixWindow extends Window{
	UnixWindow(String text){this.title = text;}

  public void repaint(){
    //Unix specific behaviour
    System.out.println("Title: " + title);
    System.out.println("Window style: Unix Stye.");
  }
}