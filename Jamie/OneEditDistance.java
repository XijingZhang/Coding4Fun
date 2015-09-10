// One Edit Distance


// O(n) O(1)
public boolean isOneEditDistance(String s, String t) {
	int len1 = s.length();
	int len2 = t.length();
	
	if (len1 > len2) return isOneEditDistance(t, s);
	
	if (len2 - len1 > 1) return false;
	
	int i = 0, shift = len2 - len1;
	
	while (i < len1 && s.charAt(i) == t.charAt(i)) 
		++i;
	if (i == len1)
		return shift > 0;
	if (shift == 0)
		i++;
	while( i < len1 && s.charAt(i) == t.charAt(i + shift))
		i++;
	
	return i == len1;
}
