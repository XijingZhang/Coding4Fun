//Paint Fence 
public int numWays(int n, int k) {
	if (n <= 1) {
		return n*k;
	}
	if (n == 2) {
		return k*k;
	}
	
	int preDiffColor = k * (k - 1);
	int preSameColor = k;
	int diffColor = 0, sameColor = 0;
	for (int i = 2; i < n; i++) {
		diffColor = (preDiffColor + preSameColor) * (k - 1);
		sameColor = preDiffColor;
		preDiffColor = diffColor;
		preSameColor = sameColor;
	}
	return (diffColor + sameColor);
	
}