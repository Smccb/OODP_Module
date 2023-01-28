
public class Vehicle {
	private String colour;
	private String type;
	private double engineSize;
	private double netPrice;
	
	public Vehicle(String colour, String type, double engineSize,double netPrice) {
		this.colour = colour;
		this.type = type;
		this.engineSize = engineSize;
		this.netPrice = netPrice;
	}
	
	public String toString() {
		return "Colour: " + this.colour + " Type: " + this.type + " Engine Size: " + this.engineSize + " Net Price: " + this.netPrice;
	}
}
