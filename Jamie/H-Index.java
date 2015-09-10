// H Index

// Solution 1 O(n)
public int hIndex(int[] citations) {
	if(citations == null || citations.length == 0){
		return 0;
	}
	Arrays.sort(citations);
	for (int i = 0; i < citations.length; i++) {
		int index = citations.length - i;
		if (citations[i] >= index)
			return index;
	}
	return 0;
	
}