//subclass car, of Vehicle superclass

public class Car extends Vehicle{
	private int numberOfDoors;
	
	//constructor
	public Car(String colour, String type, double engineSize,double netPrice, int numberOfDoors) {
		super(colour, type, engineSize, netPrice);//vehicle constructor/ superclass constructor
		this.numberOfDoors = numberOfDoors;
	}
	//accessor methods
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}
	public int getNumberOfDoors() {
		return numberOfDoors;
	}
	
	//toString
	public String toString() {
		   return "Car: " + super.toString() + " Number of Doors: " + this.numberOfDoors;//reference to superToString in vehicle
	} 
}
