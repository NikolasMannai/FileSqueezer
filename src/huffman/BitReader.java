package huffman;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class BitReader extends Reader implements AutoCloseable{
	private InputStream source;
	private int bufferedBits = 0;
	private int bitBuffer = 0;
	private long bitsRead = 0;
	/**
	 * Constructor for BitReader. 
	 * @param is InputStream
	 */
	public BitReader(InputStream is) {
		source = is;
	}
	/**
	 * Reads a bit from InputStream. One bit at a time. Once the end has been reached it will return -1
	 * @return result int
	 */
	public int read() throws IOException {
		int result = 0;
		if (bufferedBits == 0) {
			bitBuffer = source.read();
			if (bitBuffer == -1)
				return -1;
			bufferedBits = 8;
		}
		bufferedBits--;
		result = (bitBuffer >> bufferedBits) & 1;
		bitsRead++;
		return result;
	}	

	public int read(char[] a, int o, int z) {
		return a.length;
	}
	/**
	 * Closes the stream
	 */
	public void close() throws IOException {
		source.close();
	}
	/**
	 * Returns amount of bits read through the input stream.
	 * @return bitsRead long 
	 */
	public long bitsRead() {
		return bitsRead;
	}
}
