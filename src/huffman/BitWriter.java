package huffman;

import java.io.IOException;
import java.io.OutputStream;

public class BitWriter implements AutoCloseable {
	private OutputStream target;
	private int bufferedBits = 0;
	private int bitBuffer = 0;
	private long bitsWritten = 0;
	/**
	 * Constructor for a BitWriter. 
	 * @param os OutputStream
	 */
	public BitWriter(OutputStream os) {
		target = os;
	}
	/**
	 * Writes next bit in an output stream. One bit at a time
	 * @param bit 
	 * @throws IOException
	 */
	public void write(int bit) throws IOException {
		bitBuffer <<= 1;
		bitBuffer |= (1 & bit);

		bufferedBits++;
		if (bufferedBits == 8) {
			target.write(bitBuffer);
			bufferedBits = 0;
		}
		bitsWritten++;
	}
	
	public void write(char[] a, int o, int z) {
	}
	/**
	 * Closes stream and flushes the file.
	 */
	public void close() throws IOException {
		flush();
		target.close();
	}
	/**
	 * Flushes a file
	 * @throws IOException
	 */
	public void flush() throws IOException {
		while (bufferedBits != 0)
			write(0);
		target.flush();
	}
	/**
	 * Returns amount of bits written.
	 * @return bitsWritten long
	 */
	public long bitsWritten() {
		return bitsWritten;
	}
}
