package ru.sbt.mipt.oop;

public interface AlarmSystemState {
    AlarmSystemStateEnum getState();
    void turnOn();
    void turnOff();

    void onEvent(SensorEvent sensorEvent);
//изменить состояние системы
    void enterPassword(String password);
}
