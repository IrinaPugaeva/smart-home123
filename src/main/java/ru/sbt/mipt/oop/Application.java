package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;


public class Application {
    public static void main (String...args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Application.xml");
        SmartHome smartHome = ctx.getBean(SmartHome.class);
        SensorEventObserver observer = ctx.getBean(SensorEventObserver.class);
        observer.observe(smartHome);
    }

        //reflection (переменная типа класса)
        //при помощи рефлекшн можно смотреть и изменять значение переменной private
        // Door door = new Door(true, "efl");
        //Class clazz = door.getClass();
        //clazz.getMethods()


    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }

    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}

