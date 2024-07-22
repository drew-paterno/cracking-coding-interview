package linked_lists;

import java.util.List;

// Delete Middle Node, given only access to that node
public class DeleteMiddleNode {

    public static void main(String[] args) {
        var head = LinkedListNode.buildList(List.of(1, 6, 1, 2, 3));
        var middle = head.getNext();
        var result = deleteMiddleNode(middle);
        System.out.println(result);
        System.out.println(head.listToString());
    }

    public static <T> boolean deleteMiddleNode(LinkedListNode<T> node) {
        if(node == null || node.getNext() == null) {
            return false;
        }
        var next = node.getNext();
        node.setNext(next.getNext());
        node.setData(next.getData());
        return true;
    }

    public static <T> void deleteMiddleNodeDrew(LinkedListNode<T> node) {
        helper(node); // classic over complication
    }

    private static <T> LinkedListNode<T> helper(LinkedListNode<T> node) {
        if(node.getNext() == null) {
            return node;
        }
        var result = helper(node.getNext());
        var copy = new LinkedListNode<>(node.getData());
        copy.setNext(node);

        node.setData(result.getData());
        node.setNext(result.getNext());
        return copy;
    }

}
