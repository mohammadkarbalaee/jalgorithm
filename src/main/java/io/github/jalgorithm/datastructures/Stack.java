package io.github.jalgorithm.datastructures;

import java.util.NoSuchElementException;

/**
 * Implementation of Stack data structure
 * @author Muhammad Karbalaee
 * @param <T> object of any type
 */
public class Stack<T> {
  private final T[] array;
  private int top = -1;

  /**
   * constructor for Stack class
   * @param arrayLength the length of the stack which is to be built
   */
  Stack(int arrayLength){
    this.array = (T[]) new Object[arrayLength];
  }

  /**
   * @return true if stack has no elements stored in it and false if there is something stored.
   */
  public boolean isStackEmpty(){
    return this.top == -1;
  }

  /**
   *
   * @param element adding a new element to stack
   */
  public void push(T element){
    this.top++;
    array[this.top] = element;
  }

  /**
   *
   * @return deletes the last inserted element and returns it back.
   * @throws NoSuchElementException if stack is empty, this exception will be thrown.
   */
  public T pop() throws NoSuchElementException {
    if (isStackEmpty()){
      throw new NoSuchElementException("stack is already empty");
    } else {
      this.top--;
      return this.array[this.top + 1];
    }
  }
}