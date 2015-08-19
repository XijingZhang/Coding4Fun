//Factor Combinations
public List<List<Integer>> getFactors(int n) {
	return getFactors(n, 2, n);
}

List<List<Integer>> getFactors(int n, int low, int high) {
	List<List<Integer>> factors = new ArrayList<>();
	
	if (low <= n && n < high) {
		factors.add(Arrays.asList(n));
	}
	
	for (int i = low; n / i >= low; i++) {
		if (n % i == 0) {
			for (List<Integer> sub : getFactors(n / i, i, n)) {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				l.addAll(sub);
				factors.add(l);
			}
		}
	}
	
	return factors;
}