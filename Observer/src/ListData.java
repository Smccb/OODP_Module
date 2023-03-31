import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//this is the model/data class and its where all the data is kept
public class ListData extends AbstractListModel{
    private Vector data;

    public ListData(){
        data = new Vector();
    }
    public int getSize(){
        return data.size();
    }
    public Object getElementAt(int index){
        return data.elementAt(index);
    }
    public void addElement(String s){
        data.addElement(s);
        fireIntervalAdded(this, data.size()-1, data.size());
    }
    public void removeElement(String s){
        int index = data.indexOf(s);
        if (index > -1){
            data.remove(index);
            fireIntervalRemoved(this, index, data.size());
        }
    }
}
