/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.sitsiplassaaja.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Iiro
 */
public class ui extends Application{
    public void start(Stage ikkuna1)throws Exception{
        
        Database database = new Database("jdbc:sqlite:sitsit.db");       
        SitsaajaDao sitsaajadao = new SitsaajaDao(database);
        Sitsaaja uusi = new Sitsaaja("nimi","avec","pst");
        
        BorderPane alkuruutu = new BorderPane();
        Label nimi = new Label("Sitsiplassaaja");
        nimi.setFont(Font.font("Verdana", FontPosture.ITALIC,20));
        
        HBox tiedot = new HBox();
        tiedot.setPadding(new Insets(20,20,20,20));
        tiedot.setSpacing(10);
        VBox nappulat = new VBox();
        
        TextField nimet = new TextField();
        TextField avec = new TextField();
        TextField poytaseuratoive = new TextField();
        Label nimett = new Label("Nimi (etunimi sukunimi):");
        Label avect = new Label("Avec (etunimi sukunimi):");
        Label pst = new Label ("Pöytäseuratoive (etunimi sukunimi):");
        
        Button generoi = new Button ("Generoi plassi");
        Button tallenna = new Button ("Tallenna");
        Button lopeta = new Button("Lopeta");
        
        tiedot.getChildren().addAll(nimett, nimet, avect, avec, pst, poytaseuratoive);
        nappulat.getChildren().addAll(tallenna, generoi, lopeta);
        
        alkuruutu.setTop(nimi);
        alkuruutu.setBottom(nappulat);
        alkuruutu.setCenter(tiedot);
        
        lopeta.setOnMouseClicked((event) -> {
            System.exit(0);
        });
        
        generoi.setOnMouseClicked((event) ->{
            
        });
        
        tallenna.setOnMouseClicked((event) ->{                                    
           if(nimett.getText().isEmpty()){
              
           } else if(avect.getText().isEmpty()){
               
           } else if(pst.getText().isEmpty()){
               
           } else {
               uusi.setNimi(nimet.getText());
               uusi.setAvec(avect.getText());
               uusi.setToive(pst.getText());
               try {
                   sitsaajadao.saveOrUpdate(uusi);
               } catch (SQLException ex) {
                   Logger.getLogger(ui.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        Scene nakyma1 = new Scene(alkuruutu);
        
        ikkuna1.setScene(nakyma1);
        ikkuna1.show();
    }
}
