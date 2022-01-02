package sorts;

import io.github.jalgorithm.algorithms.sorts.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sample code for MergeSort class
 * @author Muhammad Karbalaee
 */
public class MergeSortSample {
  public static void main(String[] args) {
    Integer[] array = {60,10,-100,500,0};
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
    MergeSort<Integer> mergeSortArray = new MergeSort<>(array);
    MergeSort<Integer> mergeSortArrayList = new MergeSort<>(arrayList);
    mergeSortArray.sort(0,array.length - 1);
    mergeSortArrayList.sort(0,array.length - 1);
    System.out.println(mergeSortArray.getData());
    System.out.println(mergeSortArrayList.getData());
  }
}
