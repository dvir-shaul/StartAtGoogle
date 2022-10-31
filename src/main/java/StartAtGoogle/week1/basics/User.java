package StartAtGoogle.week1.basics;

import StartAtGoogle.utils.Utils;

import java.util.HashMap;
//import java.util.concurrent.ThreadLocalRandom;

public class User {

    private String name;
    private int id;
    private boolean IsActivated;

    public User(String name, int id, boolean isActivated) {
        this.name = name;
        this.id = id;
        IsActivated = isActivated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivated() {
        return IsActivated;
    }

    public void setActivated(boolean activated) {
        IsActivated = true;
    }





    static User get_user_by_ID(HashMap<Integer,User> userslist, int id1) {
        return userslist.get(id1);
    }

    static int count_activated(HashMap<Integer,User> userslist) {
        int count = 0;
        for(User user:userslist.values() ){
            if(user.IsActivated){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int userId;
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        int check = 0;
        for (int i = 0; i < 100; i++) {
            String name = Utils.generateStringName(5);//ThreadLocalRandom.current().nextInt(10));
            int id = Utils.generateIntId(5);//ThreadLocalRandom.current().nextInt(1,10));
            Boolean b = Utils.generateBoolean();
            User user = new User(name, id,b);
            users.put(user.getId(),user);
            check = user.id;
        }

        User check1 = users.get(check);
        User ans = get_user_by_ID(users, check1.getId());

        int a = count_activated(users);
        System.out.println(a);

    }

}
