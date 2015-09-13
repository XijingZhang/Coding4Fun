//Rotate Array
// Solution 1: reverse O(n), O(1)
public void RotateArray1(int[] nums, int k) {
	if (nums.length == 0) {
		return;
	}
	
	k = k % nums.length;
	reverse(nums, 0, nums.length - k - 1);
	reverse(nums, nums.length - k, nums.length - 1);
	reverse(nums, 0, nums.length - 1);
	
}

private void reverse(int[] nums, int start, int end) {
	while (start < end) {
		int tmp = nums[start];
		nums[start] = nums[end];
		nums[end] = tmp;
		start++;
		end--;
	}
}


// Solution 2: O(n),O(n)
public voide RotateArray2(iint[] nums, int k) {
	if (k > nums.length) {
		k = k % nums.length;
	}
	
	int[] result = new int[nums.length];
	
	for (int i = 0; i < k; i++) {
		result[i] = nums[nums.length - k + i];
	}
	
	int j = 0;
	for (int i = k; i < nums.length; i++) {
		result[i] = nums[j];
		j++;
	}
	System.arraycopy(result, 0, nums, 0, nums.length);
}

// Solution 3: O(n^2) O(1) Bubble Rotate

public static void RotateArray3(int[] nums, int k) {
	if (nums == null || k < 0) {
		throw new IllegalArgumentException("Illegal arguments!");
	}
	
	for (int i = 0; i < k; i++) {
		for (int j = nums.length - 1; j > 0; j--) {
			int tmp = nums[j];
			nums[j] = nums[j - 1];
			nums[j - 1] = tmp;
		}
	}
}