//testing class

public class Test {
	public static void main(String[] args) {
		//creating objects using constructors 
		Vehicle vehicle1 = new Vehicle("red", "Mazda", 2.1, 14000.00);
		Motorbike motorbikeBike1 = new Motorbike("blue", "BTW", 1.2, 6100.00, true);
		Car car1 = new Car("silver", "Toyota", 1.0, 12000.00, 4);
		
		//printing toStrings from created objects
		System.out.println(vehicle1);
		System.out.println(motorbikeBike1);
		System.out.println(car1);
		
	}
}
