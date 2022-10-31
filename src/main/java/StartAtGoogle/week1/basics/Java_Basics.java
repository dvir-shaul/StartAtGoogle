package StartAtGoogle.week1.basics;


import java.util.*;

public class Java_Basics {



    public static void print_int_for(int [] numbers, int num){
        for(int i=0; i<numbers.length; i++){
            int num2 = numbers[i];
            if(num2%num == 0){
                System.out.println(num2);
            }
        }
    }



    public static void print_int_foreach(int [] numbers, int num){
        for (int n : numbers) {
            if(n%num == 0){
                System.out.println(n);
            }
        }
    }

    public static void print_int_while(int [] numbers, int num){
        int j = 0;
        while (j < numbers.length){
            if(numbers[j]%num == 0){
                System.out.println(numbers[j]);
            }
            j++;
        }
    }



    public static void main(String[] args){
        int [] test = {0,1,2,3,4,5,6,7,8,9,10};
        print_int_for(test,2);
        print_int_foreach(test,2);
        print_int_while(test,2);


        int userId;
        HashMap<Integer, User> users = new HashMap<Integer,User>();





    }



}





