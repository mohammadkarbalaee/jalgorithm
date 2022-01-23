package io.github.jalgorithm.datastructures.hash;

import io.github.jalgorithm.datastructures.DataStructure;
import io.github.jalgorithm.datastructures.linkedlist.TailedDoublyLinkedList;

import java.util.ArrayList;

public class ChainedHashTable<T extends KeyLabeledObject> implements DataStructure<T> {
  private final ArrayList<TailedDoublyLinkedList<T>> chainTable;
  private final ChainTableInsertionTypes insertionType;
  private final HashFunctionTypes hashFunctionType;
  private final int tableLength;

  public ChainedHashTable(int tableLength,ChainTableInsertionTypes insertionType,HashFunctionTypes hashFunctionType) {
    this.chainTable = new ArrayList<>(tableLength);
    this.insertionType = insertionType;
    this.tableLength = tableLength;
    this.hashFunctionType = hashFunctionType;
    for (int i = 0; i < tableLength; i++) {
      this.chainTable.add(new TailedDoublyLinkedList<>());
    }
  }

  @Override
  public T search(int key) {
    return this.chainTable.get(hash(key)).searchKey(key).getData();
  }

  private int hash(int key) {
    switch (this.hashFunctionType){
      default: return HashFunctions.divisionHash(key,this.tableLength);
    }
  }

  @Override
  public void insert(T newObject) {
    TailedDoublyLinkedList<T> chosenList = this.chainTable.get(hash(newObject.getKey()));
    switch (this.insertionType){
      case AT_HEAD: chosenList.insert(0,newObject);
      case AT_TAIL: chosenList.insert(chosenList.size(),newObject);
    }
  }

  @Override
  public void delete(T targetObject) {
    TailedDoublyLinkedList<T> chosenList = this.chainTable.get(hash(targetObject.getKey()));
    switch (this.insertionType){
      case AT_HEAD: chosenList.delete(0);
      case AT_TAIL: chosenList.delete(chosenList.size() - 1);
    }
  }
}
