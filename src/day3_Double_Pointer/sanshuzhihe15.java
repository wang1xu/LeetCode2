package day3_Double_Pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class sanshuzhihe15 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans = solution.threeSum(nums);
        System.out.println(ans);
    }
}
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int target = -nums[first];
            int third=nums.length-1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}