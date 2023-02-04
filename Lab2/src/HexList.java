import java.util.StringTokenizer;

//subclass of NumberList
public class HexList extends NumberList {

//attributes
int size;

//subclass constructor shows polymorphism
HexList(String list) {

size = 0;
StringTokenizer token = new StringTokenizer(list);
size = token.countTokens();

// Allocate some space for the array
hexList = new int[size];

// Store each list item an the appropriate array
	for(int i=0;i<size;i++) {
		hexList[i] = Integer.parseInt(token.nextToken(),16);
	}

}

//shows polymorphism this version of sum runs rather than superclass method sum, method overloading
public Number sum() {


int n = 0;
for(int i = 0; i < size; i++)
{
n = n + hexList[i];
}
return new Integer(n);

}

//this display method runs rather than the superclass display method, example of polymorphism overloading
public void display() {
	System.out.print("Hex List");

	for(int i = 0; i < size; i++)
	System.out.println("[" + i + "] = " + hexList[i]);
}

}//end class