package com.jessermills.exercises.coding;

import java.util.HashMap;

public class StringExercises {
    public StringExercises() {}


    /**
     * Reverse a string
     *
     * This method reverses a string by converting the string into a byte array
     * and swapping the positions of the bytes. Note that this will use the default
     * JVM encoding
     * @param str
     * @return
     */
    public static String reverseString(String str) {

        // Check if the string is null, empty, or 1 character only
        if (str == null || str.isEmpty() || str.length() <= 1)
            return str;

        /**
         * Convert the string to bytes.
         *
         * This uses the default JVM character encoding
         */
        byte[] originalByteArrayStr = str.getBytes();

        // Get the left and right positions of the byte array
        int right = originalByteArrayStr.length - 1;
        int left = 0;

        // Swap bytes in place using temporary storage
        while (left < right) {

            // Temporarily store the value of the left and right byte, so we can swap them
            byte rightByte = originalByteArrayStr[right];
            byte leftByte = originalByteArrayStr[left];

            // Perform the byte position swap
            originalByteArrayStr[left] = rightByte;
            originalByteArrayStr[right] = leftByte;

            // Increment and decrement our left and right position respectively
            left++;
            right--;
        }

        // Convert the byte array back into a string
        return new String(originalByteArrayStr);
    }

    public static boolean isPalindrome(String str, Boolean ignoreCase) {

        // Check if the string is null, empty, or 1 character only
        if (str == null || str.isEmpty() || str.length() <= 1)
            return true;


        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (!ignoreCase && str.charAt(left) != str.charAt(right))
                return false;

            if (ignoreCase && Character.toUpperCase(str.charAt(left)) != Character.toUpperCase(str.charAt(right)))
                return false;

            left++;
            right--;
        }

        return true;

    }

    public static boolean isAnagram(String strOne, String strTwo) throws IllegalArgumentException {

        // Make sure we don't have null values
        if (strOne == null || strTwo == null)
            throw new IllegalArgumentException("One or both strings is null");

        /**
         * Replace spaces and lower case the strings, note that we could
         * do this check while building up the map, but this is somewhat simpler
         * to understand/read, and it also allows us to not have to check to index
         * out of bounds issues when iterating through characters
         */
        String strOneCopy = strOne.replaceAll("\\s", "").toLowerCase();
        String strTwoCopy = strTwo.replaceAll("\\s", "").toLowerCase();

        if (strOne.isEmpty() || strTwo.isEmpty())
            return false;

        int strOneLen = strOneCopy.length();
        int strTwoLen = strTwoCopy.length();

        // If the strings aren't the same length they cannot be anagrams
        if (strOneLen != strTwoLen)
            return false;

        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();


        /**
         * Build a map of the counts of each character.
         *
         * The count will be positive if a character appears in first string one or more
         * times more than it appears in the second string
         *
         * The count will be negative if a character appears in second string one or more
         * times more than it appears in the first string
         */
        for (int i = 0; i < strOneLen; i++) {

            /**
             * Get the character from string one, we're not worried about out of bound index issues here
             * as we've already checked that the strings are the same length so there should
             * be characters at every index here for both strings
             */
            char charValKey = strOneCopy.charAt(i);

            int charKeyCount = 0;

            // Check if we've already seen this character and get the existing count if so
            if (charCount.containsKey(charValKey))
                charKeyCount = charCount.get(charValKey);

            // Increment the count
            charCount.put(charValKey, ++charKeyCount);


            /**
             * Get the character from string two, we're not worried about out of bound index issues here
             * as we've already checked that the strings are the same length so there should
             * be characters at every index here for both strings
             */
            charValKey = strTwoCopy.charAt(i);
            charKeyCount = 0;

            // Check if we've already seen this character and get the existing count if so
            if (charCount.containsKey(charValKey))
                charKeyCount = charCount.get(charValKey);

            // Decrement the count
            charCount.put(charValKey, --charKeyCount);

        }


        for (int value : charCount.values()) {
            if (value != 0)
                return false;
        }

        return true;
    }


}
