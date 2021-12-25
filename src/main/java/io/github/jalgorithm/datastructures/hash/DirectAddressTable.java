package io.github.jalgorithm.datastructures.hash;

import io.github.jalgorithm.datastructures.DataStructure;
import io.github.jalgorithm.exceptions.hash.DataOverridingException;
import io.github.jalgorithm.exceptions.hash.TableIndexOutOfBoundException;

import java.util.ArrayList;

public class DirectAddressTable<T extends KeyLabledObject> implements DataStructure<T> {
  private final ArrayList<T> table;
  private final int tableLength;

  public DirectAddressTable(int tableLength) {
    this.table = new ArrayList<>(tableLength);
    this.tableLength = tableLength;
    for (int i = 0; i < tableLength; i++) {
      this.table.add(null);
    }
  }

  @Override
  public T search(int key) {
    return this.table.get(key);
  }

  @Override
  public void insert(T newObject) throws DataOverridingException, TableIndexOutOfBoundException {
    if (newObject.getKey() >= this.tableLength) {
      throw new TableIndexOutOfBoundException();
    } else if (this.table.get(newObject.getKey()) != null) {
      throw new DataOverridingException();
    } else {
      this.table.set(newObject.getKey(),newObject);
    }
  }

  @Override
  public void delete(T targetObject) {
    this.table.set(targetObject.getKey(),null);
  }
}
