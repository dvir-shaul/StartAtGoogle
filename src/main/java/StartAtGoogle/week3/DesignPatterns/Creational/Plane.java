package StartAtGoogle.week3.DesignPatterns.Creational;

public class Plane implements Vehicles {


    @Override
    public void transport(Passenger passenger) {
        System.out.println("Plane is used by: "+passenger.getName());
    }
}
