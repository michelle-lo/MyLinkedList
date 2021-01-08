public class Node{
  public Node(String value) {
    data = value;
  }
  private String data;
  private Node next,prev;

  public String getData() {
    return data;
  }

  public String setData(String val) {
    String temp = data;
    data = val;
    return temp;
  }

  public Node getNext() {
    return next;
  }

  public Node setNext(Node val) {
    Node temp = next;
    next = val;
    return temp;
  }

  public Node getPrev() {
    return prev;
  }

  public Node setPrev(Node val) {
    Node temp = prev;
    prev = val;
    return temp;
  }
}
