package StartAtGoogle.week3.AutoValue;


@com.google.auto.value.AutoValue
public abstract class Person {
    static Person create(int id, String name){
        return new AutoValue_Person(id, name);
    }
    abstract int id();
    abstract String name();
}
