package com.zipcodewilmington;

import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODOdone
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO_DONE
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO_DONE
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO_DONE
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO_DONE
    public static String[] reverse(String[] array) {
        // Create a new array to store the reversed elements
        String[] reverseArray = new String[array.length];
        // Initialize a counter variable to keep track of the position in the reverseArray
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {//original array from the last element to the first element
            reverseArray[count] = array[i];// Assign each element of the original array to the reverseArray
            // Starting from the last element to the first element
            count++;// Increment the count to move to the next position in reverseArray

        }
        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO_DONE
    public static boolean isPalindromic(String[] array) {
        //create two counters that start from both ends
        int count = 0;
        int countReverse = array.length - 1;
        while (count < countReverse) {// iterates through the array until both meet in teh middle
            if (array[count].equals(array[countReverse])) {
                //if the elements at the opposite side are equal, it is a palindrome
                return true;
            }
            count++; //move each counter towards each other
            countReverse--;
        }
        return false;//if they are not equal, it is not a palindrome
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String str = String.join(" " , array).toLowerCase();// Combine all strings into a single string separated by spaces

        boolean[] check = new boolean[26];//Array to track if each letter is present
        int index = 0;//variable to hold the index of the letter in the check array

        for (int i = 0; i < str.length(); i++){// Iterate through each character in the combined string
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){// Check if the character is a lowercase letter
                index = str.charAt(i) - 'a';// Mark this letter as present
            }
            check[index] = true;
        }
        for (int i = 0; i < 26; i++){// Check if all letters from 'a' to 'z' are present in the check array
            if (!check[i]){
                return false;// If any letter is missing, return false
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO_DONE
    public static int getNumberOfOccurrences(String[] array, String value) {
        int numOfOcc = 0; //initialize #of occurances to zero
        for (int i = 0; i < array.length; i++) {// loop through the array
            if (array[i].indexOf(value) != -1) {//check if element contains 'value'. if value not found, it
                numOfOcc++; //increment number of occurances everytime value is found
            }
        }
        return numOfOcc;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO_DONE
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] result = new String[array.length - 1];//Create new array "result" with one less than input array
        int count = 0;//set the count to zero. will keep track of # of elements added to 'result' array
        for (String i : array) { // same as int index = 0; index < array.length; index++
            if (!i.equals(valueToRemove)) {//checks if current element i does not equal valueToBeRemoved
                result[count++] = i;//if it doesnt, increases count by one
            }
        }
        return result;
    }//only works if you know you are only removing one value

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] result = new String[array.length]; // new array for result
        int x = 0; // indexer for original array
        for (int i = 0; i < array.length; i++) { // loop
            result[x++] = array[i]; // add element to result
            while (i < array.length - 1 && array[i].equals(array[i + 1])) { // skip duplicate
                i++;
            }
        }
        String[] finalArray = new String[x]; // new final array
        System.arraycopy(result, 0, finalArray, 0, x); // copy to final array

        return finalArray;
    }


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> outputArray = new ArrayList<>();
        // change to string builder from basic string
        // array initialized empty first element
        StringBuilder tempConcat = new StringBuilder(array[0]);
        for (int i = 1; i < array.length; i++) {
            // while true loop, meaning while element 1 and next are equal, keep concat going
            if (array[i].equals(array[i - 1])) {
                // change + concat to append
                tempConcat.append(array[i]);
            } else {
                // change tempConcat to string
                outputArray.add(tempConcat.toString());
                // reset the stringbuilder tempcat
                tempConcat = new StringBuilder(array[i]);
            }
        }
        // add the last concat tempConcat to the output array
        outputArray.add(tempConcat.toString());
        return outputArray.toArray(new String[0]);
    }
}


//
//    }

