public class TemperatureController extends Thread  implements CarStatus{
    private BlackBoxMediator mediator;

    TemperatureController(BlackBoxMediator mediator){
        setMediator(mediator);
    }

    @Override
    public void setMediator(BlackBoxMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void run() {
        int TestCase = 10;
        System.out.println("Temperature Control at work");
        while ((TestCase--) != 0){
            try {
                Thread.sleep(500);
                this.mediator.naturalTempChange();
                System.out.println("Thread for Air Conditioner Control, current Temperature: " + this.mediator.getCurrentTemp());
                if (this.mediator.getCurrentTemp() > 26){
                    this.mediator.setAirconCount(this.mediator.getAirconCount() + 1);
                    System.out.println("Turn on aircon to lower temperature.");
                    this.mediator.decreaseTemp();
                }
                else if(this.mediator.getCurrentTemp() < 23){
                    this.mediator.setHeaterCount(this.mediator.getHeaterCount() + 1);
                    System.out.println("Turn on heater to increase temperature.");
                    this.mediator.increaseTemp();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
