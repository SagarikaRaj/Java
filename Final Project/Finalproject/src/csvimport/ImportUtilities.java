

package csvimport;

import connector.JdbcUtilities;
import Domain.DayLightRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sagarika
 */
public class ImportUtilities
{
    
       public static ArrayList buildDayLightRecordsList(List dayLightRecords) 
       {
           //reading from the csv file
           ArrayList <DayLightRecord> daylightRecord = new ArrayList<>();
           int dayLength;
           try
           {
                BufferedReader buffRead = null;
                // Read data in from CSV file...
                buffRead = new BufferedReader(new FileReader("data/sunrise-sunset.csv"));
                String line = null;
                int day = 0 , month = 0 ,tokenNo = 0;
            
                //creating 12 arraylists for each months data
                DayLightRecord[] january= new DayLightRecord[31];
                DayLightRecord[] february = new DayLightRecord[28];
                DayLightRecord[] march = new DayLightRecord[31];
                DayLightRecord[] april= new DayLightRecord[30];
                DayLightRecord[] may= new DayLightRecord[31];
                DayLightRecord[] june= new DayLightRecord[30];
                DayLightRecord[] july = new DayLightRecord[31];
                DayLightRecord[] august = new DayLightRecord[31];
                DayLightRecord[] september = new DayLightRecord[30];
                DayLightRecord[] october= new DayLightRecord[31];
                DayLightRecord[] november= new DayLightRecord[30];
                DayLightRecord[] december= new DayLightRecord[31]; 
            
                while ((line = buffRead.readLine()) != null)
                {
                day ++ ;
                line = line.replace(",,", ",9999,");
                line = line.replace(",,", ",9999,");
                                                                
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
                    }
                    
                    if(nextToken.length()> 2 )
                    {
                    java.util.Date sunSet = new java.util.Date();
                    java.util.Date sunRise= new java.util.Date();
                    if(nextToken.equals("9999"))
                    {  
                       nextToken=stringToken.nextToken();
                       tokenNo++;
                    }
                    else
                    {    
                    //Calculating hour and minute    
                    String hour = nextToken.substring(0, (nextToken.length() - 2)); 
                    String minute = nextToken.substring((nextToken.length()-2),nextToken.length()); 
                        
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2013, (month-1), day, Integer.valueOf(hour), Integer.valueOf(minute));
                    sunRise = calendar.getTime();
                    
                    nextToken=stringToken.nextToken();
                    tokenNo++;
                    hour = nextToken.substring(0, (nextToken.length() - 2)); 
                    minute = nextToken.substring((nextToken.length()-2),nextToken.length()); 
                    
                    calendar.set(2013, (month-1), day, Integer.valueOf(hour), Integer.valueOf(minute));
                    sunSet=calendar.getTime();
              
                    DayLightRecord oneDay = new DayLightRecord(sunRise, sunSet);
                    
                    int i;
                    
                     switch(month)
                     {
                        case 1:
                            i = 0;
                            while(january[i]!=null)
                            {   i++; }
                            january[i]=oneDay;
                            dayLength = january[i].calculateDay(sunSet,sunRise);  //calculating dayLength
                            january[i].setDayLength(dayLength);
                            break;         
                            
                        case 2:
                            i = 0;
                            while(february[i]!=null)
                            {   i++; }
                            february[i]=oneDay;
                            dayLength = february[i].calculateDay(sunSet,sunRise); 
                            february[i].setDayLength(dayLength);
                            break;   
                            
                        case 3:
                            i = 0;
                            while(march[i]!=null)
                            {   i++; }
                            march[i]=oneDay;
                            dayLength = march[i].calculateDay(sunSet,sunRise); 
                            march[i].setDayLength(dayLength);
                            break;  
                        case 4:
                            i = 0;
                            while(april[i]!=null)
                            {   i++; }
                            april[i]=oneDay;
                            dayLength = april[i].calculateDay(sunSet,sunRise); 
                            april[i].setDayLength(dayLength);
                            break;  
                        case 5:
                            i = 0;
                            while(may[i]!=null)
                            {   i++; }
                            may[i]=oneDay;
                            dayLength = may[i].calculateDay(sunSet,sunRise); 
                            may[i].setDayLength(dayLength);
                            break;  
                            
                        case 6:
                             i = 0;
                            while(june[i]!=null)
                            {   i++; }
                            june[i]=oneDay;
                            dayLength = june[i].calculateDay(sunSet,sunRise); 
                            june[i].setDayLength(dayLength);
                            break;  
                        case 7:
                            i = 0;
                            while(july[i]!=null)
                            {   i++; }
                            july[i]=oneDay;
                            dayLength = july[i].calculateDay(sunSet,sunRise); 
                            july[i].setDayLength(dayLength);
                            break;
                        case 8:
                            i = 0;
                            while(august[i]!=null)
                            {   i++; }
                            august[i]=oneDay;
                            dayLength = august[i].calculateDay(sunSet,sunRise); 
                            august[i].setDayLength(dayLength);
                            break;
                        case 9:
                            i = 0;
                            while(september[i]!=null)
                            {   i++; }
                            september[i]=oneDay;
                            dayLength = september[i].calculateDay(sunSet,sunRise); 
                            september[i].setDayLength(dayLength);
                            break;
                        case 10:
                            i = 0;
                            while(october[i]!=null)
                            {   i++; }
                            october[i]=oneDay;
                            dayLength = october[i].calculateDay(sunSet,sunRise); 
                            october[i].setDayLength(dayLength);
                            break;
                        case 11:
                            i = 0;
                            while(november[i]!=null)
                            {   i++; }
                            november[i]=oneDay;
                            dayLength = november[i].calculateDay(sunSet,sunRise); 
                            november[i].setDayLength(dayLength);
                            break;
                        case 12:
                            i = 0;
                            while(december[i]!=null)
                            {   i++; }
                            december[i]=oneDay;
                            dayLength = december[i].calculateDay(sunSet,sunRise); 
                            december[i].setDayLength(dayLength);
                            break;
                        default:System.out.println("Some problem with writing data into Arrays");
                            break;
                   }//end of switch
                  }//end of else 
                     
                }//end of if
               }//end of while
        }
            //loading the daylightRecord list with a month's data in every row
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
        int nightLength;
        for(i=0;i<daylightRecord.size()-1;i++)
        { 
           nightLength = daylightRecord.get(i).calculateNight(daylightRecord.get(i+1).getSunrise(), daylightRecord.get(i).getSunset());
           daylightRecord.get(i).setNightLength(nightLength);
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
  

    public static void displayDayLightRecordContents(List<DayLightRecord> dayLightRecords)
    {
        System.out.println("Display the records read..........");
        
        for (DayLightRecord pr : dayLightRecords)
        {
            System.out.println(pr.toString());
        }
    }

    public static void createAndLoadDatabaseTables(List<DayLightRecord> dayLightRecords)
    {
        StringBuffer sb1 = null;
        StringBuffer sb2 =null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JdbcUtilities.startConnection();
            //reinitialization of the table...........
            
            try 
            {
                stmt = conn.createStatement();
                stmt.execute("DROP TABLE DAYLIGHTRECORD;");
            } 
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
                System.out.println("No such table exists... ");
            }
            //table creation
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE DAYLIGHTRECORD (sunrise timestamp,sunset timestamp,daylength int,nightlength int);");
            System.out.println("Table created");
            JOptionPane.showMessageDialog(null, "Table Created");
            
            Date date = new Date();
            SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            
            //insertion of records
            for (DayLightRecord daylight : dayLightRecords) 
            {
                sb1 = new StringBuffer();
                
                sb1.append("insert into daylightrecord values('");
                sb1.append(simpledate.format(daylight.getSunrise())).append("','");
                sb1.append(simpledate.format(daylight.getSunset())).append("',");
                sb1.append(daylight.getDayLength()).append(",");
                sb1.append(daylight.getNightLength()).append(");");
                
                System.out.println("insert statement"+ sb1.toString());
                
                stmt = conn.createStatement();
                stmt.execute(sb1.toString());
            }
            //update the records with daylength
            /*sb2 = new StringBuffer();
            sb2.append("update DAYLIGHTRECORD set daylength = UNIX_TIMESTAMP(sunset)-UNIX_TIMESTAMP(sunrise);");
            stmt = conn.createStatement();
            stmt.execute(sb2.toString());*/
           
            System.out.println("Insert successful");
            JOptionPane.showMessageDialog(null, "Insert Successful!");
           
        } 
          catch (SQLException ex) 
          {
            System.out.println("SQL INSERT fail !");
            JOptionPane.showMessageDialog(null, "Insert Failed!");
            System.out.println(ex.getMessage());
          }
          JdbcUtilities.closeStatement(stmt);
          JdbcUtilities.closeConnection(conn);
    }
    
    public static boolean  sql_exec(String query)
    {
       //connecting to the DB and executing the query
        boolean result =  false;
        try
        {      
            Connection  conn = JdbcUtilities.startConnection();
            Statement  stmt = conn.createStatement();
            stmt.execute(query);
            result = true;
        } 
        catch (SQLException ex) 
        {
                System.out.println(ex.getMessage());
                System.out.println("unsuccessful operation");
        }
       System.out.println("in sql_exec before returning"); 
       return result;
    }
          
  public static ArrayList<String> getlistofnames()
  {
        //displying all records
        ArrayList<String> list = new ArrayList();
        ResultSet rs=null;
        Statement stmt = null;
        Connection conn = null;
        try
        {   
            conn = JdbcUtilities.startConnection();
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT DATE_FORMAT(sunrise,'%m-%d-%Y') FROM DAYLIGHTRECORD;");
            while(rs.next())
            {
                list.add(rs.getObject(1).toString());            
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Unable to exec MySQL statement");
        }
       
        JdbcUtilities.closeStatement(stmt);
        JdbcUtilities.closeConnection(conn);
        return list;
    }
/*public static ArrayList<String> getlistofcolumns()
{
ArrayList<String> list = new ArrayList();
        ResultSet rs=null;
        Statement stmt = null;
        Connection conn = null;
        try{
            
            conn = JdbcUtilities.startConnection();
            
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT *  FROM DAYLIGHTRECORD;");
            while(rs.next()){
                list.add(rs.getObject(1).toString());            
            }
        }
        catch (SQLException ex){
            System.out.println("Unable to exec MySQL statement");
        }
       
        JdbcUtilities.closeStatement(stmt);
        JdbcUtilities.closeConnection(conn);
        return list;
    

    }*/
}

