package StartAtGoogle.week1.objecs;
import StartAtGoogle.utils.Names;

import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        // Creating an empty HashMap
        HashMap<String,Integer> hmFormation = new HashMap<String,Integer>();
        // Mapping position with amount of players per position
        hmFormation.put("GK",1);
        hmFormation.put("Defense",4);
        hmFormation.put("Middlefiled",4);
        hmFormation.put("Attack",3);
        try {
            String s1 = "src\\main\\java\\StartAtGoogle\\Utils\\realNames1.txt";
            String s2 = "src\\main\\java\\StartAtGoogle\\Utils\\realNames2.txt";
            // choose from s1 or s2 to use Dependency Injection.
            ArrayList<String> names2 =  Names.fileNameReader(s2);
            Names name = new Names(names2);
            Team fp = Team.makeTeam(hmFormation, "Barcelona",name);
            assert fp != null;
            System.out.println(fp.toString()); // print team players to terminal
            Team.printToFile(fp.toString()); // send team to string to print the team players
        }
        catch (Exception e){
            System.out.println("Wrong input was entered, try again :)");
        }
    }
}
