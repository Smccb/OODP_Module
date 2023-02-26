
public class ComputerClient {
	public static void main(String args[]){

        // Create the person using the builder pattern
        Computer computer = new Computer.Builder("1TB", "16GB", "AMD")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(false)
            .build();

        // Display the persons details
        Computer comp2 = ComputerBuilderDirector.getBasicComputer();
        
        Computer comp3 = ComputerBuilderDirector.getGraphicsCardEnabledComputer();
        
        computer.display(); comp2.display(); comp3.display();
    }
}
