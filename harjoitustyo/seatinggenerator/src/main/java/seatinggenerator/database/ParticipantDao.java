/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.database;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * Tietokannan kanssa kommunikoimisen hoitava luokka.
 */
public class ParticipantDao implements Dao<Participant, Integer> {
    private Database database;
    
    public ParticipantDao(Database database) {
        this.database = database;
    }
    
    
    
    /**
    *
    * Etsii tietyn henkilön tietokannasta.
    */
    @Override
    public Participant findOne(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sitsit WHERE id = ?");
        stmt.setInt(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Participant s = new Participant(rs.getInt("id"), rs.getString("nimi"),
            rs.getString("avec"), rs.getString("toive"));
  
        stmt.close();
        rs.close();

        conn.close();

        return s;
    }

    /**
    *
    * Etsii kaikki henkilöt tietokannasta.
    */
    @Override
    public List<Participant> findAll() throws SQLException {
        List<Participant> participant = new ArrayList<>();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Sitsit");

        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String name = rs.getString("nimi");
            String avec = rs.getString("avec");
            String wish = rs.getString("toive");
            participant.add(new Participant(id, name, avec, wish));
                


                
        }
        rs.close();

        return participant;
    }

    /**
    *
    * Tallentaa tai päivittää henkilön tiedot tietonkantaan.
    */
    @Override
    public Participant saveOrUpdate(Participant sitsaaja) throws SQLException {
        Connection conn = database.getConnection();

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Sitsit (nimi, avec, toive) VALUES (?,?,?)");

        stmt.setString(1, sitsaaja.getName());
        stmt.setString(2, sitsaaja.getAvec());
        stmt.setString(3, sitsaaja.getWish());
        stmt.executeUpdate();
                
        PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Sitsit WHERE nimi = ?");
        stmt2.setString(1, sitsaaja.getName());
                
        ResultSet rs = stmt2.executeQuery();
        sitsaaja.setId(rs.getInt("id"));
                
                
        conn.close();    
        

        return sitsaaja;
    }

    /**
    *
    * Poistaa tietyn henkilön tietokannasta.
    */
    @Override
    public void delete(Integer key) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM Sitsit WHERE id = ?");

        stmt.setInt(1, key);
        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }
    
}
