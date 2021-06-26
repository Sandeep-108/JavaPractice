package datastructure.linkedlistpractice;

public class ListNode<V>{
    public V data;
    public  ListNode next;

    public ListNode()
    {}
    public ListNode(V data){
        this.data=data;
        next=null;
    }

    public ListNode add(V data){
        ListNode node = new ListNode(data);
        if(this.data ==null){
            this.data = data;
            return this;
        }
        ListNode current = this;
        while (current.next !=null){
            current= current.next;
        }
        current.next=node;
        return this;
    }

    @Override
    public String toString() {
        if(this.data == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while(current != null){
            sb.append(current.data+"-> ");
            current = current.next;
        }
        sb.append("null ]");
        return sb.toString();
    }
}
