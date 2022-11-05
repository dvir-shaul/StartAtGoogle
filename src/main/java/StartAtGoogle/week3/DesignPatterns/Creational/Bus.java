package StartAtGoogle.week3.DesignPatterns.Creational;

public class Bus implements Vehicles {

    @Override
    public void transport(Passenger passenger) {
        System.out.println("Bus   is used by: " +passenger.getName());

    }
}
