// Valid Anagram
// Solution 1
public boolean isAnagram1(String s, String t) {
	if (s == null || t == null || s.length() != t.length()) {
		return false;
	}
	
	int[] letterCounter = new int[26];
	for(int i = 0; i < s.length(); i++) {
		letterCounter[s.charAt(i) - 'a']++;
		letterCounter[t.charAt(i) - 'a']--;
	}
	
	for(int count: letterCounter) {
		if(count != 0) {
			return false;
		}
	}
	
	return true;
}

// Solution 2:
public boolean isAnagram2(String s, String t) {
	if (s == null || t == null || s.length() != t.length()) {
		return false;
	}
	if (s == null && t == null) {
		return true;
	}
	
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	for (int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		if (map.containsKey(c)) {
			map.put(c,map.get(c) + 1);
		} else {
			map.put(c, 1);
		}
	}
	for (int i = 0; i < t.length(); i++) {
		char c = t.charAt(i);
		if (map.containsKey(c) && map.get(c) > 0) {
			map.put(c,map.get(c) - 1);
		} else {
			return false;
		}
	}
	
	for (Integer value : map.values()) {
		if (value != 0) {
			return false;
		}
	}
	return true;
}