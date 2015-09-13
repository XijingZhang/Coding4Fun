// Minimum Size Subarray Sum
// Solution 1: O(n)
public int minSubArrayLen1(int s, int[] nums) {
	int left = 0, right = 0;
	int sum = 0;
	int msal = nums.length + 1;
	while (right < nums.length) {
		sum +=nums[right];
		while (sum >= s) {
			if (right - left + 1 == 1)
				return 1;
			msal = Math.min(msal, right - left + 1);
			sum -= nums[left ++];
		}
		right ++;
	}
	return msal == nums.length + 1?0:msal;
	
}

// Solution 2: O(nlogn)
public int minSubArrayLen2(int s, int[] nums) {
	if (nums.length == 0 || nums == null) return 0;
	int min = Integer.MAX_VALUE;
	int[] sum = new int[nums.length + 1];
	for (int i = 0; i < nums.length; i++) {
		sum[i + 1] = sum[i] + nums[i];
		if (sum[i + 1] >= s) {
			int j = binarySearch(0, i, sum[i + 1] - s + 1, sum);
			if ( j > -1) {
				min = Math.min(min, i - j + 1);
			}
		}
	}
	return min == Integer.MAX_VALUE ? 0:min;
}

public int binarySearch(int left, int right, int target, int[] sum) {
	int result = -1;
	while (left < right - 1) {
		int m = left + (right - left) / 2;
		if (sum[m] >= target) {
			right = m - 1;
		} else if (sum[m] < target) {
			left = m;
		}
	}
	if (sum[right] < target) {
		return right;
	} else if (sum[left] < target) {
		return left;
	} else{
		return -1;
	}
}