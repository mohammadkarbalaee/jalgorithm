package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;

public class SortAlgorithm<T extends Comparable<T>> {
  public void swap(int[] array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public void swap(ArrayList<T> array, int i, int j){
    T temp = array.get(i);
    array.set(i,array.get(j));
    array.set(j,temp);
  }
}
