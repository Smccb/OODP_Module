import java.lang.reflect.*;
//import com.sun.java.swing.*;

public class ShowMethods{
   public ShowMethods(){
      // Create a Person instance
      Person p = new Person("Alex","Dublin");

      System.out.println("Method list:");
      System.out.println("*******************************");

      // Get an array of method for the Person class
      Method[] methods = p.getClass().getMethods();
      for (int i = 0; i < methods.length; i++){
         // Print each method name
         System.out.println(methods[i].getName());

         // For each method get the list of parameters and types
         Class cl[] = methods[i].getParameterTypes();
         for(int j=0; j < cl.length; j++)
            // Print the parameter types
            System.out.println(cl[j].toString());
      }
   }
   static public void main(String argv[]){
      new ShowMethods();
   }
}



