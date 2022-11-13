package StartAtGoogle.week1.objecs;

import StartAtGoogle.utils.Names;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private static Team team;

    @BeforeAll
    static void setup(){
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("GK",1);
        hmFormation.put("Defense",4);
        hmFormation.put("Middlefiled",4);
        hmFormation.put("Attack",3);
        String s2 = "src\\main\\java\\StartAtGoogle\\utils\\realNames2.txt";
        ArrayList<String> names2 =  Names.fileNameReader(s2);
        Names name = new Names(names2);
        team = Team.makeTeam(hmFormation, "Barcelona",name);
    }

    @BeforeEach
    void restart(){
        setup();
    }

    @AfterAll
    static void reset(){
        team=null;
    }
    @Test
    void getName() {
        assertEquals(team.getName(),"Barcelona");
    }

    @Test
    void setName() {
        team.setName("Real Madrid");
        assertEquals(team.getName(),"Real Madrid");
    }

    @Test
    void getMyTeam() {

    }

    @Test
    void setMyTeam() {
        ArrayList<FootballPlayer> myTeam = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            FootballPlayer p;
            p = FootballPlayer.newPlayer("kobe"+i,i,i,"GK");
            if (i>0 && i<4) p = FootballPlayer.newPlayer("kobe"+i,i,i,"Defense");
            if (i>4 && i<8) p = FootballPlayer.newPlayer("kobe"+i,i,i,"Middlefiled");
            if (i>8) p = FootballPlayer.newPlayer("kobe"+i,i,i,"baba");
            myTeam.add(p);
        }
        assertNotEquals(team.toString(),myTeam.toString());
        team.setMyTeam(myTeam);
        for (int i = 0; i < 11; i++) {
            assertEquals(myTeam.get(i),team.getMyTeam().get(i));
        }
    }

    @Test
    void makeTeam_tooManyPlayes_null() {
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("GK",1);
        hmFormation.put("Defense",4);
        hmFormation.put("Middlefiled",4);
        hmFormation.put("Attack",8);
        String s2 = "src\\main\\java\\StartAtGoogle\\utils\\realNames2.txt";
        ArrayList<String> names2 =  Names.fileNameReader(s2);
        Names name = new Names(names2);
        assertNull(Team.makeTeam(hmFormation, "Barcelona",name));
    }
    @Test
    void makeTeam_noGK_null() {
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("kk",1);
        hmFormation.put("Defense",4);
        hmFormation.put("Middlefiled",4);
        hmFormation.put("Attack",8);
        String s2 = "src\\main\\java\\StartAtGoogle\\utils\\realNames2.txt";
        ArrayList<String> names2 =  Names.fileNameReader(s2);
        Names name = new Names(names2);
        assertNull(Team.makeTeam(hmFormation, "Barcelona",name));
    }

    @Test
    void makeTeam_notGoodMapTooMuch_null() {
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("GK",1);
        hmFormation.put("Defense",4);
        hmFormation.put("Middlefiled",4);
        hmFormation.put("Attack",8);
        hmFormation.put("Attac56k",5);
        String s2 = "src\\main\\java\\StartAtGoogle\\utils\\realNames2.txt";
        ArrayList<String> names2 =  Names.fileNameReader(s2);
        Names name = new Names(names2);
        assertNull(Team.makeTeam(hmFormation, "Barcelona",name));
    }

    @Test
    void makeTeam_onlyTowPositions_null() {
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("GK",1);
        hmFormation.put("Defense",4);
        String s2 = "src\\main\\java\\StartAtGoogle\\utils\\realNames2.txt";
        ArrayList<String> names2 =  Names.fileNameReader(s2);
        Names name = new Names(names2);
        assertNull(Team.makeTeam(hmFormation, "Barcelona",name));
    }
    @Test
    void testToString() {
        StringBuilder ans = new StringBuilder();
        ans.append("My team name is:").append(team.getName()).append("\n");
        for (FootballPlayer fp: team.getMyTeam()){
            ans.append("[Position: ").append(fp.getPosition()).append(", Name:").append(fp.getName());
            ans.append(", Jersey: ").append(fp.getJersey()).append(", Grade:").append(fp.getGrade()).append("]\n");
        }
        assertEquals(ans.toString(),team.toString());
    }

    @Test
    void printToFile() {
        String s = team.toString();
        assertTrue(Team.printToFile(s));
    }
}