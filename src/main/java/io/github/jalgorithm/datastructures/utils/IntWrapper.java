package io.github.jalgorithm.datastructures.utils;

// Integer is an immutable class, so we wrap an integer value in a mutable object.
public class IntWrapper{
  private Integer val;
  
  public IntWrapper(Integer val){
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