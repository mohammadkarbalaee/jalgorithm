package datastructures;

import io.github.jalgorithm.datastructures.hash.ChainTableInsertionTypes;
import io.github.jalgorithm.datastructures.hash.ChainedHashTable;
import io.github.jalgorithm.datastructures.hash.HashFunctionTypes;
import io.github.jalgorithm.datastructures.hash.KeyLabledObject;

class Chainable implements KeyLabledObject {
  private int key;
  private String value;

  public Chainable(int key, String value) {
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

public class ChainTable {
  public static void main(String[] args) {
    ChainedHashTable<Chainable> chainedHashTable =
        new ChainedHashTable<>(3,
            ChainTableInsertionTypes.AT_TAIL,
            HashFunctionTypes.DIVISION_HASH);
    chainedHashTable.insert(new Chainable(10,"i am 10"));
    chainedHashTable.insert(new Chainable(2,"i am 2"));
    chainedHashTable.insert(new Chainable(100,"i am 100"));
    System.out.println(chainedHashTable.search(10).getValue());
    System.out.println(chainedHashTable.search(100).getValue());
    System.out.println(chainedHashTable.search(2).getValue());
  }
}
