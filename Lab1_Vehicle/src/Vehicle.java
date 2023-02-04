//superClass Vehicle


public class Vehicle {
	//attributes
	private String colour;
	private String type;
	private double engineSize;
	private double netPrice;
	
	
	//constructor
	public Vehicle(String colour, String type, double engineSize,double netPrice) {
		this.colour = colour;
		this.type = type;
		this.engineSize = engineSize;
		this.netPrice = netPrice;
	}
	//accessor methods
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getColour(){
		return colour;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}
	public double getEngineSize() {
		return engineSize;
	}
	
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	public double getNetPrice() {
		return netPrice;
	}
	
	//super class toString
	public String toString() {
		return "Colour: " + this.colour + " Type: " + this.type + " Engine Size: " + this.engineSize + " Net Price: " + this.netPrice;
	}
}
