//https://leetcode.com/problems/intersection-of-two-arrays-ii/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> nums1Map = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for(int num: nums1) {
            int count = nums1Map.getOrDefault(num, 0);
            nums1Map.put(num, ++count);
        }
        for(int num: nums2) {
            int count = nums1Map.getOrDefault(num, 0);
            if(count > 0) {
                intersection.add(num);
                nums1Map.put(num, --count);
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] nums = new int[1001];
        List<Integer> intersection = new ArrayList<>();
        for(int num: nums1) {
            nums[num] = ++nums[num];
        }
        for(int num: nums2) {
            if(nums[num] > 0) {
                intersection.add(num);
                nums[num] = --nums[num];
            }
        }
        int[] outArr = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++) {
            outArr[i] = intersection.get(i);
        }
        return outArr;
    }
}
