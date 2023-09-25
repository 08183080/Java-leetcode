package src.Linked_List;

// 107
//
//If all of your classes are in the same package, you shouldn't need to import them.
// ref: https://aaronice.gitbook.io/lintcode/linked_list
/*
不走,永远不会犯错,但是不犯错,永远不会成长的。。。
**/
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

    // 在head之前增加节点...
    SinglyListNode addBeforeHead(int val) {
        SinglyListNode node = new SinglyListNode(val);
        node.next = head;
        head = node;
        return head;
    }

    // 在tail之后增加节点
    SinglyListNode addAfterTail(int val) {
        SinglyListNode node = new SinglyListNode(val);
        SinglyListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return node;
    }

    // 遍历单链表,寻找到第一个值等于val的结点
    SinglyListNode queryNode(int val) {
        SinglyListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
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
        list.addNode(head, 2);// 6 -> 2 -> 3
        head = list.addBeforeHead(1); // 1 -> 6 -> 2 -> 3  // 重新设置头节点
        list.addAfterTail(100); // 1 -> 6 -> 2 ->3 -> 100
        list.travel(head);
        SinglyListNode n = list.queryNode(2);
        System.out.println(n.val);
    }
}
