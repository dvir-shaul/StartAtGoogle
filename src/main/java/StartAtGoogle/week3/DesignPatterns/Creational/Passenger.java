package StartAtGoogle.week3.DesignPatterns.Creational;

public class Passenger {
    private String name;
    private VehiclesAgency.VehicleType type;

    private Passenger(String name, VehiclesAgency.VehicleType type) {
        this.name = name;
        this.type = type;
    }
    public static Passenger makePassenger(String name, VehiclesAgency.VehicleType type){
        return new Passenger(name,type);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehiclesAgency.VehicleType getType() {
        return type;
    }

    public void setType(VehiclesAgency.VehicleType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", type=" + type +'}';
    }
}
