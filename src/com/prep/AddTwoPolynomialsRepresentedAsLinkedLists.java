package com.prep;

public class AddTwoPolynomialsRepresentedAsLinkedLists {
    public static void main(String[] args) {
        PolyNode poly1 = new PolyNode();
    }
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(-1, -1);
        PolyNode curr = dummy;
        PolyNode curr1 = poly1;
        PolyNode curr2 = poly2;
        while (curr1 != null && curr2 != null) {
            if (curr1.power > curr2.power) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            } else if (curr1.power < curr2.power) {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
            } else {
                int nextCoefficient = curr1.coefficient + curr2.coefficient;
                int nextPower = curr1.power;
                if (nextCoefficient != 0) {
                    curr.next = new PolyNode(nextCoefficient, nextPower);
                    curr = curr.next;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
                curr.next = null;
            }
        }
        while (curr1 != null) {
            curr.next = curr1;
            curr1 = curr1.next;
            curr = curr.next;
        }
        while (curr2 != null) {
            curr.next = curr2;
            curr2 = curr2.next;
            curr = curr.next;
        }
        return dummy.next;

    }
}

  class PolyNode {
      int coefficient, power;
      PolyNode next = null;

      PolyNode() {}
      PolyNode(int x, int y) {
          this.coefficient = x;
          this.power = y;
      }
      PolyNode(int x, int y, PolyNode next) {
          this.coefficient = x;
          this.power = y;
          this.next = next;
      }
  }

