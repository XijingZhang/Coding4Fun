//Single Number 
// Solution 1: XOR will return 1 only on two different bits.
public int singleNumber(int[] nums) {
	int x = 0;
	for (int n : nums) {
		x = x ^ n;
	}
	return x;
	
}

// Solution 2:
public int singleNumber(int[] nums) {
	HashSet<Integer> set = new HashSet<Integer>();
	for (int n : nums) {
		if(!set.add(n)){
			set.remove(n);
		}
	}
	Iterator<Integer> it = set.iterator();
	return it.next();
}