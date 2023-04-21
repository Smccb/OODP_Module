import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
//this maintains reference to flyweirght, 
//and stires the extrinsic states in vector
public class Client extends JFrame implements MouseMotionListener {
   private Folder folder;
   private Vector<String> names;
   private Vector<Folder> folders;

   private FolderFactory fact;
   private final int Top = 30, Left = 30;
   private final int  W = 50, H = 30;
   private final int VSpace = 80, HSpace=70, HCount = 3;
   private String selectedName="";
//-------------------------------
   public Client()   { //constructor
      super("Flyweight Canvas");
      fact = new FolderFactory();
      makeNames();
      makeFolders();
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      setSize(new Dimension(300,300));
      addMouseMotionListener(this);
      setVisible(true);
      repaint();
   }
//-------------------------------
   private void makeFolders() { //folders created these are a shared instance
      folders = new Vector<Folder>();
      for (int i = 0; i < names.size (); i++) {
         folders.add (fact.getFolder (false));
      }
   }
//-------------------------------
   private void makeNames() {// extrinsic states, passed in, added to vector
      names = new Vector<String>();
      names.addElement("Alan");
      names.addElement("Barry");
      names.addElement("Charlie");
      names.addElement("Dave");
      names.addElement("Edward");
      names.addElement("Fred");
      names.addElement("George");
      selectedName = "";
   }
//-------------------------------
   public void paint(Graphics g) {//shared folder drawing
      Folder f;
      String name;

      int j = 0;      //count number in row
      int row = Top;  //start in upper left
      int x = Left;

      //go through all the names and folders
      for (int i = 0; i< names.size(); i++) {
         name = (String)names.elementAt(i);
         f = (Folder)folders.elementAt(i);
         if (name.equals(selectedName))
            f = fact.getFolder(true);

            //have that folder draw itself at this spot
         f.draw(g, x, row, name);

         x = x + HSpace;          //change to next posn
         j++;
         if (j >= HCount) {       //reset for next row
            j = 0;
            row += VSpace;
            x = Left;
         }
      }
   }
//-------------------------------
   public void mouseMoved(MouseEvent e) {
      int j = 0;      //count number in row
      int row = Top;  //start in upper left
      int x = Left;

      //go through all the names and folders
      for (int i = 0; i< names.size(); i++) {
         //see if this folder contains the mouse
         Rectangle r = new Rectangle(x,row,W,H);
         if (r.contains(e.getX(), e.getY())) {
            selectedName=(String)names.elementAt(i);
            repaint();
         }
         x = x + HSpace;          //change to next posn
         j++;
         if (j >= HCount) {       //reset for next row
            j = 0;
            row += VSpace;
            x = Left;
         }
      }

   }
   public void mouseDragged(MouseEvent e){}

//-------------------------------
   static public void main(String[] argv) {
      new Client();//driver function
   }
}


