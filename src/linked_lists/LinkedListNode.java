package linked_lists;

import java.util.List;

class LinkedListNode<T> {
    
    private T data;
    private LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public String toString() {
        return data == null ? null : data.toString();
    }

    public String listToString() {
        var sb = new StringBuilder();
        sb.append('[');
        var curr = this;
        while (curr != null) {
            sb.append(curr.getData());
            curr = curr.getNext();
            if(curr != null) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> LinkedListNode<T> buildList(List<T> dataList) {

        var root = new LinkedListNode<>(dataList.get(0));
        var curr = root;
        for(int i = 1; i < dataList.size(); i++) {
            var next = new LinkedListNode<>(dataList.get(i));
            curr.setNext(next);
            curr = next;
        }

        return root;

    }

}