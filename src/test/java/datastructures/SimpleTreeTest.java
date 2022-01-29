package datastructures;


import io.github.jalgorithm.datastructures.SimpleTree;
import org.codehaus.groovy.runtime.wrappers.IntWrapper;

public class SimpleTreeTest {
  	public static void main(String[] args) {
		String output = "";
		System.out.println("This is SimpleTreeTest!!!");
  
    SimpleTree<Integer> root;
    final SimpleTree<Integer> t1 = new SimpleTree<>(1, null, null);
    final SimpleTree<Integer> t5 = new SimpleTree<>(5, null, null);
    final SimpleTree<Integer> t3 = new SimpleTree<>(5, t1, t5);
    final SimpleTree<Integer> t9 = new SimpleTree<>(9, null, null);
    root = new SimpleTree<>(7, t3, t9); 
    assert root.search(7) : "root.search(7) FAILED"; //assertTrue(root.search(7))
    assert !root.search(70) : "root.search(70) FAILED"; //assertFalse(root.search(70))
    root.insert(10);   
    assert root.search(10) : "root.search(10) FAILED";
    assert Integer.valueOf(10).equals(root.getRight().getRight().getValue()) : "Integer.valueOf(10) `"+Integer.valueOf(10)+"` differs from root.getRight().getRight().getValue() `"+root.getRight().getRight().getValue()+"` FAILED";
     
    root = new SimpleTree<>(7, null, null);
    root.insert(3); root.insert(9); root.insert(10);
    assert root.search(10) : "root.search(10) `"+root.search(10)+"` FAILED";
    assert Integer.valueOf(10).equals(root.getRight().getRight().getValue()) : "Integer.valueOf(10) `"+Integer.valueOf(10)+"` differs from root.getRight().getRight().getValue() `"+root.getRight().getRight().getValue()+"` FAILED";

    // boolean b = root.search(null); //throws AssertionError
    // root.insert(null); //throws AssertionError

    //linkedListTree
    // root = new SimpleTree<>(1, null, null);
    // root.insert(2); root.insert(3); root.insert(4); root.insert(5); 
    
    root = new SimpleTree<>(3, null, null);
    root.insert(111); root.insert(0); root.insert(41); root.insert(-10);       
    int n;
    SimpleTree<Integer> found;   
    n = 6; found = root.getFound(n);
    System.out.println("n: |" + n + "| found: |" + found + "| ");
    n = 0; found = root.getFound(n);
    System.out.println("n: |" + n + "| found: |" + found + "| ");
    n = 3; found = root.getFound(n);
    System.out.println("n: |" + n + "| found: |" + found + "| ");
      
    Integer intArr[] = new Integer[5]; 
    IntWrapper idx = new IntWrapper(0);
    root.getSorted(intArr, idx);
    System.out.println("idx: " + idx);
    System.out.print("[" + intArr[0]);
    for(int i=1; i<idx.getVal(); i++){
      System.out.print(", " + intArr[i]);
    }
    System.out.print("]");
	}
}
