package datastructure.linkedlistpractice;

import java.util.Stack;

public class ReverseLinkedList {

    public ListNode reverseListStack(ListNode list){

        Stack<ListNode> sc= new Stack<>();
        while(list!=null){
            sc.push(list);
            list=list.next;
        }
        ListNode reverse=sc.pop();
        ListNode reverseList=reverse;
        while(!sc.isEmpty()){
            reverseList.next=sc.pop();
            reverseList=reverseList.next;
        }
        reverseList.next=null;
        return reverse;
    }
    public ListNode reverseWithoutStack(ListNode head){
        //for 0 or 1 length linked list
        if(head ==null || head.next==null) return head;
        ListNode previous=null;
        ListNode current = head;
        ListNode forward =null;
        while (current!=null){
            //Create backup
            forward = current.next;
             //Link nodes
            current.next =previous; //current next point previous node

            //move
            previous =current;
            current =forward;
        }
        //In the end previous having value of reverse head;
        return previous;
    }


    public static void main(String[] args) {
        ListNode<Integer> n=new ListNode();
        n.add(1).add(2).add(3).add(4).add(5).add(6);


        ListNode reverse=new ReverseLinkedList().reverseWithoutStack(n);
        System.out.println(reverse);
        System.out.println(new ReverseLinkedList().reverseListStack(reverse));
    }
}
