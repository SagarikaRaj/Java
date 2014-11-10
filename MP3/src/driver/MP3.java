/* Developed by Sagarika Muniraj
 * A20295475
 * Mini Project 3
 * ITMD 411
*/

package driver;

import domain.ProductConsumer;
import domain.ProductProducer;
import domain.Product;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MP3 
{
    //Global array list of products that can be used from Utility to hold the data read from input file
    public static ArrayList<Product> productList = new ArrayList<Product>();
    
    public static void main(String[] args) 
    {   
        Date startTime = new Date();
        
        // creating a single product producer thread
        ProductProducer producer11 = new ProductProducer();
        Thread  p1 = new Thread( producer11);
        p1.setDaemon(true);
        p1.start();

        //creating four consumer threads
        ProductConsumer northernConsumer;
        northernConsumer = new ProductConsumer(producer11,"N",5000L);
        Thread c1 = new Thread(northernConsumer);
        c1.setDaemon(true);
        c1.start();

        ProductConsumer southernConsumer = new ProductConsumer(producer11,"S",7000L);
        Thread c2 = new Thread (southernConsumer);
        c2.setDaemon(true);
        c2.start();

        ProductConsumer easternConsumer = new ProductConsumer(producer11,"E",8000L);
        Thread c3 = new Thread(easternConsumer);
        c3.setDaemon(true);
        c3.start();

        ProductConsumer westernConsumer = new ProductConsumer(producer11,"W",9000L);
        Thread c4 = new Thread(westernConsumer);
        c4.setDaemon(true);
        c4.start();
        
        //terminating the simulation by keystroke
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try 
        {
            System.out.println("Press RETURN to exit...");
            in.read();
            System.out.println("Production and Distribution Interrupted. Halting.");
            in.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        } 
        
        //displaying required output
        finally 
        {
            Date endTime = new Date();
            long interval = (endTime.getTime() - startTime.getTime()) / 1000;
            System.out.println("Total Elapsed Time                  :   " + interval + " Seconds");
            System.out.println("No of Products Produced             :   " + ProductProducer.productCount);
            System.out.println("No of Products Consumed             :   " + ProductConsumer.totalProductsConsumed);
            int diff = (int) (ProductProducer.productCount) - (int) (ProductConsumer.totalProductsConsumed);
            System.out.println("No of Products in Inventory/Unsold  :   " + diff);
            
            //Deserializing
            try 
            {
                System.out.println("Deserializing and Displaying data before Termination!");
                ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("data/NorthenProductObjects.ser"));
                ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("data/SouthernProductObjects.ser"));
                ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("data/EasternProductObjects.ser"));
                ObjectInputStream ois4 = new ObjectInputStream(new FileInputStream("data/WesternProductObjects.ser"));

                
                // Deserialize
                Product northenProdObj = (Product) ois1.readObject();
                Product southernProdObj = (Product) ois1.readObject();
                Product easternProdObj = (Product) ois1.readObject();
                Product westernProdObj = (Product) ois1.readObject();
                System.out.println("Deserialization Complete!");

            } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(MP3.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (Exception ex)
            {
                Logger.getLogger(MP3.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            System.exit(0);
        }
    }
}
