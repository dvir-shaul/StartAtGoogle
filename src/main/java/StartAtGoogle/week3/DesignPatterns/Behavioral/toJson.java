package StartAtGoogle.week3.DesignPatterns.Behavioral;

import StartAtGoogle.week3.DesignPatterns.Behavioral.Asset;
import StartAtGoogle.week3.DesignPatterns.Behavioral.Group;
import StartAtGoogle.week3.DesignPatterns.Behavioral.User;

import java.io.IOException;

public interface toJson {
    void visit(Group visitor) throws IOException;
    void visit(Asset visitor) throws IOException;
    void visit(User visitor) throws IOException;
}
