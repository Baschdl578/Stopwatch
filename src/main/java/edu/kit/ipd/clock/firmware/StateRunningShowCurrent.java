package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * State for a running stowatch with saved splittime showing the current total time
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StateRunningShowCurrent extends StopwatchState {
    protected StopwatchState next = this;

    protected StateRunningShowCurrent(StopwatchFirmware m) {
        super(m);
    }

    protected StopwatchState next() {
        return next;
    }

    protected void buttonB() {
        obj.getControl().setIncrementTime(false);
        next = new StateStoppedShowCurrent(obj);
    }

    protected void buttonC() {
        obj.getControl().storeSplitTime();
        obj.getControl().setDisplaySplitTime(true);
        next = new StateRunningShowSplit(obj);
    }

}
