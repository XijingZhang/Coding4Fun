// Meeting room
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public boolean canAttendMeetings(Interval[] intervals) {
	Arrays.sort(intervals, (o1, o2) -> {
		int range = o1.start - o2.start;
		return range == 0 ? o1.end - o2.end : range;
	});
	
	for (int i = 1; i < intervals.length; i++) {
		Interval i1 = intervals[i - 1];
		Interval i2 = intervals[i];
		if (i1.end > i2.start) {
			return false;
		}
	}
	return true;
}