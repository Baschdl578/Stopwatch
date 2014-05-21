package edu.kit.ipd.clock.firmware;

import edu.kit.ipd.clock.ButtonID;
import edu.kit.ipd.clock.IClockControl;
import edu.kit.ipd.clock.IFirmware;
import edu.kit.ipd.clock.ui.ClockFrame;

public class StopwatchFirmware implements IFirmware {
    /**
     * Defines the state of the watch
     *
     * 0 is for off
     * 1 is for on
     * 2 is for simple stopwatch started
     * 3 is for simple stopwatch stopped
     * 4 is for running stopwatch with saved SplitTime (showing SplitTime)
     * 5 is for running stopwatch with saved SplitTime (showing stopwatch)
     * 6 is for stopped stopwatch with saved SplitTime (showing SplitTime)
     * 7 is for stopped stopwatch with saved SplitTime (showing stopwatch)
     *
     */
    public byte state = 0;
    private IClockControl control;

	public static void main(String[] args) {
		ClockFrame clock = new ClockFrame(new StopwatchFirmware());
		clock.setVisible(true);
	}


    public void setClockControl(IClockControl control) {
        this.control = control;
    }

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
                return;
            } else if (button.equals(ButtonID.B)) {
                control.setIncrementTime(true);
                state = 5;
                return;
            } else if (button.equals(ButtonID.A)) {
                control.resetTimes();
                state = 1;
                return;
            } else return;
        }
    }


    public String[] getButtonDescriptions() {
        String[] out = new String[3];
        out[0] = "On/Off";
        out[1] = "Start/Stop";
        out[2] = "Save Splittime";
        return out;
    }



}
