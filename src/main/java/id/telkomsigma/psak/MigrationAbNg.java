package id.telkomsigma.psak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.ibatis.jdbc.ScriptRunner;

public class MigrationAbNg {
    static void run() throws SQLException, FileNotFoundException {
        System.out.println("Migrasi PSAK versi ABNG Mulai");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Lakukan proses restore[Y] = ");
        String doRestore = userInput.next();
        if (doRestore == "Y") {
            // restoreDatabase();
        }
        // alterTable();
        // updateData();
        validasi();
        System.out.println("Migrasi PSAK versi ABNG Selesai ");

        System.out.println("Update data");

        System.out.println("Sinkronisasi data ke core");

    }

    static void restoreDatabase() {
        System.out.println("1. Restore");
                
    }

    static void alterTable() throws FileNotFoundException {
        System.out.println("2. Alter Table");
        Connection conn = ConnectionDb.getPsakConnection();
        ScriptRunner sr = new ScriptRunner(conn);
        // Creating a reader object
        Reader reader = new BufferedReader(new FileReader("/home/sigma/telkomsigma/src/psak-tools/psakng_alter_table.sql"));
        // Running the script
        sr.runScript(reader);

    }

    static void updateData() {
        System.out.println("3. Update Data");
    }

    static void validasi() throws SQLException {
        System.out.println("4. Validasi");
        Connection conn = ConnectionDb.getPsakConnection();

        // parameter glie
        try {
            String sql = "SELECT * FROM md_glie";
            Statement statement;
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String ieCode = result.getString("IE_CODE");
                System.out.println(String.format(ieCode));
                String productCode = result.getString("PRODUCT_CODE");
                System.out.println(String.format(productCode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }
}
