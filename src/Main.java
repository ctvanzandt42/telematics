import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        System.out.println("What is the VIN of the vehicle?");
        Scanner scanner = new Scanner(System.in);
        int VIN = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the current odometer reading?");
        double odometer = Double.parseDouble(scanner.nextLine());
        System.out.println("How many gallons of gas has the vehicle consumed?");
        double consumption = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the odometer reading since the last oil change?");
        double odometerLastOilChange = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the size of the engine in liters?");
        double engineSize = Double.parseDouble(scanner.nextLine());

        vehicleInfo.setVIN(VIN);
        vehicleInfo.setOdometer(odometer);
        vehicleInfo.setConsumption(consumption);
        vehicleInfo.setOdometerLastOilChange(odometerLastOilChange);
        vehicleInfo.setEngineSize(engineSize);



    }
}