/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.generatoretc;

import java.util.ArrayList;
import java.util.List;
import seatinggenerator.database.Participant;

/**
 *
 * @author nendeo
 */
public class Listgenerator {
    private List<Participant> all;
    private List<Participant> alone;
    private List<Participant> withavec;
    private List<Participant> withwish;
    
    public Listgenerator (List<Participant> input){
        this.all = new ArrayList<Participant> (input);
    }
    
    public List aloneList(){
        this.alone = new ArrayList<Participant>();
        
        for (int i = 0; i < all.size(); i++) {
            if(all.get(i).getAvec().equals("Empty") && all.get(i).getWish().equals("Empty")){
                this.alone.add(all.get(i));
            }
        }
        
        return this.alone;
    }
    
}
