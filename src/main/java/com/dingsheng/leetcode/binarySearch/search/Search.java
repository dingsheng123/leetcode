package com.dingsheng.leetcode.binarySearch.search;

/**
 * @author dingsheng
 * @date 2021/1/6 下午3:31
 * @description leetcode-33： 搜索旋转排序数组
 */
public class Search {

    /*
    升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
    请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

    示例 1：
    输入：nums = [4,5,6,7,0,1,2], target = 0
    输出：4

    示例 2：
    输入：nums = [4,5,6,7,0,1,2], target = 3
    输出：-1

    示例 3：
    输入：nums = [1], target = 0
    输出：-1
    */
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {
                //左边是有序的
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边是有序的
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
