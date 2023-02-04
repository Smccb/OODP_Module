//subclass motorbike, of vehicle superclass

public class Motorbike extends Vehicle{
	//attributes
	private boolean carrier;
	
	//constructor
	public Motorbike(String colour, String type, double engineSize,double netPrice, boolean carrier) { 
		super(colour, type, engineSize, netPrice);
		this.carrier = carrier;
	}
	//accessor methods
	public void setCarrier(boolean carrier) {
		this.carrier = carrier;
	}
	public boolean isCarrier() {
		return carrier;
	}
	
	//subclass toString, using super toString in vehicle class
	public String toString() {
		return "MotorBike: " + super.toString() + " Carrier: " + this.carrier;
	}  
}
