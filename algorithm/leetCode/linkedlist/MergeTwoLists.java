package linkedlist;

import org.junit.Test;

/**
 * @author ji.xie
 * @Filename linkedlist.MergeTwoLists.java
 * @description Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/8/23 17:45</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class MergeTwoLists {

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode next = l1.getNext();
        boolean noFind = true;
        while (noFind) {
            if (next.getNext() == null) {
                noFind = false;
            } else {
                next = next.getNext();
            }
        }
        next.setNext(l2);
        return l1;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode("1", new ListNode("2", new ListNode("3", null)));
        ListNode l2 = new ListNode("4", new ListNode("5", new ListNode("6", null)));
        ListNode l3 = merge(l1, l2);
//        merge(l1, l2);
        System.out.println(l3.getNext().getNext().getNext().getNext().getValue());
    }

}
