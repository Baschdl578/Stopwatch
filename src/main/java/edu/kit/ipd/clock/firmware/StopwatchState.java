package edu.kit.ipd.clock.firmware;

/**
 * Created by Sebastian Schindler on 21.06.2014.
 *
 * Abstract state for a stopwatch
 */
abstract class StopwatchState {
    protected StopwatchFirmware obj;

    /**
     * Constructs a new State with a StopwatchFirmware
     * @param m
     */
    protected StopwatchState(StopwatchFirmware m) {
        obj = m;
    }

    /**
     * Default entry method
     */
    protected void entry() { }

    /**
     * Default exit method
     */
    protected void exit() { }

    /**
     * Method for button A pressed
     */
    protected void buttonA() {
        return;
    }

    /**
     * Method for button B pressed
     */
    protected void buttonB() {
        return;
    }

    /**
     * Method for button C pressed
     */
    protected void buttonC() {
        return;
    }

    /**
     * Abstract method that returns the next state
     * @return next state
     */
    protected abstract StopwatchState next();


    /**
     * Changes to the state provided by next()
     */
    protected final void changeState() {
        StopwatchState n = next();
        if (n != this) {
            this.exit();
            n.entry();
            obj.current = n;
        }
    }

}
