package klm.pstryk;

// Integer is an immutable class, so we wrap an integer value in a mutable object.
public class IntWrapper{
  private Integer val;
  
  IntWrapper(Integer val){
    this.val = val;
  }
  
  public Integer getVal(){
    return this.val;
  }
  
  public void setVal(Integer val){
    this.val = val;
  }
  
  @Override
  public String toString(){
    return String.valueOf(val);
  }
}