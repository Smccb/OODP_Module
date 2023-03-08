
public class ComputerClient {
	//driver class for testing
	public static void main(String args[]){

        // Create the computer using the builder pattern, using setters and build method and setters in Build inner class in Computer class
        Computer computer = new Computer.Builder("1TB", "16GB", "AMD")
            .setGraphicsCardEnabled(true)
            .setBluetoothEnabled(false)
            .build();
        
        //create the computer objects using the ComputerBuild director class methods, uses constructor in Build inner class
        Computer comp2 = ComputerBuilderDirector.getBasicComputer();
        
        Computer comp3 = ComputerBuilderDirector.getGraphicsCardEnabledComputer();
        
     // Display the computer details
        computer.display(); comp2.display(); comp3.display();
    }
}
