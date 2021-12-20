package io.github.muhammadkarbalaee.datastructures;

import io.github.muhammadkarbalaee.exceptions.datastructure.hash.DataOverridingException;
import io.github.muhammadkarbalaee.exceptions.datastructure.hash.TableIndexOutOfBoundException;

public interface DataStructure<T> {
  T search(int key);
  void insert(T newObject) throws DataOverridingException, TableIndexOutOfBoundException;
  void delete(T targetObject);
}
