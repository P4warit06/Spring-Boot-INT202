package sit.int202.config;

import org.springframework.context.annotation.Bean;
import sit.int202.beans.Car;
import sit.int202.beans.DieselEngine;
import sit.int202.beans.Engine;

public class ApplicationConfig {
    //object car ต้องการ Bean ของ Engine
    @Bean(name = "car")
    public Car getCar() {
        return new Car("ZM4969JXX", "Toyota-Fortuner", fortunerEngine());
    }
    //Bean ของ  Engine
    @Bean(name = "1KD-FTV")
    public Engine fortunerEngine() {
        return new DieselEngine(2499);
    }
}
