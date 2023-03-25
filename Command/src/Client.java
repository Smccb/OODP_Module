import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//In this version, the Command objects are external classes
//and we pass them copies of the Frame instance
//in their constructor
public class Client extends JFrame{
   private Menu mnuFile;
   private MenuItem mnuOpen;
   private MenuItem mnuExit;
   private JButton btnOpen;

   //constructor
   public Client(){
      super("Frame with external commands");
      // Create the menu
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);
      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);
      mnuOpen = new MenuItem("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new MenuItem("Exit");
      mnuFile.add(mnuExit);
      btnOpen = new JButton("Open");

      JFrame frm = this;

      //buttons with action listeners
      mnuOpen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               executeCommand(new OpenCommand(frm));
            }
        });

      mnuExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               executeCommand(new ExitCommand(frm));
            }
        });

      btnOpen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               executeCommand(new OpenCommand(frm));
            }
        });

      JPanel p = new JPanel();
      add(p);
      p.add(btnOpen);

      // Setup the window
      setSize(400,450);
      show();
   }

   //execute method runs execute in command class
   private void executeCommand(Command command){
      // We could keep a command history in a stack here
      command.Execute();
   }

   //driver class runs client construtor
   static public void main(String argv[]){
      new Client();
   }
}

//class that uses command to run openCommand class details
class OpenCommand implements Command{
   private JFrame parent;
   OpenCommand(JFrame parent){this.parent = parent;}
   public void Execute(){
      FileDialog fDlg=new FileDialog(parent,"Open file");
      fDlg.show();
   }
}
//class that uses command to run openCommand class details
class ExitCommand implements Command{
   private JFrame parent;
   ExitCommand(JFrame parent){this.parent = parent;}//runs method exit command
   public void Execute(){
      System.exit(0);
   }
}



