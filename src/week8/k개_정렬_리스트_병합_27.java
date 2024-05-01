package week8;

import java.util.*;

public class k개_정렬_리스트_병합_27 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        ListNode dummyHead = new ListNode();
        ListNode currNode = dummyHead;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();

            if(node.next != null)
                pq.add(node.next);

            currNode.next = node;
            currNode = currNode.next;
        }

        return dummyHead.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
