
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcUtilities 
{
    // Connection is made
    
    public static Connection startConnection()
    {
        Connection connect=null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/itm411DB","root","Sagarika@iit2");
        } 
        catch (SQLException ex)
        {
                ex.getMessage();
        }
        catch (ClassNotFoundException ex)
        {
            ex.getMessage();
        }
        return connect;
    }
    
    // Connection is closed
    public static void closeConnection(Connection connect)
    {
        if(connect !=null)
        {
            try 
            {
                connect.close();
            }
            catch (SQLException ex)
            {
                ex.getMessage();
            }
        }
    }
    
    //Closing the statement
    public static void closeStatement(Statement st)
    {
        if(st != null)
        {
           try
           {
                st.close();
           }
           catch(SQLException ex)
           {
              ex.getMessage();
           }
        }
    }
    
    //closing the result set
    public static void closeresultSet(ResultSet rs)
    {
        if(rs !=null)
        {
            try 
            {
                rs.close();
            }
            catch (SQLException ex)
            {
                ex.getMessage();
            }
        }
    }
}