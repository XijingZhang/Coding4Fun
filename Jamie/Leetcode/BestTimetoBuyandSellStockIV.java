//Best Time to Buy and Sell Stock IV 
public int maxProfit(int k, int[] prices) {
	if (k == 0) {
		return 0;
	}
	
	if (k >= prices.length / 2) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
			}
		}
		return profit;
	}
	
	int n = prices.length;
	int[][] mustsell = new int[n + 1][n + 1];
	int[][] globalbest = new int[n + 1][n +1];
	
	mustsell[0][0] = globalbest[0][0] = 0;
	for (int i = 1; i <= k; i++) {
		mustsell[0][i] = globalbest[0][i] = 0;
	}
	
	for (int i = 1; i < n; i++) {
		int gainorlose = prices[i] - prices[i - 1];
		mustsell[i][0] = 0;
		for (int j = 1; j <= k; j++) {
			mustsell[i][j] = Math.max(globalbest[i - 1][j - 1] + gainorlose,
				                      mustsell[i - 1][j] + gainorlose);
			globalbest[i][j] = Math.max(globalbest[i - 1][j], mustsell[i][j]);
		}
	}
	return globalbest[n - 1][k];
}