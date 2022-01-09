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
    sort(0, data.size());
  }

  /**
   * this method sorts a part of the array indicated by left and right index
   * @param left is the starting of the partition to sort. It is inclusive
   * @param right is the end of the partition to sort. It is exclusive
   * it doesn't return anything.To access the sorted data, call the getData method.
   * @apiNote bubble sort is so efficient for data which is already sorted and just has some minor flaws.
   */
  public void sort(int left, int right) {
    if(!checkBounds(left, right)) {
      throw new IndexOutOfBoundsException("left:" + left + " right:" + right + " size:" + data.size());
    }
    for (int prevSwap = left, end = right - 1; end != 0; end = prevSwap) {
      prevSwap = left;
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
   * this method checks bounds for left and right indexes given to sort method
   * @return true if bounds are correct else false.
   */
  private boolean checkBounds(int left, int right) {
    return left < right && left >= 0 && right <= data.size();
  }
  /**
   *
   * @return data or sorted data. depends on whether you have called sort method before calling it or not
   */
  public ArrayList<T> getData() {
    return data;
  }
}
