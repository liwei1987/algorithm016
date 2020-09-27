package Week_02;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    /**
     * 使用hash表(sortedStr, originStrList), 一次遍历完成。
     * <p>
     * 时间复杂度 O(n), 空间复杂度 O(n)
     * <p>
     * 执行用时：8 ms, 在所有 Java 提交中击败了 95.26% 的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了 41.49% 的用户
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> sortedStrMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String originStr = strs[i];
            char[] originChars = originStr.toCharArray();
            Arrays.sort(originChars);
            String sortedStr = String.valueOf(originChars);
            if (!sortedStrMap.containsKey(sortedStr)) {
                List<String> originStrList = new ArrayList<>();
                originStrList.add(originStr);
                sortedStrMap.put(sortedStr, originStrList);
            } else {
                sortedStrMap.get(sortedStr).add(originStr);
            }
        }
        result = new ArrayList<>(sortedStrMap.values());
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = instance.groupAnagrams(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
