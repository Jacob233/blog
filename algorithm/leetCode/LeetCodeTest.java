//import linkedlist.AddTwoNumbers;
//import linkedlist.ListNode;
//import org.junit.Test;
//
///**
// * @author ji.xie
// * @Filename LeetCodeTest.java
// * @description leetcode-testor
// * @Version 1.0
// * @History <li>Author: ji.xie</li>
// * <li>Date: 2018/6/11 14:12</li>
// * <li>Version: 1.0</li>
// * <li>Content: create</li>
// */
//public class LeetCodeTest {
//
//    /**
//     * 测试数据
//     */
//    private int[] nums = new int[]{2, 7, 11, 15};
//    private String[] words = new String[]{"gin", "zen", "gig", "msg"};
//    private int target = 9;
//    private String s = "aaaad";
//    private String t = "abcd";//(2 -> 4 -> 3) + (5 -> 6 -> 4)
//    private ListNode l1 = ListNode.initIntNodes(new int[]{2, 4, 3});
//    private ListNode l2 = ListNode.initIntNodes(new int[]{5, 6, 4});
//
//    @Test
//    public void test() {
//        //1.Two Sum(2)
////        for (int i : TwoSum.twoSum1(nums, target)) {
////            System.out.println(i);
////        }
//        //2.Add Two Numbers
//        ListNode node = AddTwoNumbers.addTwoNumbers(l1, l2);
//        while (null != node) {
//            System.out.println(node.getIntVal());
//            node = node.getNext();
//        }
//        //389.Find the Difference
////        System.out.println(FindDifference.findTheDifference(s, t));
//        //804.Unique Morse Code Words(2)
////        System.out.println(MorseCodeConvenice.uniqueMorseRepresentations1(words));
//    }
//}