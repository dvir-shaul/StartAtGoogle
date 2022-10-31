package StartAtGoogle.utils;

import StartAtGoogle.week1.objecs.FootballPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Names {
    private final ArrayList<String> wordList;

    public Names(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    /**
     * Read from path to file with names and return list of names so the team will choose from
     * @param s path to file with real neams
     * @return ArrayList<String> with names to choose from
     */
    public static ArrayList<String> fileNameReader(String s) {
        StringBuilder data= new StringBuilder();
        try {
            File myObj = new File(s);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                 data.append(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ArrayList<String> realNames= new ArrayList<String>(Arrays.asList(data.toString().split(",")));
        return realNames;
    }

    public String toString(){//overriding the toString() method
        StringBuilder ans = new StringBuilder();
        for (String s: wordList) {
            ans.append(s + ",");
        }
        return ans.toString();
    }
}


