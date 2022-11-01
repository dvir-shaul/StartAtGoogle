package StartAtGoogle.week3.DesignPatterns.Creational;

public class Passenger {
    private String name;
    private VehiclesAgency.VehicleType type;

    public Passenger(String name, VehiclesAgency.VehicleType type) {
        this.name = name;
        this.type = type;
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
