//the super class, abstract so its can't be instansated
public abstract class NumberList {

//attributes, arrays, protected so any subclasses can access the variables
protected int[] intList;
protected double[] doubleList;

//constructor, not defined
NumberList() {
	intList = null; doubleList = null;
}

//accessor methods
public int[] getIntList() {
	return intList; }

public double[] getDoubleList() {
	return doubleList; }


//both blank methods to be overloaded in double and int subclasses
//display method
public void display() {}

//sum method
public Number sum() { return null; }

}