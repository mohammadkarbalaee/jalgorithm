package io.github.jalgorithm.datastructures.linkedlist;

import io.github.jalgorithm.datastructures.hash.KeyLabeledObject;

public class DoublyNode<T extends KeyLabeledObject>{
  private T data;
  private DoublyNode<T> previousNode;
  private DoublyNode<T> nextNode;

  DoublyNode(DoublyNode<T> previousNode,T data,DoublyNode<T> nextNode){
    this.previousNode = previousNode;
    this.data = data;
    this.nextNode = nextNode;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public DoublyNode<T> getPreviousNode() {
    return previousNode;
  }

  public void setPreviousNode(DoublyNode<T> previousNode) {
    this.previousNode = previousNode;
  }

  public DoublyNode<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(DoublyNode<T> nextNode) {
    this.nextNode = nextNode;
  }
}
