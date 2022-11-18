package io.github.jalgorithm.algorithms.sorts.countingsort;

import java.util.stream.IntStream;

/**
 * CharacterCountingSort get counting sort functionality on character
 * @author Mohammad Nasr
 */
public class CharacterCountingSort extends CountingSort<Character> {

    private static final int CHARACTER_COUNT = 256;

    private CharacterCountingSort(int count) {
        super(count);
    }

    public CharacterCountingSort() {
        this(CHARACTER_COUNT);
    }

    @Override
    public void sort(Character[] array) {
        isArrayValid(array);

        Character[] result = new Character[array.length];

        countEachCharacterOfArray(array);
        calculateSumEachNumberWithLastNumber();
        rotationOnClockwise();

        IntStream.range(0,array.length)
                .forEach(index -> result[countArray[array[index]]++]=array[index]);

        copyFromSortedArrayToArray(array, result);
    }

    private void isArrayValid(Character[] array) {
        if (array == null)
            throw new IllegalStateException("your array is must  be present !");

    }

    /**
     *
     * @param array as array of character which we want to calculate count of  every character in array
     */
    private void countEachCharacterOfArray(Character[] array) {
        for (char character : array)
            countArray[character]++;
    }

    /**
     * in this method we calculate sum count of number with count of number on previous step
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
     * @param sortedArray as sorted character we want to get copy from that
     */
    private void copyFromSortedArrayToArray(Character[] array, Character[] sortedArray) {
        IntStream.range(0,array.length)
                .forEach(index -> array[index]=sortedArray[index]);
    }

}
