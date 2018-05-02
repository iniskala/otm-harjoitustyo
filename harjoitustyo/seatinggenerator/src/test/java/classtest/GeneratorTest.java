/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classtest;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatinggenerator.database.Database;
import seatinggenerator.database.Participant;
import seatinggenerator.database.ParticipantDao;
import seatinggenerator.generatoretc.Generator;

/**
 *
 * @author nendeo
 */
public class GeneratorTest {
    private Participant testman;
    private Participant testman2;
    private Participant testman3;
    private Participant testman4;
    private Participant testman5;
    private ParticipantDao test;
    private Generator helper;
    
    public GeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.test = new ParticipantDao(database);
        this.testman = new Participant("Test1", "Test2", "Test3");
        this.testman2 = new Participant("Test2", "Test1", "Empty");
        this.testman3 = new Participant("Test3", "Test6", "Test1");
        this.testman4 = new Participant("Test4", "Empty", "Empty");
        this.testman5 = new Participant("Test5", "Empty", "Empty");
               
        this.helper = new Generator();
    }
    
    @After
    public void tearDown() throws SQLException {
        test.delete(testman.getId());
        test.delete(testman2.getId());
        test.delete(testman3.getId());
        test.delete(testman4.getId());
        test.delete(testman5.getId());
        
    }

    @Test
    public void generatingWorks() throws SQLException, ClassNotFoundException, IOException{
        test.saveOrUpdate(testman);  
        test.saveOrUpdate(testman2);  
        test.saveOrUpdate(testman3);  
        test.saveOrUpdate(testman4);  
        test.saveOrUpdate(testman5);  
         
        helper.seatingSave(test);
        
        
    }
}
