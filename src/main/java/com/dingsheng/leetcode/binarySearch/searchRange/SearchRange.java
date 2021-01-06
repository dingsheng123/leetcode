package com.dingsheng.leetcode.binarySearch.searchRange;

/**
 * @author dingsheng
 * @date 2021/1/6 下午2:43
 * @description leetcode-34: 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    /*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    如果数组中不存在目标值 target，返回 [-1, -1]。 

    示例 1：
    输入：nums = [5,7,7,8,8,10], target = 8
    输出：[3,4]

    示例 2：
    输入：nums = [5,7,7,8,8,10], target = 6
    输出：[-1,-1]

    示例 3：
    输入：nums = [], target = 0
    输出：[-1,-1]
    */
    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(searchRange(nums, 3)[0]);
        System.out.println(searchRange(nums, 3)[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length <= 0) {
            return result;
        }

        int left = searchLeft(nums, target);
        int right = searchRighe(nums, target);
        if (left > right) {
            return result;
        }

        result[0] = left;
        result[1] = right;
        return result;
    }

    //找到最左边的位置
    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //搜索空间在[left,right]之间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //找到了，继续在左边空间里搜索：[left,mid-1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                //搜索空间是右边：[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                //搜索空间是左边：[left,mid-1]
                right = mid - 1;
            }
        }
        return left;
    }

    //找到最右边的位置
    public static int searchRighe(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //搜索空间在[left,right]之间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                //找到了，继续在右边空间里搜索：[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] < target) {
                //搜索空间是右边：[mid+1,right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                //搜索空间是左边：[left,mid-1]
                right = mid - 1;
            }
        }

        return right;
    }

}
