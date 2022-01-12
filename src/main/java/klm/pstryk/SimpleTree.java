package klm.pstryk;

public class SimpleTree<E extends Comparable<E>> {
  private E value;
  private SimpleTree<E> left;
  private SimpleTree<E> right;
  private int level = 0;
  private static int treeDepth;
  private static String[] rows = null;

  public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right){
    this.value = value;
    this.left = left;
    this.right = right;
  }
  public E getValue(){
    return value;
  }
  public SimpleTree<E> getLeft(){
    return left;
  }
  public SimpleTree<E> getRight(){
    return right;
  }
  public void initRows(){
    if(rows == null){
      rows = new String[5];
    }
    rows[0] = String.valueOf(value);    
    for(int i=1; i<rows.length; i++){
      rows[i] = "";   
    }
  }
  public static void resetTreeDepth(){
    treeDepth = 0; System.out.println("---treeDepth reset---");
  }
  public static String[] getRows(){
    return rows;
  }
  public boolean search(E toFind){
    assert toFind != null : "search: toFind `"+toFind+"` differs from not null FAILED";
    if(toFind.equals(value)){
      return true;
    }
    if(toFind.compareTo(value) < 0 && left != null){
      return left.search(toFind);
    }
    return right != null && right.search(toFind);
  }
  public void insert(E toInsert){
    assert toInsert != null : "insert: toInsert `"+toInsert+"` differs from not null FAILED";
    if(toInsert.compareTo(value) < 0){
      if(left == null){
        left = new SimpleTree<>(toInsert, null, null);
        left.level = level + 1;
        if(treeDepth < left.level){
          treeDepth = left.level;
        }
        System.out.println("toInsert: `"+toInsert+"` value(parent): `"+value+"` level(parent): `"+level+"` treeDepth: `"+treeDepth+"`");
        rows[level+1] = toInsert + " " + rows[level+1];
      }else{
        System.out.println("toInsert: `"+toInsert+"` value(parent): `"+value+"` level(parent): `"+level+"` treeDepth: `"+treeDepth+"`");        
        left.insert(toInsert); 
      }
    }else{
      if(right == null){
        right = new SimpleTree<>(toInsert, null, null);
        right.level = level + 1;
        if(treeDepth < right.level){
          treeDepth = right.level;
        }
        System.out.println("toInsert: `"+toInsert+"` value(parent): `"+value+"` level(parent): `"+level+"` treeDepth: `"+treeDepth+"`");  
        rows[level+1] += toInsert + " ";
      }else{
        System.out.println("toInsert: `"+toInsert+"` value(parent): `"+value+"` level(parent): `"+level+"` treeDepth: `"+treeDepth+"`");  
        right.insert(toInsert);
      }
    }
  }
  public static void printRows(){
    for(String s : SimpleTree.getRows()){
        System.out.println(s);
      }   
  }
  public void print(){
    System.out.println("level: `"+level+"` value: `"+value+"`");
    if (left != null) {
      left.print();  
    }
    if (right != null){
      right.print();  
    }
  }

  
}
