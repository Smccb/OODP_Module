import javax.swing.JOptionPane;

public class Currency extends Content{
    private String txt;
    Currency(String txt){this.txt = txt;}
    public void show(){JOptionPane.showMessageDialog(null, txt);}
}
