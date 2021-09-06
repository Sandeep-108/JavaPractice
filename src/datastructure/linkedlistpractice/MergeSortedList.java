package datastructure.linkedlistpractice;

import java.util.List;

public class MergeSortedList {

    public static ListNode merge2SortedList(ListNode head1, ListNode head2){
        if(head1==null || head2==null){
            return head1==null?head2 :head1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode<Integer> c1 = head1;
        ListNode<Integer> c2 =head2;
        ListNode f =null;
        ListNode present = dummyNode;
        while(c1!=null && c2!=null) {
            if(c1.data < c2.data){
                present.next =c1;
                present =c1;
                c1=c1.next;
            }else {
                present.next = c2;
                present=c2;
                c2=c2.next;
            }
        }
        present.next = c1!=null ? c1:c2;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1).add(3).add(5).add(7).add(10).add(11);
        ListNode head2 = new ListNode(2).add(4).add(6).add(8).add(9);
        System.out.println("first Linked List: "+head1);
        System.out.println("second Linked List: "+head2);
        ListNode merged = merge2SortedList(head1,head2);
        System.out.println("merged Linked List: "+merged);
    }
}
