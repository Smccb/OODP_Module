import java.io.*;
import java.util.*;

class Client{
	private Vector data;
	private Filter filter;

	//constructor
	public Client(){
		//creates the vector and itterates through it (vectors usually use itterator)
		data = new Vector();
		data.addElement("Alan"); data.addElement("Joanne");
		data.addElement("John"); data.addElement("Martin");
	}
	//lists names using the methods in Filter class
	public void listNames(){
		Enumeration e = data.elements();
		while(e.hasMoreElements()){
			String s = (String)e.nextElement();
			System.out.println(s);
		}
	}
	//creates a filter to filter through names with a letter J
	public void filterNames(){
		filter = new Filter(data.elements(), "J");
		while(filter.hasMoreElements()){
			String s = (String)filter.nextElement();
			System.out.println(s);
		}
	}
	//driver method main
	public static void main(String[] args){
		Client app = new Client();
		System.out.println("All names");
		app.listNames();
		System.out.println("Filtered names");
		app.filterNames();
	}
}
