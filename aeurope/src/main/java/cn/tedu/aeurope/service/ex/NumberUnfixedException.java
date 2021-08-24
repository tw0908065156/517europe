package cn.tedu.aeurope.service.ex;

	/**
	 * 人數未指定異常
	 */
public class NumberUnfixedException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public NumberUnfixedException() {
		super();
	}

	public NumberUnfixedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NumberUnfixedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberUnfixedException(String message) {
		super(message);
	}

	public NumberUnfixedException(Throwable cause) {
		super(cause);
	}

}
