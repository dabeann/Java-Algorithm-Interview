package week5;

import java.util.*;
public class 페어의_노드_스왑_17 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            int temp = node.val;
            node.val = node.next.val;
            node.next.val = temp;
            node = node.next.next;
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
