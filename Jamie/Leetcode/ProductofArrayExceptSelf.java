//Product of Array Except Self 

// Solution 1 : O(n)

public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
	
	int[] t1 = new int[nums.length];
	int[] t2 = new int[nums.length];
	
	t1[0] = 1;
	t2[nums.length - 1] = 1;
	
	for (int i = 0; i < nums.length - 1; i++) {
		t1[i + 1] = nums[i] * t1[i];
	}
	for (int i = nums.length - 1; i > 0; i--) {
		t2[i - 1] = t2[i] * nums[i];
	}
	
	for (int i = 0; i < nums.length; i++) {
		result[i] = t1[i] * t2[i];
	}
	
	return result;
}


// Solution 2 : O(1)

public int[] productExceptSelf(int[] nums) {
	int[] result = new int[nums.length];
	result[result.length - 1] = 1;
	for(int i = nums.length - 2; i >= 0; i--) {
		result[i] = result[i + 1] * nums[i + 1];
	}
	
	int left = 1;
	for(int i = 0; i < nums.length; i++) {
		result[i] *= left;
		left *= nums[i];
	}
	
	return result;
}