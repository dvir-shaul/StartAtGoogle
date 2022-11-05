package StartAtGoogle.week3.ErrorProne;

import StartAtGoogle.week3.AutoValue.Person;

import java.util.Arrays;

public class errorprone {

    public static boolean compare(String[] firstList, String[] secondList) {
        return Arrays.equals(firstList, secondList);
    }


    public static void main(String[] args) {
        String[] shmulik = {"aaa","bbbb"};
        String[] shmulik3 = {"aaafff","bbbddddb"};

        System.out.println(compare(shmulik,shmulik3));
    }
}
