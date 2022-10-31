package StartAtGoogle.utils;

import StartAtGoogle.week1.objecs.FootballPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Utils {

    public static String generateStringName(int num){
        String AlphaNumericStr = "abcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(num);
        for (int i=0; i<num; i++) {

            //generating a random number using math.random()

            int ch = (int)(AlphaNumericStr.length() * Math.random());

            //adding Random character one by one at the end of s
            s.append(AlphaNumericStr.charAt(ch));
        }

        return s.toString();
    }

    public static int generateIntId(int num){
        String AlphaNumericStr = "0123456789";
        StringBuilder s = new StringBuilder(num);
        for (int i=0; i<num; i++) {
            //generating a random number using math.random()
            int ch = (int)(AlphaNumericStr.length() * Math.random());
            //adding Random character one by one at the end of s
            s.append(AlphaNumericStr.charAt(ch));
        }
        return Integer.parseInt(s.toString());
    }

    public static Boolean generateBoolean(){
        Random rd = new Random(); // creating Random object
        return rd.nextBoolean();
    }

    /**
     * gets int and create a randomly shuffled array
     * @param len len of size to create an array
     * @return int[] that is shuffled
     */
    public static int[] makeRandomNumbersArray(int len){
        int[] array = new int[len];
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            l.add(i);
        }
        Collections.shuffle(l); // shuffle for randomize the order of the numbers in list
        for (int i = 0; i < array.length; i++) { // convert from
            array[i] = l.get(i);
        }
        return array;
    }


    /**
     * Method writes data to new file
     * @param f file path location to read from
     * @param d file path location to write to
     */
    public static void writeToFile(String f, String d){
        try {
            Scanner myReader = new Scanner(f);
            PrintWriter myWriter = new PrintWriter (d);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myWriter.println(data);
            }
            myReader.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static int getRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
    }
}
