//Product Consumer consuming only its respective ProductMessage Objects 
package domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductConsumer implements Runnable, Serializable 
{
    
    private ProductProducer producer;
    private ProductMessage prodMessage = new ProductMessage();
    private String region;
    private long timeInterval;
    List<ProductProducer> producerList = new ArrayList<ProductProducer>();
    List<ProductMessage> collectedProducts = new ArrayList<ProductMessage>();
    ObjectOutputStream oos1;
    ObjectOutputStream oos2;
    ObjectOutputStream oos3;
    ObjectOutputStream oos4;
    public static int totalProductsConsumed = 0;
    
    public ProductConsumer(ProductProducer producer1, String region, Long timeInterval) 
    {
        this.producer = producer;
        producerList.add(producer1);
        this.region = region;
        this.timeInterval = timeInterval;
    }

    //serializing product messages into respective files
        public void run() 
        {
        try {
            switch (region)
            {
                case "N":
                    oos1 = new ObjectOutputStream(new FileOutputStream("data/NorthenProductObjects.ser"));
                    break;
                case "S":
                    oos2 = new ObjectOutputStream(new FileOutputStream("data/SouthernProductObjects.ser"));
                    break;
                case "E":
                    oos3 = new ObjectOutputStream(new FileOutputStream("data/EasternProductObjects.ser"));
                    break;
                case "W":
                    oos4 = new ObjectOutputStream(new FileOutputStream("data/WesternProductObjects.ser"));
                    System.out.println("The Western Object is given the patch");
                    break;
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(ProductConsumer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ProductConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }

        //producing random product and adding them into collected products
        while (true) 
        {
            
            this.producer = producerList.get((int) (producerList.size() * Math.random()));
            
            prodMessage = producer.getMessage(region);
            if (prodMessage != null) 
            {
                String region = prodMessage.getRegion();
                Product p = prodMessage.getProductObject();
                totalProductsConsumed++;
                collectedProducts.add(prodMessage);

                System.out.println("*****************************************************************");
                System.out.println(region + " Consumer - Got Product");
                System.out.println("Summary of Product just consumed in the " + region + " region:");
                System.out.println("Product ID              :   " + prodMessage.getProductObject().getProduct_id());
                System.out.println("Product Name            :   " + prodMessage.getProductObject().getDescription());
                System.out.println("Product Manufacturer ID :   " + prodMessage.getProductObject().getManufacturer_id());
                System.out.println("Product Code            :   " + prodMessage.getProductObject().getProduct_code());
                System.out.println("Product Purchase Cost   :   " + prodMessage.getProductObject().getPurchase_cost());
                System.out.println("Consumed Time           :   " + prodMessage.getTimestamp());
                System.out.println("******************************************************************");

                try {
                    // Serializing
                    System.out.println("Serializing Data..");
                    switch (region) 
                    {
                        case "N":
                            oos1.writeObject(prodMessage.getProductObject());
                            break;
                        case "S":
                            oos2.writeObject(prodMessage.getProductObject());
                            break;
                        case "E":
                            oos3.writeObject(prodMessage.getProductObject());
                            break;
                        case "W":
                            oos4.writeObject(prodMessage.getProductObject());
                            System.out.println("The Wester Object Serialized with desciption"+prodMessage.getProductObject().description);
                            break;
                    }
                    System.out.println("Serialization Complete.");
                    
                } catch (IOException ex) 
                {
                    Logger.getLogger(ProductConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try 
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) 
            {
                System.out.println("Error: " + e);
            }

        }
    }
       
}
