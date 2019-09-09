/*
 * File: JKFF.class
 * Copy: Copyright (c) All Rights Reserved 2014 - David G. Green
 * Vers: 1.1.0 dgg - update to Maven, packages
 * Vers: 1.0.0 dgg - original coding
 */
package edu.uab.ee333.digitaldemo3;

/**
 * JKFF - model a JK positive edge triggered Flip Flop
 * @author dgreen
 */
public class JKFF implements ClockedDevice {

    private boolean j;
    private boolean k;
    private boolean q;

    public JKFF() {
        j = false;
        k = false;
        q = false;
    }

    /**
     * Provide Q output of FF
     * @return output value
     */
    public boolean output() {
        return q;
    }

    /**
     * change the j input to value
     * @param value that j is externally set to
     */
    public void set_j(boolean value) {
        j = value;
    }

    /**
     * change the k input to value
     * @param value that k is externally set to
     */
    public void set_k(boolean value) {
        k = value;
    }

    /**
     * Signal start of rising edge of clock (grab j, k, q0)
     */
    @Override
    public void clock_up_start() {
        // TODO - decide if I need to separate J,K between set's and read's here
    }

    /**
     * Signal end of rising edge of clock (apply FF rules)
     */
    @Override
    public void clock_up_finish() {
        if ( j && k ) {               // j = 1, k = 1
            q = !q;
        } else if ( j && !k ) {       // j = 1, k = 0
            q = true;
        } else if ( !j && k ) {       // j = 0, k = 1
            q = false;
        }
    }

    /**
     * Reset FF asynchronously
     */
    public void reset() {
        q = false;
    }

}
