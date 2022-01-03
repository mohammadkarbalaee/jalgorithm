package io.github.jalgorithm.datastructures.trees;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> Any object which implements the Comparable interface is accepted
 */
public class BinarySearchTree<T extends Comparable<T>>{
  private final BinarySearchNode<T> nullNode;
  private BinarySearchNode<T> rootNode;
  private final ArrayList<T> sortedData;
  private final ArrayList<T> preorderWalkResult;
  private final ArrayList<T> postorderWalkResult;

  /**
   * constructor for BinarySearchTree class.
   */
  public BinarySearchTree() {
    this.nullNode = new BinarySearchNode<>(null,null,null,null);
    this.sortedData = new ArrayList<>();
    this.preorderWalkResult = new ArrayList<>();
    this.postorderWalkResult = new ArrayList<>();
  }

  /**
   * by calling this method the sorted data will be stored in the
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void inorderTreeWalk(BinarySearchNode<T> node) {
    if (node == this.rootNode) {
      this.sortedData.clear();
    }
    if (node != this.nullNode) {
      this.inorderTreeWalk(node.getLeftChild());
      this.sortedData.add(sortedData.size() - 1,node.getData());
      this.inorderTreeWalk(node.getRightChild());
    }
  }

  /**
   * by calling this method all the data in this tree will be walked through
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void preorderTreeWalk(BinarySearchNode<T> node) {
    if (node == this.rootNode) {
      this.preorderWalkResult.clear();
    }
    if (node != this.nullNode) {
      this.preorderTreeWalk(node.getLeftChild());
      this.preorderWalkResult.add(sortedData.size() - 1,node.getData());
      this.preorderTreeWalk(node.getRightChild());
    }
  }

  /**
   * by calling this method all the data in this tree will be walked through
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void postorderTreeWalk(BinarySearchNode<T> node) {
    if (node == this.rootNode) {
      this.postorderWalkResult.clear();
    }
    if (node != this.nullNode) {
      this.postorderTreeWalk(node.getLeftChild());
      this.postorderWalkResult.add(sortedData.size() - 1,node.getData());
      this.postorderTreeWalk(node.getRightChild());
    }
  }

  /**
   *
   * @return the root node of the tree
   */
  public BinarySearchNode<T> getRootNode() {
    return rootNode;
  }

  /**
   *
   * @return An ArrayList containing all the data inserted in the tree so far in a sorted order
   */
  public ArrayList<T> getSortedData() {
    this.inorderTreeWalk(this.rootNode);
    return this.sortedData;
  }

  /**
   *
   * @return data in the order presented by preorder tree walk
   */
  public ArrayList<T> getPreorderWalkResult() {
    this.preorderTreeWalk(this.rootNode);
    return this.preorderWalkResult;
  }

  /**
   *
   * @return data in the order presented by postorder tree walk
   */
  public ArrayList<T> getPostorderWalkResult() {
    this.postorderTreeWalk(this.rootNode);
    return this.postorderWalkResult;
  }
}