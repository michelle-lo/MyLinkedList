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

 //public void add(int index, String value) {};

 //public String get(int index);
 //public String set(int index, String value);

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
