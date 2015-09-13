// Edit distance

//DP O(mn) o(mn)
public boolean isOneEditDistance(String s, String t) {
	int len1 = s.length();
	int len2 = t.length();
	
	int[][] dp = new int[len1 + 1][len2 + 1];
	
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int j = 0; j <= len2; j++) {
		dp[0][j]= j;
	}
	
	for (int i = 0; i < len1; i++) {
		char c1 = s.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = t.charAt(j);
			
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
				
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
	
	if (dp[len1][len2] == 1) {
		return true;
	} else {
		return false;
	}
}