package src.Linked_List;

// 107
//
//If all of your classes are in the same package, you shouldn't need to import them.
public class SinglyList {
    SinglyListNode head;
    SinglyList (SinglyListNode node) {
        // System.out.print(node.val);
        head = node;
    }

    // 在prev节点之后插入增加一个值为val的新节点
    SinglyListNode addNode(SinglyListNode prev, int val) {
        SinglyListNode cur = new SinglyListNode(val);
        cur.next = prev.next;
        prev.next = cur;
        return head;
    }

    // 遍历整个链表...
    void  travel(SinglyListNode head) {
        SinglyListNode cur = new SinglyListNode(head.val);
        cur = head;
        while (cur != null) {
            System.out.println("value is "+ cur.val);
            cur = cur.next;
        }
    }


    public static void main(String args[]) {
        SinglyListNode head = new SinglyListNode(6);
        SinglyList list = new SinglyList(head);
        list.addNode(head, 3);
        list.addNode(head, 2);
        list.travel(head);
    }
}
