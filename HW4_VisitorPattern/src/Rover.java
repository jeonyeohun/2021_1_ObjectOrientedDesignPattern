import java.util.ArrayList;

public class Rover {
    private String[] WheelPositions = {"Front Left", "Front Right", "Back Left", "Back Right"};
    private static ArrayList<Motor> motors = new ArrayList<>();
    private ArrayList<Wheel> wheels = new ArrayList<>();
    private ArrayList<Arm> arms = new ArrayList<>();
    private ArrayList<SolarPanel> panels = new ArrayList<>();
    private PanelContainer panelContainer = new PanelContainer();
    private Camera camera = new Camera();

    public void run(){
        initRover();
        runCheckVisitor();
        runActionVisitor();
        runBuilderVisitor();
        displayBlackbox();
    }

    public void initRover(){
        // initialize motors and wheels
        for (String position : this.WheelPositions) {
            motors.add(new Motor(position));
            wheels.add(new Wheel(position));
        }

        // initialize arms
        Arm frontArm = new Arm("Front");
        Arm backArm = (Arm) frontArm.clone();
        backArm.setName("Back");
        arms.add(frontArm);
        arms.add(backArm);

        // initialize panels
        for (int i = 1; i <= 6; i++) {
            SolarPanel solarPanel = panelContainer.getPanel(i);
            panels.add(solarPanel);
        }
    }

    public void runCheckVisitor(){
        // Checking Status //
        System.out.println("The First Visitor for Checking Components");
        System.out.println("\n*** Start Checking Wheel ***\n");
        for (Wheel wheel : wheels) {
            wheel.accept(new CheckVisitor());
        }

        System.out.println("\n### Start Checking Motor ###\n");
        for (Motor motor : motors) {
            motor.accept(new CheckVisitor());
        }

        System.out.println("\n!!! Start Checking Solar Panel !!!\n");
        for (SolarPanel solarPanel : panels) {
            solarPanel.accept(new CheckVisitor());
        }

        System.out.println("\n... Start Checking Robot Arm ...\n");
        for (Arm arm : arms) {
            arm.accept(new CheckVisitor());
        }

        System.out.println("\n... Start Checking Camera ...\n");
        camera.accept(new CheckVisitor());
    }

    public void runActionVisitor(){
        // Responding //
        System.out.println("The Second Visitor for Maintaining Components");
        System.out.println("\n*** Start Working on Wheel ***\n");
        for (Wheel wheel : wheels) {
            wheel.accept(new ResponseVisitor());
        }

        System.out.println("\n### Start Working Motor ###\n");
        for (Motor motor : motors) {
            motor.accept(new ResponseVisitor());
        }

        System.out.println("\n!!! Start Working Solar Panel !!!\n");
        for (SolarPanel solarPanel : panels) {
            solarPanel.accept(new ResponseVisitor());
        }

        System.out.println("\n... Start Working Robot Arm ...\n");
        for (Arm arm : arms) {
            arm.accept(new ResponseVisitor());
        }

        System.out.println("\n... Start Working Camera ...\n");
        camera.accept(new ResponseVisitor());
    }

    public void runBuilderVisitor(){
        // Create HTML //
        Director director = new Director(new HTMLBuilder());
        director.construct(wheels, motors, panels, arms, camera);
        System.out.println("\nRover Running.html is made\n");
    }

    public void displayBlackbox(){
        // Black Box //
        ArrayList<String> states = BlackBox.getInstance().getStates();
        System.out.println("+++ Major Checking And Action from Blackbox +++");
        for (int i = 0; i < states.size(); i++) {
            System.out.println((i + 1) + ": " + states.get(i));
        }
        System.out.println("+++ Blackbox Displayed Finished +++");
    }
}
