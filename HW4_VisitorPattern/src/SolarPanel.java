import java.util.Random;

public class SolarPanel implements RoverElement{
    private int id;
    private boolean state;
    private int watts;
    SolarPanel(int id){
        this.id = id;
    }
    private int KWs[] = {20, 22, 24, 26};

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getId(){
        return this.id;
    }

    public boolean getState(){
        return this.state;
    }

    public void setState(boolean state){
        this.state = state;
    }

    public void setWatts(int watts){
        this.watts = watts;
    }

    public int getWatts(){
        return this.watts;
    }

    public int generateRandomWatts(){
        Random rand = new Random();
        int idx = rand.nextInt(4);

        return KWs[idx];
    }
}
