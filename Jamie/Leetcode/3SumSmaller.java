// 3Sum Smaller

public int threeSumSmaller(int[] nums, int target) {
	int result = 0;
	if (nums == null || nums.length < 3) {
	    return result;
	}
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
	    for (int j = i + 1; j < nums.length - 1; j++) {
	        int k = nums.length - 1;
	        while(j < k) {
	            int sum = nums[i] + nums[j] + nums[k];
	            int diff = sum - target;
		        if (diff < 0) {
		            result++;
		        }
		        k--;
	        }
	    }
	}
    return result;
}