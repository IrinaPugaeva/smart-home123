package ru.sbt.mipt.oop;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightEventHandlerTest {
    @Test
    public void testLightHandle (){
        LightEventProcessor lightEventProcessor = new LightEventProcessor();
        Light light = new Light("1",true);
        Door door = new Door(true,"1");
        //создаем список лампочек и дверей
        Room room = new Room(Arrays.asList(light),Arrays.asList(door),"myRoom");
        //asList принимает на вход несколько аргументов и возвращает их список
        //список комнат в доме:
        SmartHome home = new SmartHome(Arrays.asList(room));
        //newEventOFF выключает лампочку
        SensorEvent newEventOFF = new SensorEvent(LIGHT_OFF, "1");
        SensorEvent newEventON = new SensorEvent(LIGHT_ON, "1");
        //ctrl+D копировать строчку, ctrl+shift и стрелка - передвигать строчку
        lightEventProcessor.handle(home, newEventOFF);
        assertEquals(light.isOn(),false);
        lightEventProcessor.handle(home, newEventON);
        assertEquals(light.isOn(),true);


    }


}