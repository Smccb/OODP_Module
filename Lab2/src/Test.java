//driver class

public class Test{
	
	public static void main (String [] args){

		//creating Strings of numbers to be broken up into ints/doubles and summed
		String list1 = new String("1 2 3 4 5 6 7 8 9 10");
		String list2 = new String("1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8 9.9 10.1");
		String list3 = new String("0x00FF 0xAF45 0xEF34 0xAB23");
	
		NumberFactory nfactory = new NumberFactory();	
		
		//getNumberList is method of the numberfactory class and checks for decimal
		nfactory.getNumberList(list1).display();//getNumberList creates and displays an IntList object

		System.out.println("");

		//object type Number list created
		NumberList numberlist2 = nfactory.getNumberList(list2);//getNumberList creates and displays a DoubleList object
		//using our reference variable numberlist2 above allows us to store the reference returned by getNumberList (a list of doubles)

		
		//this runs display method in DoubleList, overloading superclass display polymorphism
	    numberlist2.display();//we use our reference to call our display method

		System.out.println("");

		System.out.println("Sum of list 2:" + numberlist2.sum());//uses sum in DoubleList, overloading superclass sum method
		
		NumberList numberlist3 = nfactory.getNumberList(list3);//getNumberList creates and displays a DoubleList object
		//using our reference variable numberlist2 above allows us to store the reference returned by getNumberList (a list of doubles)

		
		//this runs display method in DoubleList, overloading superclass display polymorphism
	    numberlist3.display();//we use our reference to call our display method

		System.out.println("");

		System.out.println("Sum of list 3:" + numberlist3.sum());

	}
}
