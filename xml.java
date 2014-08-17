/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experimental;
import experimental.url.*;
import java.io.*;
/**
 *
 * @author m3
 */
public class xml {
    public static void xmlGet() throws Exception { // gets xmlfile from the web 
        url item = new url();
        item.urlss("http://api.eve-central.com/api/evemon");
        
          try{
            FileWriter writer= new FileWriter(sFileName); 
        
            
        } catch (IOException e) {
            e.printStackTrace();
          }
    }
}
