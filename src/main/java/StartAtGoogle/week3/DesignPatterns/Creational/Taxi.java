package StartAtGoogle.week3.DesignPatterns.Creational;

public class Taxi implements Vehicles {
    @Override
    public void transport(Passenger passenger) {
        System.out.println("Taxi  is used by: "+passenger.getName());
    }
}
