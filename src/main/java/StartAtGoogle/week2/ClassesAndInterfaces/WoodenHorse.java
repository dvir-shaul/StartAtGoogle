package StartAtGoogle.week2.ClassesAndInterfaces;

public class WoodenHorse implements WoodenStructures {

    @Override
    public void roll() {
        System.out.println("rolling from horsie");
    }

    @Override
    public Animal replicate(WoodenHorse horse) {
        System.out.println("replicate from horsie");
        return new Kof(Animal.Gender.MALE,8,14);
    }
}
