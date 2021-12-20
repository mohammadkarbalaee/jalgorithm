package io.github.muhammadkarbalaee.datastructures.linkedlist;


import io.github.muhammadkarbalaee.datastructures.hash.KeyLabledObject;

public class TailedDoublyLinkedList<T extends KeyLabledObject>{
  private DoublyNode<T> headNode = null;
  private DoublyNode<T> tailNode = null;
  private int length = 0;

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

  public int size(){
    return this.length;
  }
}

