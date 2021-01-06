package com.dingsheng.leetcode.findMin;

/**
 * @author dingsheng
 * @date 2021/1/6 下午6:16
 * @description leetcode-153：寻找旋转排序数组中的最小值
 */
public class FindMin {
    /**
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
    请找出其中最小的元素。 

    示例 1：
    输入：nums = [3,4,5,1,2]
    输出：1

    示例 2：
    输入：nums = [4,5,6,7,0,1,2]
    输出：0

    示例 3：
    输入：nums = [1]
    输出：1
     **/
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        int min = nums[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                //左边有序，nums[left]最小
                if (min > nums[left]) {
                    min = nums[left];
                }
                left = mid + 1;
            } else {
                //右边有序，nums[mid]最小
                if (min > nums[mid]) {
                    min = nums[mid];
                }
                right = mid - 1;
            }
        }
        return min;
    }
}
