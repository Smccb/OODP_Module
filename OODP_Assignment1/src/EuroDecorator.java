import javax.swing.JOptionPane;

public class EuroDecorator extends Decorator{
	String balance;
	EuroDecorator(String bal, Content contentToBeDecorated){
		super(contentToBeDecorated);
		this.balance = bal;
	}
	public void show(){
	    String s = "Balance: €" + balance;
	    JOptionPane.showMessageDialog(null,s);
	    super.show(); 
	}
}
