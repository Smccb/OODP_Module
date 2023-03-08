public class ComputerBuilderDirector {
	//create a regular computer object using builder inner class in Computer
    public static Computer getBasicComputer() {
        // Build and return a basic computer
        return new Computer.Builder("2GB", "2TB", "Intel i7").setBluetoothEnabled(true).build();
    }

    //creating a more detailed computer object using builder inner class in Computer
    public static Computer getGraphicsCardEnabledComputer() {
        // Build and return a GFX computer
        return new Computer.Builder("2GB", "2TB", "Intel i7").setGraphicsCardEnabled(true).build();
    }
}
