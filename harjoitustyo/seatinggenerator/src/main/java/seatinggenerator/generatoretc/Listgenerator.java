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
    private List<Participant> withall;
    
    public Listgenerator(List<Participant> input) {
        this.all = new ArrayList<Participant>(input);
        this.alone = new ArrayList<Participant>();
        this.withavec = new ArrayList<Participant>();
        this.withwish = new ArrayList<Participant>();
        this.withall = new ArrayList<Participant>();
    }
    
    public List aloneList() {
        withallList();
        withavecList();
        withwishList();
        for (int i = 0; i < all.size(); i++) {
            
            this.alone.add(all.get(i));
            this.all.remove(i);
            
        }        
        return this.alone;
    }
    
    public List withavecList() { 
        withallList();
        for (int i = 0; i < all.size(); i++) {
            
                for (int i2 = 0; i2 < all.size(); i2++) {
                    if (all.get(i).getAvec().equals(all.get(i2).getName()) && all.get(i2).getAvec().equals(all.get(i).getName()) && !all.get(i).getAvec().equals("Empty") && all.get(i).getWish().equals("Empty")) {
                        this.withavec.add(all.get(i));
                        this.withavec.add(all.get(i2));
                        Participant remove1 = all.get(i);
                        Participant remove2 = all.get(i2);
                        this.all.remove(remove1);
                        this.all.remove(remove2); 
                    }             
                }
                       
        }        
        return this.withavec;
    }
    
    public List withwishList() {
        withallList();
        for (int i = 0; i < all.size(); i++) {
                for (int i2 = 0; i2 < all.size(); i2++) {
                    if (all.get(i).getWish().equals(all.get(i2).getName()) && all.get(i2).getWish().equals(all.get(i).getName()) && all.get(i).getAvec().equals("Empty") && !all.get(i).getWish().equals("Empty")) {
                        this.withwish.add(all.get(i));
                        this.withwish.add(all.get(i2));
                        Participant remove1 = all.get(i);
                        Participant remove2 = all.get(i2);
                        this.all.remove(remove1);
                        this.all.remove(remove2);                      
                    }           
                }                   
        }           
        return this.withwish;
    }
    
    public List withallList() {       
        for (int i = 0; i < all.size(); i++) {            
                for (int i2 = 0; i2 < all.size(); i2++) {
                    for (int i3 = 0; i3 < all.size(); i3++) {
                        if (all.get(i).getAvec().equals(all.get(i2).getName()) && all.get(i).getWish().equals(all.get(i3).getName()) &&  all.get(i3).getWish().equals(all.get(i).getName()) && all.get(i2).getAvec().equals(all.get(i).getName()) && !all.get(i).getAvec().equals("Empty") && !all.get(i).getWish().equals("Empty")) {                                                
                            this.withall.add(all.get(i3));
                            this.withall.add(all.get(i));
                            this.withall.add(all.get(i2));                        
                            Participant remove1 = all.get(i);
                            Participant remove2 = all.get(i2);
                            Participant remove3 = all.get(i3);
                            this.all.remove(remove1);
                            this.all.remove(remove2);
                            this.all.remove(remove3);                         
                    }                   
                }
            }
        }           
        return withall;
    }
}
