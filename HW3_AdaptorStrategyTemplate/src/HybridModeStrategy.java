import java.util.Random;

public class HybridModeStrategy extends ModeTemplate implements ModeStrategy{
    CarMode prevMode;
    HybridModeStrategy(CarMode prevMode) {
        this.prevMode = prevMode;
    }

    @Override
    public void convertMode() {
        if (prevMode == CarMode.HYBRIDMODE){
            System.out.println("Keep hybrid car mode");
        }
        else{
            System.out.println("Convert from " + this.toString(prevMode) + " to hybrid car mode");
        }
    }

    public void startEngine(){
        System.out.println("( For Hybrid Mode)Fuel Engine Started if engine is in sleep mode");
    }

    @Override
    public void manageElectricity() {
        System.out.println("Supply electricity to front motor of hybrid car");
    }

    @Override
    public void manageFuel() {
        return;
    }

    @Override
    public void checkSpeed() {
        Random random = new Random();
        System.out.println("(Hybrid Mode) Current Speed: " + (random.nextInt(80) + 20) + "\n");
    }

    public void runVehicle() {
        super.runVehicle();
    }
}
