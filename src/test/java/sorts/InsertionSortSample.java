package sorts;

import io.github.jalgorithm.algorithms.sorts.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sample code for InsertionSort class
 * @author Muhammad Karbalaee
 */
public class InsertionSortSample {
  public static void main(String[] args) {
    Integer[] array = {60,10,1000,2,1,3,-100,500,0};
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
    InsertionSort<Integer> insertionSortArray = new InsertionSort<>(array);
    InsertionSort<Integer> insertionSortArrayList = new InsertionSort<>(arrayList);
    insertionSortArray.sort();
    insertionSortArrayList.sort();
    System.out.println(insertionSortArray.getData());
    System.out.println(insertionSortArrayList.getData());
  }
}
