package leetcode;

import classes.ListNode;

public class Q141LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode walker, runner;
        walker = head;
        runner = head;
        while(runner.next != null
                && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
