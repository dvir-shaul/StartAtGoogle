package StartAtGoogle.week2.ClassesAndInterfaces;

public class City{

    private final String name;
    private final String country;
    private int population;

    private City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    private static City telaviv;
    public static final City TEL_AVIV(){
        if(telaviv == null){
            telaviv = new City("Tel Aviv", "Israel", 435855);
        }
        return telaviv;
    }

//    public static City newCity(String name, String country, int population){
//        return City.newCity(name,country,population );
//    }


}