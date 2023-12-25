import java.util.Scanner;  // import the Scanner class

public class Main {

   public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     SDList x, y, z;
     String a, b;

     System.out.println("A: ");
     a = input.nextLine();
     x = makeSDList(a);          // convert first string to a linked list
     System.out.println("B: ");   
     b = input.nextLine();
     y = makeSDList(b);         // convert second string to a linked list
     z = x.addLists(y);        // add lists x & y and store result in list z
     System.out.print("A+B: ");
     z.displayList();          // call function that displays list z
 }

   public static SDList makeSDList(String s) {
     SDList tempList = new SDList();
     for (int i = 0; i < s.length(); i++) {
       char tempChar = s.charAt(i);
       SDNode tempNode = new SDNode(tempChar);
       tempList.addLast(tempNode);
     }
     return tempList;
   }
}

class SDNode {
  public char data;
  public SDNode next;

  public SDNode (char d) {
    data = d;
    next = null;
  }
}

class SDList {
  public SDNode head;
  public SDNode tail;

  public SDList() {
    head = null;
    tail = null;
  }

  public void addLast(SDNode newNode) {
    if (tail == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  public String listsToString() {
    if (head == null && tail == null) {
      System.out.println("No data in the list.");
      return null;
    } else {
      String tempString = "";
      while (head != tail) {
        tempString += head.data;
        head = head.next;
      }
      tempString += tail.data;
      return tempString;
    }
  }

  public SDList addLists(SDList c) {
    String tempThis = this.listsToString();
    String tempOther = c.listsToString();

    String reverseThis = "";
    String reverseOther = "";
    for (int i = 0; i < tempThis.length(); i++) {
      reverseThis = tempThis.charAt(i) + reverseThis;
    }
    for (int j = 0; j < tempOther.length(); j++) {
      reverseOther = tempOther.charAt(j) + reverseOther;
    }

    String outcome = "";
    int carryUp = 0;
    int indThis = 0, indOther = 0;
    while (indThis < reverseThis.length() || indOther < reverseOther.length()) {
      int digi = carryUp;
      carryUp = 0;
      if (indThis < reverseThis.length()) {
        digi += reverseThis.charAt(indThis) - '0';
        indThis++;
      }
      if (indOther < reverseOther.length()) {
        digi += reverseOther.charAt(indOther) - '0';
        indOther++;
      }
      if (digi >= 10) {
        outcome = Integer.toString(digi-10) + outcome;
        carryUp = 1;
      } else {
        outcome = Integer.toString(digi) + outcome;
      }
    }
    if (carryUp == 1) {
      outcome = "1" + outcome;
    }
    // if (reverseThis.length() >= reverseOther.length()) {
    //   for (ind = 0; ind < reverseOther.length(); ind++) {
    //     int digi1 = (reverseThis.charAt(ind)-'0') + (reverseOther.charAt(ind)-'0') + carryUp;
    //     carryUp = 0;
    //     if (digi1 >= 10) {
    //       outcome = Integer.toString(digi1-10) + outcome;
    //       carryUp = 1;
    //     } else {
    //       outcome = Integer.toString(digi1) + outcome;
    //     }
    //   }
    //   for (int k = ind; k < reverseThis.length(); k++) {
    //     int digi2 = (reverseThis.charAt(k)-'0') + carryUp;
    //     carryUp = 0;
    //     if (digi2 >= 10) {
    //       outcome = Integer.toString(digi2-10) + outcome;
    //       carryUp = 1;
    //     } else {
    //       outcome = Integer.toString(digi2) + outcome;
    //     }
    //   }
    //   if (carryUp == 1) {
    //     outcome = "1" + outcome;
    //   }
    // } else {
    //   for (ind = 0; ind < reverseThis.length(); ind++) {
    //     int digi1 = (reverseThis.charAt(ind)-'0') + (reverseOther.charAt(ind)-'0') + carryUp;
    //     carryUp = 0;
    //     if (digi1 >= 10) {
    //       outcome = Integer.toString(digi1-10) + outcome;
    //       carryUp = 1;
    //     } else {
    //       outcome = Integer.toString(digi1) + outcome;
    //     }
    //   }
    //   for (int k = ind; k < reverseOther.length(); k++) {
    //     int digi2 = (reverseOther.charAt(k)-'0') + carryUp;
    //     carryUp = 0;
    //     if (digi2 >= 10) {
    //       outcome = Integer.toString(digi2-10) + outcome;
    //       carryUp = 1;
    //     } else {
    //       outcome = Integer.toString(digi2) + outcome;
    //     }
    //   }
    //   if (carryUp == 1) {
    //     outcome = "1" + outcome;
    //   }
    // }

    SDList tempList = new SDList();
    for (int i = 0; i < outcome.length(); i++) {
      SDNode tempNode = new SDNode(outcome.charAt(i));
      tempList.addLast(tempNode);
     }
    return tempList;
  }

  public void displayList() {
    if (head == null && tail == null) {
      System.out.println("No data in the list.");
    } else {
      while (head != tail) {
        System.out.print(head.data);
        head = head.next;
      }
      System.out.println(tail.data);
    }
  }
}