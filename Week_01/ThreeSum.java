package Week_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum instance = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> result = instance.threeSum(nums);
//        System.out.println(result);

        List<List<Integer>> result1 = instance.threeSum1(nums);
        System.out.println(result1);
    }

    /**
     * 暴力解法：三重嵌套循环 => O(n^3)
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length < 3) {
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {//[-1, 0, 1, 2, -1], -4
            for (int j = i + 1; j < length; j++) {//-1, [0, 1, 2, -1, -4]
                for (int k = 0; k < length; k++) {//[-1, 0, 1, 2, -1, -4]
                    if (k != i && k != j && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> subResult = new ArrayList<>();
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[k]);
                        result.add(subResult);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 优化解法：
     * 思路：a + b + c = 0 => a + b = -c
     * 步骤：找到所有组合 + 去重
     *
     * @param nums
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}
