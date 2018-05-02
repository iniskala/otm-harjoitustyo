/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.ui;

import java.io.IOException;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import seatinggenerator.generatoretc.Generator;
/**
 *
 * Käyttöliittymän luova luokka.
 */
public class Ui extends Application {
    
    /**
    *
    * Näkymä jossa näkyy kaikki osallistujat listana.
    */
    private Scene allParticipants() throws Exception{
        Database database = new Database("jdbc:sqlite:sitsit.db");
        
        
        ParticipantDao participantdao = new ParticipantDao(database);
        BorderPane listwindow = new BorderPane();
        Label list2 = new Label("");
        List list1 = new ArrayList<Participant>(participantdao.findAll());
        StringBuilder builder = new StringBuilder();
        
        
        
        for (int i = 0; i < list1.size(); i++){
            
            builder.append(list1.get(i).toString() + "\n");
            
        }
        
        
        list2.setText(builder.toString());
        
        
        
        listwindow.setCenter(list2);
        
        Scene scene2 =new Scene(listwindow);
        
        return scene2;
    }
    
    /**
    *
    * Aloitus näkymän luova luokka.
    * 
    */
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
        Button list = new Button("Participants");
        
        info.getChildren().addAll(name, names, avectxt, avec, wishtxt, wish);
        buttons.getChildren().addAll(save, generoi, list, exit);
        
        startwindow.setTop(name);
        startwindow.setBottom(buttons);
        startwindow.setCenter(info);
        
        exit.setOnMouseClicked((event) -> {
            System.exit(0);
        });
        
        
        Generator generator = new Generator();
        generoi.setOnMouseClicked((event) ->{
            try {
                generator.seatingSave(participantdao);
            } catch (IOException ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        list.setOnMouseClicked((event) ->{
            try {
                window1.setScene(allParticipants());
            } catch (Exception ex) {
            }
        });
        
        save.setOnMouseClicked((event) ->{                                    
            if(!names.getText().isEmpty()){
                newp.setName(names.getText());
                newp.setAvec(avec.getText());
                newp.setWish(wish.getText());
                try {
                    participantdao.saveOrUpdate(newp);
                } catch (SQLException ex) {
                    Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(avec.getText().isEmpty() && wish.getText().isEmpty()){
                avec.setText("Empty");
                wish.setText("Empty");
                newp.setName(names.getText());
                newp.setAvec(avec.getText());
                newp.setWish(wish.getText());
                try {
                    participantdao.saveOrUpdate(newp);
                } catch (SQLException ex) {
                    Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(avec.getText().isEmpty()){
                avec.setText("Empty");
                newp.setName(names.getText());
                newp.setAvec(avec.getText());
                newp.setWish(wish.getText());
                try {
                    participantdao.saveOrUpdate(newp);
                } catch (SQLException ex) {
                    Logger.getLogger(Ui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(wish.getText().isEmpty()){
                wish.setText("Empty");
                newp.setName(names.getText());
                newp.setAvec(avec.getText());
                newp.setWish(wish.getText());
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
