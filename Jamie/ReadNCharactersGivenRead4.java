//Read N Characters Given Read4

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int readByteCount = 0;
		boolean eof = false;
		while(readByteCount < n && !eof) {
			int c = read4(buffer);
			if (c < 4) {
				eof = true;
			}
			int bytes = Math.min(n - readByteCount, c);
			System.arraycopy(buffer, 0, buf, readByteCount, bytes);
			readByteCount += bytes;
		}
		
		return readByteCount;
        
    }
}