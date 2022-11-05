package StartAtGoogle.week2.ClassesAndInterfaces;

import java.util.ArrayList;
import java.util.UUID;


public class Farm {
    public Farm(ArrayList<Animal> farmAnimal) {
        this.farmAnimal = farmAnimal;
    }

    private ArrayList<Animal> farmAnimal;

    public Farm() {
        this.farmAnimal = new ArrayList<>();
    }

    public ArrayList<Animal> getFarmAnimal() {
        return farmAnimal;
    }

    public void setFarmAnimal(ArrayList<Animal> farmAnimal) {
        this.farmAnimal = farmAnimal;
    }

    public void create_ani(Animal a, Animal b){
        if(a!=null & b!=null){
            if(a.getGender()!= b.getGender()){
                Animal anim = a.mate(b);
                farmAnimal.add(anim);
                System.out.println("created !!!!!");

                return;
            }
            System.out.println("Cant create, need different gender");
            return;
        }
        System.out.println("Cant create got NULL");
    }


    public void acquire(String s,Animal.Gender g){
        switch (s){
            case "Sheep": {
                Sheep sheep = Sheep.SheepcreateNewSheep(g, Animal.getId(), 8);
                farmAnimal.add(sheep);
                return;
            }
            case "Dolphin": {
                Dolphin dolphin = Dolphin.createNewDolphin(g, Animal.getId(), 8);
                farmAnimal.add(dolphin);
                return;
            }
            case "Kof": {
                Kof kof = Kof.createNewkof(g, Animal.getId(), 8);
                farmAnimal.add(kof);
                return;
            }
            default: break;
        }
    }

    public Animal getFarmAnimaltoFarmer(String s) {
        for (int i = 0; i < farmAnimal.size(); i++) {
            if (farmAnimal.get(i).toString().equals(s)) {
                Animal ans = farmAnimal.get(i);
                farmAnimal.remove(ans);
                return ans;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Print farm animals: \n");
        for (Animal an : farmAnimal) {
            s.append("type:")
                    .append(an.toString())
                    .append(" gender: ")
                    .append(an.getGender())
                    .append("  Weight ")
                    .append(an.getWeight())
                    .append("\n");
        }
        return s.toString();
    }
}

interface AnimalIface{
    void move();
    Animal mate(Animal partner);
}






abstract class Animal implements AnimalIface{

    enum Gender{MALE,FEMALE}

    private final Gender gender;
    private final int id;
    private double weight;

    protected Animal(Gender gender, int id, double weight) {
        this.gender = gender;
        this.id = id;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }


    public Gender getGender() {
        return gender;
    }

    public static int getId() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode();
    }
}


/**
 * SHEEP
 */
class Sheep extends Animal{
    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof  Sheep){
            return new Sheep(Gender.FEMALE,getId(),24);
        }
        return null;
    }



    @Override
    public void move() {
        System.out.println("Sheep walk on 4");
    }

    Sheep(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }
    public static Sheep SheepcreateNewSheep(Gender gender, int id, double weight){
        return new Sheep(gender, id, weight);
    }

    @Override
    public String toString() {
        return "Sheep ";
    }
}


/**
 * Dolphin
 */
class Dolphin extends Animal{
    private Dolphin(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }
    public static Dolphin createNewDolphin(Gender gender, int id, double weight){
        return new Dolphin(gender, id, weight);
    }
    @Override
    public void move() {
        System.out.println("Dolphin swim");
    }
    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof  Dolphin){
            System.out.println("mate from Dolphin");
            return new Dolphin(Gender.FEMALE,1,24);
        }
        return null;
    }
    @Override
    public String toString() {
        return "Dolphin";
    }
}


/**
 * kof
 */
class Kof extends Animal{
    Kof(Gender gender, int id, double weight) {
        super(gender, id, weight);
    }
    public static Kof createNewkof(Gender gender, int id, double weight){
        return new Kof(gender, id, weight);
    }
    @Override
    public void move() {
        System.out.println("kof walk on 2");
    }
    @Override
    public Animal mate(Animal partner) {
        if(partner instanceof  Kof){
            return new Kof(Gender.FEMALE,1,24);
        }
        return null;
    }
    @Override
    public String toString() {
        return "Kof";
    }
}


//
//public class FowardingKof extends Kof.createNewkof {
//
//}

