public class Tester {
  public static void main (String[] args) {
    head("add");
    MyLinkedList a1 = new MyLinkedList();
    for (int i = 0; i < 6; i++) {
      a1.add("" + i);
    }
    print(a1.toString(), "[0, 1, 2, 3, 4, 5]");
  }
  public static void print (Object actual, Object expected) {
    String str = "";
    str += "Actual: " + actual + "\n";
    str += "Expected: " + expected + "\n";
    if (actual.equals(expected)) {
      str += "Success! :)\n";
    } else {
      str += "Fail! :(\n";
    }
    System.out.println(str);
  }

  public static void head (String heading) {
    String str = "";
    str+= "~~~\n" + heading + "\n~~~";
    System.out.println(str);
  }

}
