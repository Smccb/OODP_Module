package Modified;
import java.io.*;

public class Client{

	public static void main(String[] args)	{
		ScreenAdapter scr = new ScreenAdapter();
        scr.writeInt(10);
		scr.nextLine();
		scr.writeInt(20);
		scr.nextLine();
		scr.writeInt(30);
		scr.nextLine();
		scr.writeInt(40);
		scr.nextLine();
		scr.writeInt(50);
		scr.nextLine();
	}
}
