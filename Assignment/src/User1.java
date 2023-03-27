
public class User1 {
	//required parameters
	 private String RAM;
	 private String HDD;
	 private String CPU;
	 
	//optional parameters
	 private boolean isGraphicsCardEnabled;
	 private boolean isBluetoothEnabled;
	 
	 
	 //display method for printing
	 public void display(){
	        System.out.println(CPU + ", " + HDD + ", " + RAM + ", " +
	        		isGraphicsCardEnabled + ", " + isBluetoothEnabled );
	    }
	 
	 //constructor for Computer class
	 public User1(Builder builder) {
	        this.RAM = builder.RAM;
	        this.HDD = builder.HDD;
	        this.CPU = builder.CPU;
	        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
	        this.isBluetoothEnabled = builder.isBluetoothEnabled;
	    }
	 
	//inner class Builder starts here
	 public static class Builder {
		//required parameters
		 private String RAM;
		 private String HDD;
		 private String CPU;
		//optional parameters
		 private boolean isGraphicsCardEnabled;
		 private boolean isBluetoothEnabled;
		 
		 //builder constructor
		 public Builder(String RAM, String HDD, String CPU){
	            this.RAM = RAM;
	            this.HDD = HDD;
	            this.CPU = CPU;
	        }
		 
		 //setters for using build class and setting the details to create object
			public Builder setRAM(String rAM) {
				this.RAM = rAM;
				return this;
			}
			public Builder setHDD(String hDD) {
				this.HDD = hDD;
				return this;
			}
			public Builder setCPU(String cPU) {
				this.CPU = cPU;
				return this;
			}
			public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
				this.isGraphicsCardEnabled = isGraphicsCardEnabled;
				return this;
			}
			public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
				this.isBluetoothEnabled = isBluetoothEnabled;
				return this;
			}
			//build method for creating the computer object
			public User1 build() {
	            return new User1(this);
	        }
	 }
}
