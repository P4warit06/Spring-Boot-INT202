package sit.int202.beans;

public class DieselEngine implements Engine {
    private int capacity;

    public DieselEngine() {
    }

    public DieselEngine(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void turnOn() {
        System.out.println("Turn On - Diesel Engine");
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void turnOff() {
        System.out.println("Turn Off - Diesel Engine");
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
