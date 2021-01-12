import java.util.*;
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
    try{
      a1.get(10);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("nope!");
    }

    MyLinkedList a2 = new MyLinkedList();
    a2.add(0, "no");
    print(a2.toString(), "[no]");

    head("get");
    print(a1.get(0), "-1");

    try{
      a1.get(10);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("nope!");
    }

    head("set");
    print(a1.set(0, "-2"), "-1");
    print(a1.toString(), "[-2, 0, 1, 1.5, 2, 3]");
    try{
      a1.get(10);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("nope!");
    }
    print(a1.toStringReversed(), "[3, 2, 1.5, 1, 0, -2]");


    head("class tester!");
    MyLinkedList words = new MyLinkedList();

    //add 0-9 in order
    for(int i = 0; i < 10; i++){
      words.add(i+"");
    }
    //insert 0x - 9x before each value 0-9
    for(int i = 0; i < 10; i++){
      words.add(2*i,i+"x");
    }
    //check the head/tail add
    words.add(0,"head");
    words.add(words.size(),"tail");

    try{
      words.add(-1,"");
      System.out.println("ERROR! Added to negative index");
    }catch(IndexOutOfBoundsException e){

    }

    try{
      words.add(words.size()+1,"");
      System.out.println("ERROR! Added to (size + 1) index");
    }catch(IndexOutOfBoundsException e){

    }


    System.out.println("Your result:\n"+words+" "+words.size());
    System.out.println("expected:\n[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail] 22");
    System.out.println("\nYour result:\n"+words.toStringReversed()+" "+words.size());
    System.out.println("expected:\n[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head] 22");

    head("remove");
    a1.remove(0);
    print(a1.toString(), "[0, 1, 1.5, 2, 3]");
    a1.remove(4);
    print(a1.toString(), "[0, 1, 1.5, 2]");
    a1.remove(1);
    print(a1.toString(), "[0, 1.5, 2]");

    MyLinkedList a3 = new MyLinkedList();
    a3.add("1");
    a3.remove(0);
    print(a3.toString(), "[]");

    head("extend");
    a2.add("yes");
    a2.add("lmao");
    System.out.println("a1: " + a1.toString());
    System.out.println("a2: " + a2.toString());
    a1.extend(a2);
    //"regular" cases
    print(a1.toString(), "[0, 1.5, 2, no, yes, lmao]");
    print(a2.toString(), "[]");
    //two emptys
    MyLinkedList empty1 = new MyLinkedList();
    System.out.println("empty: " + empty.toString());
    System.out.println("empty1: " + empty1.toString());
    empty.extend(empty1);
    print(empty.toString(), "[]");

    MyLinkedList single = new MyLinkedList();
    single.add("lonely");
    //this empty, other not
    System.out.println("empty: " + empty.toString());
    System.out.println("single: " + single.toString());
    empty.extend(single);
    print(empty.toString(),"[lonely]");
    print(single.toString(),"[]");
    //this full, other empty

    MyLinkedList alone = new MyLinkedList();
    alone.add("forever");
    System.out.println("alone: " + alone.toString());
    System.out.println("empty1: " + empty1.toString());
    alone.extend(empty1);
    print(alone.toString(), "[forever]");
    print(empty1.toString(), "[]");

    head("class tester!!");
    MyLinkedList a = new MyLinkedList();
    MyLinkedList b = new MyLinkedList();
    for(int i = 0; i < 10; i++){
      if(i < 5){
        a.add(i+"");
      }else{
        b.add(i+"");
      }
    }
    System.out.println();
    System.out.println("A:"+a+a.size());
    System.out.println("B:"+b+b.size());

    a.extend(b);
    System.out.println("A:"+a+a.size());
    System.out.println("B:"+b+b.size());
    System.out.println("A reversed:"+a.toStringReversed()+a.size());
    System.out.println("B reversed:"+b.toStringReversed()+b.size());

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
