/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4_driver;

import domain.Record;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import utilities.JDBCUtilities;
import utilities.UtilityFunctions;

/**
 *
 * @author Sagarika
 */
public class MP4 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // Call display menu and get the user selection of CRUD operations
        
        while (true) 
        {
            UtilityFunctions.displayMenu();
            UtilityFunctions.getUserSelection(new Scanner(System.in));
        }
    }
}
