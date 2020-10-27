/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

        
/**
 *
 * @author inkilaio
 */
public class StatisticsTest {
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void hakuToimii() {
        assertEquals("Kurri", stats.search("Kurri").getName());
    }
    
    @Test
    public void hakuPalauttaaNullJosEiLoydy() {
        assertEquals(null, stats.search("Ossi"));
    }
    
    @Test
    public void joukkueHakuToimii() {
        List <Player> joukkue = stats.team("EDM");
        assertEquals(3, joukkue.size());
    }
    
    @Test
    public void topScorersPalauttaaOikein(){
        List<Player> top = stats.topScorers(2);
        List<Player> tulos = new ArrayList<Player>();
        tulos.add(new Player("Gretzky", "EDM", 35, 89));
        tulos.add(new Player("Lemieux", "PIT", 45, 54));

        assertEquals(tulos.get(0).getName(), top.get(0).getName());
    }
}
