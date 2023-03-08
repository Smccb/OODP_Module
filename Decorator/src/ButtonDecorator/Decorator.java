package ButtonDecorator;
import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


public class Decorator extends JComponent {
    public Decorator(JComponent c) {
        setLayout(new FlowLayout());
        //add("Center", c);
        add(c);
    }
}



