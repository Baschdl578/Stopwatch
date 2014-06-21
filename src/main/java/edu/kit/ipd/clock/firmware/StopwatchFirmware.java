package edu.kit.ipd.clock.firmware;

import edu.kit.ipd.clock.ButtonID;
import edu.kit.ipd.clock.IClockControl;
import edu.kit.ipd.clock.IFirmware;
import edu.kit.ipd.clock.ui.ClockFrame;

/**
 * Firmware for a stopwatch
 * @version 1.0
 * @author Sebastian Schindler
 */
public class StopwatchFirmware implements IFirmware {

    private IClockControl control;

    protected StopwatchState current = new StateOFF(this);

	public static void main(String[] args) {
		ClockFrame clock = new ClockFrame(new StopwatchFirmware());
		clock.setVisible(true);
	}

    /**
     * Sets the IClockControl for the stopwatch
     * @param control IClockControl to set
     */
    public void setClockControl(IClockControl control) {
        this.control = control;
    }

    /**
     * Calls method for button A pressed
     */
    public void buttonA() {
        current.buttonA();
        current.changeState();
    }

    /**
     * Calls method for button B pressed
     */
    public void buttonB() {
        current.buttonB();
        current.changeState();
    }

    /**
     * calls method for button C pressed
     */
    public void buttonC() {
        current.buttonC();
        current.changeState();
    }

    /**
     * Returns the IClockControl
     * @return IClockControl of this stopwatch
     */
    public IClockControl getControl() {
        return this.control;
    }

    /**
    public void buttonPressed(ButtonID button) {
        if (state == 0) {
            if (button.equals(ButtonID.A)) {
                control.setPowerOn(true);
                state = 1;
                return;
            } else return;
        }

        if (state == 1) {
            if (button.equals(ButtonID.A)) {
                control.setPowerOn(false);
                state = 0;
                return;
            }
            else if (button.equals(ButtonID.B)) {
                control.setIncrementTime(true);
                state = 2;
                return;
            } else return;
        }

        if (state == 2) {
            if (button.equals(ButtonID.B)) {
                control.setIncrementTime(false);
                state = 3;
                return;
            }
            else if (button.equals(ButtonID.C)) {
                control.storeSplitTime();
                control.setDisplaySplitTime(true);
                state = 4;
                return;
            } else return;
        }

        if (state == 3) {
            if (button.equals(ButtonID.A)) {
                control.resetTimes();
                state = 1;
                return;
            }
            else if (button.equals(ButtonID.B)) {
                control.setIncrementTime(true);
                state = 2;
                return;
            } else return;
        }

        if (state == 4) {
            if (button.equals(ButtonID.C)) {
                control.setDisplaySplitTime(false);
                state = 5;
                return;
            }
            else if (button.equals(ButtonID.B)) {
                control.setIncrementTime(false);
                control.setDisplaySplitTime(false);
                state = 6;
                return;
            } else return;
        }

        if (state == 5) {
            if (button.equals(ButtonID.B)) {
                control.setIncrementTime(false);
                state = 7;
                return;
            }
            else if (button.equals(ButtonID.C)) {
                control.storeSplitTime();
                control.setDisplaySplitTime(true);
                state = 4;
                return;
            } else return;
        }

        if (state == 6) {
            if (button.equals(ButtonID.C)) {
                control.setDisplaySplitTime(false);
                state = 7;
                return;
            } else if (button.equals(ButtonID.A)) {
                control.resetTimes();
                control.setDisplaySplitTime(false);
                state = 1;
                return;
            } else return;
        }

        if (state == 7) {
            if (button.equals(ButtonID.C)) {
                control.setDisplaySplitTime(true);
                state = 6;
            } else if (button.equals(ButtonID.B)) {
                control.setIncrementTime(true);
                state = 5;
            } else if (button.equals(ButtonID.A)) {
                control.resetTimes();
                state = 1;
            }
        }
    }
    */

    /**
     * Calls the appropriate method if a button is pressed
     * @param button Pressed Button
     */
    public void buttonPressed(ButtonID button) {
        if (button.equals(ButtonID.A)) {
            buttonA();
            return;
        }
        if (button.equals(ButtonID.B)) {
            buttonB();
            return;
        }
        if (button.equals(ButtonID.C)) {
            buttonC();
        }
    }

    /**
     * Gets an arry with button descriptions
     * @return button descriptions
     */
    public String[] getButtonDescriptions() {
        String[] out = new String[3];

        out[0] = "On/Off/Reset";
        out[1] = "Start/Stop Timer";
        out[2] = "Save/Display Splittime";

        return out;
    }



}
