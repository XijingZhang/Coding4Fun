//Closest Binary Search Tree Value

public int closestValue(TreeNode root, double target) {
        if (root.right == null && root.left == null)
        return root.val;
        if ((root.val < target && root.right == null) || (root.val > target && root.left == null))
        return root.val;
	    double minDiff = Min_Diff(root, target);
	    int result = (int) (minDiff + target);
	    return result;
}

public static double Min_Diff(TreeNode root, double target) {
    if (root == null)
		return Double.MAX_VALUE;
	if (root.val < target) 
		return smallDiff(root.val - target, Min_Diff(root.right, target));
	else
		return smallDiff(root.val - target, Min_Diff(root.left, target));
	
}

private static double smallDiff(double a, double b) {
	if (Math.abs(a) > Math.abs(b))
		return b;
	return a;
}
