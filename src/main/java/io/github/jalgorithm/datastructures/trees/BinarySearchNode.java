package io.github.jalgorithm.datastructures.trees;

/**
 * @author Muhammad Karbalaee
 * @param <T> Any object which implements the Comparable interface is accepted
 */
public class BinarySearchNode<T extends Comparable<T>>{
  private BinarySearchNode<T> parent;
  private BinarySearchNode<T> leftChild;
  private BinarySearchNode<T> rightChild;
  private T data;

  public BinarySearchNode(BinarySearchNode<T> parent, BinarySearchNode<T> leftChild,
                          BinarySearchNode<T> rightChild, T data) {
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.data = data;
  }

  /**
   *
   * @return the parent node
   */
  public BinarySearchNode<T> getParent() {
    return parent;
  }

  /**
   *
   * @param parent the new parent node to be set
   */
  public void setParent(BinarySearchNode<T> parent) {
    this.parent = parent;
  }

  /**
   *
   * @return left child of the node
   */
  public BinarySearchNode<T> getLeftChild() {
    return leftChild;
  }

  /**
   *
   * @param leftChild the new left chilad node to be set
   */
  public void setLeftChild(BinarySearchNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  /**
   *
   * @return right child node
   */
  public BinarySearchNode<T> getRightChild() {
    return rightChild;
  }

  /**
   *
   * @param rightChild the new right child node to be set
   */
  public void setRightChild(BinarySearchNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  /**
   *
   * @return the satellite data stored int the node
   */
  public T getData() {
    return data;
  }

  /**
   *
   * @param data the new data object to be set
   */
  public void setData(T data) {
    this.data = data;
  }
}