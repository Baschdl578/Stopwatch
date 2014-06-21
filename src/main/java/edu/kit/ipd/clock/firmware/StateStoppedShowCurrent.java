package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a stopped stopwatch with saved splittime showing the total time
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateStoppedShowCurrent extends StopwatchState {
    protected StopwatchState next = this;

    protected StateStoppedShowCurrent(StopwatchFirmware m) {
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
        next = new StateStoppedShowCurrent(obj);
    }

    protected void buttonC() {
        obj.getControl().setDisplaySplitTime(true);
        next = new StateStoppedShowSplit(obj);
    }

}
