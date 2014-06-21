package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a turned-on stopwatch
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateON extends StopwatchState {
    protected StopwatchState next = this;

    protected StateON(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonA() {
        obj.getControl().setPowerOn(false);
        next = new StateOFF(obj);
    }

    protected void buttonB() {
        obj.getControl().setIncrementTime(true);
        next = new StateSimpleRunning(obj);
    }
}
