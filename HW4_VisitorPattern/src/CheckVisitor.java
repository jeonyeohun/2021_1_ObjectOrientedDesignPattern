import java.util.Random;

public class CheckVisitor implements Visitor{

    @Override
    public void visit(Motor motor) {
        System.out.println("Checking Motors " + motor.getName() + " Motor");
        if (generateRandomNum() == 0){
            System.out.println("Power is OK");
            motor.setState(true);
        }
        else{
            System.out.println(">> Alarm: Week Power to " + motor.getName() + " Motor");
            motor.setState(false);
            BlackBox.getInstance().saveAlarm(motor);
        }
    }

    @Override
    public void visit(Camera camera) {
        System.out.println("Checking camera");
        if (generateRandomNum() == 0){
            System.out.println("camera is OK");
            camera.setState(true);
        }
        else{
            System.out.println("... Alarm: Camera Not Working Properly");
            camera.setState(false);
            BlackBox.getInstance().saveAlarm(camera);
        }
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Checking " + wheel.getName() + " Axle");
        if (generateRandomNum() == 0){
            System.out.println("Wheel Axle OK");
            wheel.setState(true);
        }
        else{
            System.out.println(">> Alarm: Mud and Dust on Wheel Axle of " + wheel.getName() + " wheel");
            wheel.setState(false);
            BlackBox.getInstance().saveAlarm(wheel);
        }
    }

    @Override
    public void visit(Arm arm){
        System.out.println("Checking robot arm");
        if (generateRandomNum() == 0){
            System.out.println(arm.getName() + " Robot Arm is OK");
            arm.setState(true);
        }
        else{
            System.out.println("... Alarm: " + arm.getName() + " Robot Arm Not Working Properly");
            arm.setState(false);
            BlackBox.getInstance().saveAlarm(arm);
        }
    }

    @Override
    public void visit(SolarPanel solarPanel) {
        System.out.println("Checking Solar Panel " + solarPanel.getId());
        if (generateRandomNum() == 0){
            System.out.println("Solar Panel is OK");
            solarPanel.setState(true);
        }
        else{
            System.out.println(">>>> Alarm: Low Electricity Generated to Solar Panel " + solarPanel.getId());
            solarPanel.setState(false);
            BlackBox.getInstance().saveAlarm(solarPanel);
        }
    }

    private int generateRandomNum(){
        Random rand = new Random();
        int action = rand.nextInt(2);

        return action;
    }
}
