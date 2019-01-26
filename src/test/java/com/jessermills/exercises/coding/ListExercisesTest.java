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
    public class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
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

        List<Tuple<String, String>> originalWordAndNewWord = new ArrayList<>();

        originalWordAndNewWord.add(new Tuple<>("internationalization", "i18n"));
        originalWordAndNewWord.add(new Tuple<>("aaa", "aaa"));
        originalWordAndNewWord.add(new Tuple<>("", null));


        for (Tuple<String, String> word : originalWordAndNewWord) {

            String newWord = ListExercises.shortenWord(word.x, 0);
            assertEquals(word.y, newWord);
        }
    }

    public void testShortenWordWithNoDuplicationAllowed() {

        Tuple<String, String>[] originalWordAndNewWord = new Tuple[]{
                new Tuple<>("internationalization", "i18n"),
                new Tuple<>("internationalization", "in17n"),
                new Tuple<>("internationalization", "int16n"),
                new Tuple<>("aaa", "aaa"),
                new Tuple<>("", null)
        };

        HashMap<String, Boolean> shortenedWords = new HashMap<>();


        for (Tuple<String, String> word : originalWordAndNewWord) {

            String newWord = ListExercises.shortenWordValidatingPreviousAcronyms(shortenedWords, word.x);
            assertEquals(word.y, newWord);
        }

    }


}