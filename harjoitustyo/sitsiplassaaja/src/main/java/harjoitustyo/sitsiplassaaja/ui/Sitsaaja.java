/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.sitsiplassaaja.ui;

/**
 *
 * @author nendeo
 */
public class Sitsaaja {
    private Integer id;
    private String nimi;
    private String avec;
    private String toive;
    
    public Sitsaaja(String nimi,String avec, String toive){
        this.nimi=nimi;
        this.avec=avec;
        this.toive=toive;
    }
    public Sitsaaja(Integer id, String nimi,String avec, String toive){
        this.nimi=nimi;
        this.avec=avec;
        this.toive=toive;
    }
    
    public String getNimi(){
        return this.nimi;
    }
    
    public String getAvec(){
        return this.avec;
    }
    
    public String getToive(){
        return this.toive;
    }
    public void setNimi(String uusi){
        this.nimi= uusi;
    }
    public void setAvec(String uusi){
        this.avec=uusi;
    }
    public void setToive(String uusi){
        this.toive=uusi;
    }
    public void setId(Integer id) {
        this.id=id;
    }
    
    public Integer getId() {
        return id;
    }
    
    
}
