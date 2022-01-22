package datastructures;

import io.github.jalgorithm.datastructures.linkedlist.TailedDoublyLinkedList;

public class TailedDoublyLinkedListSample {
    public static void main(String[] args) {
        TailedDoublyLinkedList<Chainable> linkedList = new TailedDoublyLinkedList<>();
        linkedList.insert(0, new Chainable(1, "one"));
        linkedList.insert(1, new Chainable(2, "two"));
        linkedList.insert(2, new Chainable(3, "three"));
        linkedList.insert(3, new Chainable(4, "four"));
        linkedList.insert(4, new Chainable(5, "five"));
        System.out.println(linkedList);

        linkedList.reverse();
        System.out.println(linkedList);
    }
}
