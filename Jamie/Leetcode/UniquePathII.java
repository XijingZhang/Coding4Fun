// Unique Path II
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
		return 0;
	int[] rst = new int[obstacleGrid[0].length];
	rst[0] = 1;
	for (int i = 0; i < obstacleGrid.length; i++) {
		for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					rst[j] = 0;
			} else {
				if (j > 0)
					rst[j] += rst[j - 1];
			}
		}
	}
	return rst[obstacleGrid[0].length - 1];
}