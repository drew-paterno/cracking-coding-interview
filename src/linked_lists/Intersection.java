package linked_lists;

import java.util.List;

public class Intersection {

    public static void main(String[] args) {
        var list1 = LinkedListNode.buildList(List.of(7, 1, 6, 6));
        var list2 = LinkedListNode.buildList(List.of(9, 1));
        var secondHalf = LinkedListNode.buildList(List.of(1, 6, 1, 2, 3));

        findInfo(list1).tail.setNext(secondHalf);
        findInfo(list2).tail.setNext(secondHalf);

        var result = findIntersection(list1, list2);
        System.out.println(result);
    }

    public static <T> LinkedListNode<T> findIntersection(LinkedListNode<T> head1, LinkedListNode<T> head2) {
        var list1 = findInfo(head1);
        var list2 = findInfo(head2);
        if(list1.tail != list2.tail) {
            return null;
        } else { // Lists do intersect (end with same node), now find intersection point
            if(list1.length > list2.length) {
                return findIntersection(head1, head2, list1.length - list2.length);
            } else {
                return findIntersection(head2, head1, list2.length - list1.length);
            }
        }
    }

    private static <T> LinkedListNode<T> findIntersection(LinkedListNode<T> longer, LinkedListNode<T> shorter, int offset) {
        while (offset > 0) {
            longer = longer.getNext();
            offset--;
        }

        var curr1 = longer;
        var curr2 = shorter;
        while (curr1 != null && curr2 != null) {
            if(curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.getNext();
            curr2 = curr2.getNext();
        }
        return null;
    }

    private static <T> ListInfo<T> findInfo(LinkedListNode<T> head) {
        if(head == null) {
            return new ListInfo<>(null, 0);
        }
        var curr = head;
        int length = 1;
        while (curr.getNext() != null) {
            length++;
            curr = curr.getNext();
        }
        return new ListInfo<>(curr, length);
    }

    record ListInfo<T>(LinkedListNode<T> tail, int length) {}
}
