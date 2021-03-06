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
import java.util.Random;
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
    private List<Participant> alone;
    private List<Participant> withavec;
    private List<Participant> withwish;
    private List<Participant> withall;
    private Listgenerator listgenerator;
    private FileWriter writer;
    private Random rnd;
    private int size;
    private int half;
    private int point;
    private int alonei;
    private int withaveci;
    private int withalli;
    private int withwishi;
    
    public Generator() throws ClassNotFoundException, SQLException, IOException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.help = new ParticipantDao(database);
        this.list1 = new ArrayList<Participant>(help.findAll());
        this.listgenerator = new Listgenerator(this.list1);        
        this.withavec = new ArrayList<Participant>(listgenerator.withavecList());
        this.withall = new ArrayList<Participant>(listgenerator.withallList());
        this.withwish = new ArrayList<Participant>(listgenerator.withwishList());
        this.alone = new ArrayList<Participant>(listgenerator.aloneList());
        this.writer = new FileWriter("Seat_map.csv");
        this.rnd = new Random();
    }
    /**
    *
    *  Alustaa metodin seatingSave muuttujat.
    */
    public void intinit() {
        this.size = list1.size();
        this.half = size / 2;
        this.point = 0;
        this.alonei = 0;
        this.withaveci = 0;
        this.withalli = 0;
        this.withwishi = 0;
    }
    /**
    *
    *  Generoi ja tallentaa istumajärjestyksen.
    * 
    */
    public void seatingSave() throws IOException, ClassNotFoundException, SQLException {
                        
        
        intinit();
        
        for (int i = 0; i < size; i++) {
            int which = rnd.nextInt(4); 
            if (half == point) {
                writer.append("\n");
                point++;
            }
            
             
            if (which == 1 && alonei < this.alone.size()) {
                writer.append(alone.get(alonei).getName() + ";");
                alonei++;
                point++;
                
            } else {
                i--;       
            }
            if (which == 2 && withaveci < this.withavec.size() && half != point + 2 && half != point + 1) {
                writer.append(withavec.get(withaveci).getName() + ";");
                withaveci++;
                point++;
                writer.append(withavec.get(withaveci).getName() + ";");
                withaveci++;
                point++;
            } else {
                i--;
                
            }
            if (which == 3 && withwishi < this.withwish.size() && half != point + 2 && half != point + 1) {
                writer.append(withwish.get(withwishi).getName() + ";");
                withwishi++;
                point++;
                writer.append(withwish.get(withwishi).getName() + ";");
                withwishi++;
                point++;
            } else if (alonei == alone.size() && half == point + 1) {
                writer.append(withwish.get(withwishi).getName() + ";");
                withwishi++;
                point++;
                writer.append("\n");
                writer.append(withwish.get(withwishi).getName() + ";");
                withwishi++;
                point++;
            } else {    
                i--;
            }
            if (which == 0 && withalli < this.withall.size() && half != point + 2 && half != point + 1 && half != point + 3) {
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
            } else if (alonei == alone.size() && half == point + 1) {
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
                writer.append("\n");
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
                writer.append(withall.get(withalli).getName() + ";");
                withalli++;
                point++;
            } else {
                i--;
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
