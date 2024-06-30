package week16;

import java.util.Arrays;

public class 이진_검색_70 {
    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) >= 0 ? Arrays.binarySearch(nums, target) : -1;
    }
}
