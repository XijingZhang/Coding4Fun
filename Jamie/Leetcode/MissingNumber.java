// Missing Number
//O(n) O(1)
public int missingNumber(int[] nums) {
	int result = nums.length;
	for (int i = 0; i < nums.length; i++) {
		result += (i - num[i]);
	}
	return result;
}