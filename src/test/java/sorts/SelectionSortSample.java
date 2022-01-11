package sorts;

import io.github.jalgorithm.algorithms.sorts.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSortSample {
  public static void main(String[] args) {
    int[] array = {100,-15,6,0,10,11,200,1};
    ArrayList<Integer> data = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      data.add(array[i]);
    }
    SelectionSort selectionSort = new SelectionSort(data);
    selectionSort.sort();
    System.out.println(selectionSort.getData());
  }
}
