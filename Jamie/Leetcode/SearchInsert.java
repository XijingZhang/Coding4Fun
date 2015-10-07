// Solution 1 : find the first position >= target
public int SearchInsert(int[] A, int target) {
	if (A == null || A.length == 0) {
		return 0;
	}
	int start = 0, end = A.length - 1;
	
	while (start + 1 < end) {
		int mid = start + (end - start) / 2;// avoid overflow
		if (A[mid] == target) {
			return mid;
		} else if (A[mid] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}
	if (A[start] >= target) {
		return start;
	} else if (A[end] >= target) {
		return end;
	} else {
		return end + 1;
	}
}

//Solution 2: find the last position < target, return + 1
public int SearchInsert(int[] A, int target) {
	if (A == null || A.length == 0) {
		return 0;
	}
	int start = 0;
	int end = A.length - 1;
	int mid;
	
	if (target < A[0]) {
		return 0;
	}
	// find the last number less than target
	while (start + 1 < end) {
		mid = start + (end - start) / 2;
		if (A[mid] == target) {
			return mid;
		} else if (A[mid] < target) {
			start = mid;
		} else {
			end = mid;
		}
	}
	
	if (A[end] == target) {
		return end;
	}
	if (A[end] < target) {
		return end + 1;
	}
	if (A[start] == target) {
		return start;
	}
	return start + 1;
 }
 