package com.dingsheng.leetcode.binarySearch.search;

/**
 * @author dingsheng
 * @date 2021/1/6 下午6:01
 * @description leetcode-81： 搜索旋转排序数组 II
 */
public class SearchRepeat {

    /**
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
    编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

    示例 1:
    输入: nums = [2,5,6,0,0,1,2], target = 0
    输出: true

    示例 2:
    输入: nums = [2,5,6,0,0,1,2], target = 3
    输出: false
     **/
    public static void main(String[] args) {
        int[] nums = {3,5,1};
        System.out.println(search(nums, 1));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length <= 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[left]) {
                left++;
                continue;
            }

            if (nums[mid] > nums[left]) {
                //左边有序
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
