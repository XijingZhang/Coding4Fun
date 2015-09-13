//Pascal's Triangle 
public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> rst = new ArrayList<List<Integer>>();
	if (numRows == 0) {
		return rst;
	}
	
	List<Integer> first = new ArrayList<Integer>();
	first.add(0,1);
	rst.add(first);
	
	for (int i = 1; i < numRows; i++) {
		List<Integer> tmp = new ArrayList<Integer>(i + 1);
		for (int j = 0; j < i + 1; j++) {
			tmp.add(-1);
		}
		List<Integer> prev = new ArrayList<Integer>();
		prev = rst.get(i - 1);
		tmp.set(0, prev.get(0));
		tmp.set(i, prev.get(i - 1));
		for (int j = 1; j < i; j++) {
			tmp.set(j, prev.get(j - 1) + prev.get(j));
		}
		rst.add(tmp);
	}
	return rst;
}