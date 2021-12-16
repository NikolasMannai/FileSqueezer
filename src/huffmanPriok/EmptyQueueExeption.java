package huffmanPriok;

public class EmptyQueueExeption extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * skickar ett tomt exeption.
	 */
	public EmptyQueueExeption() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * sickar ett exeption med ett fel medelande.
	 * @param message
	 */
	public EmptyQueueExeption(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * sickar ett exeption med en orsak.
	 * @param cause
	 */
	public EmptyQueueExeption(final Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 *  sickar ett exeption med ett fel medelande och en orsak.
	 * @param message
	 * @param cause
	 */
	public EmptyQueueExeption(final String message,final Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 *  sickar ett exeption med ett fel medelande och en orsak,nertystands meddelande och en stacktrace.
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public EmptyQueueExeption(final String message,final Throwable cause,
			final boolean enableSuppression,final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}
