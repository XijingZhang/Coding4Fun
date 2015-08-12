//Invert Binary Tree 
// Solution 1 Recursive
public TreeNode invertTree(TreeNode root) {
	if (root != null) {
		helper(root);
	}
	return root;
}

public void helper(TreeNode p) {
	TreeNode temp = p.left;
	p.left = p.right;
	p.right = temp;
	
	if(p.left != null){
		helper(p.left);
	}
	if(p.right != null) {
		helper(p.right);
	}
}

// Solution 2 Iterative
public TreeNode invertTree(TreeNode root) {
	LinkedList<TreeNode> l = new LinkedList<TreeNode>();
	
	if (root != null) {
		l.add(root);
	}
	
	while(!l.isEmpty()){
		TreeNode p = l.poll();
		if(p.left != null)
			l.add(p.left);
		if(p.right != null)
			l.add(p.right);
		
		TreeNode temp = p.left;
		p.left = p.right;
		p.right = temp;
	}
	return root;
}