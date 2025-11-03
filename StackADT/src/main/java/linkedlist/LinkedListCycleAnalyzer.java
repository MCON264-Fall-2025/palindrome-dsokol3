package linkedlist;

import org.apache.commons.lang3.NotImplementedException;
import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head){
        if (head == null) {
            return new CycleInfo(-1, 0);
        }

        LLNode<T> slow = head;
        LLNode<T> fast = head;

        // Find meeting point if cycle exists
        boolean hasCycle = false;
        while (fast != null && fast.getLink() != null) {
            slow = slow.getLink();
            fast = fast.getLink().getLink();
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return new CycleInfo(-1, 0);
        }

        // Determine cycle length
        int cycleLen = 1;
        LLNode<T> marker = slow.getLink();
        while (marker != slow) {
            marker = marker.getLink();
            cycleLen++;
        }

        // Find entry index: move one pointer to head, other stays at meeting; advance both
        LLNode<T> ptr1 = head;
        LLNode<T> ptr2 = slow;
        int index = 0;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.getLink();
            ptr2 = ptr2.getLink();
            index++;
        }

        return new CycleInfo(index, cycleLen);
    }
}
