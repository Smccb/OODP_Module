//creates the numberlist objects

//checks for decimal point and if it finds one it creates and object of type DoubleList otherwise it uses type IntList

public class NumberFactory
{
	//class only has this checking method
	public NumberList getNumberList(String list) {

		int i = list.indexOf('.');
		if(i!= -1)
		{
		return new DoubleList(list);//call of type DoubleList with list passed to class
		}
		else{
			return new IntList(list);//call of type IntList with list passed class
		}
	}




}