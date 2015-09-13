//House Robber 
// Solution 1: DP
public int rob(int[] nums) {
	if (nums == null || nums.length == 0)
		return 0;
	int n = nums.length;
	
	int[] dp = new int[n + 1];
	dp[0] = 0;
	dp[1] = nums[0];
	
	for (int i = 2; i < n + 1; i++) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
	}
	return dp[n];
}

// Solution 2:
public int rob(int[] nums) {
	if (nums == null || nums.length == 0)
		return 0;
	int even = 0, odd = 0;
	for (int i = 0; i < nums.length; i++) {
		if (i % 2 == 0) {
			even += nums[i];
			even = even > odd ? even : odd;
		} else {
			odd += nums[i];
			odd = even > odd ? even : odd;
		}
	}
	return even > odd ? even : odd;
}