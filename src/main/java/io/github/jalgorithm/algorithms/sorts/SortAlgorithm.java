package io.github.jalgorithm.algorithms.sorts;

public class SortAlgorithm {
  public void swap(int[] array,int i,int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
