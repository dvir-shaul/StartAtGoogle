package StartAtGoogle.week3.DesignPatterns.Creational;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws Exception {
        VehiclesAgency vh = VehiclesAgency.getInstance();
        Passenger p = Passenger.makePassenger("dvir1", VehiclesAgency.VehicleType.Plane);
        Passenger p1 = Passenger.makePassenger("dv2ir", VehiclesAgency.VehicleType.Plane);
        Passenger p2 = Passenger.makePassenger("dv3ir", VehiclesAgency.VehicleType.Plane);
        Passenger p3 = Passenger.makePassenger("dv6ir", VehiclesAgency.VehicleType.Plane);
        Passenger p4 = Passenger.makePassenger("dv4ir", VehiclesAgency.VehicleType.Plane);
        Passenger p5 = Passenger.makePassenger("dv546ir", VehiclesAgency.VehicleType.Plane);
        Passenger p6 = Passenger.makePassenger("dv56ir", VehiclesAgency.VehicleType.Plane);
        Passenger p7 = Passenger.makePassenger("dvi76r", VehiclesAgency.VehicleType.Plane);
        Passenger p8 = Passenger.makePassenger("dv5656ir", VehiclesAgency.VehicleType.Plane);
        Passenger p9 = Passenger.makePassenger("dv6546ir", VehiclesAgency.VehicleType.Plane);
        Passenger p10 = Passenger.makePassenger("dv5465ir", VehiclesAgency.VehicleType.Plane);
        Passenger p11 = Passenger.makePassenger("dv54ir", VehiclesAgency.VehicleType.Plane);
        Passenger p12 = Passenger.makePassenger("dv546ir", VehiclesAgency.VehicleType.Plane);
        Passenger p13 = Passenger.makePassenger("dv57565ir", VehiclesAgency.VehicleType.Plane);
        Passenger p14 = Passenger.makePassenger("d6546vir", VehiclesAgency.VehicleType.Plane);
        Passenger p15 = Passenger.makePassenger("dv547ir", VehiclesAgency.VehicleType.Plane);
        Passenger p16 = Passenger.makePassenger("dv6547ir", VehiclesAgency.VehicleType.Plane);
        Passenger p17 = Passenger.makePassenger("dv7546ir", VehiclesAgency.VehicleType.Plane);
        Passenger p18 = Passenger.makePassenger("dv7548654ir", VehiclesAgency.VehicleType.Plane);

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
