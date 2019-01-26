package com.jessermills.exercises.coding;

import java.util.HashMap;

public class ListExercises {
    public ListExercises() {

    }

    public static void transformWords(String[] words) {

        HashMap<String, Boolean> shortenedWords = new HashMap<String, Boolean>();


        for (String word : words) {

            String newWord = shortenWordValidatingPreviousAcronyms(shortenedWords, word);

            // If the acrnoym returns null, just continue
            if (newWord == null)
                continue;

            // Print out the acronym
            System.out.println(newWord);

        }


    }

    // Note: this is a static method just for testing purposes, in a production env I'd make this private as it modifies
    // one of the inputs without returning it, which is not a practice I like
    public static String shortenWordValidatingPreviousAcronyms(HashMap<String, Boolean> shortenedWords, String word) {

        // If the word is empty, return null
        if (word.isEmpty())
            return null;

        // Start with a length offset of 0
        int offset = 0;

        // Shorten the word, note we don't need to do a null
        // check here because we've already checked for an empty string above
        String shortenedWord = shortenWord(word, offset);


        // If the shortned word didn't already exist, add it to the map and return it
        if (!shortenedWords.containsKey(shortenedWord)) {
            shortenedWords.put(shortenedWord, true);

            return shortenedWord;
        }

        /**
         * Keep attempting to build new shortened words, increasing the offset until we find a unique
         * acronym.
         */
        while (shortenedWords.containsKey(shortenedWord) && offset < word.length()) {
            shortenedWord = shortenWord(word, offset);
            offset += 1;
        }

        /**
         * Check if the shortned word exists already in the map, this is an edge
         * case that exists where all variations of the word already were created
         */

        if (shortenedWords.containsKey(shortenedWord))
            return null;

        /**
         * If the acronym doesn't exist add it to the map as it's a new acronym
         * Once we do that we can return the new word
         */
        shortenedWords.put(shortenedWord, true);
        return shortenedWord;
    }

    public static String shortenWord(String word, int offset) {

        // If the word is empty return null, null is our error case here
        if (word.isEmpty())
            return null;

        int length = word.length();

        // Add two to the offset so that we exclude first and last characters
        int numberOffset = offset + 2;
        int substrIndexOffset = 1 + offset;

        // If the offset is larger than length minus one, just return the word because the count would include
        // the last character, which we don't want. For example, if the offset is 2 and the word is "aaa" it's
        // not useful to print a1a.
        if (numberOffset >= length - 1)
            return word;

        // I'd probably prefer a string builder here, but this works for now. Substr is not a particularly
        // efficient method as it creates a copy, so we're using some extra memory here that could be
        // made more efficient
        return word.substring(0, substrIndexOffset) + (length - numberOffset) + word.charAt(length - 1);
    }

}