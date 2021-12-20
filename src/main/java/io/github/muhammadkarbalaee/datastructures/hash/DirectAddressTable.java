package io.github.muhammadkarbalaee.datastructures.hash;

import io.github.muhammadkarbalaee.exceptions.datastructure.hash.DataOverridingException;
import io.github.muhammadkarbalaee.exceptions.datastructure.hash.TableIndexOutOfBoundException;

import java.util.ArrayList;

public class DirectAddressTable<T extends DirectAddressableObject> {
  private final ArrayList<T> table;
  private final int tableLength;

  public DirectAddressTable(int tableLength) {
    this.table = new ArrayList<>(tableLength);
    this.tableLength = tableLength;
    for (int i = 0; i < tableLength; i++) {
      this.table.add(null);
    }
  }

  public T search(int key) {
    return this.table.get(key);
  }

  public void insert(T newObject) throws DataOverridingException, TableIndexOutOfBoundException {
    if (newObject.getKey() >= this.tableLength) {
      throw new TableIndexOutOfBoundException();
    } else if (this.table.get(newObject.getKey()) != null) {
      throw new DataOverridingException();
    } else {
      this.table.set(newObject.getKey(),newObject);
    }
  }

  public void delete(T targetObject) {
    this.table.set(targetObject.getKey(),null);
  }
}
