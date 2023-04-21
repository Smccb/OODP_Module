
//this is the user connecting on, Or the driver class
public class Client{
    private static ProxyInternet internet;

    public static void main (String[] args){
        internet = new ProxyInternet();
        try{
            internet.connectTo("tudublin.ie");//passes the names of the sites
            internet.connectTo("abc.com");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}




