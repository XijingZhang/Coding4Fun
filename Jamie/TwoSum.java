// Two sum with unsorted list
// Return indices of the two numbers such that they add up to the target, 
// where index1 must be less than index2. 

public int[] TwoSum(int[] nums, int target) {
	// Creat an empty HashMap
	Map<Integer, Integer> map = new HashMap<>();//"<>" valid in source 7
	
	for (int i = 0; i < nums.length; i++) {
		int x = nums[i];
		// If Hashtable didn't contains key of (target-x) at this time, then add it as new key:value, so that when it is being searched later, the returned index will be in ascending order
		if (map.containsKey(target - x)) {
			return new int[]{
				map.get(target - x) + 1, i + 1
			};
		}
		map.put(x,i);
		
	}
	// If the initial capacity is negative or the load factor is nonpositive
	throw new IllegalArgumentException("No two sum solution");
}