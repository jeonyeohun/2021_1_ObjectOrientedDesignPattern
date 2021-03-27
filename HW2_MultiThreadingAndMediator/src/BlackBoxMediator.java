import java.util.Random;

public class BlackBoxMediator implements Mediator{
    private int animalsCount = 0;
    private int pedestrianCount = 0;
    private int redTrafficCount = 0;
    private int distanceCount = 0;
    private int heaterCount = 0;
    private int airconCount = 0;
    private int laneCenteringCount = 0;

    private int currentSpeed;
    private int currentTemp;
    private int initialSpeed;
    Random rand = new Random();

    BlackBoxMediator(int initalSpeed) throws InterruptedException {
        this.initialSpeed = initalSpeed;
        this.currentSpeed = initalSpeed;
        this.currentTemp = 23 + rand.nextInt(4);
        this.createCarStatus();
    }

    @Override
    public void increaseSpeed() {
        this.currentSpeed = this.currentSpeed + initialSpeed/2 + rand.nextInt(11) - 20;
    }

    @Override
    public void decreaseSpeed() {
        this.currentSpeed = this.currentSpeed - rand.nextInt(initialSpeed/2);
        if (this.currentSpeed < initialSpeed){
            System.out.println("Pick up Speed");
            this.naturalSpeedChange();
        }
    }

    public void naturalSpeedChange(){
        int change = (rand.nextInt(21) - 10);
        this.currentSpeed = this.currentSpeed + change;
        this.handleInvalidSpeed();
    }

    public void naturalTempChange(){
        int change = (rand.nextInt(7) - 3);
        this.currentTemp = this.currentTemp + change;
        this.handleInvalidSpeed();
    }

    @Override
    public void stopSpeed() {
        this.currentSpeed = 0;
    }

    @Override
    public void increaseTemp() {
        this.currentTemp = this.currentTemp + rand.nextInt(3);
    }

    @Override
    public void decreaseTemp() {
        this.currentTemp = this.currentTemp - rand.nextInt(3);
    }

    public void handleInvalidSpeed(){
        if (this.currentSpeed < 0) this.currentSpeed = 0;
    }

    @Override
    public void createCarStatus() throws InterruptedException {
        Thread distanceController = new DistanceController(this);
        Thread brakeController = new BrakeController(this);
        Thread speedController = new SpeedController(this);
        Thread temperatureController = new TemperatureController(this);

        distanceController.start();
        brakeController.start();
        speedController.start();
        temperatureController.start();

        speedController.join();

        printBlackBox();
    }

    public void printBlackBox(){
        System.out.println("=== Black Box Data ===");
        System.out.println("Speed Control Terminating");
        System.out.println("Number of Animals Sensed: " + this.animalsCount);
        System.out.println("Number of Pedestrian Sensed: " + this.pedestrianCount);
        System.out.println("Number of Red Traffic Lights Sensed: " + this.redTrafficCount);
        System.out.println("Number of Distance Control: " + this.distanceCount);
        System.out.println("Number of Heater Turned On: " + this.heaterCount);
        System.out.println("Number of Aircon Turned On: " + this.airconCount);
        System.out.println("Number of Lane Centering Activated: " + this.laneCenteringCount);
        System.out.println("=== Black Box in Sleep Mode ===");
    }

    public void setAnimalsCount(int animalsCount) {
        this.animalsCount = animalsCount;
    }

    public void setPedestrianCount(int pedestrianCount) {
        this.pedestrianCount = pedestrianCount;
    }

    public void setRedTrafficCount(int redTrafficCount) {
        this.redTrafficCount = redTrafficCount;
    }

    public void setDistanceCount(int distanceCount) {
        this.distanceCount = distanceCount;
    }

    public void setHeaterCount(int heaterCount) {
        this.heaterCount = heaterCount;
    }

    public void setAirconCount(int airconCount) {
        this.airconCount = airconCount;
    }

    public void setLaneCenteringCount(int laneCenteringCount) {
        this.laneCenteringCount = laneCenteringCount;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentTemp(){
        return currentTemp;
    }

    public int getAnimalsCount() {
        return animalsCount;
    }

    public int getPedestrianCount() {
        return pedestrianCount;
    }

    public int getRedTrafficCount() {
        return redTrafficCount;
    }

    public int getDistanceCount() {
        return distanceCount;
    }

    public int getHeaterCount() {
        return heaterCount;
    }

    public int getAirconCount() {
        return airconCount;
    }

    public int getLaneCenteringCount() {
        return laneCenteringCount;
    }
}
