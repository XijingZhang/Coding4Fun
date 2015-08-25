// Roman to Integer

public int romanToInt(String s) {
	int[] a = {1000,500,100,50,10,5,1};
	char[] r = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	int ret = 0;
	int index = 0;
	int last = 0;
	
	for (int i = 0; i < s.length(); i++) {
		for (int j = 0; j < r.length; j++) {
			if (r[j] == s.charAt(i)) {
				ret = ret + a[j];
				if (last > j) {
					ret = ret - 2 * a[last];
				}
				last = j;
			}
		}
	}
	return ret;
}
