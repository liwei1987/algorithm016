package Week_02.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    /**
     * 利用hash表存储（差值,差值索引），一次遍历数组完成。
     * <p>
     * 时间复杂度O(n),空间复杂度O(n)
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.60%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了65.08%的用户
     * <p>
     * 注意事项：
     * 1. key为差值
     * 2. 数组中元素的排序，最好小下标在前。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = null;
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subNum = target - nums[i];
            if (numMap.containsKey(subNum)) {
                result = new int[]{numMap.get(subNum), i};
                break;
            }
            numMap.put(nums[i], i);
        }
        return result;
    }

    /**
     * 注意与确认题意：
     * 1. 只会对应一个答案，但是同一个元素不能使用两遍。
     * 2. 返回的是数组的下标
     * <p>
     * 解决方案：
     * 1. 先遍历将所有值放入hash表<num, index> => 遍历时间复杂度 O(n), 哈希表空间复杂度O(n)
     * 2. 再次遍历所有值，每次从hash表中获取是否有(target-num)的key。 => 查找空间复杂度O(1)，遍历空间复杂度O(n)
     * <p>
     * 复杂度分析：
     * 时间复杂度O(n), 空间复杂度O(n)
     * <p>
     * 可优化方案：
     * 可以只遍历一遍数组即可
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = null;
        if (nums == null || nums.length <= 1) {
            return result;
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (numMap.containsKey(num) && numMap.get(num) != i) {
                result = new int[]{numMap.get(num), i};
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum instance = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(instance.twoSum(nums, target)));
    }
}
