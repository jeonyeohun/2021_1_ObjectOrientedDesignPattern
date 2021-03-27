import java.util.Random;

public class BrakeController extends Thread implements CarStatus {
    private BlackBoxMediator mediator;
    static final int ANINAL = 0;
    static final int PEDESTRIAN = 1;
    static final int RED_LIGHT = 2;

    BrakeController(BlackBoxMediator mediator){
        setMediator(mediator);
    }

    @Override
    public void setMediator(BlackBoxMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void run() {
        System.out.println("Brake Control at work");
        int TestCase = 10;
        Random rand = new Random();
        while ((TestCase--) != 0){
            try {
                Thread.sleep(200);
                int event = rand.nextInt(3);

                switch (event){
                    case ANINAL:
                        animalControl();
                        break;
                    case PEDESTRIAN:
                        pedestrianControl();
                        break;
                    case RED_LIGHT:
                        redLightControl();
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void redLightControl (){
        this.mediator.setRedTrafficCount(this.mediator.getRedTrafficCount() + 1);
        System.out.println("Red Traffic Light Sensed...");
        System.out.println("Slowing down speed to stop at red light...");

        this.mediator.decreaseSpeed();

        System.out.println("Current Decreased Speed in Front of Red Light : " + this.mediator.getCurrentSpeed());

        this.mediator.stopSpeed();
        System.out.println("Now the car made a complete stop.");
        System.out.println("Now Green Light Turned on.");

        this.mediator.increaseSpeed();

        System.out.println("Current Increased Speed on Green Traffic Light : " + + this.mediator.getCurrentSpeed());
    }

    public void animalControl(){
        this.mediator.setAnimalsCount(this.mediator.getAnimalsCount() + 1);

        System.out.println("Event Generated -- Animal");
        System.out.println("Animal Crossing Sensed: slow down ...!");

        this.mediator.decreaseSpeed();

        System.out.println("Current Decreased Speed in Front of an Animal : " + this.mediator.getCurrentSpeed());
        System.out.println("Road Cleared of Animal: Increase Speed");

        this.mediator.increaseSpeed();

        System.out.println("Current Increased Speed after Passing an Animal : " + this.mediator.getCurrentSpeed());
    }
    public void pedestrianControl(){
        this.mediator.setPedestrianCount(this.mediator.getPedestrianCount() + 1);

        System.out.println("Event Generated -- Pedestrian");
        System.out.println("Pedestrian Crossing Sensed: slow down to stop!");

        this.mediator.decreaseSpeed();

        System.out.println("Current Decreased Speed while a Pedestrian Crossing : " + this.mediator.getCurrentSpeed());

        this.mediator.stopSpeed();
        System.out.println("Now the car made full stop for pedestrians.");
        System.out.println("Now the Pedestrian in Sage Area and the Road Cleared");

        this.mediator.increaseSpeed();

        System.out.println("Current Increased Speed after Passing a Pedestrian in Safe Area : " + this.mediator.getCurrentSpeed());
    }
}
