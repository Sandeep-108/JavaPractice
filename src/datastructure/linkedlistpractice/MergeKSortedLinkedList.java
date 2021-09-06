package datastructure.linkedlistpractice;

public class MergeKSortedLinkedList {

    public static ListNode mergeKLists(ListNode list[]){
        if(list.length ==0) return null;
        return mergeKLists(list, 0, list.length-1);
    }

    private static ListNode mergeKLists(ListNode[] list, int si, int ei) {
        if(si>ei) return null;
        if(si==ei) return list[si];
        int mid = (si+ei)/2;

        ListNode mergeList1 = mergeKLists(list,si,mid);
        ListNode mergeList2 = mergeKLists(list, mid+1,ei);
        ListNode mergeList = merge2SortedList(mergeList1,mergeList2);
        System.out.println("merged list:"+mergeList);
        return mergeList;
    }

    public static ListNode merge2SortedList(ListNode head1, ListNode head2){
        System.out.println("list to merge: "+head1+", "+head2);
        if(head1 ==null || head2==null){
            return  head1==null?head2:head1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode<Integer> c1 =head1;
        ListNode<Integer> c2=head2;
        ListNode p=dummyNode;
        while(c1!=null && c2!=null){
            if(c1.data <c2.data){
                p.next=c1;
                p=c1;
                c1=c1.next;
            }else {
                p.next=c2;
                p=c2;
                c2=c2.next;
            }
        }
        p.next= c1==null?c2:c1;
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
        ListNode merged = mergeKLists(list);
        System.out.println(merged);
    }
}
