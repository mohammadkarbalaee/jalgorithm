package algorithms.sorts.quicksort;

import algorithms.sorts.SortAlgorithm;

public class QuickSort extends SortAlgorithm {
  private int[] array;

  public QuickSort(int[] array) {
    this.array = array;
  }

  public QuickSort() {
    this.array = new int[0];
  }

  public int[] getArray() {
    return array;
  }

  public void setArray(int[] array) {
    this.array = array;
  }

  public void lomutoSort(int startIndex, int endIndex) {
    if (startIndex < endIndex){
      int previousPivotIndex = lomutoPartition(startIndex,endIndex);
      lomutoSort(startIndex,previousPivotIndex - 1);
      lomutoSort(previousPivotIndex + 1,endIndex);
    }
  }

  private int lomutoPartition(int startIndex, int endIndex) {
    long pivot = this.array[endIndex];
    int startOfLeftHalf = startIndex - 1;
    for (int startOfRightHalf = startIndex; startOfRightHalf < endIndex; startOfRightHalf++) {
      if (this.array[startOfRightHalf] <= pivot){
        startOfLeftHalf++;
        swap(this.array,startOfLeftHalf,startOfRightHalf);
      }
    }
    swap(this.array,startOfLeftHalf + 1,endIndex);
    return startOfLeftHalf + 1;
  }

  public void hoareSort(int startIndex, int endIndex){
    if (startIndex < endIndex){
      int previousPivotIndex = hoarePartition(startIndex,endIndex);
      hoareSort(startIndex,previousPivotIndex);
      hoareSort(previousPivotIndex + 1,endIndex);
    }
  }

  public int hoarePartition(int startIndex, int endIndex){
    long pivot = this.array[startIndex];
    int i = startIndex - 1;
    int j = endIndex + 1;

    while (true) {
      do {
        i++;
      }
      while (this.array[i] < pivot);
      do {
        j--;
      }
      while (this.array[j] > pivot);
      if (i >= j) {
        return j;
      } else {
        super.swap(this.array,i,j);
      }
    }
  }
}
