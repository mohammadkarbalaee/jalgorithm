package datastructures;

import io.github.jalgorithm.datastructures.trees.BinarySearchTree;

public class BinarySearchSample {
  public static void main(String[] args) {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.insert(10);
    binarySearchTree.insert(0);
    binarySearchTree.insert(-100);
    binarySearchTree.insert(500);
    System.out.println(binarySearchTree.getSortedData());
  }
}
