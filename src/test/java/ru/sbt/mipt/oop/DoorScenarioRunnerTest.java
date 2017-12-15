package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorScenarioRunnerTest {

    @Test
    public void handle() {
        DoorScenarioRunner doorScenarioRunner = new DoorScenarioRunner();
        Light light = new Light("1", true);
        Door door = new Door(true, "1");
        Room room = new Room(Arrays.asList(light), Arrays.asList(door), "hall");
        SmartHome smartHome = new SmartHome(Arrays.asList(room));
        SensorEvent newEventOpen = new SensorEvent(DOOR_OPEN, "1");
        SensorEvent newEventClosed = new SensorEvent(DOOR_CLOSED, "1");
        doorScenarioRunner.handle(smartHome, newEventOpen);
        assertEquals(true, door.isOpen());
        assertEquals(true, light.isOn());
        doorScenarioRunner.handle(smartHome, newEventClosed);
        assertEquals(false, door.isOpen());
        assertEquals(false, light.isOn());
    }
}