//Two Sum II
// Assume input is already sorted.

//Binary tree
//O(nlogn) runtime, O(1) space

public int[] TwoSumII(int[] nums, int target) {
	for (int i = 0; i < nums.length; i++) {
		int j = BinarySearch(nums, target - nums[i], i + 1);
		if (j != -1) {
			return new int[] {i+1, j+1};
		}
	}
	throw new IllegalArgumentException("No two sum solution");
}
private int BinarySearch(int[] A, int key, int Start) {
	int L = Start, R = A.length - 1;
	while (L < R) {
		int M = (L + R) / 2;
		if (A[M] < key) {
			L = M + 1;
		} else {
			R = M;
		}
	}
	return (L == R && A[L] == key) ? L : -1;
}


//Two pointers
//O(n) runtime, O(1) space
public int[] TwoSumIIs(int[] nums, int target) {
	int i = 0, j = nums.length - 1;
	while (i < j){
		int sum = nums[i] + nums[j];
		if (sum > target){
			j--;
		} else if (sum < target) {
			i++;
		} else {
			return new int[]{i + 1, j + 1};
		}
	}
	throw new IllegalArgumentException("No two sum solution");
}