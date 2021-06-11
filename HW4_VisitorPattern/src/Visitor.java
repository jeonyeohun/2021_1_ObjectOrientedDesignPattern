public interface Visitor {
    public void visit(Motor motor);
    public void visit(Camera camera);
    public void visit(Wheel wheel);
    public void visit(Arm arm);
    public void visit(SolarPanel solarPanel);
}
