package io.github.jalgorithm.datastructures;

import io.github.jalgorithm.datastructures.utils.IntWrapper;

/**
 * @author Cyprian Klimkowski
 * @param <T> Any object implementing the Comparable interface
 */
public class SimpleTree<T extends Comparable<T>> {
  private T value;
  private SimpleTree<T> left;
  private SimpleTree<T> right;
  
  /**
   * constructor for SimpleTree class.
   * @param left the left tree
   * @param right the right tree
   * @param value the data stored in tree
   */
  public SimpleTree(T value, SimpleTree<T> left, SimpleTree<T> right){
    this.value = value;
    this.left = left;
    this.right = right;
  }
  
  /**
   *
   * @return the value of the node
   */
  public T getValue(){
    return value;
  }
  
  /**
   *
   * @return left child of the node
   */
  public SimpleTree<T> getLeft(){
    return left;
  }
  
  /**
   *
   * @return right child of the node
   */
  public SimpleTree<T> getRight(){
    return right;
  } 
  public boolean search(T toFind){
    assert toFind != null : "search: toFind `"+toFind+"` differs from not null FAILED";
    if(toFind.equals(value)){
      return true;
    }
    if(toFind.compareTo(value) < 0 && left != null){
      return left.search(toFind);
    }
    return right != null && right.search(toFind);
  }
  
  /**
   *
   * @param toFind the value to search for in the tree
   * @return the node with the wanted value or null if not found
   */
  public SimpleTree<T> getFound(T toFind){
    assert toFind != null : "getFound: toFind `"+ toFind +"` is null ASSERTION FAILED";
    if(toFind.equals(value)){
      return this;
    }
    if(toFind.compareTo(value) < 0 && left != null){
      return left.getFound(toFind);
    }
    if(right != null){
      return right.getFound(toFind);
    }
    return null; // not found
  }
  
  /**
   *
   * @param toInsert the value to be inserted into the tree
   * the node with the wanted value or null if not found
   */
  public void insert(T toInsert){
    assert toInsert != null : "insert: toInsert `"+toInsert+"` differs from not null FAILED";
    if(toInsert.compareTo(value) < 0){
      if(left == null){
        left = new SimpleTree<>(toInsert, null, null);
      }else{
        left.insert(toInsert); 
      }
    }else{
      if(right == null){
        right = new SimpleTree<>(toInsert, null, null);
      }else{
        right.insert(toInsert);
      }
    }
  }
  
  /**
   *
   * @param intArr the destination array with the sorted values
   * @param idx the current index of intArr[] of mutable wrapper of Integer type IntWrapper
   */
  public void getSorted(T[] intArr, IntWrapper idx){
    if (left != null) {
      left.getSorted(intArr, idx);  
    }
    intArr[idx.getVal()] = value; idx.setVal(idx.getVal() + 1);
    if (right != null){
      right.getSorted(intArr, idx);  
    }
  }

  /**
   *
   * @return the string representation of a SimpleTree object
   */
  @Override
  public String toString(){
    return "SimpleTree{" + 
      "value=" + value + " " +
      "leftChild=" + left + " " +
      "rightChild=" + right + " " +
      "}";
  }
}
