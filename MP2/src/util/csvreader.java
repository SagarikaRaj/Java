 
package util;

//code to read from CSV

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import mp2.domain.DaylightRecord;
import mp2.domain.PersistantObject;

public class csvreader 
{
    List <DaylightRecord> daylightRecord = new ArrayList<>();
    
    public  List csvread()
    {
        try
        {
            BufferedReader buffRead = null;
            buffRead = new BufferedReader(new FileReader("C:\\MP2\\src\\data\\sunrise-sunset.csv"));
            
            String line = null;
            int day = 0 , month = 0 ,tokenNo = 0;
            
            //creating 12 arraylists for each months data
            DaylightRecord[] january= new DaylightRecord[31];
            DaylightRecord[] february = new DaylightRecord[28];
            DaylightRecord[] march = new DaylightRecord[31];
            DaylightRecord[] april= new DaylightRecord[30];
            DaylightRecord[] may= new DaylightRecord[31];
            DaylightRecord[] june= new DaylightRecord[30];
            DaylightRecord[] july = new DaylightRecord[31];
            DaylightRecord[] august = new DaylightRecord[31];
            DaylightRecord[] september = new DaylightRecord[30];
            DaylightRecord[] october= new DaylightRecord[31];
            DaylightRecord[] november= new DaylightRecord[30];
            DaylightRecord[] december= new DaylightRecord[31];
            
            
            while ((line = buffRead.readLine()) != null)
            {
                day ++ ;
                
                line = line.replace(",,", ",9999,");
                line = line.replace(",,", ",9999,");
                //System.out.println(line);
                                                
                StringTokenizer stringToken = new StringTokenizer(line,",");
                
                String nextToken = new String();
                while(stringToken.hasMoreTokens())
                {
                    nextToken = stringToken.nextToken();
                    tokenNo++;
                    
                    // calculating Month value
                    if(Integer.parseInt(nextToken)!=day )
                    {   
                        month = month +1;
                        if(month ==13) {month = 1;}
                        month = month %13;
                        //System.out.println("month" + month);
                    }
                    
                    if(nextToken.length()> 2 )
                    {
                    Date sunSet = new Date();
                    Date sunRise= new Date();
                    if(nextToken.equals("9999"))
                    {
                        //System.out.println("No input to parse");
                       /*Calendar calendar = Calendar.getInstance();
                       System.out.println("month when 9999 = " + month);
                       calendar.set(2013, (month-1), day, 0, 0);
                       sunRise = calendar.getTime();
                       System.out.println("Sunrise = " + sunRise); 
                        
                       
                       calendar.set(0, 0, 0, 0, 0);
                       sunSet = calendar.getTime();;
                       System.out.println("sunSet = " + sunSet); */
                       
                       //System.out.println("tokenNo" + tokenNo) ;
                       //System.out.println(nextToken.toString());
                       nextToken=stringToken.nextToken();
                       tokenNo++;
                       //System.out.println("tokenNo" + tokenNo) ;
                       //System.out.println(nextToken.toString());
                    }
                    else
                    {    
                    //Calculating hour and minute    
                    String hour = nextToken.substring(0, (nextToken.length() - 2)); 
                    String minute = nextToken.substring((nextToken.length()-2),nextToken.length()); 
                        
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2013, (month-1), day, Integer.valueOf(hour), Integer.valueOf(minute));
                    sunRise = calendar.getTime();
                    //System.out.println("Sunrise = " + sunRise);
                    
                    nextToken=stringToken.nextToken();
                    tokenNo++;
                    hour = nextToken.substring(0, (nextToken.length() - 2)); 
                    minute = nextToken.substring((nextToken.length()-2),nextToken.length()); 
                    
                    calendar.set(2013, (month-1), day, Integer.valueOf(hour), Integer.valueOf(minute));
                    sunSet=calendar.getTime();
                    //System.out.println("sunSet = " + sunSet);
              
                    DaylightRecord oneDay = new DaylightRecord(sunRise, sunSet);
                    
                    int i;
                    
                     switch(month)
                     {
                        case 1:
                            i = 0;
                            while(january[i]!=null)
                            {   i++; }
                            january[i]=oneDay;
                            //System.out.println("The value of januarary[i] is"+january[i].getSunrise().toString());
                            january[i].calculateDay(sunSet,sunRise);  
                            //january[i].calculateNight(sunRise,sunSet); //pass sunrise of the next day 
                            break;         
                            
                        case 2:
                            i = 0;
                            while(february[i]!=null)
                            {   i++; }
                            february[i]=oneDay;
                            //System.out.println("The value of february[i] is"+february[i].getSunrise().toString());
                            february[i].calculateDay(sunSet,sunRise); 
                           // daylightRecord.add(february[i]);
                            break;   
                            
                        case 3:
                            i = 0;
                            while(march[i]!=null)
                            {   i++; }
                            march[i]=oneDay;
                            //System.out.println("The value of march[i] is"+march[i].getSunrise().toString());
                          //  daylightRecord.add(march[i]);
                            break;  
                        case 4:
                            i = 0;
                            while(april[i]!=null)
                            {   i++; }
                            april[i]=oneDay;
                            //System.out.println("The value of april[i] is"+april[i].getSunrise().toString());
                          //  daylightRecord.add(april[i]);
                            break;  
                        case 5:
                            i = 0;
                            while(may[i]!=null)
                            {   i++; }
                            may[i]=oneDay;
                            //System.out.println("The value of may[i] is"+may[i].getSunrise().toString());
                          //  daylightRecord.add(may[i]);
                            break;  
                            
                        case 6:
                             i = 0;
                            while(june[i]!=null)
                            {   i++; }
                            june[i]=oneDay;
                            //System.out.println("The value of june[i] is"+june[i].getSunrise().toString());
                         //   daylightRecord.add(june[i]);
                            break;  
                        case 7:
                            i = 0;
                            while(july[i]!=null)
                            {   i++; }
                            july[i]=oneDay;
                            //System.out.println("The value of july[i] is"+july[i].getSunrise().toString());
                          //  daylightRecord.add(july[i]);
                            break;
                        case 8:
                            i = 0;
                            while(august[i]!=null)
                            {   i++; }
                            august[i]=oneDay;
                            //System.out.println("The value of august[i] is"+august[i].getSunrise().toString());
                         //   daylightRecord.add(august[i]);
                            break;
                        case 9:
                            i = 0;
                            while(september[i]!=null)
                            {   i++; }
                            september[i]=oneDay;
                           // System.out.println("The value of september[i] is"+september[i].getSunrise().toString());
                         //   daylightRecord.add(september[i]);
                            break;
                        case 10:
                            i = 0;
                            while(october[i]!=null)
                            {   i++; }
                            october[i]=oneDay;
                            //System.out.println("The value of october[i] is"+october[i].getSunrise().toString());
                         //   daylightRecord.add(october[i]);
                            break;
                        case 11:
                            i = 0;
                            while(november[i]!=null)
                            {   i++; }
                            november[i]=oneDay;
                            //System.out.println("The value of november[i] is"+november[i].getSunrise().toString());
                          //  daylightRecord.add(november[i]);
                            break;
                        case 12:
                            i = 0;
                            while(december[i]!=null)
                            {   i++; }
                            december[i]=oneDay;
                            //System.out.println("The value of december[i] is"+december[i].getSunrise().toString());
                           // daylightRecord.add(december[i]);
                            break;
                        default:System.out.println("Some problem with writing data into Arrays");
                            break;
                   }//end of switch
                  }//end of else 
                     
                }//end of if
               }//end of while
        }
            //loading the daylightRecord list with a mnoth's data in every row
            int i;
            for(i=0;i<january.length;i++)
            {
                daylightRecord.add(january[i]);
            }
            
            for(i=0;i<february.length;i++)
            {
                daylightRecord.add(february[i]);
            }
            for(i=0;i<march.length;i++)
            {
                daylightRecord.add(march[i]);
            }
            for(i=0;i<april.length;i++)
            {
                daylightRecord.add(april[i]);
            }
            for(i=0;i<may.length;i++)
            {
                daylightRecord.add(may[i]);
            }
            for(i=0;i<june.length;i++)
            {
                daylightRecord.add(june[i]);
            }
            for(i=0;i<july.length;i++)
            {
                daylightRecord.add(july[i]);
            }
            for(i=0;i<august.length;i++)
            {
                daylightRecord.add(august[i]);
            }
            for(i=0;i<september.length;i++)
            {
                daylightRecord.add(september[i]);
            }
            for(i=0;i<october.length;i++)
            {
                daylightRecord.add(october[i]);
            }
            for(i=0;i<november.length;i++)
            {
                daylightRecord.add(november[i]);
            }
            for(i=0;i<december.length;i++)
            {
                daylightRecord.add(december[i]);
            }
            
        //setting every object with its night-length
        for(i=0;i<daylightRecord.size()-1;i++)
        { 
            daylightRecord.get(i).calculateNight(daylightRecord.get(i+1).getSunrise(), daylightRecord.get(i).getSunset());
        }
        
        System.out.println("The length of the daylight record is"+daylightRecord.size());
        
        return daylightRecord;
        }
        
        catch(Exception e)
        {
                    System.out.println("Exception" + e);
                    return null;
        }        
       
    }
    //Serializing 
     public static PersistantObject serializePersistantObj(PersistantObject serialize)
     {
        ObjectOutputStream oos;
        try 
        {
            serialize.setSerializedDate(new Date());
            oos = new ObjectOutputStream(new FileOutputStream("C:\\MP2\\src\\data\\object_csv.ser"));
            oos.writeObject(serialize);
            return serialize;
        }
        catch (IOException ex)
        {
            System.out.println(ex);
            return null;
            
        }
     }
   //Deserializing 
   public static PersistantObject deserializePersistantObject()
   {
        ObjectInputStream ois = null;
        PersistantObject deSerialize= new PersistantObject();
        try {
                ois = new ObjectInputStream(new FileInputStream("C:\\MP2\\src\\data\\object_csv.ser"));
                deSerialize = (PersistantObject)ois.readObject();
                deSerialize.setSerializedDate(new Date());
            } 
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        }
        return deSerialize;
    }
  }
            

