//Maximum Subarray 
// Solution 1: Greedy
public int maxSubArray1(int[] nums) {
	if (nums == null || nums.length == 0){
		return 0;
	}
	int max = Integer.MIN_VALUE, sum = 0;
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		max = Math.max(max, sum);
		sum = Math.max(sum, 0);
	}
	return max;
}

// Solution 2: Prefix sum (DP)
public int maxSubArray2(int[] nums) {
	if (nums == null || nums.length == 0) {
		return 0;
	}
	
	int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
	for (int i = 0; i < nums.length; i++) {
		sum += nums[i];
		max = Math.max(max, sum - minSum);
		minSum = Math.min(minSum, sum);
	}
	return max;
}

