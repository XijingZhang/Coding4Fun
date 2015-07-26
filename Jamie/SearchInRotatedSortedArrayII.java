//Search in Rotate Sorted Array II
public boolean search(int[] A, int target) {
	if ( A == null || A.length==0) 
		return false;
	int left = 0;
	int right = A.length - 1;
	while (left < right) {
		int mid = left + (right - left) / 2;
		if (A[mid] ==target)
			return true;
		if (A[mid > A[left]]) {
			if (A[mid] >target && A[left] <= target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		else if (A[mid] < A[left]) {
			if (A[mid] < target && A[right] >= target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		else {
			left ++;
		}
	}
	return false;
}