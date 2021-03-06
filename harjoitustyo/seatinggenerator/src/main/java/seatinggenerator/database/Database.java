/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * Luo yhteyden tietokantaan ja mahdollisesti luo sen.
 */
public class Database {
    private String databaseAddress;

    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
    
    /**
    *
    * Valmistelee tai luo tietokannan.
    */
    public void init() {
        List<String> commands = sqliteCommands();
    
        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();

            for (String command : commands) {
                System.out.println("Running command >> " + command);
                st.executeUpdate(command);
            }

        } catch (Throwable t) {
            System.out.println("Error >> " + t.getMessage());
        }
    }
    
    /**
    *
    * Tallennetut tietokanta komennot.
    */
    private List<String> sqliteCommands() {
        ArrayList<String> lista = new ArrayList<>();

        lista.add("CREATE TABLE IF NOT EXISTS Sitsit(id integer PRIMARY KEY, nimi varchar(200), avec varchar(200), toive varchar(200));");
        
        return lista;
    }
}
