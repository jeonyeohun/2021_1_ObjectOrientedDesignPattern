import java.util.ArrayList;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(ArrayList<Wheel> wheels, ArrayList<Motor> motors, ArrayList<SolarPanel> panels, ArrayList<Arm> arms, Camera camera) {

        builder.makeTitle("Rover Running");

        builder.makeText("Each Wheel Turns Adapting to Terrain State");
        for (Wheel wheel : wheels){
            wheel.accept(new BuildVisitor(builder));
        }

        builder.makeText("Each Motor Controls Power Consumption");
        for (Motor motor : motors){
            motor.accept(new BuildVisitor(builder));
        }

        builder.makeText("Solar Panel Generating Electricity");
        for (SolarPanel solarPanel : panels){
            solarPanel.accept(new BuildVisitor(builder));
        }

        builder.makeText("Robot Arm in Operation");
        arms.get(0).accept(new BuildVisitor(builder));

        builder.makeText("Camera in Operation");
        camera.accept(new BuildVisitor(builder));

        builder.close();
    }
}
