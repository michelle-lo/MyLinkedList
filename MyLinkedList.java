import java.util.*;

public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
 }
 public int size() {
   return size;
 }

 public boolean add(String value) {
   Node newNode = new Node(value);
   if (size == 0) {
     start = newNode;
     end = newNode;
   } else {
     newNode.setPrev(end);
     end.setNext(newNode);
     end = newNode;
   }
   size++;
   return true;
 }

 public void add(int index, String value) {
  if (index < 0 || index > size) {
    throw new IndexOutOfBoundsException("error! index is out of bounds");
  }

  Node newNode = new Node(value);
  Node x = nodePos(index);
  if (size == 0) { //empty
    start = newNode;
    end = newNode;
  } else if (index == 0) { //start
    start.setPrev(newNode);
    newNode.setNext(start);
    start = newNode;
  } else if (index == size) {
    newNode.setPrev(end);
    end.setNext(newNode);
    end = newNode;
  } else {
    x.getPrev().setNext(newNode);
    newNode.setPrev(x.getPrev());
    x.setPrev(newNode);
    newNode.setNext(x);
  }
  size++;
 }

 public String get(int index) {
   if (index < 0 || index >= size) {
     throw new IndexOutOfBoundsException("error! index is out of bounds");
   }
   Node x = nodePos(index);
   return x.getData();
 }

 public String set(int index, String value) {
   if (index < 0 || index >= size) {
     throw new IndexOutOfBoundsException("error! index is out of bounds");
   }
    Node x = nodePos(index);
    String temp = x.getData();
    x.setData(value);
    return temp;
 }

 public String toString() {
    String str = "[";
    Node x = start;
    for (int i = 0; i < size; i++) {
      str+= x.getData();
      if (i != size - 1) {
        str += ", ";
      }
      x = x.getNext();
    }
    return str + "]";
 }

 public String remove(int index) {
   Node x = nodePos(index);
   String temp = x.getData();
   if (size == 1) {
     start = null;
     end = null;
   } else if (index == 0) { //head
     start.getNext().setPrev(null);
     start = start.getNext();
   } else if (index == size - 1) {
     end.getPrev().setNext(null);
     end = end.getPrev();
   } else {
     x.getNext().setPrev(x.getPrev());
     x.getPrev().setNext(x.getNext());
   }
   size--;
   return temp;
 }


 public String toStringReversed() {
    String str = "[";
    Node x = end;
    for (int i = size - 1; i >= 0; i--) {
      str+= x.getData();
      if (i > 0) {
        str += ", ";
      }
      x = x.getPrev();
    }

    return str + "]";
 }

 private Node nodePos(int index) {
   Node x = start;
   for (int i = 0; i < index; i++) {
     x = x.getNext(); //prev node at position
   }
   return x;
 }

}
