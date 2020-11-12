//package com.example.timeserver.Controller;
//
//public class QuickSort {
//    public static void main(String[] args) {
//
//    }
//
//    public void quickSort(int[] nums, int l, int r){
//        partation(nums, 0, nums.length - 1);
//    }
//
//    public void partation(int[] nums, int l, int r){
//        int hi = r;
//        int lo = l;
//        while (l < r) {
//            while (lo < hi && nums[hi] > nums[lo])
//                hi--;
//            swap(nums, lo, hi);
//            while (lo < hi && nums[lo] < nums[hi])
//                lo++;
//            swap(nums, lo, hi)
//        }
//        partation(nums, l, pivot - 1);
//        partation(nums, pivot + 1, r);
//    }
//}
