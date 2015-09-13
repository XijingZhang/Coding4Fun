//Path Sum II 

public List<List<Integer>> pathSumII(TreeNode root, int sum) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (root == null)
		return result;
	
	ArrayList<Integer> l = new ArrayList<Integer>();
	l.add(root.val);
	dfs(root, sum - root.val, result, l);
	return result;
}

public void dfs(TreeNode r, int sum, List<List<Integer>> result, ArrayList<Integer> l) {
	if(r.left == null && r.right == null && sum == 0) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(l);
		result.add(temp);
	}
	
	if (r.left != null) {
		l.add(r.left.val);
		dfs(r.left, sum - r.left.val, result, l);
		l.remove(l.size() - 1);
	}
	
	if (r.right != null) {
		l.add(r.right.val);
		dfs(r.right, sum - r.right.val, result, l);
		l.remove(l.size() - 1);
	}
}