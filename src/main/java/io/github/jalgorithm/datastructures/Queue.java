package io.github.jalgorithm.datastructures;

import java.util.NoSuchElementException;

/**
 *
 * @param <T>
 */
public class Queue<T>{
  private final T[] array;
  private int queueLength;
  private int tail;
  private int head;

  Queue(int queueLength){
    this.array = (T[]) new Object[queueLength];
    this.head = 0;
    this.tail = 0;
    this.queueLength = 0;
  }

  public void enqueue(T newElement){
    if (isQueueFull()){
      throw new OutOfMemoryError("queue is already full");
    } else {
      queueLength++;
      this.array[this.tail] = newElement;
      if (this.tail == (this.array.length -1)){
        this.tail = 0;
      } else {
        this.tail++;
      }
    }
  }

  public T dequeue(){
    if (isQueueEmpty()){
      throw new NoSuchElementException("queue is already empty");
    } else {
      queueLength--;
      T headElement = this.array[this.head];
      if (this.head == (this.array.length - 1)){
        this.head = 0;
      } else {
        this.head++;
      }
      return headElement;
    }
  }

  public boolean isQueueEmpty(){
    return queueLength == 0;
  }

  public boolean isQueueFull(){
    return this.array.length == queueLength;
  }
}