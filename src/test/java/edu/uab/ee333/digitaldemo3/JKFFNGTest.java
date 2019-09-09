/*
 * File: JKFFNGTest.java
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
public class JKFFNGTest {


    private JKFF ff1;

    public JKFFNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
         ff1 = new JKFF();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of clock_up_start method, of class JKFF.
     */
    @Test
    public void testClock_up_start() {
        boolean initial_value = ff1.output();
        ff1.clock_up_start();
        assertEquals(initial_value, ff1.output());
    }

    /**
     * Test of Toggle command (j=1, k=1).
     */
    @Test
    public void testToggleCommand() {
        boolean initial_value = ff1.output();
        ff1.set_j(true);
        ff1.set_k(true);
        ff1.clock_up_start();
        ff1.clock_up_finish();
        assertEquals(! initial_value, ff1.output());
    }

   /**
     * Test of Set and Reset commands (j=1, k=0; j=0, k=1).
     */
    @Test
    public void testSetAndResetCommand() {
        // set ff
        ff1.set_j(true);
        ff1.set_k(false);
        ff1.clock_up_start();
        ff1.clock_up_finish();
        assertEquals(true, ff1.output());
        // reset ff
        ff1.set_j(false);
        ff1.set_k(true);
        ff1.clock_up_start();
        ff1.clock_up_finish();
        assertEquals(false, ff1.output());
    }

   /**
     * Test of Set and Reset commands (j=1, k=0; j=0, k=1).
     */
    @Test
    public void testAsyncResetCommand() {
        // set ff
        ff1.set_j(true);
        ff1.set_k(false);
        ff1.clock_up_start();
        ff1.clock_up_finish();
        assertEquals(true, ff1.output());
        ff1.reset();
        assertEquals(false, ff1.output());
    }

    /**
     * Test of clock_up_finish method, of class JKFF.
     */
    @Test
    public void testClock_up_finish() {
        System.out.println("clock_up_finish");
        JKFF instance = new JKFF();
        instance.clock_up_finish();
        // TODO review the generated test code and add assert
    }

}