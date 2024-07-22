package linked_lists;

import java.util.List;

public class Partition {

    public static void main(String[] args) {
        var head = LinkedListNode.buildList(List.of(6, 1, 6, 1, 2, 1, 1, 3, 4, 5, 1, 4));
        partition(head, 6);
        System.out.println(head.listToString());
    }

    // another optimal (and probably more readable) solution involves keep track of two different lists, one for
    // elements greater than or equal to the partition and one for elements less. It involves keeping track of
    // 4 pointers (2 for each list). I like mine better :)
    public static void partition(LinkedListNode<Integer> head, int partition) {
        LinkedListNode<Integer> left = null;
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            if (curr.getData() < partition) {
                left = left == null ? head : left.getNext();
                swap(left, curr);
            }
            curr = curr.getNext();
        }
    }

    private static void swap(LinkedListNode<Integer> n1, LinkedListNode<Integer> n2) {
        if(n1 == n2) {
            return;
        }
        var n1Val = n1.getData();
        n1.setData(n2.getData());
        n2.setData(n1Val);
    }

}
