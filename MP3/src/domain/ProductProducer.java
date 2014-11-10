
package domain;

import driver.MP3;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductProducer implements Runnable
{     
    static final int QueueSize = 5;
    public static int productID = 0;
    ProductMessage productMessage ;
    public static int productCount;
    
     
    public ProductProducer() 
    {
       
    }
    
    private List<ProductMessage> productMessageList = new ArrayList<ProductMessage> ();
    
    public List<ProductMessage> getMessages() 
    {
        return productMessageList;
    }
    
    public void run()
    { 
        int index,randomNumber;
        //String randomState = "";
        
        //producinging random products with random region
        while (true) 
        {
            index = 0;
            randomNumber = (int) (MP3.productList.size() * Math.random());
            /*Product newProduct = new Product(++productID, Integer.parseInt(products[randomNumber][index++]),
                    products[randomNumber][index++],Double.parseDouble(products[randomNumber][index++]),
                    Integer.parseInt(products[randomNumber][index++]),Double.parseDouble(products[randomNumber][index++]),
                    Boolean.valueOf(products[randomNumber][index++]),products[randomNumber][index++]);*/            
            
            //reading the input file PRODUCT_data.txt
            Utility utility = new Utility();
            try 
            {
                utility.FileRead();
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(ProductProducer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //selecting random product from the array list created
            Product newProduct = new Product();
            newProduct = MP3.productList.get(randomNumber);
            
            //selecting random region
            String [] region = {"N","S","E","W"};
            Random rnd = new Random();
            int rndIndex = rnd.nextInt(4);
            
            //adding a product message
            productMessage = new ProductMessage(newProduct, new Date(),region[rndIndex]);
            putMessage(productMessage);
            try 
            {
                // Decrease sleep period to meet increasing demand / Increase period to avoid over production
                Thread.sleep(1000);
            } catch (InterruptedException e) 
            {
            }
        }
        
    }

    //adding the newly created product message into the message list
    private synchronized void putMessage(ProductMessage pMessage) 
    {
        
        while(productMessageList.size() >= QueueSize) 
        {
             try
             {
                wait();
             } 
             catch (InterruptedException e) 
             {
            
             }
            
        }
        productMessageList.add(pMessage);
        productCount++;
        System.out.println("Producer " + ((int) (Thread.currentThread().getId()) - 8) + " : 1 Unit produced for "
                + productMessage.getRegion() + " Consumers. Queue contains " + productMessageList.size() + " product(s) ");
        notify();
    }
    
    //retrieving a product message based on region
    public synchronized ProductMessage getMessage(String region) 
    {
        ProductMessage message = null;
        while (productMessageList.size() == 0) 
        {           
            try 
            {
                notify();
                wait();
            } 
            catch (InterruptedException e) 
            {
            }
        }

        if (region == productMessageList.get(0).getRegion()) 
        {
            message = ((ProductMessage) productMessageList.remove(0));
        }
        notify();
        return message;
    }

    //finding the size of productmessagelist
    public int getListSize()
    {
        return productMessageList.size();
    }    
}
