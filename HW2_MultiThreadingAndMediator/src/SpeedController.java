
public class SpeedController extends Thread implements CarStatus{
    private BlackBoxMediator mediator;

    SpeedController(BlackBoxMediator mediator){
        setMediator(mediator);
    }

    @Override
    public void setMediator(BlackBoxMediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void run() {
        System.out.println("Speed Control at work");
        int TestCase = 10;
        while ((TestCase--) != 0){
            try {
                Thread.sleep(200);
                this.mediator.naturalSpeedChange();
                System.out.println("Thread for Speed Control, current speed : " + this.mediator.getCurrentSpeed());

                if (this.mediator.getCurrentSpeed() >= 100){
                    System.out.println("Push brake to slow down speed");
                    this.mediator.decreaseSpeed();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
