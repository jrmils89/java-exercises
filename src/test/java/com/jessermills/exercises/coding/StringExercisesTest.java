package com.jessermills.exercises.coding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Testing for StringExercises methods.
 */
public class StringExercisesTest
        extends TestCase
{
    public StringExercisesTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StringExercisesTest.class );
    }


    public void testReverseString()
    {

        String[] stringsToReverse = {"Hello", "World"};
        String[] reversedStrings = {"olleH", "dlroW"};

        int length = stringsToReverse.length;

        for (int i = 0; i < length; i++) {

            String originalString = stringsToReverse[i];
            String expectedString = reversedStrings[i];
            String reversedString = StringExercises.reverseString(originalString);
            assertTrue("Expect " + expectedString + " to equal " + reversedString, reversedString.equals(expectedString));
        }

    }

    public void testIsPalindromeNotIgnoringCase()
    {

        String[] palindromeStrings = {"abba", "ABBA", "WWDDWW"};

        int length = palindromeStrings.length;

        for (int i = 0; i < length; i++) {

            String str = palindromeStrings[i];
            assertTrue("Expect isPalindrome to return true for " + str , StringExercises.isPalindrome(str, false));
        }


        String[] nonPalindromeStrings = {"asbba", "AsBBA", "WsWDDWW", "wddW"};

        length = nonPalindromeStrings.length;

        for (int i = 0; i < length; i++) {

            String str = nonPalindromeStrings[i];
            assertFalse("Expect isPalindrome to return false for " + str , StringExercises.isPalindrome(str, false));
        }

    }


    public void testAnagram() {
        assertTrue(StringExercises.isAnagram("bob", "bbo"));
        assertFalse(StringExercises.isAnagram("ob", "bbo"));
        assertFalse(StringExercises.isAnagram("bob", "boo"));
        assertTrue(StringExercises.isAnagram("aa aa bb aa", "aaaaaabb"));
    }

}