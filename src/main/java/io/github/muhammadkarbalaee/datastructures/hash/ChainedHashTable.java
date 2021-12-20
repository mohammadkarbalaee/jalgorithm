package io.github.muhammadkarbalaee.datastructures.hash;

import io.github.muhammadkarbalaee.datastructures.DataStructure;
import io.github.muhammadkarbalaee.datastructures.linkedlist.TailedDoublyLinkedList;

import java.util.ArrayList;

public class ChainedHashTable<T extends KeyLabledObject> implements DataStructure<T> {
  private final ArrayList<TailedDoublyLinkedList<T>> chainTable;
  private final ChainTableInsertionTypes insertionType;
  private final int tableLength;

  public ChainedHashTable(int tableLength,ChainTableInsertionTypes insertionType) {
    this.chainTable = new ArrayList<>(tableLength);
    this.insertionType = insertionType;
    this.tableLength = tableLength;
    for (int i = 0; i < tableLength; i++) {
      this.chainTable.add(new TailedDoublyLinkedList<>());
    }
  }

  @Override
  public T search(int key) {
    return this.chainTable.get(key).searchKey(key).getData();
  }

  @Override
  public void insert(T newObject) {

  }

  @Override
  public void delete(T targetObject) {

  }
}
