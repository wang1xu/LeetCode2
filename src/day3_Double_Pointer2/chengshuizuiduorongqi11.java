package day3_Double_Pointer2;
/*
11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。
示例 1：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
示例 2：

输入：height = [1,1]
输出：1
示例 3：

输入：height = [4,3,2,1,4]
输出：16
示例 4：

输入：height = [1,2,1]
输出：2
*/

public class chengshuizuiduorongqi11 {
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
//        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums = new int[]{1,2,1};
        int ans = solution.maxArea(nums);
        System.out.println(ans);
    }
}
class Solution2 {
    public int maxArea(int[] height) {
        int maxarea=0;
        int low=0;
        int high = height.length - 1;
        while (low < high) {
            maxarea = Math.max(maxarea, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxarea;
    }
}