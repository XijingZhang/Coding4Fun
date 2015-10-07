//Find Peak Element
// O(n)
public int FindPeakElement(int[] nums) {
	int max = nums[0];
	int index = 0;
	for (int i = 1; i <= nums.length - 2; i++) {
		int prev = nums[i - 1];
		int curr = nums[i];
		int next = nums[i + 1];
		
		if (curr > prev && curr > next && curr > max) {
			index = i;
			max = curr;
		}
	}
	if (nums[nums.length - 1] > max) {
		return nums.length - 1;
	}
	return index;
}

// Optimal soluiton : O(lgn)

public int findPeakElement(int[] nums) {
     int start = 0, end = nums.length  - 1; 
     while(start + 1 <  end) {
		 int mid = (start + end) / 2;
         if(nums[mid] < nums[mid - 1]) {
			 end = mid;
         } else if(nums[mid] < nums[mid + 1]) {
			 start = mid;
         } else {
             end = mid;
         }
    }
    if(nums[start] < nums[end]) {
		return end;
    } else { 
        return start;
    }
}