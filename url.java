/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experimental;

import java.net.*;
import java.io.*;
/**
 *
 * @author m3
 */
public class url {

  public static void urlss(String args) throws Exception {
  URL oracle = new URL(args);
  BufferedReader in = new BufferedReader(
        new InputStreamReader(
        oracle.openStream()));

  String inputLine;

  while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);

  in.close();
    }
}
