package io.github.jalgorithm.algorithms.sorts.countingsort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * NumericCountingSort get counting sort functionality on number with specific limitation
 *
 * @author Mohammad Nasr
 */
public class NumericCountingSort extends CountingSort<Integer> {

    public NumericCountingSort(int count) {
        super(count);
    }

    @Override
    public void sort(Integer[] array) throws Exception {

        isArrayValid(array);

        Integer[] result = new Integer[array.length];

        int min = calculateMinNumberOnArray(array);
        countEachNumberOfArray(array, min);
        calculateSumEachNumberWithLastNumber();
        rotationOnClockwise();

        for (int number : array) {
            result[countArray[number - min]] = number;
            countArray[number - min]++;
        }
        copyFromSortedArrayToArray(array, result);

    }

    private void isArrayValid(Integer[] array) {
        if (array == null)
            throw new IllegalStateException("your array is must  be present !");

    }

    /**
     *
     * @param array as parameter with many number
     * @return min value of array if exists otherwise throw IllegalStateException
     */
    private int calculateMinNumberOnArray(Integer[] array) {

        return Arrays.stream(array).mapToInt(number -> number)
                .min()
                .orElseThrow(() -> new IllegalStateException("dont find any value in array !"));
    }

    /**
     * @param array get array of number
     *              calculate count of every number have been seen in every step
     */

    private void countEachNumberOfArray(Integer[] array, int min) {

        try {

            for (int number : array)
                countArray[number - min]++;

        } catch (Exception e) {
            throw new IllegalStateException("your number out of expected count");
        }
    }

    /**
     * in this method we sum count of number with count of number on previous step
     * indeed index 0 don't change then will start from index 1
     */

    private void calculateSumEachNumberWithLastNumber() {
        IntStream.range(1, count)
                .forEach(index -> countArray[index] += countArray[index - 1]);
    }

    /**
     * in this method rotate data on clock wise and use them
     */
    private void rotationOnClockwise() {

        for (int number = count - 1; number > 0; number--)
            countArray[number] = countArray[number - 1];

        countArray[0] = 0;

    }

    /**
     * @param array       as disordered array we want to copy all of ordered array to this array
     * @param sortedArray as sorted number we want to get copy from that
     */

    private void copyFromSortedArrayToArray(Integer[] array, Integer[] sortedArray) {
        IntStream.range(0, array.length)
                .forEach(index -> array[index] = sortedArray[index]);
    }

}
