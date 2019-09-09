/*
 * File: ClockSource.java
 * Author: David Green <dgreen@uab.edu>
 * Assignment:  DigitalDemo - EE333 Spring 2014
 * Vers: 1.1.0 08/12/2019 dgg - convert to Maven, packates
 * Vers: 1.0.0 01/28/2014 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.ee333.digitaldemo3;

import java.util.ArrayList;

/**
 *
 * @author David Green <dgreen@uab.edu>
 */
public class ClockSource {

    /**
     * Registered device to be clocked
     */
    private ArrayList<ClockedDevice> devices;

    public ClockSource() {
        devices = new ArrayList<>();
    }

    /**
     * Register supplied device for future clocking
     * @param device
     */
    public void addClockedDevice(ClockedDevice device) {
       devices.add(device);
    }

    /**
     * Create a rising edge (and tell all registered devices)
     */
    public void raise_clock() {
        int i;
        for (i = 0; i < devices.size(); i++) {
            devices.get(i).clock_up_start();
        }

        for (i = 0; i < devices.size(); i++) {
            devices.get(i).clock_up_finish();
        }
    }

}
