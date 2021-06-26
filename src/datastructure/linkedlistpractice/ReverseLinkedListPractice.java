package datastructure.linkedlistpractice;

import java.util.List;

public class ReverseLinkedListPractice {

    public static void main(String[] args) {
        ListNode<Integer> n = new ListNode<>(0);
        n.add(1).add(2).add(3).add(4).add(5).add(6).add(7);
        System.out.println(n);
        System.out.println("*****************");
        ListNode head = reverseInGroup(n, 3);
        System.out.println(head);

    }

    public static ListNode reverseInGroup(ListNode head, int size) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;
        ListNode currentBlockHead = head;
        int i = 1;
        //reverse list for current group
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
            ++i;
            if (i == size) {
                break;
            }
        }
        current.next = previous;
        System.out.println("setting " + currentBlockHead.data + " next ");
        //set next block first node at current block head next
        // which is last node of this current block after reversal
        currentBlockHead.next = reverseInGroup(next, size);
        if(currentBlockHead.next == null){
            System.out.println( "null ");
        }else
                System.out.println("," + currentBlockHead.next.data);
        return current;

    }

}
