package id.telkomsigma.psak;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, FileNotFoundException
    {
        MigrationAbNg.run();
    }
}
