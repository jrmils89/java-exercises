package com.jessermills.exercises.coding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ExampleExerciseTest
        extends TestCase
{
    public ExampleExerciseTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExampleExerciseTest.class );
    }


    public void testTestMeMethod()
    {
        ExampleExercise exampleExercise = new ExampleExercise();
        assertEquals(true , exampleExercise.testMe());
    }
}