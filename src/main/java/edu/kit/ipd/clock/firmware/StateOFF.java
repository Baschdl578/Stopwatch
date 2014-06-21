package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State of a turned-off stopwatch
 * @author Sebastian Schindler
 * @version 1.0
 */
public class StateOFF extends StopwatchState {
    protected StopwatchState next = this;

    protected StateOFF(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonA() {
        obj.getControl().setPowerOn(true);
        next = new StateON(obj);
    }
}
