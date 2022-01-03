package io.github.jalgorithm.datastructures.trees;

import java.util.ArrayList;

/**
 * @author Muhammad Karbalaee
 * @param <T> Any object which implements the Comparable interface is accepted
 */
public class BinarySearchTree<T extends Comparable<T>>{
  private BinarySearchNode<T> nullNode;
  private BinarySearchNode<T> rootNode;

  /**
   * constructor for BinarySearchTree class.
   */
  public BinarySearchTree() {
    this.nullNode = new BinarySearchNode<>(null,null,null,null);
  }

  /**
   *
   * @param node the node to of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void inorderTreeWalk(BinarySearchNode<T> node) {
    if (node != this.nullNode) {
      this.inorderTreeWalk(node.getLeftChild());
      System.out.println(node.getData());
      this.inorderTreeWalk(node.getRightChild());
    }
  }

  /**
   * This method makes use of inorder tree walk to gather data in sorted order from the tree
   * @return An ArrayList containing all the data inserted in the tree so far in a sorted order
   */
  public ArrayList<T> getSortedData() {

  }
}

