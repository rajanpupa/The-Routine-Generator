/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import java.io.*;

/**
 *
 * @author power
 */
public class WriteToFile {
    
    private static void writeStringToFile(String file, String message) throws FileNotFoundException{
        PrintWriter out=new PrintWriter(file);
        out.println(message);
    }
    
    public static void writeToFile(String file, String message){
            BufferedWriter writer = null;
        try
        {
                writer = new BufferedWriter( new FileWriter( file));
                writer.write( message);

        }
        catch ( IOException e)
        {
        }
        finally
        {
                try
                {
                        if ( writer != null)
                                writer.close( );
                }
                catch ( IOException e)
                {
                }
     }

    }
}
