package datastructures;

import exceptions.hash.DataOverridingException;
import exceptions.hash.TableIndexOutOfBoundException;

public interface DataStructure<T> {
  T search(int key);
  void insert(T newObject) throws DataOverridingException, TableIndexOutOfBoundException;
  void delete(T targetObject);
}
