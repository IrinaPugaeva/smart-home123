package ru.sbt.mipt.oop;

//import org.junit.Test;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmSystemTest {

    @Test
    public void testNewSystemIsOff() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.OFF, alarmSystem.getSystemState());
    }

    @Test
    public void testTurnOnSetsOnState() {
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.ON, alarmSystem.getSystemState());
    }

    @Test
    public void testWaitsForPasswordWhenSensorEvent(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(
                SensorEventType.DOOR_OPEN,
                "1");
        alarmSystem.onSensor(event);
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getSystemState());
    }

    @Test
    public void test2(){
        AlarmSystem alarmSystem = new AlarmSystem();
        alarmSystem.turnOn();
        SensorEvent event = new SensorEvent(
                SensorEventType.DOOR_OPEN,
                "1");
        alarmSystem.onSensor(event);
        alarmSystem.turnOn();
        assertEquals(AlarmSystemStateEnum.WAIT_FOR_PASSWORD, alarmSystem.getSystemState());
    }

}