import java.lang.reflect.*;
//import com.sun.java.swing.*;

public class InvokeMethod{
   public InvokeMethod(){
      // Create a Person instance
      Person p = new Person("Alex","Dublin");
      System.out.println("Before method invocation.");
      p.display();

      // Get an array of method for the Person class
      Method[] methods = p.getClass().getMethods();
      for (int i = 0; i < methods.length; i++){
         // Check to see this is the setName method
         if (methods[i].getName() == "setName"){
            try{
               // Invoke the setName method on the Person instance
               Object o = methods[i].invoke(p, "John");
            }
            catch (InvocationTargetException | IllegalAccessException e){
               System.out.println(e.getMessage());
            }
         }
      }
      System.out.println("After method invocation.");
      p.display();
   }
   static public void main(String argv[]){
      new InvokeMethod();
   }
}