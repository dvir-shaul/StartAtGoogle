package StartAtGoogle.week2.ClassesAndInterfaces;

public class WoodenStructureAdapter implements AnimalIface {

    WoodenHorse horse;

    public WoodenStructureAdapter(WoodenHorse horse) {
        this.horse = horse;
    }

    @Override
    public void move() {
        horse.roll();
    }

    @Override
    public Animal mate(Animal partner) {
        return horse.replicate(horse);
    }
}
