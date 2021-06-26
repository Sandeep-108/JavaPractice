package datastructure.linkedlistpractice;

public class MiddleNodeLinkedList {

    ListNode middleNode(ListNode<Integer> list){
        ListNode pointer1 =list;
        ListNode pointer2=list;
        while(pointer2!=null && pointer2.next!=null){
            pointer2=pointer2.next.next;
            pointer1=pointer1.next;
        }
        return pointer1;
    }

    public static void main(String[] args) {
        ListNode<Integer> n=new ListNode<>(0);
        n.add(1);
        n.add(2).add(3).add(4).add(5);

        ListNode middle=new MiddleNodeLinkedList().middleNode(n);
        System.out.println(n);


    }
}
