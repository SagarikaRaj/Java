/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import domain.Record;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mp4_driver.MP4;

/**
 *
 * @author Sagarika
 */
public class UtilityFunctions 
{
     static String data = ""; 

     public static void displayMenu() throws IOException 
     {
        // Create recurring command line menu...
        // Selected option will invoke an assitive method outside of this driver class...
        
        data= "Please enter choice from the following options:\n" 
                + "a - Create an Employee Record.\n"
                + "b - Retrieve an Employee Record by ID.\n"
                + "c - Retrieve all Employee Records.\n"
                + "d - Update Employee Records.\n"
                + "e - Delete Employee Records.\n"
                + "q - quit the application.\n";
        writeToFile(data,true);
     }
     //Invoking the CRUD operations based on the user input
      public static void getUserSelection(Scanner s) throws IOException 
      {
        if (s.hasNext()) 
        {
            //displayMenu();
            switch (s.next())
            {
                case "a":
                    writeToFile("a", true);
                    data = "Creating a Record...";
                    writeToFile(data,true);
                    boolean createResult = JDBCUtilities.createRecord();
                    if(createResult)
                    {
                        data = "Insert Successful";
                        writeToFile(data,true);
                    }
                    else
                    {
                        data = "Insert failed";
                        writeToFile(data,true);
                    }
                    break;
                case "b":
                    writeToFile("b",false);
                    data = "Retrieving an Employee by id...";
                    writeToFile(data,true);
                    Record record = JDBCUtilities.retrieveRecord();
                    data = record.toString();
                    //System.out.println(record);
                    writeToFile(data,true);
                    break;
                case "c":
                    writeToFile("c",false);
                    List<Record> records;
                    data = "Retrieving all Employees...";
                    writeToFile(data,true);
                    records = JDBCUtilities.retrieveAllRecords();
                    for (Record r : records)
                    {
                        writeToFile(r.toString(),true);
                    }
                    break;
                 case "d":
                    writeToFile("d",false);
                    data = "Update...";
                    writeToFile(data,true);
                    boolean updateResult = JDBCUtilities.updateRecord();
                    if(updateResult)
                    {
                        data = "Update Successful";
                        writeToFile(data,true);
                    }
                    else
                    {
                        data = "Update failed";
                        writeToFile(data,true);
                    }
                    break;
                  case "e":
                    writeToFile("e",false);  
                    data = "Delete..";
                    writeToFile(data,true);
                    boolean deleteResult = JDBCUtilities.deleteRecord();
                    if(deleteResult)
                    {    
                        data = "Delete Successful";
                        writeToFile(data,true);
                    }
                    else
                    {
                        data = "Delete failed";
                        writeToFile(data,true);
                    }
                    break;
                case "q":
                    writeToFile("q",false);
                    data = "Exiting...";
                    writeToFile(data,true);
                    System.exit(0);
                    break;
            }
            try 
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(MP4.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            s.reset();
        }
    }
    
    //function to write the System.out and system.in statements to a text file
    public static void writeToFile(String data,boolean outputFlag) throws IOException
    {
        if(outputFlag == true)
        System.out.println(data);
    
        FileWriter fileWriter = new FileWriter("docs/mp4out.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }  
}
