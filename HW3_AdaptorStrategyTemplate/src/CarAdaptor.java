public class CarAdaptor implements FuelCar{

    ModeStrategy strategy;

    public CarAdaptor(ModeStrategy strategy){
        this.strategy = strategy;
    }

    @Override
    public void runVehicle() {
        strategy.runVehicle();
    }
}
