import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*
 * Reverse a set of items in a linked list.
 */
public class Solution {

  /*
   * Reverse the elements in the list in sets of n USING a stack.
   */
  static LinkedList<Integer> reverse(LinkedList<Integer> ll, int n) {

    // **** list with reversed elements ****
    LinkedList<Integer> rll = new LinkedList<Integer>();

    // **** used to reverse entries ****
    Stack<Integer> stack = new Stack<Integer>();

    // **** iterate through the linked list ****
    Iterator<Integer> it = ll.iterator();
    while (it.hasNext()) {

      // **** collect the elements to be reversed ****
      for (int i = 0; (i < n) && it.hasNext(); i++) {
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
  static LinkedList<Integer> reverseNoStack(LinkedList<Integer> ll, int n) {

    // **** ****
    LinkedList<Integer> rll = new LinkedList<Integer>();

    // **** traverse the linked list ****
    for (int i = 0; i < ll.size(); i += n) {

      // **** set j ****
      int j = 0;
      if (ll.size() - i > n - 1) {
        j = n - 1;
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

    // *** populate linked list with elements ****
    LinkedList<Integer> ll = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
      ll.add(Integer.parseInt(values[i]));
    }

    // **** reverse the elements as needed ****
    // ll = reverse(ll, m);
    ll = reverseNoStack(ll, m);

    // **** display reversed list ****
    System.out.println(ll.toString());

    // **** close scanner ****
    sc.close();
  }
}