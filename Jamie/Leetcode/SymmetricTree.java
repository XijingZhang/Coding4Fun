//Symmetric Tree
// Solution 1: recursively

public boolean isSymmetric(TreeNode root) {
	if (root == null) {
		return true;
	}
	return isSymmetircTree(root.left, root.right);
}

public boolean isSymmetircTree(TreeNode a, TreeNode b) {
	if (a == null) return b == null;
	if (b == null) return false;
	
	if (a.val != b.val) return false;
	if (!isSymmetircTree(a.left, b.right)) return false;
	if (!isSymmetircTree(a.right, b.left)) return false;
	
	return true;
}

// Solution 2: Iterative

public boolean isSymmetric(TreeNode root) {
	if (root == null) return true;
	LinkedList<TreeNode> l = new LinkedList<TreeNode>(),
		r = new LinkedList<TreeNode>();
	l.add(root.left);
	r.add(root.right);
	
	while (!l.isEmpty() && !r.isEmpty()) {
		TreeNode temp1 = l.poll(),
			temp2 = r.poll();
		if (temp1 == null && temp2 != null || temp1 != null && temp2 == null) {
			return false;
		}
		if (temp1 != null) {
			if (temp1.val != temp2.val) return false;
			l.add(temp1.left);
			l.add(temp1.right);
			r.add(temp2.right);
			r.add(temp2.left);
		}
	}
	return true;
	
}