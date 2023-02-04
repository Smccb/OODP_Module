
import java.util.StringTokenizer;

//subclass of NumberList
public class DoubleList extends NumberList {

int size;

//subclass constructor
DoubleList(String list) { size = 0;

StringTokenizer token = new StringTokenizer(list);
size = token.countTokens();

// Allocate some space for the array
doubleList = new double[size];

// Store each list item an the appropriate array

for(int i = 0; i < size; i++) {
	doubleList[i] = Double.parseDouble(token.nextToken());
}
}

public Number sum() {

double n = 0;
for(int i = 0; i < size; i++) {
	n = n + doubleList[i];
}
return new Double(n);
}

public void display() {
System.out.print("Double List"); for(int i = 0; i < size; i++)
System.out.println("[" + i + "] = " + doubleList[i]);
}
}