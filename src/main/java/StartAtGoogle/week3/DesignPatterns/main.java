package StartAtGoogle.week3.DesignPatterns;

import StartAtGoogle.week3.DesignPatterns.Group;
import StartAtGoogle.week3.DesignPatterns.Visitor;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Group g = new Group(1,3);
        Asset a = new Asset(1,"Dvir",0.5);
        User u = new User(1,"Dor","Davido232");

        Visitor v = new Visitor();
        v.visit(g);
        v.visit(a);
        v.visit(u);
    }
}
