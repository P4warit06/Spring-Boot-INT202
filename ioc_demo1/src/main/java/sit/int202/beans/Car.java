package sit.int202.beans;

public class Car {
    private String chasisNumber;
    private String brand;
    private Engine engine;

    public Car() {
    }

    public Car(String chasisNumber, String brand, Engine engine) {
        this.chasisNumber = chasisNumber;
        this.brand = brand;
        this.engine = engine;
    }

    public void start() {
        engine.turnOn();
    }

    @Override
    public String toString() {
        return "Car: " + chasisNumber + " - " + brand + ", " + engine.getCapacity();
    }
}
