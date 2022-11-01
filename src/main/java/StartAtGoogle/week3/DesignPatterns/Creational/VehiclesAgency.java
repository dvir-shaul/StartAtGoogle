package StartAtGoogle.week3.DesignPatterns.Creational;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class VehiclesAgency {
    private final Map<VehicleType, Integer> vehicleAmount;
    private static Map<Passenger, Vehicles> vehicleAssignd;

    private static VehiclesAgency instance;


    public static VehiclesAgency getInstance() {
        if (instance == null) {
            instance = new VehiclesAgency();
        }
        return instance;
    }

    private VehiclesAgency() {
        VehiclesAgency.vehicleAssignd = new HashMap<>();
        vehicleAmount = new HashMap<>();
        vehicleAmount.put(VehicleType.Plane, 1);
        vehicleAmount.put(VehicleType.Bus, 4);
        vehicleAmount.put(VehicleType.Taxi, 8);
        vehicleAmount.put(VehicleType.Boat, 3);
    }

    enum VehicleType {
        Plane, Bus, Taxi, Boat;
        static final List<VehicleType> VALUES = List.of(values());
    }


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

    public void assignVehicle(Passenger p) throws Exception {
        int left = vehicleAmount.get(p.getType());
        if(left > 0){
            vehicleAssignd.put(p,createVehicle(p.getType()));
            vehicleAmount.put(p.getType(),vehicleAmount.get(p.getType())-1);
        }// not enough wanted type of vehicles available
        else{
            ThreadLocalRandom r= ThreadLocalRandom.current();
            List<VehicleType> list2 = new ArrayList<>(VehicleType.VALUES);
            for (Map.Entry<VehicleType, Integer> entry : vehicleAmount.entrySet()) {
                if(entry.getValue() == 0){
                    list2.remove(entry.getKey());
                }
            }
            if(list2.size()==0){
                System.out.println("---------------Cant assign anymore cars to passengers-------------");
                return;
            }
            VehicleType type2 = list2.get(r.nextInt(list2.size()));
            vehicleAssignd.put(p,createVehicle(type2));
            vehicleAmount.put(type2,vehicleAmount.get(type2)-1);
        }
        if(checkAllUsed()){
            invoke();
        }
    }

    public boolean checkAllUsed(){
        boolean flag = true;
        for (Map.Entry<VehicleType, Integer> entry : vehicleAmount.entrySet()) {
            if (entry.getValue() > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public void invoke (){
        for (Map.Entry<Passenger, Vehicles> entry : vehicleAssignd.entrySet()) {
            entry.getValue().transport(entry.getKey());
        }
    }
}
