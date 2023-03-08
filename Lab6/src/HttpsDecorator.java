
public class HttpsDecorator extends Decorator {
	HttpsDecorator(Content contentToBeDecorated){super(contentToBeDecorated);}
  public void show(){
    // Decorate
    System.out.print("https://www.");
    // Delegate
    super.show();
  }
}
