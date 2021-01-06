package com.dingsheng.leetcode.searchInsert;

import com.sun.tools.javac.util.Assert;

/**
 * @author dingsheng
 * @date 2021/1/6 下午2:35
 * @description leetcode-35 二分查找
 */
public class SearchInsert {
    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。

    示例 1:
    输入: [1,3,5,6], 5
    输出: 2

    示例 2:
    输入: [1,3,5,6], 2
    输出: 1

    示例 3:
    输入: [1,3,5,6], 7
    输出: 4

    示例 4:
    输入: [1,3,5,6], 0
    输出: 0
    */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5) == 2);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //搜索空间在[left,right]之间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //找到了，直接返回下标
                return mid;
            } else if (nums[mid] < target) {
                //搜索空间是右边：[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                //搜索空间是左边：[left,mid-1]
                right = mid - 1;
            }
        }
        //没有找到，返回-1
        return -1;
    }

}
