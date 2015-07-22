// Solution #1: O(n^2) time, O(n^2) space
public int MinPathSum(int[][] grid) {
	int row = grid.length;
	int col = grid[0].length;
	
	int[][] res = new int[row][col];
	res[0][0] = grid[0][0];
	
	for (int i = 1; i < row; i++) {
		res[i][0] = res[i-1][0] + grid[i][0];
	}
	for (int j = 1; j < col; j++) {
		res[0][j] = res[0][j-1] + grid[0][j];
	}
	for (int i = 1; i < row; i++) {
		for (int j = 1; j < col; j++) {
			res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
		}
	}
	return res[row - 1][col - 1];
}
}

// Solution #2: O(n^2) time, O(n) space
public int MinPathSum(int[][] grid) {
	int row = grid.length;
	int col = grid[0].length;
	
	int[] res = new int[col];
	Arrays.fill(res, Integer.MAX_VALUE);
	res[0] = 0;
	for (int i = 0; i < row; i++) {
		res[0] = res[0] + grid[i][0];
		for (int j = 1; j < col; j++) {
			res[j] = grid[i][j] + Math.min(res[j], res[j - 1]);
		}
	}
	return res[col - 1];
	
}