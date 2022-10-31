package StartAtGoogle.week1.objecs;

import StartAtGoogle.utils.Utils;

public class user2 {
    enum Country {israel, usa, england, russia}


    private String name;
    private Country country;
    private  String email;

    private user2(String n, Country c, String e) {
        this.name = n;
        this.country = c;
        this.email = e;
    }


    public static user2 newUserNoMail(String name, Country c) {
        return new user2(name , c, "....@gmail.com");
    }
    public static user2 newUserNoName(String email, Country c) {
        return new user2(Utils.generateStringName(4) , c, email);
    }

    public static user2 newUsaUser(String name, String email) {
        return new user2(name , Country.usa, email);
    }
}
