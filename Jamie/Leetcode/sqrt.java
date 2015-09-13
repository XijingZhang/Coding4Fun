//Sqrt(x)
// Solution 1
public int mySqrt1(int x) {
	long low = 0;
	long high = x;
	
	while (high >= low) {
		long mid = low + (high - low) / 2;
		if ( x < mid * mid) {
			high = mid -1;
		} else {
			low = mid + 1;
		}
	}
	return (int) high
}

// Solution 2
public int mySqrt2(int x) {
	if ( x == 0)
		return 0;
	double lastY = 0;
	double y = 1;
	while (y != lastY) {
		lastY = y;
		y = (y + x / y) / 2;
	}
	return (int) (y);
}

