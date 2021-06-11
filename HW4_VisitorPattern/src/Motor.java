public class Motor implements RoverElement{
    private String name;
    private boolean state;

    Motor(String name){
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName(){
        return this.name;
    }

    public boolean getState(){
        return this.state;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
