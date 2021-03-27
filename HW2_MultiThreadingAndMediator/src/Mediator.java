public interface Mediator {
    public abstract void increaseSpeed();
    public abstract void decreaseSpeed();
    public abstract void stopSpeed();
    public abstract void increaseTemp();
    public abstract void decreaseTemp();
    public abstract void createCarStatus() throws InterruptedException;
}
