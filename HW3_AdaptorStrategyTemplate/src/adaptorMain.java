import java.util.Random;

public class adaptorMain {

    public static void main(String[] args) {
        Random random = new Random();
        CarMode prevMode = CarMode.FUELMODE;
        int tests = 10;
        final int bound = 75;
        while(tests != 0){
            tests--;
            int firstBattery = random.nextInt(70) + 30;
            int secondBattery = random.nextInt(70) + 30;

            if (firstBattery >= bound && secondBattery >= bound){
                System.out.println("Main and Secondary Batteries have enough power.");
                printBatteryStatus(firstBattery, secondBattery);
                FuelCar car = new CarAdaptor(new ElectricModeStrategyStrategy(prevMode));
                car.runVehicle();
                prevMode = CarMode.ELECTRICMODE;
            }
            else if (firstBattery >= bound && secondBattery < bound){
                System.out.println("Main battery has enough power. But secondary battery needs more charging.");
                printBatteryStatus(firstBattery, secondBattery);
                FuelCar car = new CarAdaptor(new HybridModeStrategy(prevMode));
                car.runVehicle();
                prevMode = CarMode.HYBRIDMODE;

            }
            else if (firstBattery < bound && secondBattery < bound) {
                System.out.println("Main battery and secondary battery have low power level.");
                printBatteryStatus(firstBattery, secondBattery);
                ModeStrategy strategy = new FuelModeStrategy(prevMode);
                strategy.runVehicle();
                prevMode = CarMode.FUELMODE;
            }
        }
    }

    public static void printBatteryStatus(int firstBattery, int secondBattery){
        System.out.println("Main Battery: -> " + firstBattery + " % Charged");
        System.out.println("Secondary Battery: -> " + secondBattery + " % Charged");
    }
}
