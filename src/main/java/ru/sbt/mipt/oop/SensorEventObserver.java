package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.List;

import static ru.sbt.mipt.oop.Application.getNextSensorEvent;

public class SensorEventObserver {
    public List<EventHandler> handlers = new ArrayList<>();

    public SensorEventObserver(List<EventHandler> eventHandlers) {
        handlers = eventHandlers;
    }

    public void addHandlers(EventHandler eventHandler) {
        handlers.add(eventHandler);
    }

    public void observe(SmartHome home) {
        SensorEvent event = getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventHandler handler : handlers) {
                handler.handle(home, event);
            }
            event = getNextSensorEvent();
        }
    }

    public void onEvent(SmartHome smartHome, SensorEvent event) {
        System.out.println("Got event: " + event.getType());
        for (EventHandler handler : handlers) {
            handler.handle(smartHome, event);
        }
    }
}