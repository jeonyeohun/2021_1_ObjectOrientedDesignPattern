public class Camera implements RoverElement{
    private boolean state;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public boolean getState(){
        return this.state;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
