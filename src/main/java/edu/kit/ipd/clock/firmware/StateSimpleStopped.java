package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a stopped stopwatch without saved splittime
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateSimpleStopped extends StopwatchState {
    protected StopwatchState next = this;

    protected StateSimpleStopped(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonA() {
        obj.getControl().resetTimes();
        next = new StateON(obj);
    }

    protected void buttonB() {
        obj.getControl().setIncrementTime(true);
        next = new StateSimpleRunning(obj);
    }

}
