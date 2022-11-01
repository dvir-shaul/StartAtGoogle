package StartAtGoogle.week3.DesignPatterns.Creational.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) throws Exception {
        LocalDate date = LocalDate.from(LocalDateTime.now());
        JobPosition jp = new JobPosition.Builder(date,"Harry Potter", true).Description("very good").build();
        System.out.println(jp.toString());
    }
}
