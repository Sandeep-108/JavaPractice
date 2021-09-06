package datastructure.linkedlistpractice;

import java.util.LinkedList;

public class FoldedLinkedList {

    public static ListNode findMid(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast =head;
        while(fast.next !=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static ListNode foldList(ListNode head){
        ListNode midNode = findMid(head);
        ListNode newHead = midNode.next;
        midNode.next=null;
        System.out.println("splited lists "+head+","+newHead);
        ListNode reverseHead = reverseList(newHead);
        System.out.println("reversed "+reverseHead);
        ListNode c1 =head;
        ListNode c2 =reverseHead;
        ListNode f1;
        ListNode f2;

        while (c2!=null){
            f1=c1.next;
            f2=c2.next;
            c1.next=c2;
            c2.next=f1;
            c1=f1;
            c2=f2;
        }
        return head;

    }

    private static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr =head;
        ListNode frwd =null;
        while(curr!=null){
            frwd =curr.next;
            curr.next=prev;
            prev=curr;
            curr=frwd;

        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode<Integer> n=new ListNode();
        n.add(1).add(2).add(3).add(4);


        ListNode folded =foldList(n);
        System.out.println(n);
    }
}
