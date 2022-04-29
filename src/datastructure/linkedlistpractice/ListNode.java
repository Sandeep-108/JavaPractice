package datastructure.linkedlistpractice;

public class ListNode<V>{
    public V data;
    public  ListNode<V> next;

    public ListNode()
    {}
    public ListNode(V data){
        this.data=data;
        next=null;
    }
    public V getData(){
        return data;
    }

    public ListNode<V> add(V data){
        ListNode<V> node = new ListNode<V>(data);
        if(this.data ==null){
            this.data = data;
            return this;
        }
        ListNode<V> current = this;
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
        ListNode<V> current = this;
        while(current != null){
            sb.append(current.data).append("-> ");
            current = current.next;
        }
        sb.append("null ]");
        return sb.toString();
    }
}
