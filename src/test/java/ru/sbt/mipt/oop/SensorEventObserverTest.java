package ru.sbt.mipt.oop;
import org.junit.Test;


import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SensorEventObserverTest {

    @Test
    public void test() {
        SmartHome smartHome = mock(SmartHome.class);
        DoorScenarioRunner doorScenarioRunner = mock(DoorScenarioRunner.class);
        LightEventProcessor lightEventProcessor = mock(LightEventProcessor.class);
        DoorEventProcessor doorEventProcessor = mock(DoorEventProcessor.class);

        SensorEventObserver sensorEventObserver = new SensorEventObserver(asList(lightEventProcessor,
                doorEventProcessor, doorScenarioRunner));
        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.onEvent(smartHome, sensorEvent);

        verify(lightEventProcessor).handle(smartHome, sensorEvent);
        verify(doorEventProcessor).handle(smartHome, sensorEvent);
        verify(doorScenarioRunner).handle(smartHome, sensorEvent);
    }
}
