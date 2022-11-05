package StartAtGoogle.week2.ClassesAndInterfaces;

public class main {

    public static void main(String[] args){

        Farm hava = new Farm();
        Farmer kobi = new Farmer();
        kobi.setFarm(hava);
//        System.out.println("current size of farm animal: "+hava.getFarmAnimal().size());
        hava.acquire("Dolphin",Animal.Gender.FEMALE);
//        hava.acquire("Dolphin",Animal.Gender.MALE);
        hava.acquire("Kof",Animal.Gender.MALE);
//        System.out.println("current size of farm animal: "+hava.getFarmAnimal().size());
//        System.out.println("check move function: ");
//        kobi.makeAniMove("Kof");
//        kobi.makeAniMove("Dolphin");
//        kobi.makeAniMove("Sheep");
//        System.out.println(hava);
//
//        hava.acquire("Kof",Animal.Gender.MALE);
//        hava.acquire("Kof",Animal.Gender.MALE);
//        hava.acquire("Sheep",Animal.Gender.MALE);
//
//        System.out.println(hava.getFarmAnimal().size());
//        hava.create_ani(kobi.farm.getFarmAnimal().get(0),
//                kobi.farm.getFarmAnimal().get(1));
//        System.out.println(hava.getFarmAnimal().size());
//
//       hava.create_ani(kobi.requestAnimal("Kof"),kobi.requestAnimal("Kof"));
//
//        hava.create_ani(kobi.requestAnimal("Sheep"),
//                kobi.requestAnimal("Kof"));

        WoodenHorse horse1  = new WoodenHorse();
        WoodenHorse horse2  = new WoodenHorse();
        System.out.println("\nwoodenStructureAdapter - roll:");
        WoodenStructureAdapter woodenHorse1 = new WoodenStructureAdapter(horse1);
        WoodenStructureAdapter woodenHorse2 = new WoodenStructureAdapter(horse2);
        woodenHorse1.move();
        System.out.println("\nwoodenStructureAdapter - replicate:");
        Animal a = woodenHorse2.mate(hava.getFarmAnimaltoFarmer("Kof"));
        System.out.println(a);


    }
}
