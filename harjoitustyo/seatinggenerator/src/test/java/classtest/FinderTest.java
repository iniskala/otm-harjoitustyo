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
import seatinggenerator.generatoretc.Finder;
import seatinggenerator.generatoretc.Generator;

/**
 *
 * @author nendeo
 */
public class FinderTest {
    private Participant testman;
    private Participant testman2;
    private Participant testman3;
    private Participant testman4;
    private Participant testman5;
    private Participant testman6;
    private Participant testman7;
    private Participant testman8;
    private Participant testman9;
    private Participant testman10;
    private Participant testman11;
    private ParticipantDao test;
    private Generator helper;
    private Finder finder;
    public FinderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() throws ClassNotFoundException, SQLException, IOException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        this.test = new ParticipantDao(database);
        this.testman = new Participant("Test1", "Test2", "Test3");
        this.testman2 = new Participant("Test2", "Test1", "Empty");
        this.testman3 = new Participant("Test3", "Empty", "Test1");
        this.testman4 = new Participant("Test4", "Empty", "Empty");
        this.testman5 = new Participant("Test5", "Empty", "Test6");
        this.testman6 = new Participant("Test6", "Empty", "Test5");    
        this.testman7 = new Participant("Test7", "Empty", "Empty");
        this.testman8 = new Participant("Test8", "Empty", "Empty");
        this.testman9 = new Participant("Test9", "Empty", "Empty");
        this.testman10 = new Participant("Test10", "Empty", "Test11");
        this.testman11 = new Participant("Test11", "Empty", "Test10");
        test.saveOrUpdate(testman);  
        test.saveOrUpdate(testman2);  
        test.saveOrUpdate(testman3);  
        test.saveOrUpdate(testman4);  
        test.saveOrUpdate(testman5);  
        test.saveOrUpdate(testman6);
        test.saveOrUpdate(testman7);  
        test.saveOrUpdate(testman8);  
        test.saveOrUpdate(testman9);  
        test.saveOrUpdate(testman10);  
        test.saveOrUpdate(testman11);
        this.helper = new Generator();
        this.finder = new Finder();
    }
    
    @After
    public void tearDown() throws SQLException {
        test.delete(testman.getId());
        test.delete(testman2.getId());
        test.delete(testman3.getId());
        test.delete(testman4.getId());
        test.delete(testman5.getId());
        test.delete(testman6.getId());
        test.delete(testman7.getId());
        test.delete(testman8.getId());
        test.delete(testman9.getId());
        test.delete(testman10.getId());
        test.delete(testman11.getId());
    }

    @Test
    public void finderWorks() throws SQLException {        
        
        
        Participant found = finder.findPerson("Test1", "Test2", "Test3");
        int answer2 = testman.getId();
        int test = found.getId();
        
        assertEquals(answer2, test);
    }
}
