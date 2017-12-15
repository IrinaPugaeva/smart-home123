package ru.sbt.mipt.oop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;

//import static ru.sbt.mipt.oop.SensorEventType.*;


public class Application {

    public Application() throws IOException {
    }

    public void main(String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("Application.xml");
        /* создание дома */

        SensorEventObserver sensorEventObserver = new SensorEventObserver();
        sensorEventObserver.addHandlers();
        sensorEventObserver.observe(smartHome);
    }
         // считываем состояние дома из файла
        SmartHome smartHome = ReadHome.getSmartHome("smart-home-1.js");


        //reflection (переменная типа класса)
        //при помощи рефлекшн можно смотреть и изменять значение переменной private
        // Door door = new Door(true, "efl");
        //Class clazz = door.getClass();
        //clazz.getMethods()



    public static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }

    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
