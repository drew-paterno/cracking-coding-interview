package linked_lists;

import java.util.List;

public class FindKthToLastElement {

    public static void main(String[] args) {
        var head = LinkedListNode.buildList(List.of(1, 6, 1, 2, 1, 1, 3, 4, 5, 1, 4));
        var result = findKthToLastElement(head, 3, new Index());
        System.out.println(result);
    }

    public static <T> LinkedListNode<T> findKthToLastElement(LinkedListNode<T> head, int target, Index index) {
        if(head == null) {
            return null;
        }

        var node = findKthToLastElement(head.getNext(), target, index);
        index.increment();

        if(index.getIndex() == target) {
            return head;
        } else {
            return node;
        }
    }

}
