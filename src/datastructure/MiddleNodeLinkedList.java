package datastructure;

class ListNode<V>{
    public V data;
   public  ListNode next;

   public ListNode(V data){
       this.data=data;
       next=null;
   }
    public ListNode(V data, ListNode next){
        this.data=data;
        this.next=next;
    }
        }
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
        ListNode<Integer> n1=new ListNode<>(1,n);
        ListNode<Integer> n2=new ListNode<>(2,n1);
        ListNode<Integer> n3=new ListNode<>(3,n2);
        ListNode<Integer> n4=new ListNode<>(4,n3);

        ListNode middle=new MiddleNodeLinkedList().middleNode(n4);
        System.out.println(middle.data);


    }
}
