

public class Computer {
	//required parameters
	 private String RAM;
	 private String HDD;
	 private String CPU;
	//optional parameters
	 private boolean isGraphicsCardEnabled;
	 private boolean isBluetoothEnabled;
	 
	 
	 public void display(){
	        System.out.println(CPU + ", " + HDD + ", " + RAM + ", " +
	        		isGraphicsCardEnabled + ", " + isBluetoothEnabled );
	    }
	 
	 public Computer(Builder builder) {
	        this.RAM = builder.RAM;
	        this.HDD = builder.HDD;
	        this.CPU = builder.CPU;
	        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
	        this.isBluetoothEnabled = builder.isBluetoothEnabled;
	    }
	 
	 public static class Builder {
		//required parameters
		 private String RAM;
		 private String HDD;
		 private String CPU;
		//optional parameters
		 private boolean isGraphicsCardEnabled;
		 private boolean isBluetoothEnabled;
		 
		 public Builder(String RAM, String HDD, String CPU){
	            this.RAM = RAM;
	            this.HDD = HDD;
	            this.CPU = CPU;
	        }
		 
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
			public Computer build() {
	            return new Computer(this);
	        }
	 }
}
