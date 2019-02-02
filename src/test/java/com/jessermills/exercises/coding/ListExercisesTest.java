package com.jessermills.exercises.coding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Testing for ListExercises methods.
 */
public class ListExercisesTest
        extends TestCase
{

    public ListExercisesTest(String testName )
    {
        super( testName );
    }


    // Small tuple class for testing purposes
    public class TestTuple<X, Y> {
        public final X x;
        public final Y y;
        public TestTuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }


    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ListExercisesTest.class );
    }


    public void testShortenWord() {

        List<TestTuple<String, String>> originalWordAndNewWord = new ArrayList<>();

        originalWordAndNewWord.add(new TestTuple<>("internationalization", "i18n"));
        originalWordAndNewWord.add(new TestTuple<>("aaa", "aaa"));
        originalWordAndNewWord.add(new TestTuple<>("", null));


        for (TestTuple<String, String> word : originalWordAndNewWord) {

            String newWord = ListExercises.shortenWord(word.x, 0);
            assertEquals(word.y, newWord);
        }
    }

    public void testShortenWordWithNoDuplicationAllowed() {

        TestTuple<String, String>[] originalWordAndNewWord = new TestTuple[]{
                new TestTuple<>("internationalization", "i18n"),
                new TestTuple<>("internationalization", "i18n"),
                new TestTuple<>("internationalization", "i18n"),
                new TestTuple<>("intdrnationalization", "in17n"),
                new TestTuple<>("intdrnazionalization", "int16n"),
                new TestTuple<>("intdrnazionalization", "int16n"),
                new TestTuple<>("aaa", "aaa"),
                new TestTuple<>("", null)
        };

        HashMap<String, String> shortenedWords = new HashMap<>();


        for (TestTuple<String, String> word : originalWordAndNewWord) {

            String newWord = ListExercises.shortenWordValidatingPreviousAcronyms(shortenedWords, word.x);
            assertEquals(word.y, newWord);
        }

    }



}