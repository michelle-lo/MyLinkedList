public class Tester {
  public static void main (String[] args) {
    head("add");
    MyLinkedList a1 = new MyLinkedList();
    for (int i = 0; i < 3; i++) {
      a1.add("" + i);
    }
    print(a1.toString(), "[0, 1, 2]");

    MyLinkedList empty = new MyLinkedList();
    print(empty.toString(), "[]");

    head("add(index, value)");
    //adding in middle
    a1.add(2, "1.5");
    print(a1.toString(), "[0, 1, 1.5, 2]");
    //adding to front
    a1.add(0, "-1");
    print(a1.toString(), "[-1, 0, 1, 1.5, 2]");
    //adding to end
    a1.add(5, "3");
    print(a1.toString(), "[-1, 0, 1, 1.5, 2, 3]");

    head("get");
    print(a1.get(0), "-1");

    head("set");
    print(a1.set(0, "-2"), "-1");
    print(a1.toString(), "[-2, 0, 1, 1.5, 2, 3]");
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
