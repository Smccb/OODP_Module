import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener
{
	
	//view components/GUI class
	
    // UI Components
    private JTextField text;
    private JList list1, list2, list3; //observer
	private ListData listData; //data model
	private JButton addBtn;
    private JButton deleteBtn;

	public MainWindow()	{
		super("Main Window");

		// Create the buttons and actionlisteners
		addBtn = new JButton("Add");
		addBtn.addActionListener(this);
		deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(this);

		// Create the text field for user input
		text = new JTextField();

		
		//this is registering interest in data
		// Create the list data source (listData) and the JLists
		// NOTE how the data source is passed to each JList
		listData = new ListData();
		list1 = new JList(listData); list1.setBorder(BorderFactory.createLineBorder(Color.gray));
		list2 = new JList(listData); list2.setBorder(BorderFactory.createLineBorder(Color.gray));
		list3 = new JList(listData); list3.setBorder(BorderFactory.createLineBorder(Color.gray));

		// Set the main layout as a BorderLayout
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.NORTH, text);

		// Setup a panel with a GridLayout for the lists and add it to the BorderLayout
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(1,3));
		listPanel.add(list1); listPanel.add(list2); listPanel.add(list3);
		c.add(BorderLayout.CENTER, listPanel);

		// Setup a panel with a FlowLayout for the buttons and add it to the BorderLayout
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add(addBtn); btnPanel.add(deleteBtn);
		c.add(BorderLayout.SOUTH, btnPanel);

		setSize(400,450);
		show();
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == addBtn){
			// Add to the data source
			if (text.getText().length() > 0){
				System.out.println("Adding");
				listData.addElement(text.getText());//keep track of changes that happened, form the registered interest in the data
				text.setText("");
			}
		}
		else if (e.getSource() == deleteBtn){
			// Remove from the data source
			if (listData.getSize() > 0 && text.getText().length() > 0){
				System.out.println("Deleting " + text.getText());
				listData.removeElement(text.getText());
				text.setText("");
			}

		}
	}

	public static void main(String[] args){
		MainWindow mainframe = new MainWindow();
	}
}
