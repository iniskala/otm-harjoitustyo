/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.ui;

import seatinggenerator.database.Participant;
import seatinggenerator.database.ParticipantDao;
import seatinggenerator.database.Database;
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
public class Ui extends Application {
    public void start(Stage window1)throws Exception{
        
        Database database = new Database("jdbc:sqlite:sitsit.db");       
        ParticipantDao participantdao = new ParticipantDao(database);
        Participant newp = new Participant("name","avec","wish");
        
        BorderPane startwindow = new BorderPane();
        Label title = new Label("Sitsiplassaaja");
        title.setFont(Font.font("Verdana", FontPosture.ITALIC,20));
        
        HBox info = new HBox();
        info.setPadding(new Insets(20,20,20,20));
        info.setSpacing(10);
        VBox buttons = new VBox();
        
        TextField names = new TextField();
        TextField avec = new TextField();
        TextField wish = new TextField();
        Label name = new Label("Name (firstname lastname):");
        Label avectxt = new Label("Avec (firstname lastname):");
        Label wishtxt = new Label ("Company wishes (firstname lastname):");
        
        Button generoi = new Button ("Generate");
        Button save = new Button ("Save");
        Button exit = new Button("Exit");
        
        info.getChildren().addAll(name, names, avectxt, avec, wishtxt, wish);
        buttons.getChildren().addAll(save, generoi, exit);
        
        startwindow.setTop(name);
        startwindow.setBottom(buttons);
        startwindow.setCenter(info);
        
        exit.setOnMouseClicked((event) -> {
            System.exit(0);
        });
        
        generoi.setOnMouseClicked((event) ->{
            
        });
        
        save.setOnMouseClicked((event) ->{                                    
           if(names.getText().isEmpty()){
              
           } else if(avectxt.getText().isEmpty()){
               newp.setAvec("Empty");
           } else if(wishtxt.getText().isEmpty()){
               
           } else {
               newp.setNimi(name.getText());
               newp.setAvec(avec.getText());
               newp.setToive(wish.getText());
               try {
                   participantdao.saveOrUpdate(newp);
               } catch (SQLException ex) {
                   Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        Scene scene1 = new Scene(startwindow);
        
        window1.setScene(scene1);
        window1.show();
    }
}
