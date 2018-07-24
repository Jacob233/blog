package linkedlist;


/**
 * @author ji.xie
 * @Filename AddTwoNumbers.java
 * @description　leetCode->2.Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/6/11 16:27</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i1 = transferNode2Int(l1);
        int i2 = transferNode2Int(l2);
        int bit = 0;
        int sum = i1 + i2;
        int[] vals = new int[10000];
        for (; sum > 1; sum /= 10) {
            vals[bit] = sum % (10 ^ (bit));
            ++bit;
        }
        ListNode node = ListNode.initIntNode(vals);
        return node;
    }

    private static int transferNode2Int(ListNode node) {
        int num = 0;
        int count = 1;
        while (null != node.getNext()) {
            num += node.getIntVal() * count;
            node = node.getNext();
            count *= 10;
        }
        return num;
    }
}

