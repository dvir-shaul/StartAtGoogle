package StartAtGoogle.week3.DesignPatterns;

import java.io.IOException;

public interface toJson {
    void visit(Group visitor) throws IOException;
    void visit(Asset visitor) throws IOException;
    void visit(User visitor) throws IOException;
}
