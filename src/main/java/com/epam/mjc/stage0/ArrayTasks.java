package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        return new String[]{"Winter", "Spring", "Summer", "Autumn"};
    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] array = new int[length];
        for(int i = 1; i <= array.length; i++){
            array[i-1] = i;
        }
        return array;
    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        for(int i = 0; i<arr.length; i++){
            if(number == arr[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
        String[] res = new String[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            res[arr.length - 1 - i] = arr[i];
        }
        return res;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int count = 0;
        for(int k : arr){
            if(k>0)
                count++;
        }
        int[] res = new int[count];
        int j = 0;
        for (int k : arr) {
            if (k > 0) {
                res[j] = k;
                j++;
            }
        }
        return res;
    }

    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public int[][] sortRaggedArray(int[][] arr) {
        /*boolean needIteration1 = true;
        while (needIteration1) {
            needIteration1 = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].length < arr[i - 1].length) {
                    int[] tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    needIteration1 = true;
                }
            }
        }*/
        boolean needIteration2 = true;
        while (needIteration2) {
            needIteration2 = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < arr[i].length; j++) {
                    if (i + 1 < arr.length && arr[i].length > arr[i + 1].length) {
                        int[] tmp = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = tmp;
                        needIteration2 = true;
                        break;
                    }
                    if (arr[i][j] < arr[i][j - 1]) {
                        int tmp = arr[i][j];
                        arr[i][j] = arr[i][j - 1];
                        arr[i][j - 1] = tmp;
                        needIteration2 = true;
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayTasks arrayTasks = new ArrayTasks();
        //System.out.println(Arrays.deepToString(arrayTasks.sortRaggedArray(new int[][]{{3,1,2},{3, 2}, {4,3,1,2}})));
        /*System.out.println(Arrays.deepToString(Arrays.stream(new int[][]{{3, 1, 2}, {3, 2}, {4, 3, 1, 2}})
                .sorted(Comparator.comparingInt(array -> array.length))
                .peek(Arrays::sort)
                .toArray(int[][]::new)));*/
    }
}
