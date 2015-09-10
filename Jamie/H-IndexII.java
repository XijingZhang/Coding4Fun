// H-Index II
// O(logn)
public int hIndex(int[] citations) {
	int left = 0;
	int right = citations.length - 1;
	while(left <= right) {
		int mid = left + (right - left)/ 2;
		if (citations[mid] < citations.length - mid){
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	return citations.length - left;
}