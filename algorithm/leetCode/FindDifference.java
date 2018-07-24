
/**
 * @author ji.xie
 * @Filename FindDifference.java
 * @description leetcode:->389. Find the Difference
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/6/8 14:02</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class FindDifference {


    /**
     * @Description  copy by @shet
     *               solve:surplus=summation-subtract
     * @Params
     * @Return
     * @Exceptions
     */
    public static char findTheDifference(String s, String t) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            sum -= t.charAt(j);
        }
        return (char) Math.abs(sum);
    }

}
