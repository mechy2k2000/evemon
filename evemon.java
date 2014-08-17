/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experimental;


import java.io.*;
import nu.xom.*;

/**
 *
 * @author m3
 */
public class evemon {
    double[] price = new double[8];
    String[] name= new String[8];
   
    Builder builder = new Builder();
    Document doc = builder.build("http://api.eve-central.com/api/evemon");
   
    public evemon() throws ParsingException, IOException{
        
    
        
        Element root = doc.getRootElement();
        
        Elements minerals = root.getChildElements("mineral");
        System.out.println(minerals.size());
        for(int current = 0; current <minerals.size(); current++){
            Element mineral = minerals.get(current);
            Element name_id = mineral.getFirstChildElement("name");
            Element price_avg = mineral.getFirstChildElement("price");
            
            name[current] = name_id.getValue();
            price[current]= Double.parseDouble(price_avg.getValue());
        }// end of for
    }// end of evemon 
    
    public void search(String arg){ //searches for a particular item
        Element root = doc.getRootElement();
        Elements minerals = root.getChildElements("mineral");
        System.out.println("Searching for " + arg);
        System.out.println(minerals.size());
        for(int i = 0; i <minerals.size(); i++){
            Element mineral = minerals.get(i);
            Element name_id = mineral.getFirstChildElement("name");
            Element price_avg = mineral.getFirstChildElement("price");
            String target = name_id.getValue();
            
            if(arg.equals(target)){
                System.out.println(name_id.getValue());
                System.out.println(price_avg.getValue()); 
                break;
            }else{
                System.out.println("Mineral not found.... ");
            }
        }
        
    }

    public void display(){
        for (int i = 0; i < price.length; i++){
            System.out.println("Name: "+ name[i]);
            System.out.println("Price avg: " + price[i]);
          
        }// end of for
    }// end of display
    
    public static void main(String[] args) throws ParsingException, IOException{
        try{
            evemon station = new evemon();
            station.search("Jita");
        }catch (Exception exception){
           System.out.println("Error: ##" + exception.getMessage());
        }
    }
    
}// end of class
