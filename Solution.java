import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * Linked list node.
 */
class LLNode {

  // **** ****
  int value;
  LLNode next;

  // **** constructor ****
  public LLNode(int value) {
    this.value = value;
    this.next = null;
  }

  // **** toString ****
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("value: " + value);
    return sb.toString();
  }
}

/*
 * Linked list.
 */
class LL {

  // **** ****
  public LLNode head;
  public LLNode tail;

  // **** ****
  static LL linkedList = null;

  // **** constructor ****
  public LL() {
    this.head = null;
    this.tail = null;
  }

  // **** add ****
  public void add(int value) {

    // **** ****
    LLNode node = new LLNode(value);

    // **** check if list is empty ****
    if (this.head == null && this.tail == null) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
  }

  // **** toString ****
  public String toString() {

    // **** open list ****
    StringBuilder sb = new StringBuilder("[");

    // **** traverse linked list ****
    for (LLNode p = this.head; p != null; p = p.next) {
      if (p.next == null) {
        sb.append(p.value);
      } else {
        sb.append(p.value + ", ");
      }
    }

    // **** close list ****
    sb.append("]");

    // **** return string representation ****
    return sb.toString();
  }

  // **** reverse with stack ****
  public LL reverse(LL ll, int m) {

    // **** reversed linked list to return to caller ****
    LL rll = new LL();

    // **** to reverse set of elements ****
    Stack<Integer> stack = new Stack<Integer>();

    // **** traverse the linked list ****
    LLNode p = ll.head;
    while (p != null) {

      // **** push elements into stack ****
      for (int i = 0; (i < m) && (p != null); i++, p = p.next) {
        stack.push(p.value);
      }

      // **** pop elements from stack and insert them into the reversed list ****
      while (!stack.isEmpty()) {
        rll.add(stack.pop());
      }
    }

    // **** return list with reversed elements ****
    return rll;
  }
}

/*
 * Reverse a set of items in a linked list.
 */
public class Solution {

  /*
   * Reverse the elements in the list in sets of n USING a stack.
   */
  static LinkedList<Integer> reverse(LinkedList<Integer> ll, int m) {

    // **** list with reversed elements ****
    LinkedList<Integer> rll = new LinkedList<Integer>();

    // **** used to reverse entries ****
    Stack<Integer> stack = new Stack<Integer>();

    // **** iterate through the linked list ****
    Iterator<Integer> it = ll.iterator();
    while (it.hasNext()) {

      // **** collect the elements to be reversed ****
      for (int i = 0; (i < m) && it.hasNext(); i++) {
        stack.push(it.next());
      }

      // **** pop elements inserting them into the temporary list ****
      while (!stack.empty()) {
        rll.add(stack.pop());
      }
    }

    // **** return list with reversed elements ****
    return rll;
  }

  /*
   * Reverse the elements in the list in sets of n NOT using a stack.
   */
  static LinkedList<Integer> reverseNoStack(LinkedList<Integer> ll, int m) {

    // **** ****
    LinkedList<Integer> rll = new LinkedList<Integer>();

    // **** traverse the linked list ****
    for (int i = 0; i < ll.size(); i += m) {

      // **** set j ****
      int j = 0;
      if (ll.size() - i > m - 1) {
        j = m - 1;
      } else {
        j = ll.size() - i - 1;
      }

      // **** insert elements into the reverse list ****
      for (; j >= 0; j--) {

        // **** get element from list ****
        int e = ll.get(i + j);

        // **** add element to reverse list ****
        rll.add(e);
      }
    }

    // **** return list with reversed elements ****
    return rll;
  }

  /*
   * Test scaffolding.
   */
  public static void main(String[] args) {

    // **** open scanner ****
    Scanner sc = new Scanner(System.in);

    // **** read the number of elements to insert in a linked list ****
    int n = sc.nextInt();

    // **** read the number of elements to reverse at a time ****
    int m = sc.nextInt();

    // **** read the elements to be inserted in the linked list ****
    sc.nextLine();
    String str = sc.nextLine();

    // **** split values ****
    String[] values = str.split(" ");

    // *** populate linked list(s) ****
    LinkedList<Integer> ll = new LinkedList<Integer>();
    LL myll = new LL();
    for (int i = 0; i < n; i++) {
      ll.add(Integer.parseInt(values[i]));
      myll.add(Integer.parseInt(values[i]));
    }

    // **** reverse the elements in the linked list as needed ****
    // ll = reverse(ll, m);
    // ll = reverseNoStack(ll, m);
    myll = myll.reverse(myll, m);

    // **** display reversed list ****
    // System.out.println(ll.toString());
    System.out.println(myll.toString());

    // **** close scanner ****
    sc.close();
  }
}