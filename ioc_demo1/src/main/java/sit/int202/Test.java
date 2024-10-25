package sit.int202;

import sit.int202.beans.Car;
import sit.int202.beans.Engine;
import sit.int202.beans.GasolineEngine;

public class Test {
    public static void main(String[] args) {
        tightCoupling();        // looseCoupling();
    }

    private static void tightCoupling() {
        Engine ge = new GasolineEngine(3000);
        Car carA = new Car("ZB25478-23958D", "Toyota", ge);
        carA.start();
        System.out.println(carA);
    }
}
