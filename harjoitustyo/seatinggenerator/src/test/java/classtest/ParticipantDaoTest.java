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

public class ParticipantDaoTest {
    private Participant testman;
    private ParticipantDao test;
    private Generator helper;
    
    public ParticipantDaoTest() {
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
        this.testman = new Participant("Test1", "Test1", "Test1");
        this.helper = new Generator();
        
    }
    @Test
    public void insertWorks() throws SQLException, ClassNotFoundException {
        Database database = new Database("jdbc:sqlite:sitsit.db");
        test.saveOrUpdate(testman);
        Integer answer = test.findOne(helper.numberOfParticipants() + 1 ).getId() ;
        database.init();
        assertEquals(answer, testman.getId());
        
        
    }
    
    @After
    public void tearDown() throws SQLException {
        test.delete(testman.getId());
    }
    
}
