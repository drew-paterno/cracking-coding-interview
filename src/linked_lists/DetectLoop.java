package linked_lists;

import java.util.HashMap;
import java.util.List;

public class DetectLoop {

    public static void main(String[] args) {
        var head = initLoop(LinkedListNode.buildList(List.of('d', 'a', 'b', 'c')));
//        var head = LinkedListNode.buildList(List.of('a', 'b', 'c'));
        var result = detectLoopTortoiseHare(head);
        System.out.println(result);
    }

    private static <T> LinkedListNode<T> initLoop(LinkedListNode<T> head) {
        var curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(head);
        return head;
    }

    public static <T> LinkedListNode<T> detectLoopLinearMemory(LinkedListNode<T> head) {
        HashMap<LinkedListNode<T>, Boolean> deduper = new HashMap<>();

        var curr = head;
        while(curr != null) {
            if(deduper.containsKey(curr)) {
                return curr;
            } else {
                deduper.put(curr, Boolean.TRUE);
            }
            curr = curr.getNext();
        }

        return null;
    }

    public static <T> LinkedListNode<T> detectLoopTortoiseHare(LinkedListNode<T> head) {
        if(head == null || head.getNext() == null) {
            return null;
        }

        LinkedListNode<T> tortoise = head;
        LinkedListNode<T> hare = head;
        while (tortoise.getNext() != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
            if(tortoise == hare) {
                hare = head; // or tortoise = head
                while(tortoise != hare) {
                    tortoise = tortoise.getNext();
                    hare = hare.getNext();
                }
                return hare; // or tortoise
            }
        }

        return null;
    }

}
