package ru.sbt.mipt.oop;

/**
 * Created by user on 15.12.2017.
 */
public class EventHandlerDecorator implements EventHandler {
    EventHandler eventHandler;

    public EventHandlerDecorator(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void handle(SmartHome home, SensorEvent event) {
        System.out.println(System.nanoTime() +" start");
        long a = System.nanoTime();
        eventHandler.handle(home, event);
        System.out.println(System.nanoTime() +" end");
        long b = System.nanoTime();
        System.out.println("time of event = " + (b - a));
    }
}
