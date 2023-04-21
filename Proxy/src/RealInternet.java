
//this class is supoed to be the real internet connection if the url was not a benned one
public class RealInternet implements Internet{
    @Override
    public void connectTo(String serverhost){
        System.out.println("Connecting to "+ serverhost);
    }
}
