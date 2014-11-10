
package domain;

import driver.MP3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

//file to read from the input data file PRODUCT_data.txt
public class Utility 
{   
    public void FileRead() throws FileNotFoundException
    {
        //String inputLine,strFile= "C:\\Sagarika\\sAGARIKA_MS\\Courses_ITM\\Courses\\mp3_bk\\MP3\\data\\PRODUCT_data.txt";
        String inputLine,strFile="data/PRODUCT_data.txt";
        StringTokenizer st=null;
        String product_id=null,manufacturer_id=null,product_code=null,
                purchase_cost=null,quantity_on_hand=null,markup=null,available=null,description=null;
        BufferedReader br = new BufferedReader( new FileReader(strFile));
        int lineNo=0;
        try 
        {
            while((inputLine=br.readLine())!=null)
            {
                inputLine=inputLine.replace("\t", ",");
                lineNo++;
                if(lineNo!=1)
                {
                    st = new StringTokenizer(inputLine,",");
                    int tokenNumber=0;
                    while(st.hasMoreTokens())
                    {
                        tokenNumber++;                
                        switch(tokenNumber)
                        {
                            case 1: product_id=st.nextToken();;
                                    break;
                            case 2: manufacturer_id=st.nextToken();;
                                    break;
                            case 3:product_code=st.nextToken();;
                                    break;
                            case 4:purchase_cost=st.nextToken();;
                                    break;
                            case 5:quantity_on_hand=st.nextToken();;
                                    break;
                            case 6: markup=st.nextToken();;
                                    break;
                            case 7: available=st.nextToken();;
                                    break;
                            case 8:description=st.nextToken();;
                                    break;
                        }
                   }
                   //System.out.println("product details from main()"+ product_id);
                   MP3.productList.add(new Product(Integer.parseInt(product_id),Integer.parseInt(manufacturer_id),product_code,Float.parseFloat(purchase_cost),Integer.parseInt(quantity_on_hand),Float.parseFloat(markup),Boolean.parseBoolean(available),description));
            }
        }
    } 
    catch (IOException ex) 
    {
       Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
    
    