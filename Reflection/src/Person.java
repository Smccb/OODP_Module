public class Person{
	private String name;
	private String address;

	Person(String initName, String initAddress)	{
		name = initName;
		address = initAddress;
	}
	public String getName()	{return name;}
	public String getAddress(){return address;}
	public void setName(String newName){
		name = newName;
	}
	public void setAddress(String newAddress){
		address = newAddress;
	}
	public void display(){
		System.out.println(name + " " + address);
	}
}






