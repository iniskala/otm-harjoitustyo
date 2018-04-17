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
    private String nimi;
    private String avec;
    private String toive;
    
    public Participant(String nimi, String avec, String toive) {
        this.nimi = nimi;
        this.avec = avec;
        this.toive = toive;
    }
    public Participant(Integer id, String nimi, String avec, String toive) {
        this.id = id;
        this.nimi = nimi;
        this.avec = avec;
        this.toive = toive;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String getAvec() {
        return this.avec;
    }
    
    public String getToive() {
        return this.toive;
    }
    public void setNimi(String uusi) {
        this.nimi = uusi;
    }
    public void setAvec(String uusi) {
        this.avec = uusi;
    }
    public void setToive(String uusi) {
        this.toive = uusi;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String toString(){
        return "Participant: " + this.nimi + ", avec: " + this.avec + ", wish: " + this.toive;
    }
}
