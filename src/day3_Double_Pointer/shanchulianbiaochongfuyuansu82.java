package day3_Double_Pointer;

/*
82. 删除排序链表中的重复元素 II
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。



示例 1：


输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：


输入：head = [1,1,1,2,3]
输出：[2,3]

 */
public class shanchulianbiaochongfuyuansu82 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode p = new ListNode();
        ListNode head=p;
        int[] nums = new int[]{1,1,1,1,1,2,2};
        for (int i = 0; i < nums.length; i++) {
            p.next=new ListNode(nums[i]);
            p=p.next;
        }
        head=head.next;
        head=solution.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
//        ListNode l=head;
//        ListNode r = head.next;
//        while (r != null) {
//            if (l.val == r.val) {
//                l.next=r.next;
//                r = r.next;
//            } else {
//                l=r;
//                r = r.next;
//            }
//        }
//        return head;
        ListNode p = new ListNode();
        p.next=head;
        ListNode temp=p;
        ListNode np=head;
        while (np!=null && np.next != null) {
            if (np.val != np.next.val) {
                p=np;
                np = np.next;
            } else {
                while (np.next != null && np.val == np.next.val) {
                    np = np.next;
                }
                p.next=np.next;
                np = np.next;
            }
        }
        return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}