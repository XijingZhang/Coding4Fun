// Shortest Word Distance III
public int shortestWordDistance(String[] words, String word1, String word2) {
	Map<String, List<Integer>> map = new HashMap<>();
	
	for (int i = 0; i < words.length; i++) {
		String s = words[i];
		List<Integer> list;
		if (map.containsKey(s)) {
			list = map.get(s);
		} else {
			list = new ArrayList<>();
		}
		list.add(i);
		map.put(s, list);
	}
	
	List<Integer> l1 = map.get(word1);
	List<Integer> l2 = map.get(word2);
	
	int min = Integer.MAX_VALUE;
	
	for (int a : l1) {
		for (int b : l2) {
			int dist = Math.abs(b - a);
			if (dist != 0) {
				min = Math.min(dist, min);
			}
		}
	}
	return min;
}