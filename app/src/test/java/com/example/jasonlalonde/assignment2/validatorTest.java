package com.example.jasonlalonde.assignment2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Jason Lalonde on 2/9/2018.
 */

public class validatorTest {
    @BeforeClass
    public static void runOnce(){
        System.out.println("This will only run once before everything else");
    }
    @AfterClass
    public static void alsoRunOnce(){
        System.out.println("This will only run once after everything else");
    }
    @Before
    public void BeforeEachTest(){
        System.out.println("Start of test");
    }
    @After
    public void afterEachTest(){
        System.out.println("End of test");
    }
    @Test
    public void testIsLength() throws Exception {
        String s="8LETTERS";
        Validator myVal = new Validator(s);
        assertTrue(myVal.isLength());
    }
    @Test
    public void testIsCorrect() throws Exception {
        String s="AnyWordButNothingAndPassword";
        Validator myVal = new Validator(s);
        assertTrue(myVal.isCorrect());
    }
}
