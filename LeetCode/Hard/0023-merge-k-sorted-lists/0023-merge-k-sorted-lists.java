import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode each : lists) {
            while (each != null) {
                pq.add(new ListNode(each.val));
                each = each.next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            ListNode current = pq.poll();
            tail.next = current;
            tail = tail.next;
        }
        
        return head.next;
        
    }
}