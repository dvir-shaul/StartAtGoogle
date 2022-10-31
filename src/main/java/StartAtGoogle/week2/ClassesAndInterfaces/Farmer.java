package StartAtGoogle.week2.ClassesAndInterfaces;



public class Farmer {

    Farm farm;

    public void setFarm(Farm f) {
        this.farm = f;
    }

    public Animal requestAnimal(String ani) {
        switch (ani) {
            case "Sheep":
                return farm.getFarmAnimaltoFarmer("Sheep");
            case "Dolphin":
                return farm.getFarmAnimaltoFarmer("Dolphin");
            case "Kof":
                return farm.getFarmAnimaltoFarmer("Kof");
        }
        return null;
    }


    public void makeAniMove(String s) {
        for (Animal animal : farm.getFarmAnimal()) {
            if (animal.toString().equals(s)) {
                animal.move();
                return;
            }
        }
        System.out.println("No Such An Animal To Move");
    }


}
