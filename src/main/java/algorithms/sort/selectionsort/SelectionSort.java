package algorithms.sort.selectionsort;

public class SelectionSort{
  private int[] array;

  public SelectionSort(int arrayLength){
    this.array = new int[arrayLength];
  }

  public SelectionSort(int[] array){
    this.array = array;
  }

  public int[] sort(int[] array){
    return actualSort(array);
  }

  public int[] sort(){
    return actualSort(this.array);
  }

  private int[] actualSort(int[] array){
    for (int i = 0; i < array.length - 1; i++) {
      int leastIndex = i;
      for (int j = i; j < array.length; j++) {
        if (array[j] < array[leastIndex]){
          leastIndex = j;
        }
      }
    }
    return array;
  }
}