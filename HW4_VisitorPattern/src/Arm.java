public class Arm implements RoverElement, Cloneable{
    private String name;
    private boolean state;

    Arm (String name){
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public Object clone() {
        try {
            Arm copy = (Arm) super.clone();
            return copy;

        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }

    }
    public boolean getState(){
        return this.state;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
