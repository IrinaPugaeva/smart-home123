package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventHandlerTest {
    @Test
    public void handle(){
        DoorEventProcessor doorEventProcessor = new DoorEventProcessor();
        Light light = new Light("1", true);
        Door door = new Door(true, "1");
        Room room = new Room(Arrays.asList(light), Arrays.asList(door), "myRoom");
        SmartHome home = new SmartHome(Arrays.asList(room));
        SensorEvent newEventOpen = new SensorEvent(DOOR_OPEN, "1");
        SensorEvent newEventClosed = new SensorEvent(DOOR_CLOSED, "1");
        doorEventProcessor.handle(home, newEventOpen);

        assertEquals(true, door.isOpen());
        doorEventProcessor.handle(home, newEventClosed);
        assertEquals(door.isOpen(), false);
    }

}