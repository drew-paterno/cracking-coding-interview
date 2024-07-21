package linked_lists;

import java.util.HashMap;
import java.util.List;

public class RemoveDupes {

    public static void main(String[] args) {
        var head = LinkedListNode.buildList(List.of(1, 6, 1, 2, 1, 1, 3, 4, 5, 1, 4));
        removeDupes(head);
        System.out.println(head.listToString());
    }

    public static <T> void removeDupes(LinkedListNode<T> head) {
        var map = new HashMap<T, LinkedListNode<T>>();
        LinkedListNode<T> curr = head;
        LinkedListNode<T> prev = null;
        while(curr != null) {
            if(!map.containsKey(curr.getData())) {
                map.put(curr.getData(), curr);
                prev = curr;
            } else { // dupe detected
                prev.setNext(curr.getNext());
            }
            curr = curr.getNext();
        }
    }

}
