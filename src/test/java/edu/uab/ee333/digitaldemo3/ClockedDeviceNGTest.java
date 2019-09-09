/*
 * File: ClockedDeviceNGTest.java
 * Author: David G. Green DGreen@uab.edu
 * Assignment:  DigitalDemo - EE333 Spring 2019
 * Vers: 1.0.0 01/22/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.ee333.digitaldemo3;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author David G. Green DGreen@uab.edu
 */
public class ClockedDeviceNGTest {

    private ClockSource theClock;

    public ClockedDeviceNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        theClock = new ClockSource();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of ClockSource applied to JK.
     */
    @Test
    public void testWiredJK() {
        /*
          1. Make A JKFF
          2. Wire to clockSource
          3. Apply asynchronous reset
          4. Apply JK to toggle
          5. Raise the clock
          6. Check for ff1 == 1
          7. Raise the clock
          8. Check for ff1 = 0
        */
        JKFF ff1 = new JKFF();
        JKFF ff2 = new JKFF();
        theClock.addClockedDevice(ff1);
        theClock.addClockedDevice(ff2);
        ff1.reset();
        ff2.reset();
        ff1.set_j(true);
        ff1.set_k(true);
        ff2.set_j(true);
        ff2.set_k(false);
        theClock.raise_clock();
        assertTrue(ff1.output());
        assertTrue(ff2.output());
        theClock.raise_clock();
        assertTrue(! ff1.output());
        assertTrue(ff2.output());
    }

}