package io.github.jalgorithm.algorithms.sorts.countingsort;



public abstract class CountingSort<T> {

    protected final int[] countArray;
    protected final int count;

    public CountingSort(int count) {
        this.count=count;
        countArray = new int[count];
    }

    /**
     *
     * @param array as array of data we want to sort them
     * @throws Exception if any data out of  bound  for example bounded of issue is 0-9 but find one number greater than
     *
     */
    public abstract void sort(T[] array) throws Exception;
}
