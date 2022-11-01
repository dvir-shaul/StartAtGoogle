package StartAtGoogle.week3.DesignPatterns.Creational;

import java.util.HashMap;
import java.util.Map;

public class VehiclesAgency {
    private Map<VehicleType, Integer> vehicleAmount;
    private Map<Passenger,VehicleType> vehicleAssignd;

    private static VehiclesAgency instance;


    public static VehiclesAgency getInstance(){
        if(instance==null){
            instance = new VehiclesAgency();
        }
        return instance;
    }

    private VehiclesAgency(){
        vehicleAmount = new HashMap<>();
        vehicleAmount.put(VehicleType.Plane,1);
        vehicleAmount.put(VehicleType.Bus,4);
        vehicleAmount.put(VehicleType.Taxi,8);
        vehicleAmount.put(VehicleType.Boat,3);
    }
    enum VehicleType {Plane, Bus, Taxi, Boat}
    public Vehicles createVehicle(VehicleType type) {
        switch (type) {
            case Plane:
                return new Plane();
            case Bus:
                return new Bus();
            case Taxi:
                return new Taxi();
            case Boat:
                return new Boat();
            default:
                throw new IllegalArgumentException(String.format("Store type not supported: %s", type));
        }
    }

    public void assignVehicle(Passenger p){
        VehicleType type = p.getType();
        if(vehicleAmount.get(type) > 0){

        }
    }
}
