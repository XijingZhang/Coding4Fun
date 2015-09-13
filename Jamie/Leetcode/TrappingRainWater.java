//Trapping Rain Water  *
// Solution 1:
public int trap1(int[] height) {
	int result = 0;
	
	if (height == null || height.length){
		return result;
	}
	
	int[] left = new int[height.length];
	int[] right = new int[height.length];
	
	int max = height[0];
	left[0] = height[0];
	for (int i = 1; i < height.length; i++) {
		if (height[i] < max) {
			left[i] = max;
		} else {
			left[i] = height[i];
			max = height[i];
		}
	}
	
	max = height[height.length - 1];
	right[height.length - 1] = height[height.length - 1];
	for(int i = height.length - 2; i >= 0; i--) {
		if (height[i] < max) {
			right[i] = max;
		} else {
			right[i] = height[i];
			max = height[i];
		}
	}
	
	for (int i = 0; i < height.length; i++) {
		result += Math.min(left[i], right[i] - height[i]);
	}
	
	return result;
	
}

// Solution 2:
public int trap2(int[] height) {
	if (height == null || height.length == 0) {
		return 0;
	}	

    int[] maxHeights = new int[height.length + 1];
	maxHeights[0] = 0;
	for (int i = 0; i < height.length; i++) {
		maxHeights[i + 1] = Math.max(maxHeights[i], height[i]);
	}
	
	int max = 0, area = 0;
	for (int i = height.length - 1; i >= 0; i--) {
		area += Math.min(max, maxHeights[i]) > height[i] ? Math.min(max,maxHeights[i]) - height[i]: 0;
		max = Math.max(max, height[i]);
	}
	
	return area;
}

// Solution 3:
public int trap3(int[] height) {
	if (height == null || height.length == 0) {
		return 0;
	}
	
	int left = 0;
	int right = height.length - 1;
	int result = 0;
	while(left < right) {
		int min = Math.min(height[left],height[right]);
		if(height[left] == min) {
			left++;
			while (left < right && height[left] < min) {
				result += min - height[left];
				left++;
			}
		}
		else {
			right--;
			while(left < right && height[right] < min) {
				result += min - height[right];
				right--;
			}
		}
	}
	return result;
}