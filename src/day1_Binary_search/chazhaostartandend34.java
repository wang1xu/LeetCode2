package day1_Binary_search;

import java.util.Arrays;

/*
34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
 */
public class chazhaostartandend34 {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution solution = new Solution();
//        int ans = solution.Bin_search(nums, 10);
//        System.out.println(ans);
        int[] ans = solution.searchRange(nums, 1);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans = Bin_search(nums, target);
        if (ans == -1) {
            return new int[]{-1, -1};
        }
        int start = ans, end = ans;
        while (start - 1 >= 0) {
            if (nums[start - 1] == target) {
                start -= 1;
            } else {
                break;
            }
        }
        while (end + 1 < nums.length) {
            if (nums[end + 1] == target) {
                end += 1;
            } else {
                break;
            }
        }
        return new int[]{start, end};
    }

    public int Bin_search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}