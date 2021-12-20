package io.github.muhammadkarbalaee.datastructures.hash;

public class HashFunctions {
  public static int divisionHash(int key,int tableLength){
    return key % tableLength;
  }
}
