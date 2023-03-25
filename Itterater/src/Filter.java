import java.util.*;
//itterator class is used to iterate through a list of objects

class Filter implements Enumeration{
	private Enumeration data;
	private String filter;
	private String element;

	//constructor
	public Filter(Enumeration data, String filter){
		this.filter = filter;
		this.data = data;
		element = null;
	}
	//itterates to next element and returns the next element
	public Object nextElement(){
		if (element != null)
			return element;
		else
			throw new NoSuchElementException(); // if no next element/ list is empty
	}
	//as long as there is more elements itterates using nextElement method to next element
	public boolean hasMoreElements(){
		boolean found = false;
		while(data.hasMoreElements() && !found){
			element = (String)data.nextElement();
			found = element.startsWith(filter);
		}
		if (! found)
			element = null;
		return found;
	}

}


