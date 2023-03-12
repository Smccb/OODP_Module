//this class acts the same as the decorator class

public class Url extends Content{
    private String txt;
    Url(String txt){this.txt = txt;}
    public void show(){System.out.println(txt);}
}
