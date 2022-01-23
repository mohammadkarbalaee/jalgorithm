package io.github.jalgorithm.datastructures.linkedlist;

import io.github.jalgorithm.datastructures.hash.KeyLabeledObject;

/**
 * @param <T> Any object which implements the KeyLabeledObject class
 */
public class TailedDoublyLinkedList<T extends KeyLabeledObject>{
  private DoublyNode<T> headNode = null;
  private DoublyNode<T> tailNode = null;
  private int length = 0;

  /**
   * Return the node at a given index
   * @param wantedNodeIndex index of node to search for
   * @return found node
   */
  public DoublyNode<T> searchIndex(int wantedNodeIndex){
    int middle = this.length / 2;
    DoublyNode<T> wantedNode;

    if (wantedNodeIndex > middle){
      wantedNode = this.tailNode;
      int currentIndex = this.length - 1;
      while (wantedNode != null && wantedNodeIndex != currentIndex){
        wantedNode = wantedNode.getPreviousNode();
        currentIndex--;
      }
    } else {
      wantedNode = this.headNode;
      int currentIndex = 0;
      while (wantedNode != null && wantedNodeIndex != currentIndex){
        wantedNode = wantedNode.getNextNode();
        currentIndex++;
      }
    }
    return wantedNode;
  }

  /**
   * Searches for a node based on a given key
   * @param key key of node to search for
   * @return found node
   */
  public DoublyNode<T> searchKey(int key){
    int middle = this.length / 2;
    DoublyNode<T> wantedNode;

    if (key > middle){
      wantedNode = this.tailNode;
      while (wantedNode != null && key != wantedNode.getData().getKey()){
        wantedNode = wantedNode.getPreviousNode();
      }
    } else {
      wantedNode = this.headNode;
      while (wantedNode != null && key != wantedNode.getData().getKey()){
        wantedNode = wantedNode.getNextNode();
      }
    }
    return wantedNode;
  }

  /**
   * Creates a new node and inserts it at a given index
   * @param indexToInsertAt index at which to insert the node
   * @param newData data of the new node
   */
  public void insert(int indexToInsertAt, T newData){
    DoublyNode<T> currentNode;
    DoublyNode<T> newNode = new DoublyNode<>(null,newData,null);
    if (indexToInsertAt == this.length && indexToInsertAt != 0) {
      newNode.setNextNode(null);
      newNode.setPreviousNode(this.tailNode);
      this.tailNode.setNextNode(newNode);
      this.tailNode = newNode;
    } else if(indexToInsertAt == 0) {
      if (this.headNode == null){
        this.headNode = newNode;
        this.tailNode = this.headNode;
      } else {
        newNode.setNextNode(this.headNode);
        this.headNode.setPreviousNode(newNode);
        newNode.setPreviousNode(null);
        this.headNode = newNode;
      }
    } else {
      currentNode = this.searchIndex(indexToInsertAt);
      if (currentNode != null){
        if (currentNode.getPreviousNode() != null) {
          newNode.setNextNode(currentNode);
          newNode.setPreviousNode(currentNode.getPreviousNode());
          currentNode.getPreviousNode().setNextNode(newNode);
          currentNode.setPreviousNode(newNode);
        }
      }
    }
    this.length++;
  }

  /**
   * Deletes the node at a given index
   * @param indexToRemove index of node to be removed
   */
  public void delete(int indexToRemove){
    if (indexToRemove == this.length - 1) {
      if (this.headNode == this.tailNode) {
        this.headNode = null;
        this.tailNode = null;
      } else {
        this.tailNode.getPreviousNode().setNextNode(null);
        this.tailNode = this.tailNode.getPreviousNode();
      }
      this.length--;
      return;
    }
    DoublyNode<T> currentNode = this.searchIndex(indexToRemove);
    if (currentNode != null){
      if (currentNode.getPreviousNode() != null){
        if (currentNode.getNextNode() != null){
          currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
          currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
        }
      } else {
        if (this.headNode.getNextNode() != null){
          this.headNode.getNextNode().setPreviousNode(null);
          this.headNode = this.headNode.getNextNode();
        } else {
          this.headNode = null;
        }
      }
    }
    this.length--;
  }

  /**
   * Reverses the order of the current Linked List
   */
  public void reverse() {
    if (this.length > 1) {
      DoublyNode<T> currentNode = this.headNode;
      DoublyNode<T> tempNode = null;

      while (currentNode != null) {
        // Swap next and prev references of each node
        tempNode = currentNode.getPreviousNode();
        currentNode.setPreviousNode(currentNode.getNextNode());
        currentNode.setNextNode(tempNode);
        currentNode= currentNode.getPreviousNode();
      }

      // This tempNode is now the second to last of the old list,
      // such that its new previous node is the last node of the old list
      assert tempNode != null;
      this.headNode = tempNode.getPreviousNode();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");

    DoublyNode<T> currentNode = this.headNode;
    for (int i = 0; i < this.length; i++) {
      sb.append(currentNode.getData().getKey()).append(" ");
      currentNode = currentNode.getNextNode();
    }

    sb.append("]");

    return sb.toString();
  }

  public int size(){
    return this.length;
  }
}
