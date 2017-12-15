package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

public class SensorEventObserver {
    public List<EventHandler> handlers = new ArrayList<>();

    public void addHandlers() {
        handlers.add(new LightEventProcessor());
        handlers.add(new DoorEventProcessor());
    }

    public void observe(SmartHome home){
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler : handlers) {
                handler.handle(home, event);
            }
            event = getNextSensorEvent();
        }
    }
}
