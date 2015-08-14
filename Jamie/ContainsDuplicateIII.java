//Contains Duplicate III
// Solution 1
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	if (k < 1 || t < 0)
		return false;
	TreeSet<Integer> set = new TreeSet<Integer>();
	
	for (int i = 0; i < nums.length; i++) {
		int c = nums[i];
		if ((set.floor(c) != null && c <= set.floor(c) + t) 
			|| (set.ceiling(c) != null && c >= set.ceiling(c) - t))
				return true;
		set.add(c);
		
		if (i >= k)
			set.remove(nums[i - k]);
	}
	return false;
}

// Solution 2 leetcode doesn't support class SortedSet
public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	if (k < 1 || t < 0)
		return false;
	SortedSet<Long> set = new TreeSet<Long>();
	
	for (int j = 0; j < nums.length; j++) {
		long leftBoundary = (long) nums[j] - t;
		long rightBoundary = (long) nums[j] + t + 1;
		SortedSet<long> subSet = set.subSet(leftBoundary, rightBoundary);
		
		if (!subSet.isEmpty())
			return true;
		set.add((long) nums[j]);
		if (j >= k) {
			set.remove((long) nums[j - k]);
		}
	}
	return false;
}