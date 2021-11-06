package day1_Binary_search;

public class sousuoerweijuzhen74 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean ans = solution.searchMatrix(matrix, 8);
        System.out.println(ans);
    }
}
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m*n - 1;
        int mid=0;
        int x,y;
        while (l <= r) {
            mid = (l + r) / 2;
            x = mid / n;
            y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                l = mid + 1;
            } else {
                r =mid -1;
            }
        }
        return false;
    }
}