//creates the numberlist objects

//checks for decimal point and if it finds one it creates and object of type DoubleList otherwise it uses type IntList

public class NumberFactory
{
	//class only has this checking method
	public NumberList getNumberList(String list) {
		
		int i = list.indexOf('.');//gets index of .
		int j = list.indexOf("x");//index of x
		
		if(i!= -1)//if there is an index it is decimal
		{
		return new DoubleList(list);//call of type DoubleList with list passed to class
		}
		else if(j != -1) {//if there is an x its hex
			return new HexList(list);
		}
		else{//integer
			return new IntList(list);//call of type IntList with list passed class
		}
	}
}