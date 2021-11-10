package day3_Double_Pointer2;

import java.util.ArrayList;
import java.util.List;

/*
986. 区间列表的交集
给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。

返回这 两个区间列表的交集 。

形式上，闭区间[a, b]（其中a <= b）表示实数x的集合，而a <= x <= b 。

两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。




示例 1：


输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
示例 2：

输入：firstList = [[1,3],[5,9]], secondList = []
输出：[]
示例 3：

输入：firstList = [], secondList = [[4,8],[10,12]]
输出：[]
示例 4：

输入：firstList = [[1,7]], secondList = [[3,10]]
输出：[[3,7]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interval-list-intersections
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class qujianliebiaojiaoji986 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] firstList=new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList=new int[][]{{1,5},{8,12},{15,23},{24,24},{25,25}};
        int[][] ans=new int[][]{};
        ans=solution.intervalIntersection(firstList,secondList);
        for (int[] i : ans) {
            System.out.println(i[0]+" "+i[1]);
        }
    }
}
class Solution1 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans=new ArrayList();
        int firstlength=firstList.length-1;
        int secondlength=secondList.length-1;
        int la=0;
        int lb=0;
        while (la <= firstlength && lb <= secondlength) {
            int low = Math.max(firstList[la][0], secondList[lb][0]);
            int high = Math.min(firstList[la][1], secondList[lb][1]);
            if (low <= high) {
                ans.add(new int[]{low, high});
            }
            if (firstList[la][1] < secondList[lb][1]) {
                la++;
            } else {
                lb++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }


}