import java.util.ArrayList;
import java.util.List;

//this is the proxy site, if the url passed in is  on the banned list then it is not redirected to the real site/internet,
//if its not on the banned list the user is redirected to real internet
public class ProxyInternet implements Internet{
    private RealInternet internet = new RealInternet();
    private static List<String> bannedSites;

    static{
        bannedSites = new ArrayList<String>();//banned sites url here
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception{//reroutes here based on arraylist banned sites
        if(bannedSites.contains(serverhost.toLowerCase())){
            throw new Exception("Access Denied " + serverhost);
        }
        internet.connectTo(serverhost);
    }
}
