package io.github.jalgorithm.algorithms.sorts;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * This class implements the most efficient version of selection sort
 */
public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

  private ArrayList<T> data;

  /**
   * this is the constructor of the SelectionSort class
   * @param data an ArrayList of type T that stores all the data that you want to get sorted
   */
  public SelectionSort(ArrayList<T> data){
    this.data = data;
  }

  /**
   * sorts the data array and stores it there. this method doesn't
   * return anything, so use the getData method to get the sorted data
   * after you call the sort method
   */
  public void sort(){
    for (int i = 0; i < this.data.size(); i++) {
      for (int middle = 0, j = i; middle < j; middle++, j--) {
        T min = this.data.get(middle);
        T max = this.data.get(middle);
        int minimumIndex = middle;
        int maximumIndex = middle;
        for (int k = middle; k <= j; k++) {

          int tempComparisonResult1 = this.data.get(k).compareTo(max);
          int tempComparisonResult2 = this.data.get(k).compareTo(min);

          if (tempComparisonResult1 > 0) {
            max = this.data.get(k);
            maximumIndex = k;
          } else if (tempComparisonResult2 < 0) {
            min = this.data.get(k);
            minimumIndex = k;
          }
        }

        super.swap(this.data,middle, minimumIndex);

        int comparison = this.data.get(minimumIndex).compareTo(max);
        if (comparison == 0){
          super.swap(this.data,j, minimumIndex);
        } else {
          super.swap(this.data,j, maximumIndex);
        }
      }
    }
  }

  /**
   *
   * @return the data which is either sorted or not, depending on whether sort method has been
   * called before or not.
   */
  public ArrayList<T> getData() {
    return data;
  }

  /**
   * to set the new data for data field
   * @param data an ArrayList of type T containing all the data that
   *             should be sorted
   */
  public void setData(ArrayList<T> data) {
    this.data = data;
  }
}