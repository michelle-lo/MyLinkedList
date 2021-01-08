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
  Node newNode = new Node(value);
  Node x = start;
  for (int i = 0; i < index; i++) {
    x = x.getNext(); //prev node at position
  }

  if (index == 0) { //start
    x.setPrev(newNode);
    newNode.setNext(x);
    start = newNode;
  } else if (index == size) {
    add(value);
    size--;
    //x.setNext(newNode);
    //newNode.setPrev(x);
    //end = newNode;
  } else {
    x.getPrev().setNext(newNode);
    x.setPrev(newNode);
    newNode.setPrev(x.getPrev());
    newNode.setNext(x);
  }
  size++;
 }

 public String get(int index) {
   Node x = start;
   for (int i = 0; i < index; i++) {
     x = x.getNext();
   }
   return x.getData();
 }

 public String set(int index, String value) {
    Node x = start;
    for (int i = 0; i < index; i++) {
      x = x.getNext();
    }
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
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
