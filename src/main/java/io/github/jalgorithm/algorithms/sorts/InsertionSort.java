package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Muhammad Karbalaee
 * The class which includes the implementation of insertion sort algorithm
 * @param <T> should implement the Comparable interface
 */

public class InsertionSort<T extends Comparable<T>> extends SortAlgorithm{
  private ArrayList<T> data;

  /**
   * constructor for creating an insertion sort instance via passing an array of data
   * @param dataArray an array of data of type T
   */
  public InsertionSort(T[] dataArray) {
    this.data = new ArrayList<>(Arrays.asList(dataArray));
  }

  /**
   * constructor for creating an insertion sort instance via passing an ArrayList of data
   * @param data an ArrayList of data of type T
   */
  public InsertionSort(ArrayList<T> data) {
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
   * this method sorts the data array using insertion sort algorithm
   * it doesn't return anything.To access the sorted data, call the getData method.
   * insertion sort is so efficient when it comes to sorting small arrays.
   */
  public void sort() {
    for (int i = 1; i < this.data.size(); i++) {
      T key = this.data.get(i);
      int j = i - 1;
      while (j >= 0 && this.data.get(j).compareTo(key) > 0) {
        this.data.set(j + 1,this.data.get(j));
        j--;
      }
      this.data.set(j + 1,key);
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
