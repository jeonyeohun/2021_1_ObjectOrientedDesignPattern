import java.util.Random;

public class ElectricModeStrategyStrategy extends ModeTemplate implements ModeStrategy{
    CarMode prevMode;
    ElectricModeStrategyStrategy(CarMode prevMode) {
        this.prevMode = prevMode;
    }

    public void manageElectricity(){
        System.out.println("Supply electricity to front and rear motors of electric car");
    }

    @Override
    void manageFuel() {
        System.out.println("( For Electric Mode)Cut fuel to engine");
    }

    @Override
    public void runVehicle() {
        super.runVehicle();
    }

    @Override
    public void generateCharge() {
        return;
    }

    @Override
    public void convertMode() {
        if (this.prevMode == CarMode.ELECTRICMODE){
            System.out.println("keep fuel car mode");
        }
        else{
            System.out.println("Convert from " + this.toString(this.prevMode) + " to electric car mode");
        }
    }

    @Override
    void startEngine() {
        return;
    }

    @Override
    public void checkSpeed() {
        Random random = new Random();
        System.out.println("(Electric Mode) Current Speed: " + (random.nextInt(80) + 20) + "\n");
    }

}
