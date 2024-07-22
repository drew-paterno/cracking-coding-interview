package linked_lists;

import java.util.List;

public class IsPalindrome {

    public static void main(String[] args) {
        var head = LinkedListNode.buildList(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1));
//        var head = LinkedListNode.buildList(List.of(1, 2, 3, 4, 5, 5, 4, 3, 2, 1));
        var result = isPalindrome(head);
        System.out.println(result);
    }

    public static <T> boolean isPalindrome(LinkedListNode<T> head) {
        LinkedListNode<T> tortoise = head;
        LinkedListNode<T> hare = head;
        int tCount = 0, hCount = 0;
        while (hare != null && hare.getNext() != null) {
            hare = hare.getNext().getNext();
            hCount += 2;
            tortoise = tortoise.getNext();
            tCount += 1;
        }

//        System.out.println(hCount);
//        System.out.println(tCount);

        // lists can be at most one larger - in that case it is the value in the middle, so for the sake of
        // finding if it is a palindrome, we don't need to consider the extra node
        LinkedListNode<T> half1 = head;
        LinkedListNode<T> half2 = reverse(tortoise);
        while (half1 != null && half2 != null) {
            if(half1.getData() != half2.getData()) {
                return false;
            }
            half1 = half1.getNext();
            half2 = half2.getNext();
        }

        return true;
    }

    private static <T> LinkedListNode<T> reverse(LinkedListNode<T> head) {
        LinkedListNode<T> prev = null;
        LinkedListNode<T> curr = head;
        while (curr != null) {
            var temp = new LinkedListNode<>(curr.getData());
            temp.setNext(prev);
            prev = temp;
            curr = curr.getNext();
        }
        return prev;
    }

}
