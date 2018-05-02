/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.generatoretc;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seatinggenerator.database.Database;
import seatinggenerator.database.Participant;
import seatinggenerator.database.ParticipantDao;

/**
 *
 * Luokka hoitaa tiedoston luomisen, jossa istumajärjestys on.
 * Luokka myös generoi istumajärjestyksen.
 */
public class Generator {
    private ParticipantDao help;
    private List<Participant> list1;
    private List<Participant> withavec;

    
    public Generator() throws ClassNotFoundException, SQLException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.help = new ParticipantDao(database);
        this.list1 = new ArrayList<Participant>(help.findAll());
        this.withavec = new ArrayList<Participant>();
    }
    
    /**
    *
    *  Generoi ja tallentaa istumajärjestyksen.
    */
    public void seatingSave(ParticipantDao database1) throws IOException, ClassNotFoundException, SQLException {
                        
        FileWriter writer = new FileWriter("Seat_map.csv");
        
        
        int size = list1.size();
        int half = size / 2;
        int point = 0;
        for (int i = 0; i < list1.size(); i++) {
            
            if (half == point) {
                writer.append("\n");
            }
            
            point++;
            
            if (!withavec.isEmpty() && half != (point)) {
                for (int i3 = 0; i3 < withavec.size(); i3++) {
                    writer.append(withavec.get(i).getName());                    
                }
                withavec.clear();
            }
            
            if (!list1.get(i).getAvec().equals("Empty") && !list1.get(i).getWish().equals("Empty")) {
                for (int i4 = 0; i4 < list1.size(); i4++) {
                    if (list1.get(i4).getName().equals(list1.get(i).getAvec())) {
                        if (half == (point)) {
                            withavec.add(list1.get(i));
                            withavec.add(list1.get(i4));
                            list1.remove(i);                        
                        if (i < i4) {
                            list1.remove(i4 - 1);
                        } else {
                            list1.remove(i4);
                        }
                        i = 0;
                        break;
                        } else {
                            writer.append(list1.get(i).getName() + ";");
                            writer.append(list1.get(i4).getName() + ";");
                            list1.remove(i);                        
                            if (i < i4) {
                                list1.remove(i4 - 1);
                            } else {
                                list1.remove(i4);
                            }
                            i = 0;
                            break;
                        }
                    }
                            
                }
            }
            if (list1.get(i).getAvec().equals("Empty")) {
                if (list1.get(i).getWish().equals("Empty")) {
                    writer.append(list1.get(i).getName() + ";");
                    list1.remove(i);
                    i = 0;
                } else {
                    for (int i2 = 0; i2 < list1.size(); i2++) {
                        if (list1.get(i2).getName().equals(list1.get(i).getWish())) {                            
                            writer.append(list1.get(i).getName() + ";");
                            if (half == (point)) {
                                writer.append("\n");
                            }
                            writer.append(list1.get(i2).getName() + ";");
                            list1.remove(i);
                            if (i < i2) {
                                list1.remove(i2 - 1);
                            } else {
                                list1.remove(i2);
                            }
                            i = 0;
                            break;
                        }
                            
                    }
                    writer.append(list1.get(i).getName() + ";");
                    list1.remove(i);
                    i = 0;
                }                     
            } else if (list1.get(i).getWish().equals("Empty")) {
                for (int i2 = 0; i2 < list1.size(); i2++) {
                    if (list1.get(i2).getName().equals(list1.get(i).getAvec())) {
                        if (half == (point)) {
                            withavec.add(list1.get(i));
                            withavec.add(list1.get(i2));
                            list1.remove(i);                        
                            if (i < i2) {
                                list1.remove(i2 - 1);
                            } else {
                                list1.remove(i2);
                            }
                            i = 0;
                            break;
                        } else {
                            writer.append(list1.get(i).getName() + ";");
                            writer.append(list1.get(i2).getName() + ";");
                            list1.remove(i);                        
                            if (i < i2) {
                                list1.remove(i2 - 1);
                            } else {
                                list1.remove(i2);
                            }
                            i = 0;
                            break;
                        }
                    }
                            
                }
            }
            
            
        }
        writer.flush();
        writer.close();
        
    }
    
    /**
    *
    * Palauttaa osallistujien määrän. Auttaa muiden luokkien toimintaa.
    */
    public Integer numberOfParticipants() throws SQLException, ClassNotFoundException {
                
        return list1.size();
    }
    
}
