package StartAtGoogle.week1.objecs;

import java.io.*;
import java.util.Scanner;

public class CDonObjects {

    /**
     * 9. Spot Check read from f and write to file d only when a line that contain String str
     * @param f - file to read from
     */
    public static void writeLinesContaining(String f, String d,String str){
        boolean flag = false;
        try {
            Scanner myReader = new Scanner(new File(f));
            PrintWriter myWriter = new PrintWriter (d);
            while (myReader.hasNextLine()) {
                flag=false;
                String data = myReader.nextLine();
                String[] s = data.split(" ");
                for (String newStr: s) {
                    if (newStr.equals(str)) {
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    myWriter.println(data);
                }
            }
            myReader.close();
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        writeLinesContaining("src\\main\\java\\StartAtGoogle\\week1\\objecs\\textFile.txt",
                "src\\main\\java\\StartAtGoogle\\week1\\objecs\\newText.txt",
                "story");
    }
}
