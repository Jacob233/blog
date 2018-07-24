import java.util.HashMap;
import java.util.Map;

/**
 * @author ji.xie
 * @Filename TwoSum.java
 * @description leetcode->1.Two Sum
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/6/11 13:48</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class TwoSum {
    /**
     * solve:遍历求解。有点笨的方法
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * solve:参考leetcode
     * 原理:
     * 1.利用hashMap特性
     * 2.对于求和类似的,可以在一条线上逼近。
     * 原因:对容器的使用还算不得熟练,所以一时没想到。
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //减
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            //增
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}