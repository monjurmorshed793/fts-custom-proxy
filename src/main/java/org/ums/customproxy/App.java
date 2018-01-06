package org.ums.customproxy;
import org.rapidoid.http.Req;
import org.rapidoid.reverseproxy.LoadBalancer;
import org.rapidoid.reverseproxy.ProxyUpstream;
import org.rapidoid.reverseproxy.Reverse;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        org.rapidoid.setup.App.bootstrap(args);
    	  
          LoadBalancer lb = (Req req, List<ProxyUpstream> candidates) -> {
              int index = 0; // FIXME implement load balancing strategy
              return candidates.get(index);
          };
   
          Reverse.proxy("/")
              .to("http://localhost:8081", "http://localhost:8082")
              .loadBalancer(lb)
              .add();
    }
}
