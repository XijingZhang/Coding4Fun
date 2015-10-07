// Find Minimum in Rotated Sorted Array II
public int FindMinimumInRotatedSortedArrayII(int[] nums) {
	return FindMin(nums, 0, nums.length - 1);
}

public int FindMin(int[] nums, int left, int right) {
	if (right == left) {
		return nums[left];
	}
	if (right == left + 1) {
		return Math.min(nums[left], nums[right]);
	}
	int mid = left + (right - left) / 2;
	if (nums[right] > nums[left]) {
		return nums[left];
	} else if (nums[right] == nums[left]) {
		return FindMin(nums, left + 1, right);
	} else if ( nums[mid] >= nums[left]) {
		return FindMin(nums, mid, right);
	} else {
		return FindMin(nums, left, mid);
	}
}
