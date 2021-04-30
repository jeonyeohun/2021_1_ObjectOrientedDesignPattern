import java.util.Random;

public class FuelModeStrategy extends ModeTemplate implements ModeStrategy, FuelCar  {

    private CarMode prevMode;
    FuelModeStrategy(CarMode prevMode){
        this.prevMode = prevMode;
    }

    @Override
    public void convertMode() {
        if (this.prevMode == CarMode.FUELMODE){
            System.out.println("keep fuel car mode");
        }
        else{
            System.out.println("Convert from " + this.toString(prevMode) + " to fuel car mode");
        }
    }

    public void startEngine(){
        System.out.println("( For Fuel Mode)Fuel Engine Started if engine is in sleep mode");
    }

    public void manageElectricity(){
        System.out.println("( For Fuel Mode)Cut Electricity to motor");
    }

    @Override
    void manageFuel() {
        System.out.println("Continue to run fuel engine");
    }

    @Override
    public void checkSpeed() {
        Random random = new Random();
        System.out.println("(Fuel Mode) Current Speed: " + (random.nextInt(80) + 20) + "\n");
    }

    @Override
    public void runVehicle() {
        super.runVehicle();
    }
}
