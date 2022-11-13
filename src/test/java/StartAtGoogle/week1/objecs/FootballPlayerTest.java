package StartAtGoogle.week1.objecs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballPlayerTest {
    private static FootballPlayer p;
    @BeforeAll
    static void setup() {
        p = FootballPlayer.newPlayer("David", 14, 78, "Defense");
    }

    @BeforeEach
    void before(){
        setup();
    }


    @Test
    void getName() {
        assertEquals(p.getName(),("David"),"p.getName wont work");
        assertNotEquals(p.getName(),"dvir");
    }
    @Test
    void setName(){
        assertEquals(p.getName(),("David"),"p.getName wont work");
        p.setName("Rony");
        assertEquals(p.getName(),("Rony"),"p.getName wont work");
    }

    @AfterEach
    void tearDown() {
        setup();
    }

    @Test
    void getJersey() {
        assertEquals(p.getJersey(),14);
    }

    @Test
    void setJersey() {
        p.setJersey(20);
        assertEquals(p.getJersey(),20);
    }

    @Test
    void getGrade() {
        assertEquals(p.getGrade(),78);
    }

    @Test
    void setGrade() {
        p.setGrade(20);
        assertEquals(p.getGrade(),20);
    }

    @Test
    void getPosition() {
        String s = p.getPosition();
        assertEquals(s,"Defense");
    }

    @Test
    void setPosition_wrongPosition() {
        assertThrows(IllegalArgumentException.class,()-> p.setPosition("aaa"));
        String s = p.getPosition();
        assertEquals(s,"Defense");
    }

    @Test
    void newPlayer() {
        FootballPlayer np = FootballPlayer.newPlayer(p.getName(),p.getJersey(),p.getGrade(),"gg");
        assertNotNull(np);
        assertNotEquals(np.getPosition(),"gg");
        assertNotEquals(p.toString(),np.toString());
    }

    @Test
    void newPlayer_GkPosition() {
        FootballPlayer np = FootballPlayer.newPlayer(p.getName(),p.getJersey(),p.getGrade(),"GK");
        assertNotNull(np);
        assertEquals(np.getPosition(),"GK");
        assertNotEquals(p.toString(),np.toString());
    }
    @Test
    void newPlayer_MiddlefiledPosition() {
        FootballPlayer np = FootballPlayer.newPlayer(p.getName(),p.getJersey(),p.getGrade(),"Middlefiled");
        assertNotNull(np);
        assertEquals(np.getPosition(),"Middlefiled");
        assertNotEquals(p.toString(),np.toString());
    }
    @Test
    void newPlayerWithDiffPos_goodInput() {
        FootballPlayer np = FootballPlayer.newPlayerWithDiffPos("p.getName()",p.getJersey(),p.getGrade(),"Attack");
        assertNotNull(np);
        assertNotEquals(p.getPosition(),"gg");
        assertEquals("p.getName()",np.getName());
    }
    @Test
    void newPlayerWithDiffPos_badInput_nullPlayer() {
        assertThrows(IllegalArgumentException.class,()->FootballPlayer.newPlayerWithDiffPos("p.getName()"
                ,p.getJersey(),p.getGrade(),"tack"),"Not proper Position was input, need to throw");

    }
}