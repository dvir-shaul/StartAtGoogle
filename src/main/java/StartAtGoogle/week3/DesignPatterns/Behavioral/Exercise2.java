package StartAtGoogle.week3.DesignPatterns.Behavioral;


import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

/**
 * export to JSON program using the visitor pattern
 */
public class Exercise2 {

}


class Group implements Appliance{
    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    private final int id;
    private int size ;

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}


class Asset implements Appliance{
    private final int id;
    private final String name;
    private final double rating;
    public Asset(int id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}


class User implements Appliance{
    private final int id;
    private final String name;
    private final String password;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public void accept(Visitor visitor) throws IOException {
        visitor.visit(this);
    }
}

class Visitor implements toJson {
    @Override
    public void visit(Group group) throws IOException {
        Gson gson = new Gson();
        String groupJson = gson.toJson(group);
        System.out.printf("exportJson the group %s\n", groupJson);
    }

    @Override
    public void visit(Asset asset) throws IOException {
        Gson gson = new Gson();
        String assetJson = gson.toJson(asset);
        System.out.printf("exportJson the asset %s\n", assetJson);
    }

    @Override
    public void visit(User user) throws IOException {
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.printf("exportJson the user %s\n", userJson);
    }
}

interface Appliance{
    void accept(Visitor visitor) throws IOException;
}