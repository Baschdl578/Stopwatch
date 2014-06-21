package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a stopped stopwatch with saved splittime showing the splittime
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateStoppedShowSplit extends StopwatchState {
    protected StopwatchState next = this;

    protected StateStoppedShowSplit(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonA() {
        obj.getControl().resetTimes();
        obj.getControl().setDisplaySplitTime(false);
        next = new StateON(obj);
    }

    protected void buttonC() {
        obj.getControl().setDisplaySplitTime(false);
        next = new StateStoppedShowCurrent(obj);
    }
}
