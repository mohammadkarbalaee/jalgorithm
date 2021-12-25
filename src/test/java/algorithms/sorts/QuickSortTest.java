package algorithms.sorts;

import io.github.jalgorithm.algorithms.sorts.quicksort.QuickSort;

import java.util.Arrays;

public class QuickSortTest {
  public static void main(String[] args) {
    int[] array = {100,-15,6,0,10,11,200,1};
    QuickSort quickSort = new QuickSort(array);
//    quickSort.lomutoSort(0,array.length - 1);
    quickSort.hoareSort(0,array.length - 1);
    System.out.println(Arrays.toString(quickSort.getArray()));
  }
}
