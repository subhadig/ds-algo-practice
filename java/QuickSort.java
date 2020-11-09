//https://leetcode.com/problems/sort-an-array/

class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    void quickSort(int[] arr, int l, int h) {
        if(h > l) {
            int p = partition(arr, l, h);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, h);
        }
    }
    
    int partition(int[] arr, int l, int h) {
        int p = h;
        h--;
        while(l <= h) {
            if(arr[l] < arr[p]) {
                l++;
            } else if(arr[h] >= arr[p]) {
                h--;
            } else {
                swap(arr, l, h);
                l++;
                h--;
            }
        }
        swap(arr, l, p);
        
        return l;
    }
    
    void swap(int[] arr, int i, int j) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }
}
