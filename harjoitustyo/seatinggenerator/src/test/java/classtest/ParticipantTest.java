package classtest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seatinggenerator.database.Participant;

/**
 *
 * @author Iiro
 */
public class ParticipantTest {
    
    public ParticipantTest() {
    }
    
    @Before
    public void setUp() {
            
    }
    
    @Test
    public void constructorWorks() { 
        Participant test = new Participant("Jack Bauer", "Lillith Smith", "Jack Ryan");
        String answer = test.toString();
        
        assertEquals("Participant: Jack Bauer, avec: Lillith Smith, wish: Jack Ryan", answer);
    }
    
    @Test
    public void changesWork() {
        Participant test = new Participant("Jack Bauer", "Lillith Smith", "Jack Ryan");
        test.setName("Nope");
        test.setAvec("Empty");
        test.setWish("Not");
        String answer = test.toString();
        
        assertEquals("Participant: Nope, avec: Empty, wish: Not", answer);
    }
    
    @Test
    public void getWorks() {
        Participant test = new Participant(1, "Jack Bauer", "Lillith Smith", "Jack Ryan");
        String answer = test.toString();
        
        assertEquals("Participant: " + test.getName() + ", avec: " + test.getAvec() + ", wish: " + test.getWish(), answer);
    }
    @Test
    public void constructor2Works() {
        Participant test2 = new Participant(1, "Jack Bauer", "Lillith Smith", "Jack Ryan");
        
        int answer2 =test2.getId();
        
        assertEquals(1, answer2);
    }
    @Test
    public void constructor2_1Works() {
        Participant test2 = new Participant(1, "Jack Bauer", "Lillith Smith", "Jack Ryan");
        
        test2.setId(3);
        int answer2 =test2.getId();
        
        assertEquals(3, answer2);
    }
}
