import java.util.ArrayList;

public class BlackBox {

    ArrayList<String> states = new ArrayList<>();
    private static BlackBox blackBox = null;

    public static BlackBox getInstance() {
        if (blackBox == null){
            blackBox = new BlackBox();
        }
        return blackBox;
    }

    public ArrayList<String> getStates (){
        return this.states;
    }

    public void saveAlarm(Motor motor){
        states.add("Alarm: Weak Power to " + motor.getName() + " Motor");
    }

    public void saveAlarm(Wheel wheel){
        states.add("Alarm: Mud and Dust on Wheel Axle of " + wheel.getName() + " wheel");
    }

    public void saveAlarm(SolarPanel solarPanel){
        states.add("Alarm: Low Electricity Generated to Solar Panel " + solarPanel.getId());
    }

    public void saveAlarm(Arm arm){
        states.add("Alarm: " + arm.getName() + " Robot Arm Not Working Properly");
    }

    public void saveAlarm(Camera camera){
        states.add("Alarm: Camera Not Working Properly");
    }

    public void saveAction (Wheel wheel){
        states.add("Action: " + " Removing Mud/Dust from " + wheel.getName() + " Axle");
    }

    public void saveAction (Motor motor){
        states.add("Action: " + " Supply more power to " + motor.getName() + " Motor");
    }

    public void saveAction (SolarPanel solarPanel){
        states.add("Action: Replacing Solar Paenl " + solarPanel.getId());
    }

    public void saveAction (Camera camera){
        states.add("Action: Repair Camera");
    }

    public void saveAction (Arm arm){
        states.add("Action: " + arm.getName() + " Arm Replaced by Prototype " + arm.getName() + " Arm Clone");
    }
}
