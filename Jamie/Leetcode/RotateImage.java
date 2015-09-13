// Rotate Image (in place)
// Solution 1:
public void RotateImage1(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return;
	}
	
	int length = matrix.length;
	
	for (int i = 0; i < length / 2; i++) {
		for (int j = 0; j < (length + 1) / 2; j++) {
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[length - j - 1][i];
			matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
			matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
			matrix[j][length - i - 1] = tmp;
		}
	}
}

//Solution 2:
public void RotateImage2(int[][] matrix) {
	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		return;
	}
	
	int length = matrix.length;
	int mid = length / 2;
	// reverse top-bottom, swap the ith row with (n-i)th row
	for (int i = 0; i < mid; i++) {
		for ( int j = 0; j < length; j++) {
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[length - 1 - i][j];
			matrix[length - 1 - i][j] = tmp;
		}
	}
	
	// swap symmetry
	for (int i = 0; i < length; i++) {
		for ( int j = i + 1; j < length; j++) {
			int tmp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = tmp;
		}
	}
}