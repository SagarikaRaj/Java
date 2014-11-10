/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import domain.Record;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Sagarika
 */
public class JDBCUtilities
{
    //CRUD - Create an Employee Record
    public static boolean createRecord() throws IOException 
    {
        Connection conn = getConnection();
        Scanner in = new Scanner(System.in);
        Record rec = null;
        try 
        {
            Statement stmt = conn.createStatement();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's ID",true);
            String id = in.nextLine();  
            utilities.UtilityFunctions.writeToFile("Enter the Employee's LAST NAME",true);
            String lastName = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's FIRST NAME",true);
            String firstName = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's EXTENSION",true);
            String extension = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's EMAIL",true);
            String email = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's OFFICE CODE",true);
            String officeCode = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the id of Employee to whom this employee REPORTS TO",true);
            String reportsTo = in.nextLine();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's JOB TITLE",true);
            String jobTitle = in.nextLine();
            
            int employeeNumber = Integer.parseInt(id);
            System.out.println("employeeNumber" +employeeNumber);
            
            String sql1 = "insert into employees values ( "+employeeNumber+",'"+lastName+"','"+firstName+"','"+extension+"',"
                    + "'"+email+"','"+officeCode+"',"+reportsTo+",'"+jobTitle+"');";
            System.out.println("Insert statement " +sql1);
            
            stmt.executeUpdate(sql1);
            
           
                rec = new Record(employeeNumber,lastName,firstName,extension,
                        officeCode,email,reportsTo,jobTitle);
            
            return true;
            
            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //CRUD - Retrieve an employee record by id
    public static Record retrieveRecord() throws IOException
    {
        Connection conn = getConnection();
        Record rec = null;
        Scanner in = new Scanner(System.in);
        try 
        {
            Statement stmt = conn.createStatement();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's id",true);
            String s1 = in.nextLine();
            String sql1 = "SELECT * from Employees where employeeNumber = "+ s1+";";
            //System.out.println("select output " +sql1 );
	    ResultSet rs = stmt.executeQuery(sql1);
            
            while (rs.next()) 
            {
                int employeeNumber = rs.getInt("employeeNumber");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String extension = rs.getString("extension");
                String email = rs.getString("email");
                String officeCode = rs.getString("officeCode");
                String reportsTo = rs.getString("reportsTo");
                String jobTitle = rs.getString("jobTitle");
                
                rec = new Record(employeeNumber,lastName,firstName,extension,
                        officeCode,email,reportsTo,jobTitle);
                
        } 
        }
        catch (SQLException ex)
        {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rec;
    }
    
    //Retrieving all Employee Records
    public static List retrieveAllRecords()
    {
        Connection conn = getConnection();
        List<Record> recList = null;
        try 
        {
            recList = new ArrayList();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employees;");
            while (rs.next()) 
            {
                int employeeNumber = rs.getInt("employeeNumber");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                String extension = rs.getString("extension");
                String email = rs.getString("email");
                String officeCode = rs.getString("officeCode");
                String reportsTo = rs.getString("reportsTo");
                String jobTitle = rs.getString("jobTitle");
                
                Record rec = new Record(employeeNumber,lastName,firstName,extension,
                        email,email,reportsTo,jobTitle);
                recList.add(rec);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try 
            {
                if(conn != null) conn.close();
            } catch (SQLException ex) 
            {
                Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        return recList;
    }
    
    //CRUD - Update a Record by id
    public static boolean updateRecord() throws IOException 
    {
        Connection conn = getConnection();
        Scanner in = new Scanner(System.in);
         Record rec = null;
         try 
         {
              Statement stmt = conn.createStatement();
              utilities.UtilityFunctions.writeToFile("Enter the Employee's ID on which you want the update",true);
              String id = in.nextLine();
              utilities.UtilityFunctions.writeToFile("Enter the field which you want to update",true);
              String updateField = in.nextLine();
              utilities.UtilityFunctions.writeToFile("Enter the update value",true);
              String updateValue = in.nextLine();
              
              String sql1 = "update employees set "+updateField+" = '"+updateValue+"' where employeeNumber  = "+ id+";";
              System.out.println("Update statement " +sql1);
              
              stmt.executeUpdate(sql1);
              return true;
         }
         catch(SQLException ex)
         {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
            return false;
         }
        
        
    }
    
    //Delete a n Employee Record by id
    public static boolean deleteRecord() throws IOException 
    {
         Connection conn = getConnection();
         Scanner in = new Scanner(System.in);
         Record rec = null;
         try 
         {
            Statement stmt = conn.createStatement();
            utilities.UtilityFunctions.writeToFile("Enter the Employee's ID",true);
            String id = in.nextLine();
            
            int employeeNumber = Integer.parseInt(id);
            System.out.println("employeeNumber" +employeeNumber);
            
            String sql1 = "delete from employees where employeeNumber  = "+ employeeNumber+";";
            System.out.println("Delete statement " +sql1);
            
            stmt.executeUpdate(sql1);
            return true;
            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //extablishing Database connection
     private static Connection getConnection() 
     {
        Connection conn = null;
        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itm411DB","root","Sagarika@iit2");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(JDBCUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
