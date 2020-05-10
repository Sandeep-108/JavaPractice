package datastructure;

import java.util.Stack;

public class ReverseLinkedList {

    public ListNode reverseListStak(ListNode list){

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


    public static void main(String[] args) {
        ListNode<Integer> n=new ListNode<>(0);
        ListNode<Integer> n1=new ListNode<>(1,n);
        ListNode<Integer> n2=new ListNode<>(2,n1);
        ListNode<Integer> n3=new ListNode<>(3,n2);
        ListNode<Integer> n4=new ListNode<>(4,n3);

        ListNode reverse=new ReverseLinkedList().reverseListStak(n4);
        while (reverse!=null){
            System.out.println(reverse.data);
            reverse=reverse.next;
        }
    }
}
