//Climbing Stairs 

// Solution 1:
public int climbStairs(int n) {
	if (n == 1)
		return 1;
	if (n == 2)
		return 2;
	
	return climbStairs(n - 1) + climbStairs(n - 2);
}

// Solution 2:
public int climbStairs(int n) {
	int[] res = new int[n + 1];
	res[0] = 1;
	res[1] = 1;
	for (int i = 2; i <= n; i++) {
		res[i] = res[i - 1] + res[i - 2];
	}
	return res[n];
}