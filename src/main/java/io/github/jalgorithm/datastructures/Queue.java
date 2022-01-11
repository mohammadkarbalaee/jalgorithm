package io.github.jalgorithm.datastructures;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *Queue class delivers the functionality of Queue data structure.
 * @author Muhammad Karbalaee
 * @param <T> any type is possible
 */
public class Queue<T>{
  private final T[] array;
  private int queueLength;
  private int tail;
  private int head;

  /**
   * constructor for Queue class
   * @param queueLength the length of the queue that you want to make
   */
  public Queue(int queueLength){
    this.array = (T[]) new Object[queueLength];
    this.head = 0;
    this.tail = 0;
    this.queueLength = 0;
  }

  /**
   *
   * @return an array containing all the data in the queue
   */
  public T[] getData() {
    return this.array;
  }

  /**
   *
   * @return to get the length of queue
   */
  public int getQueueLength() {
    return queueLength;
  }

  /**
   * adds an element to the end of the queue
   * @param newElement the new element to add to the queue
   */
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

  /**
   * deletes an element from the start of the queue.
   * @return the first element of queue
   */
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

  /**
   *
   * @return true of queue has no elements in it
   */
  public boolean isQueueEmpty(){
    return queueLength == 0;
  }

  /**
   *
   * @return true if queue has the most number of elements that is can store.
   */
  public boolean isQueueFull(){
    return this.array.length == queueLength;
  }
}