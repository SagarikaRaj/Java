
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mp2.domain.DaylightRecord;
import mp2.domain.PersistantObject;
import util.DataAnalytics;
import util.csvreader;


// Class to include the Main function to do all the required functionality

public class MP2 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        List daylightRecords = new ArrayList <DaylightRecord>();
        
        csvreader csvr = new csvreader();
        daylightRecords = csvr.csvread(); 
        
         // Serialize records as a aggregate...
        System.out.println("Serialize records as an aggregate");
        PersistantObject serilizable=new PersistantObject(new Date(), daylightRecords);
        csvreader.serializePersistantObj(serilizable); 
        
        // Wait 10 secs...
        try
        {
           System.out.println("Waiting 10 seconds...");
           Thread.sleep(10000);
        } 
        catch (InterruptedException ex)
        {
            System.out.println(ex);
        }     
        
        // Deserialize records back into app...
        System.out.println("Deserialize records back into app");
        PersistantObject persistantObject = csvreader.deserializePersistantObject();
        
        //calling the function for calculating shortest day
        DataAnalytics da = new DataAnalytics();
        String result1,result2,result3,result4 = null;
        result1 = da.calculateAutumnalEquinox(daylightRecords);
        System.out.println("Autumnal Equinox is :" + result1);
                
        result2 = da.calculateSummerSolstice(daylightRecords);
        System.out.println("Summer Solistice is :" + result2);
        
        result3 = da.calculateVernalEquinox(daylightRecords);
        System.out.println("Vernal Equinox is :" + result3);
        
        result1 = da.caculateWinterSolstice(daylightRecords);
        System.out.println("Winter Solistice is :" + result4);
    }
}
