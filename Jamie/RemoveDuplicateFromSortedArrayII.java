//Remove Duplicates from Sorted Array II *
public int removeDuplicates(int[] nums) {
	if(nums == null || nums.length == 0){
		return 0;
	}
	
	int pre = nums[0];
	boolean flag = false;
	int count = 0;
	
	for (int i = 1; i < nums.length; i++) {
		int curr = nums[i];
		
		if (curr == pre) {
			if(!flag) {
				flag = true;
				continue;
			} else {
				count++;
			}
		} else {
			pre = curr;
			flag = false;
		}
	}
	return nums.length - count;
}