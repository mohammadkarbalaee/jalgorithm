package io.github.jalgorithm.datastructures;

import io.github.jalgorithm.datastructures.hash.DataOverridingException;
import io.github.jalgorithm.datastructures.hash.TableIndexOutOfBoundException;

public interface DataStructure<T> {
  T search(int key);
  void insert(T newObject) throws DataOverridingException, TableIndexOutOfBoundException;
  void delete(T targetObject);
}
