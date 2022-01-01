package sorts;

import io.github.jalgorithm.algorithms.sorts.BubbleSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sample code for BubbleSort class
 * @author Muhammad Karbalaee
 */
public class BubbleSortSample {
  public static void main(String[] args) {
    Integer[] array = {60,10,-100,500,0};
    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
    BubbleSort<Integer> bubbleSortArray = new BubbleSort<Integer>(array);
    BubbleSort<Integer> bubbleSortArrayList = new BubbleSort<Integer>(arrayList);
    bubbleSortArray.sort();
    bubbleSortArrayList.sort();
    System.out.println(bubbleSortArray.getData());
    System.out.println(bubbleSortArrayList.getData());
  }
}
