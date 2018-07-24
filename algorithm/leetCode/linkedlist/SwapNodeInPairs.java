package linkedlist;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename linkedlist.SwapNodeInPairs.java
 * @description
 * @交换相邻节点: Given a linked list, swap every two adjacent nodes and return its head.
 * For example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/1/20 21:23</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class SwapNodeInPairs {

    /**
     * 算法实现
     */
    public ListNode swapPairs(ListNode head) throws CloneNotSupportedException {

        boolean flag = true;

        ListNode pre = head;
        ListNode post = new ListNode();

        while (flag) {
            if (pre.getNext() == null) {
                flag = false;
            }

            post = pre.getNext();
            ListNode temp = post;
            post.setNext(pre);
            pre.setNext(temp.getNext());

            pre = temp.getNext();
        }

        return head;
    }

    @Test
    public void test() throws CloneNotSupportedException {
        ListNode orign = new ListNode("1", new ListNode("2", new ListNode("3", new ListNode("4", new ListNode()))));
        ListNode head = swapPairs(orign);
        System.out.println(head.getStrVal() + "->" + head.getNext().getStrVal() + "->" + head.getNext().getNext().getStrVal() + "->" +
                head.getNext().getNext().getNext().getStrVal());
    }
}
