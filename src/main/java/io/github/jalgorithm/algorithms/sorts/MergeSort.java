package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Muhammad Karbalaee
 * The class which includes the implementation of merge sort algorithm
 * @param <T> should implement the Comparable interface
 */
public class MergeSort<T extends Comparable<T>> extends SortAlgorithm<T>{
  private ArrayList<T> data;

  /**
   * constructor for creating a merge sort instance via passing an array of data
   * @param dataArray an array of data of type T
   */
  public MergeSort(T[] dataArray) {
    this.data = new ArrayList<>(Arrays.asList(dataArray));
  }

  /**
   * constructor for creating a merge sort instance via passing an ArrayList of data
   * @param data an ArrayList of data of type T
   */
  public MergeSort(ArrayList<T> data) {
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
   * this method sorts the data array using merge sort algorithm
   * it doesn't return anything.To access the sorted data, call the getData method.
   * @param leftIndex the start of the sub array to sort
   * @param rightIndex the end of the sub array to sort
   */
  public void sort(int leftIndex, int rightIndex){
    if (leftIndex < rightIndex) {
      int middle = (int) Math.floor((leftIndex + rightIndex) / 2.0);
      sort(leftIndex, middle);
      sort(middle + 1, rightIndex);
      merge(leftIndex, middle, rightIndex);
    }
  }

  /**
   *
   * @return data or sorted data. depends on whether you have called sort method before calling it or not
   */
  public ArrayList<T> getData() {
    return data;
  }

  /**
   *This method is responsible for merging two sorted sub array together
   * @param leftIndex the index of the start of the sub array
   * @param middleIndex the index of the middle of the sub array
   * @param rightIndex the index of the end of the sub array
   */
  private void merge(int leftIndex, int middleIndex, int rightIndex) {
    int leftArrayBound = middleIndex - leftIndex + 1;
    int rightArrayBound = rightIndex - middleIndex;
    ArrayList<T> leftArray = new ArrayList<T>(Collections.nCopies(leftArrayBound, null));
    ArrayList<T> rightArray = new ArrayList<T>(Collections.nCopies(rightArrayBound, null));

    for (int i = 0; i < leftArrayBound; i++){
      leftArray.set(i,this.data.get(leftIndex + i));
    }
    for (int i = 0; i < rightArrayBound; i++){
      rightArray.set(i,this.data.get(middleIndex + i + 1));
    }

    int i = 0;
    int j = 0;
    int k = leftIndex;

    while (i < leftArrayBound && j < rightArrayBound){
      int comparisonResult = leftArray.get(i).compareTo(rightArray.get(j));
      if (comparisonResult <= 0){
        this.data.set(k++,leftArray.get(i++));
      } else {
        this.data.set(k++,rightArray.get(j++));
      }
    }

    while (i < leftArrayBound) {
      this.data.set(k++,leftArray.get(i++));
    }
    while (j < rightArrayBound) {
      this.data.set(k++,rightArray.get(j++));
    }
  }
}
