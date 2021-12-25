package io.github.jalgorithm.datastructures.hash;

import io.github.jalgorithm.exceptions.hash.DataOverridingException;
import io.github.jalgorithm.exceptions.hash.TableIndexOutOfBoundException;

class DirectAddressable implements KeyLabledObject {
  private int key;
  private String value;

  public DirectAddressable(int key, String value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public int getKey() {
    return this.key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}

public class DirectAddressingTableTest {
  public static void main(String[] args) throws DataOverridingException, TableIndexOutOfBoundException {
    DirectAddressTable<DirectAddressable> directAddressTable =
        new DirectAddressTable<>(3);
    directAddressTable.insert(new DirectAddressable(1,"hi"));
    directAddressTable.insert(new DirectAddressable(0,"hello"));
    directAddressTable.insert(new DirectAddressable(2,"bye"));
//    directAddressTable.insert(new DirectAddressable(5,"i want to cause error"));
    System.out.println(directAddressTable.search(1).getValue());
    System.out.println(directAddressTable.search(0).getValue());
    System.out.println(directAddressTable.search(2).getValue());
  }
}
