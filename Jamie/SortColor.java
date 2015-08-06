// Sort Colors
public void sortColors(int[] nums) {
	if (nums == null || nums.length <= 1){
		return;
	}
	
	int pl = 0;
	int pr = nums.length - 1;
	int i = 0;
	while (i <= pr) {
		if(nums[i] == 0) {
			swap(nums, pl, i);
			pl++;
			i++;
		} else if (nums[i] == 1) {
			i++;
		} else {
			swap(nums, pr, i);
			pr--;
		}
	}
}

private void swap(int[] nums, int i, int j) {
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}