package datastructures;

import io.github.jalgorithm.datastructures.trees.BinarySearchNode;
import io.github.jalgorithm.datastructures.trees.BinarySearchTree;

public class BinarySearchSample {
  public static void main(String[] args) {
    BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
    binarySearchTree.insert(10);
    binarySearchTree.insert(0);
    binarySearchTree.insert(-100);
    binarySearchTree.insert(500);
    //System.out.println(binarySearchTree.getSortedData());
//    BinarySearchNode<Integer> foundNode =
//                    binarySearchTree.treeSearch(binarySearchTree.getRootNode(),-100);
//    System.out.println(foundNode.getParent().getData());
//    System.out.println(binarySearchTree.treeMaximum(binarySearchTree.getRootNode()).getData());
//    System.out.println(binarySearchTree.treePredecessor(binarySearchTree.getRootNode()).getData());
//    System.out.println(binarySearchTree.treeSuccessor(binarySearchTree.getRootNode()).getData());
    binarySearchTree.delete(binarySearchTree.getRootNode());
    System.out.println(binarySearchTree.getSortedData());
  }
}
