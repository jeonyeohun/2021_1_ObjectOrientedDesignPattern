public class ResponseVisitor implements Visitor{
    @Override
    public void visit(Motor motor) {
        System.out.println("Acting on " + motor.getName());
        if (motor.getState() == false){
            System.out.println("==> Action: Supply more power to " + motor.getName() + " Motor");
            BlackBox.getInstance().saveAction(motor);
        }
        else{
            System.out.println("No Action on Right Motor");
        }
    }

    @Override
    public void visit(Camera camera) {
        System.out.println("Action on Camera");
        if (camera.getState() == false){
            System.out.println("===> Action: Repair Camera");
            BlackBox.getInstance().saveAction(camera);
        }
        else{
            System.out.println("No Action on camera");
        }
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Acting on " + wheel.getName() + " Wheel");
        if (wheel.getState() == false){
            System.out.println("--> Action: Removing Mud/Dust from " + wheel.getName() + " Axle");
            BlackBox.getInstance().saveAction(wheel);
        }
        else{
            System.out.println("No Action on " + wheel.getName() + " Axle");
        }
    }

    @Override
    public void visit(Arm arm) {
        System.out.println("Action on RobotArm");
        if (arm.getState() == false){
            arm = (Arm)arm.clone();
            System.out.println("==> Action: " + arm.getName() + " Arm Replaced by Prototype " + arm.getName() + " Arm Clone");
            System.out.println(arm.getName() + " Robot Arm Clone Made from Prototype");
            BlackBox.getInstance().saveAction(arm);
        }
        else{
            System.out.println("No Action on " + arm.getName() + " Robot Arm");
        }
    }

    @Override
    public void visit(SolarPanel solarPanel) {
        System.out.println("Acting on " + solarPanel.getId());
        if (solarPanel.getState() == false){
            System.out.println("==> Action: repairing Solar Panel " + solarPanel.getId());
            int watts = solarPanel.generateRandomWatts();

            System.out.println("Making a New Solar Panel : " + watts + " KW Panel");
            System.out.println("A Troublesome Panel Replaced by " + watts + " KW Panel");
            BlackBox.getInstance().saveAction(solarPanel);
        }
        else{
            System.out.println("No Action on Solar Panel " + solarPanel.getId());
        }
    }
}
