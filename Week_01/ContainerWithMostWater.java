package Week_01;

/**
 * 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且n的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg
 * <p>
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater instance = new ContainerWithMostWater();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = instance.maxArea(height);
        System.out.println(maxArea);

        //int maxArea = instance.maxArea1(height);
        //System.out.println(maxArea);
    }

    /**
     * 优化解法： 双指针，左右夹逼。 初始化为最宽状态，高度最低的向内移动减少面积。 => O(n)
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.17%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了37.89%的用户
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i != j) {
            int w = j - i;
            int h = 0;
            if (height[i] < height[j]) {
                h = height[i++];
            } else {
                h = height[j--];
            }
            int area = w * h;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法：嵌套循环，遍历所有可能性 => O(n ^ 2)
     * <p>
     * 执行用时：686 ms, 在所有 Java 提交中击败了19.17%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了37.89%的用户
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int w = j - i;
                int h = height[i] < height[j] ? height[i] : height[j];
                int area = w * h;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}