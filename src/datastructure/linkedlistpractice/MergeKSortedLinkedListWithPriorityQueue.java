package datastructure.linkedlistpractice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedListWithPriorityQueue {

    public static ListNode mergeKSortedList(ListNode listNode[]){
        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(ListNode::getData));
//        PriorityQueue<ListNode<Integer>> pq = new PriorityQueue<>((a,b)->{return a.data-b.data;});

        for(ListNode node: listNode){
            if(node != null) {
                pq.add(node);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode previous =dummyNode;
        while (!pq.isEmpty()){
            for(ListNode n: pq){
                System.out.print(n.data+",");
            }
            System.out.println();
            ListNode minNode = pq.remove();
            previous.next =minNode;
            previous =minNode;
            System.out.println("minNode:"+minNode.data);
            if(minNode.next!=null) {
                pq.add(minNode.next);
            }
            minNode.next=null;
            System.out.println("sorted List: "+dummyNode.next);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0).add(1).add(4).add(7).add(10);
        ListNode n2 = new ListNode(2).add(5).add(9);
        ListNode n3 = new ListNode(3).add(6).add(8);
        ListNode n4 = new ListNode(11).add(13).add(15);
        ListNode n5 = new ListNode(12).add(14).add(16);
        ListNode[] list = new ListNode[]{n1,n2,n3,n4,n5};
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        ListNode merged = mergeKSortedList(list);
        System.out.println(merged);
    }

}
