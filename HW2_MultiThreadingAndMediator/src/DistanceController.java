import java.util.Random;

public class DistanceController extends Thread implements CarStatus{
    private BlackBoxMediator mediator;
    static final int LANE_CENTERING = 0;
    static final int DISTANCE_AHEAD = 1;

    DistanceController(BlackBoxMediator mediator){
        setMediator(mediator);
    }

    @Override
    public void setMediator(BlackBoxMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void run() {
        System.out.println("Distance Control at work");
        int TestCase = 10;
        Random rand = new Random();

        while ((TestCase--) != 0){
            try {
                Thread.sleep(200);
                int event = rand.nextInt(2);

                switch (event) {
                    case LANE_CENTERING:
                        laneCenteringControl();
                        break;
                    case DISTANCE_AHEAD:
                        distanceAheadControl();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + event);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void laneCenteringControl(){
        this.mediator.setLaneCenteringCount(this.mediator.getLaneCenteringCount() + 1);
        System.out.println("Event Generated -- Not in Lane Center");
        System.out.println("Not in Lane Center ...");
        System.out.println("Correcting Car Position on Lance Center");
    }

    public void distanceAheadControl(){
        this.mediator.setDistanceCount(this.mediator.getDistanceCount() + 1);
        System.out.println("Event Generated -- Distance Getting Closer from the Front Car");
        System.out.println("the Speed of Front Car Dropping Fast: slow down to keep distance...");

        this.mediator.decreaseSpeed();

        System.out.println("Current Decreased Speed for Distance from the Car Ahead :" + this.mediator.getCurrentSpeed());

        this.mediator.increaseSpeed();

        System.out.println("Current Increased Speed Following the Front Car Increasing Speed : "+ this.mediator.getCurrentSpeed());

    }
}
