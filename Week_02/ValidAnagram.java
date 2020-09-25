package Week_02;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidAnagram {

    /**
     * 思路：
     * 1. 首先判断两个字符串长度是否相等，不相等则直接返回 false
     * 2. 若相等，则初始化 26 个字母哈希表，遍历字符串 s 和 t
     * 3. s 负责在对应位置增加，t 负责在对应位置减少
     * 4. 如果哈希表的值都为 0，则二者是字母异位词
     * https://leetcode-cn.com/problems/valid-anagram/solution/hua-jie-suan-fa-242-you-xiao-de-zi-mu-yi-wei-ci-by/
     * <p>
     * 执行用时：5 ms, 在所有 Java 提交中击败了49.80%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了25.38%的用户
     * <p>
     * 什么是异位词：两个字符串长度相等,各个字母的个数相等,只是顺序不同。(确认是否关心字母大小写)
     *
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] countTable = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countTable[s.charAt(i) - 'a']++;
            countTable[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < countTable.length; i++) {
            if (countTable[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 未看题解前，第一次解答。
     * <p>
     * 思路：
     * 使用Hash映射统计s字符串各个字符出现次数，然后循环t字符串中各个字符并对Hash映射统计进行减法。
     * 最终如果Hash映射统计中无元素即为异位词
     * <p>
     * 执行用时： 17 ms, 在所有 Java 提交中击败了 19.09% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 14.39% 的用户
     * <p>
     * 可优化点：
     * 1. 没必要2次循环，因为在判断完s与t对长度是否不相等之后，他们对长度是一致对循环任意一个字符串即可。
     * 2. 要与面试官确认异位数的严谨性：空算不算，完全相同算不算，大小写算不算。
     * 3. 代码有点长了。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> statMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = statMap.get(c);
            if (count == null) {
                statMap.put(c, 1);
            } else {
                statMap.put(c, ++count);
            }
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            Integer count = statMap.get(c);
            if (count == null) {
                break;
            }
            Integer newCount = --count;
            if (newCount == 0) {
                statMap.remove(c);
                continue;
            } else if (newCount < 0) {
                break;
            }
            statMap.put(c, newCount);
        }
        return statMap.size() == 0;
    }

    public static void main(String[] args) {
        ValidAnagram instance = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(instance.isAnagram(s, t));
        //System.out.println(instance.isAnagram1(s, t));
    }
}
