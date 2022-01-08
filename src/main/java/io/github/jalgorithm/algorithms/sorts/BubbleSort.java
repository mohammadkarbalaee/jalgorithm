package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Muhammad Karbalaee
 * The class which includes the implementation of bubble sort algorithm
 * @param <T> should implement the Comparable interface
 */

public class BubbleSort<T extends Comparable<T>> extends SortAlgorithm{
  private ArrayList<T> data;

  /**
   * constructor for creating a bubble sort instance via passing an array of data
   * @param dataArray an array of data of type T
   */
  public BubbleSort(T[] dataArray) {
    this.data = new ArrayList<>(Arrays.asList(dataArray));
  }

  /**
   * constructor for creating a bubble sort instance via passing an ArrayList of data
   * @param data an ArrayList of data of type T
   */
  public BubbleSort(ArrayList<T> data) {
    this.data = data;
  }

  /**
   *
   * @param data a new ArrayList that replaces the existing one
   */
  public void setData(ArrayList<T> data) {
    this.data = data;
  }

  /**
   * this method sorts the data array using bubble sort algorithm
   * it doesn't return anything.To access the sorted data, call the getData method.
   * @implNote It also has some improvements compared to the normal algorithm because of using flags.
   * @apiNote bubble sort is so efficient for data which is already sorted and just has some minor flaws.
   */
  public void sort() {
    for (int prevSwap = 0, end = data.size() - 1; end != 0; end = prevSwap) {
      prevSwap = 0;
      for (int j = 1; j <= end; j++) {
        int comparisonResult = this.data.get(j).compareTo(this.data.get(j - 1));
        if (comparisonResult < 0) {
          super.swap(this.data,j,j - 1);
          prevSwap = j - 1;
        }
      }
    }
  }

  /**
   *
   * @return data or sorted data. depends on whether you have called sort method before calling it or not
   */
  public ArrayList<T> getData() {
    return data;
  }
}
