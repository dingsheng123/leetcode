package com.dingsheng.leetcode.binarySearch.searchMatrix;

/**
 * @author dingsheng
 * @date 2021/1/6 下午7:01
 * @description leetcode-74：搜索二维矩阵
 */
public class SearchMatrix {

    /**
    编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。
             
    示例 1：
    输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    输出：true

    示例 2：
    输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    输出：false
     **/
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        //二维数组打平成一维数组，使用二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] > target) {
                right = mid - 1;
            } else if (matrix[midRow][midCol] < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
