package com.techelevator;

import java.util.ArrayList;
import java.util.List;

class DistinctArray {
    /**
     * You are given an input array of integers. Write a function to remove any duplicate
     * numbers from the input array
     * <p>
     * for example, given array:
     * <p>
     * [2, 3, 1, 8, 4, 8, 5, 1, 9, 8, 6]
     * <p>
     * the function returns:
     * <p>
     * [2, 3, 1, 8, 4, 5, 9, 6]
     * <p>
     * Provide 2 implementations for this function:
     * A) - The unique numbers in the returned array can be in ANY order
     * (easier case).
     * Implement inside removeDuplicates() function below.
     * <p>
     * B) - The unique numbers in the returned array must be in the SAME
     * order as the input array (see example above).
     * Implement inside removeDuplicatesPreserveOrder() function below.
     * <p>
     * NOTE: This kata is similar to a problem that you may get as a part of an interview assessment.
     * To keep this exercise realistic, PLEASE DON'T SEARCH THE WEB FOR A COMPLETE SOLUTION TO
     * REMOVING DUPLICATES FROM AN ARRAY.
     */

    public int[] removeDuplicates(int[] input) {

        List<Integer> broccoli = new ArrayList<>();
        List<Integer> carrot = new ArrayList<>();

            if(input==null){
                throw new NullPointerException("null");
            }
            else {
                for (int i = 0; i < input.length; i++) {

                    broccoli.add(input[i]);
                }

                for (int i = 0; i < input.length; i++) {
                    if (carrot.contains(broccoli.indexOf(i))) {
                        continue;
                    } else {
                        carrot.add(broccoli.indexOf(i));
                    }
                }
                int[] result = new int[carrot.size()];
                for (int i : carrot) {
                    result[i] = carrot.indexOf(i);

                }
            }

            return result;}





            public int[] removeDuplicatesPreserveOrder (int[] input){

                throw new UnsupportedOperationException("This method is not yet implemented");
            }
        }


