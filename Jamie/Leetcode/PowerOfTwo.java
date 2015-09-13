// Power of Two
// If a number is power of 2,
// it's binary form should be 10...0. So if we right shift a bit of the number and then left shift a bit,
// the value should be the same when the number >= 10(i.e.,2).

public boolean isPowerOfTwo(int n) {
	if (n <= 0) {
		return false;
	}
	
	while(n > 2) {
		int r = n >> 1;
		int l = r << 1;
		
		if (n - l != 0) 
			return false;
		
		n = n >> 1;
		
	}
	
	return true;
}