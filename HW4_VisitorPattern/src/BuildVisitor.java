import java.util.Random;

public class BuildVisitor implements Visitor{

    Builder builder;
    BuildVisitor(Builder builder){
        this.builder = builder;
    }

    @Override
    public void visit(Motor motor) {
        String title = "Control of " + motor.getName() + " Motor";
        String detail;
        Random rand = new Random();
        int rmpType = rand.nextInt(3);
        if (rmpType == 0){
            detail = "RMP Increased --> Decrease Power to " + motor.getName() + " Motor";
        }
        else if (rmpType == 1){
            detail = "Constant RMP --> Keep the Same Power to " + motor.getName() + " Motor";
        }
        else {
            detail = "RMP Decreased --> Increase Power to " + motor.getName() + " Motor";
        }

        builder.makeItems(new String[]{title, detail});

    }

    @Override
    public void visit(Camera camera) {
        Random rand = new Random();
        int type = rand.nextInt(3);

        if (type == 0){
            builder.makeItems(new String[]{"Camera Taking Pictures of 180 degrees View"});
        }
        else if (type == 1){
            builder.makeItems(new String[]{"Camera Taking Pictures of 270 degrees View"});
        }
        else{
            builder.makeItems(new String[]{"Camera Taking Pictures of 360 degrees View"});
        }
    }

    @Override
    public void visit(Wheel wheel) {
        String title = "Turning " + wheel.getName() + " wheel";
        String detail;
        Random rand = new Random();
        int groundType = rand.nextInt(3);

        if (groundType == 0){
            detail = "Pebble Ground --> Enlarge " + wheel.getName() + " Wheel Thread";
        }
        else if (groundType == 1) {
            detail = "Mushy Ground --> Widen " + wheel.getName() + " Wheel Width";
        }
        else {
            detail = "Slippery Ground --> Extrude Spike from " + wheel.getName() + " Wheel Shoe";
        }

        builder.makeItems(new String[]{title, detail});
    }

    @Override
    public void visit(Arm arm) {
        Random rand = new Random();
        int type = rand.nextInt(4);

        if (type == 0){
            builder.makeItems(new String[]{"Rear Robot Arm in Fine Calibration"});
        }
        else if (type == 1){
            builder.makeItems(new String[]{"Both Front and Rear Robot Arms in Fine Calibration"});
        }
        else if (type == 2){
            builder.makeItems(new String[]{"Front Robot Arm in Fine Calibration"});
        }
        else {
            builder.makeItems(new String[]{"Robot Arm in Complete Calibration"});
        }
    }

    @Override
    public void visit(SolarPanel solarPanel) {
        String title = "Solar Panel " + solarPanel.getId() + " Generating Electricity...";
        Random rand = new Random();
        int watts = rand.nextInt(10) + 11;

        String detail = "Charging " + watts + "KW";

        builder.makeItems(new String[]{title, detail});
    }
}
