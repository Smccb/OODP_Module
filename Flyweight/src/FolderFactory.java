//this is the flyweight factor, folder factory
import java.awt.*;

class FolderFactory
{
   private Folder unSelected, Selected;
   public FolderFactory(){
      //Color brown = new Color(0x5f5f1c);
      Selected =  new Folder(new Color(0x5f5f1c));
      unSelected = new Folder(Color.yellow);
      }
   public Folder getFolder(boolean isSelected){
      if (isSelected)
         return Selected;
      else
         return unSelected;
   }
}
//manages flyweight objects like a singleton regestry