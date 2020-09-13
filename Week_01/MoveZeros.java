package Week_01;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros instance = new MoveZeros();
        int[] nums = new int[]{0, 1, 0, 3, 12};

        instance.moveZeros(nums);
        System.out.println(Arrays.toString(nums));

        instance.moveZeros1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 优化解法：双指针，快慢指针。快指针遍历数组，慢指针指向需要操作的数据。 => O(n)
     *
     * @param nums
     */
    public void moveZeros(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                if (i != nonZeroIndex) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

    /**
     * 暴力解法：嵌套循环 => O(n ^ 2)
     *
     * @param nums
     */
    private void moveZeros1(int[] nums) {

    }
}