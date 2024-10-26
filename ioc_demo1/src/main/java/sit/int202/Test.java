package sit.int202;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sit.int202.beans.Car;
import sit.int202.beans.Engine;
import sit.int202.beans.GasolineEngine;
import sit.int202.config.ApplicationConfig;

public class Test {
    public static void main(String[] args) {
        //tightCoupling();
        looseCoupling();
        codeBase();
    }

    private static void codeBase() {
        ApplicationContext ct = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        System.out.println("------ Code_Base_Bring Data From ApplicationConfig -------");
        Car car = (Car) ct.getBean("car");
        car.start();
        System.out.println(car);
        System.out.println("-------------");
    }

    private static void tightCoupling() {
        Engine ge = new GasolineEngine(3000);
        Car carA = new Car("ZB25478-23958D", "Toyota", ge);
        carA.start();
        System.out.println(carA);
        System.out.println("-------------------");
    }

    private static void looseCoupling() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Car car = (Car) context.getBean("car");
        car.start();
        System.out.println("-------------");
        System.out.println("--LooseCoupling--");
        System.out.println(car);
        Car car2 = (Car) context.getBean("carX");
        car2.start();
        System.out.println(car2);
        car2.getEngine().turnOff();
        System.out.println("-------------------");

    }

}
