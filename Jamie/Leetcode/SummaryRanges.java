//Summary Ranges

public List<String> SummaryRanges(int[] nums) {
        List<String> SR = new ArrayList<>();
        if (nums == null || nums.length < 1) return  SR;

        int start = 0, end = 0;
        while (end < nums.length) {
            if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
                end++;
            } else {
                if(start == end) {
                    SR.add(Integer.toString(nums[start]));
                } else {
                    String str = nums[start] + "->" + nums[end];
                    SR.add(str);
                }
                ++end;//return increased end
                start = end;
            }
        }
        return SR;
}