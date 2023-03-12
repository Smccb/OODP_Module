
//this class uses the show method from Content in its show method alone with the message/string taken in from the client/driver class

public class Decorator extends Content{
    private Content contentToBeDecorated;
    Decorator(Content contentToBeDecorated){this.contentToBeDecorated = contentToBeDecorated;}
    public void show(){contentToBeDecorated.show();}
}



