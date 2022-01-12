package klm.pstryk;

public class SimpleTreeTest {
	public static void main(String[] args) {
		String output = "";
		System.out.println("This is SimpleTreeTest!!!");
  
    SimpleTree<Integer> root;
    final SimpleTree<Integer> t1 = new SimpleTree<>(1, null, null);
    final SimpleTree<Integer> t5 = new SimpleTree<>(5, null, null);
    final SimpleTree<Integer> t3 = new SimpleTree<>(5, t1, t5);
    final SimpleTree<Integer> t9 = new SimpleTree<>(9, null, null);
    root = new SimpleTree<>(7, t3, t9);  SimpleTree.resetTreeDepth(); root.initRows();
    assert root.search(7) : "root.search(7) FAILED"; //assertTrue(root.search(7))
    assert !root.search(70) : "root.search(70) FAILED"; //assertFalse(root.search(70))
    root.insert(10);   
    assert root.search(10) : "root.search(10) FAILED";
    assert Integer.valueOf(10).equals(root.getRight().getRight().getValue()) : "Integer.valueOf(10) `"+Integer.valueOf(10)+"` differs from root.getRight().getRight().getValue() `"+root.getRight().getRight().getValue()+"` FAILED";
     
    root = new SimpleTree<>(7, null, null);  SimpleTree.resetTreeDepth(); root.initRows();
    root.insert(3); root.insert(9); root.insert(10);
    assert root.search(10) : "root.search(10) `"+root.search(10)+"` FAILED";
    assert Integer.valueOf(10).equals(root.getRight().getRight().getValue()) : "Integer.valueOf(10) `"+Integer.valueOf(10)+"` differs from root.getRight().getRight().getValue() `"+root.getRight().getRight().getValue()+"` FAILED";

    // boolean b = root.search(null); //throws AssertionError
    // root.insert(null); //throws AssertionError

    //linkedListTree
    root = new SimpleTree<>(1, null, null); SimpleTree.resetTreeDepth(); root.initRows();
    root.insert(2); root.insert(3); root.insert(4); root.insert(5); 
    
    //tree printing  
    root = new SimpleTree<>(3, null, null); SimpleTree.resetTreeDepth(); root.initRows();
    root.insert(5); root.insert(2); root.insert(4); root.insert(1);    
 /*     
    __I.    3
    ---------------------
    _II.    3
            \
              5
    ---------------------          
    III.    3
           / \
          2   5
    ---------------------      
    _IV.    3
           / \
          2   5
             /
            4
    ---------------------        
    __V.    3
           / \
          2   5
         /   /
        1   4
    ---------------------
*/ 
    root.print();
    SimpleTree.printRows();    
    // root.prettyPrint();
/* 
    ---------------------    
    __I.    print(3)
    _II.    print(2)
    III.    print(1)
    _IV.    print(5)
    __V.    print(4)
    ---------------------
 */
	}
}
