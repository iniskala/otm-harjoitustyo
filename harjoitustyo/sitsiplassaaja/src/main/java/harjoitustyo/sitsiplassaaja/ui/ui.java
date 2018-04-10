/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harjoitustyo.sitsiplassaaja.ui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 *
 * @author Iiro
 */
public class ui extends Application{
    public void start(Stage ikkuna1){
        BorderPane alkuruutu = new BorderPane();
        Label nimi = new Label("Sitsiplassaaja");
        nimi.setFont(Font.font("Verdana", FontPosture.ITALIC,20));
        alkuruutu.setTop(nimi);
        
        Scene nakyma1 = new Scene(alkuruutu);
        
        ikkuna1.setScene(nakyma1);
        ikkuna1.show();
    }
}
