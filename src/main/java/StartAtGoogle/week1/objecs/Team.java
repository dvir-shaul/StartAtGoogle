package StartAtGoogle.week1.objecs;

import StartAtGoogle.utils.*;
import java.util.*;

public class Team {
    public String name;
    private ArrayList<FootballPlayer> myTeam;

    private Team() {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<FootballPlayer> getMyTeam() {
        return myTeam;
    }
    public void setMyTeam(ArrayList<FootballPlayer> myTeam) {
        this.myTeam = myTeam;
    }

    /**
     * This method construct new Team based on the  static factory methods technique.
     * @param map of formation to build the team
     * @param strName name of the team
     * @param name object that contains an ArrayList of names
     * @return Object of Team
     */
    public static Team makeTeam(HashMap<String,Integer> map,String strName, Names name){
        // First check now for wrong input so we cant create the team
        try{
            for (Map.Entry<String,Integer> pair : map.entrySet()) {
                if(map.size() > 4){
                    return null;
                }
                int key = pair.getValue();
                if(key<1 ||
                        key>6 ||
                        (pair.getKey().equals("GK") && pair.getValue()>1)||
                        ((! pair.getKey().equals("GK")) && pair.getValue()<2)){
                    return null;
                }
            }

            int count=0;
            Team team = new Team();
            ArrayList<FootballPlayer> fpList = new ArrayList<FootballPlayer>();
            int[] arr = Utils.makeRandomNumbersArray(20);
            Random randI = new Random();
            Random rnd = new Random();

            for (Map.Entry<String,Integer> pair : map.entrySet()) {
                int amountOfPlayers = pair.getValue();
                String pos = pair.getKey();
                for (int i = 0; i < amountOfPlayers; i++) {
                    int y = rnd.nextInt(name.getWordList().size()); // random from size of names length
                    String playerName = name.getWordList().get(y); // randomize new name each iteration
                    int grade = randI.nextInt(100) +1;// randomize new grade each iteration between 0-100
                    // build new object FootballPlayer
                    FootballPlayer p = FootballPlayer.newPlayer(playerName,arr[count++],grade,pos);
                    fpList.add(p);
                }
            }
            // build into the object of the team
            team.setName(strName);
            team.setMyTeam(fpList);
            return team;
        }
        catch (InputMismatchException e){
            return null;
        }
    }
    public String toString(){//overriding the toString() method
        StringBuilder ans = new StringBuilder();
        ans.append("My team name is:").append(getName()).append("\n");
        for (FootballPlayer fp: getMyTeam()){
            ans.append("[Position: ").append(fp.getPosition()).append(", Name:").append(fp.getName());
            ans.append(", Jersey: ").append(fp.getJersey()).append(", Grade:").append(fp.getGrade()).append("]\n");
        }
          return ans.toString();
    }

    /**
     * Method goal is to print data of the team to a new file location
     * using the Utils.writeToFile function.
     * @param s path to file
     * @return true
     */
    public static Boolean printToFile(String s){
        Utils.writeToFile(s,"src\\main\\java\\StartAtGoogle\\week1\\objecs\\PrintMyTeam.txt");
        return true;
    }

}


/**
 * that was my implementation for previous task
 * with no input make random team
 * not good because it will generate more than 11 players objects
 */


//    public static ArrayList<FootballPlayer> createFBTeam(ArrayList<FootballPlayer> myTeam) {
//        int countGK = 0, countDef = 0, countMid = 0, countAtt = 0;
//        boolean flag = false;
//        while (myTeam.size() < 7) {
//            flag = false;
//            FootballPlayer p = genNewFB();
//            for (FootballPlayer footballPlayer : myTeam) {
//                if (p.getJersey() == footballPlayer.getJersey()) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) continue;
//            if (p.getPosition().equals("Goal Keeper") && (!(countGK > 0))) {
//                myTeam.add(p);
//                countGK++;
//            }
//            if (p.getPosition().equals("Defender") && countDef != 2) {
//                myTeam.add(p);
//                countDef++;
//            }
//            if (p.getPosition().equals("Midfielder") && countMid != 2) {
//                myTeam.add(p);
//                countMid++;
//            }
//            if (p.getPosition().equals("Attacker") && countAtt != 2) {
//                myTeam.add(p);
//                countAtt++;
//            }
//        }
//        while (myTeam.size() < 11) {
//            flag = false;
//            FootballPlayer p = genNewFB();
//            for (FootballPlayer footballPlayer : myTeam) {
//                if (p.getJersey() == footballPlayer.getJersey()) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) continue;
//            if (!p.getPosition().equals("Goal Keeper")) {
//                myTeam.add(p);
//            }
//        }
//        return myTeam;
//    }

