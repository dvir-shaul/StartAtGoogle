package StartAtGoogle.week3.DesignPatterns.Creational;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws Exception {
        VehiclesAgency vh = VehiclesAgency.getInstance();
        Passenger p = Passenger.makePassenger("Dvir", VehiclesAgency.VehicleType.Plane);
        Passenger p1 = Passenger.makePassenger("Lior", VehiclesAgency.VehicleType.Plane);
        Passenger p2 = Passenger.makePassenger("Ziv", VehiclesAgency.VehicleType.Plane);
        Passenger p3 = Passenger.makePassenger("Ana", VehiclesAgency.VehicleType.Plane);
        Passenger p4 = Passenger.makePassenger("Rany", VehiclesAgency.VehicleType.Plane);
        Passenger p5 = Passenger.makePassenger("David", VehiclesAgency.VehicleType.Plane);
        Passenger p6 = Passenger.makePassenger("Mostafa", VehiclesAgency.VehicleType.Plane);
        Passenger p7 = Passenger.makePassenger("Rachel", VehiclesAgency.VehicleType.Plane);
        Passenger p8 = Passenger.makePassenger("Saray", VehiclesAgency.VehicleType.Plane);
        Passenger p9 = Passenger.makePassenger("Eden", VehiclesAgency.VehicleType.Plane);
        Passenger p10 = Passenger.makePassenger("Maya", VehiclesAgency.VehicleType.Plane);
        Passenger p11 = Passenger.makePassenger("Sharon", VehiclesAgency.VehicleType.Plane);
        Passenger p12 = Passenger.makePassenger("Gideon", VehiclesAgency.VehicleType.Plane);
        Passenger p13 = Passenger.makePassenger("Valeria", VehiclesAgency.VehicleType.Plane);
        Passenger p14 = Passenger.makePassenger("Leon", VehiclesAgency.VehicleType.Plane);
        Passenger p15 = Passenger.makePassenger("Khader", VehiclesAgency.VehicleType.Plane);
        Passenger p16 = Passenger.makePassenger("Hadi", VehiclesAgency.VehicleType.Plane);
        Passenger p17 = Passenger.makePassenger("Fadi", VehiclesAgency.VehicleType.Plane);
        Passenger p18 = Passenger.makePassenger("Itamar", VehiclesAgency.VehicleType.Plane);

        vh.assignVehicle(p);
        vh.assignVehicle(p1);
        vh.assignVehicle(p2);
        vh.assignVehicle(p3);
        vh.assignVehicle(p4);
        vh.assignVehicle(p5);
        vh.assignVehicle(p6);
        vh.assignVehicle(p7);
        vh.assignVehicle(p8);
        vh.assignVehicle(p9);
        vh.assignVehicle(p10);
        vh.assignVehicle(p11);
        vh.assignVehicle(p12);
        vh.assignVehicle(p13);
        vh.assignVehicle(p14);
        vh.assignVehicle(p15);
        vh.assignVehicle(p16);
        vh.assignVehicle(p17);
        vh.assignVehicle(p18);




    }
}
