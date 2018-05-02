/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatinggenerator.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;
import seatinggenerator.database.Database;
import seatinggenerator.ui.Ui;
/**
 *
 * Käynnistää ohjelman.
 */
public class Main extends Ui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
                       
        Database database = new Database("jdbc:sqlite:sitsit.db");
        database.init();
        
        launch(Ui.class);
    }
    
    
    
}
