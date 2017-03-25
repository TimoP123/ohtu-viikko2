
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    public StatisticsTest() {
    }
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
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
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    
    @Test
    public void searchPalauttaaOikeanPelaajan() {
        Player kurri = stats.search("Kurri");
        assertEquals("Kurri", kurri.getName());
    }
    
    @Test
    public void josPelaajaaEiOleOlemassaPalautetaanNull() {
        Player olematon = stats.search("Oskari");
        assertEquals(null, olematon);
    }
    
    @Test
    public void tiimiHakuPalauttaaOikeanMaaranPelaajia() {
        List<Player> edm = stats.team("EDM");
        assertEquals(3, edm.size());
    }

    @Test
    public void topScorersHakuToimii() {
        List<Player> top = stats.topScorers(3);
        assertEquals("Gretzky", top.get(0).getName());
        assertEquals("Lemieux", top.get(1).getName());
        assertEquals("Yzerman", top.get(2).getName());
    }
}
