
public class ComputerClient {
	public static void main(String args[]){

        // Create the person using the builder pattern
        Computer computer = new Computer.Builder("16GB", "1TB", "AMD")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(false)
            .build();

        // Display the persons details
        Computer comp2 = ComputerBuilderDirector.getBasicComputer();
        
        Computer comp3 = ComputerBuilderDirector.getGraphicsCardEnabledComputer();
    }
}
