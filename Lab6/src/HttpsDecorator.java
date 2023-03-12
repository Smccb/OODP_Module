
public class HttpsDecorator extends Decorator {
	HttpsDecorator(Content contentToBeDecorated){super(contentToBeDecorated);}
  public void show(){
    // Decorate
    System.out.print("https://www."); //prints https message first that is specific to this class
    // Delegate
    super.show(); //uses the superclass (Decorator) like other child classes http and ftp..
  }
}
