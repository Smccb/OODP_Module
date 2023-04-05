import javax.swing.JOptionPane;

public class DollarDecorator extends Decorator{
	String balance;
	DollarDecorator(String bal, Content contentToBeDecorated){
		super(contentToBeDecorated);
		this.balance = bal;
	}
	public void show(){
	    String s = "Balance: $" + balance;
	    JOptionPane.showMessageDialog(null,s);
	    super.show(); 
	}
}
