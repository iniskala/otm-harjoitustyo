package seatinggenerator.generatoretc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seatinggenerator.database.Database;
import seatinggenerator.database.Participant;
import seatinggenerator.database.ParticipantDao;

/**
 *
 * Luokka jonka avulla voidaan etsiä tietty henkilö osallistujista.
 */
public class Finder {
    private ParticipantDao database1;
    private List<Participant> list1;
    private String name;
    private String avec;
    private String wish;
    private Participant wanted;
    
    public Finder() throws SQLException, ClassNotFoundException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.database1 = new ParticipantDao(database);
        this.list1 = new ArrayList<Participant>(database1.findAll());
        
    }
/**
 *
 * Metodi joka toteuttaa henkilön etsimisen
 * @param name etsittävän henkilön nimi
 * @param avec etsittävän henkilön avec
 * @param wish etsittävän henkilön pöytäseuratoive
 */
    public Participant findPerson(String name, String avec, String wish) {
        this.name = name;
        this.avec = avec;
        this.wish = wish;
        boolean found = false;
        
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getName().equals(name) && list1.get(i).getAvec().equals(avec) && list1.get(i).getWish().equals(wish)) {
                this.wanted = list1.get(i);
                found = true;
            }            
        }
       
        return this.wanted;
        
        
    }
    
}