//Word Break 
// Solution 1: Naive Approach (Exceed Time Limit)
public boolean wordBreak (String s, Set<String> wordDict) {
	return wordBreakHelper(s, wordDict, 0);
}

public boolean wordBreakHelper(String s, Set<String> dict, int start) {
	if (start == s.length())
		return true;
	
	for (String a : dict) {
		int len = a.length();
		int end = start + len;
		
		if (end > s.length())
			continue;
		
		if (s.substring(start, start + len).equals(a)) {
			if (worBreakHelper(s, dict, start + len)) {
				return true;
			}
		}
		
	}
	return false;
}

// Solution 2: Dynamic Programming
//O(String length * dict size)
public boolean wordBreak(String s, Set<String> wordDict) {
	boolean[] t = new boolean[s.length() + 1];
	t[0] = true;
	
	for (int i = 0; i < s.length(); i++) {
		if (!t[i])
			continue;
		for (String a : wordDict) {
			int len = a.length();
			int end = i + len;
			if (end > s.length())
				continue;
			
			if (t[end]) continue;
			
			if (s.substring(i, end).equals(a)) {
				t[end] = true;
			}
		}
	}
	return t[s.length()];
}