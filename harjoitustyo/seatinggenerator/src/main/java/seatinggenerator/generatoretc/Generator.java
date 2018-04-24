/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.generatoretc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import seatinggenerator.database.Database;
import seatinggenerator.database.Participant;
import seatinggenerator.database.ParticipantDao;

/**
 *
 * @author Iiro
 */
public class Generator {
    private ParticipantDao help;
    public void seatingSave(ParticipantDao database1) throws IOException, ClassNotFoundException, SQLException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.help = new ParticipantDao(database);
        List<Participant> list1 = help.findAll();
        
        FileWriter writer = new FileWriter("Seat_map.csv");
        
        for (int i = 0; i < list1.size(); i++) {
            if (i == (list1.size() / 2)) {
                writer.append("\n");
            }
            writer.append(list1.get(i).getName() + ";");
            
            
        }
        writer.flush();
        writer.close();
        
    }
    public Integer numberOfParticipants() throws SQLException, ClassNotFoundException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.help = new ParticipantDao(database);
        List<Participant> list1 = help.findAll();
        return list1.size();
    }
    
}
