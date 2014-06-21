package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a running stopwatch with saved splittime showing the splittime
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateRunningShowSplit extends StopwatchState {
    protected StopwatchState next = this;

    protected StateRunningShowSplit(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonB() {
        obj.getControl().setIncrementTime(false);
        obj.getControl().setDisplaySplitTime(false);
        next = new StateStoppedShowCurrent(obj);
    }

    protected void buttonC() {
        obj.getControl().setDisplaySplitTime(false);
        next = new StateRunningShowCurrent(obj);
    }

}
