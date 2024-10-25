package sit.int202.beans;

public class GasolineEngine implements Engine {
    private int capacity;

    public GasolineEngine() {
    }

    public GasolineEngine(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void turnOn() {
        System.out.println("Turn On - Gasoline Engine");
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void turnOff() {
        System.out.println("Turn Off - Gasoline Engine");
    }
}
