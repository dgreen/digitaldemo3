/*
 * File: DemoClocking.java
 * Author: David Green <dgreen@uab.edu>
 * Assignment:  DigitalDemo - EE333 Fall 2014
 * Vers: 1.1.0 08/12/2019 dgg - update to Maven, packages
 * Vers: 1.0.0 09/11/2014 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.ee333.digitaldemo3;

/**
 *
 * @author David Green <dgreen@uab.edu>
 */
public class DemoClocking {

    public static void main(String[] args) {

        ClockSource theClock = new ClockSource();     // a clock

        JKFF ff1 = new JKFF();                        // flip flop 1
        JKFF ff2 = new JKFF();                        // flip flop 2

        theClock.addClockedDevice(ff1);               // connect flip flop 1 to clock source
        theClock.addClockedDevice(ff2);               // connect flip flop 2 to clock source

        ff1.set_j(true);                              // set up flip flop 1 to toggle (J,K both 1)
        ff1.set_k(true);

        ff2.set_j(true);                              // set flip flop to clock to a true
        ff2.set_k(false);

        System.out.println("ff1 = " + ff1.output() + " ff2 = " + ff2.output());
        System.out.println("Clock flip flops");
        theClock.raise_clock();                       // cause rising edge to emanate from clock source
        System.out.println("ff1 = " + ff1.output() + " ff2 = " + ff2.output());
        theClock.raise_clock();                       // cause (another) rising edge to emanate from clock source
        System.out.println("ff1 = " + ff1.output() + " ff2 = " + ff2.output());

    }
}
