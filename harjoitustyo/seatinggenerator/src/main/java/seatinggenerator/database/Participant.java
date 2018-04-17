/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.database;

/**
 *
 * @author nendeo
 */
public class Participant {
    private Integer id;
    private String name;
    private String avec;
    private String wish;
    
    public Participant(String nimi, String avec, String toive) {
        this.name = nimi;
        this.avec = avec;
        this.wish = toive;
    }
    public Participant(Integer id, String nimi, String avec, String toive) {
        this.id = id;
        this.name = nimi;
        this.avec = avec;
        this.wish = toive;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAvec() {
        return this.avec;
    }
    
    public String getWish() {
        return this.wish;
    }
    public void setName(String newone) {
        this.name = newone;
    }
    public void setAvec(String newone) {
        this.avec = newone;
    }
    public void setWish(String newone) {
        this.wish = newone;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Participant: " + this.name + ", avec: " + this.avec + ", wish: " + this.wish;
    }
}
