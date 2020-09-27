package Week_01.code;

import DataStructure.code.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 10^4]
 * -10^5 <= Node.val <= 10^5
 * pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle {

    /**
     * 首先要读懂题意：什么是链表，什么是链表中存在环？
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        boolean result = false;
        Set<ListNode> alreadyAccessSet = new HashSet<>();
        ListNode currentObj = head;
        while (true) {
            if (alreadyAccessSet.contains(currentObj)) {
                result = true;
                break;
            } else {
                alreadyAccessSet.add(currentObj);
                currentObj = currentObj.getNext();
                if (currentObj == null) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedListCycle instance = new LinkedListCycle();

        // head = [3,2,0,-4], pos = 1
        ListNode ln4 = new ListNode();
        ListNode ln3 = new ListNode(0, ln4);
        ListNode ln2 = new ListNode(2, ln3);
        ListNode ln1 = new ListNode(3, ln2);
        ln4.setVal(-4);
        ln4.setNext(ln2);
//        boolean result = instance.hasCycle(ln1);
//        System.out.println(result);

        boolean result = instance.hasCycle1(ln1);
        System.out.println(result);
    }
}

