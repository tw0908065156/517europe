package cn.tedu.aeurope.service.ex;

	/**
	 * 天數未指定異常
	 */
public class DayUnfixedException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DayUnfixedException() {
		super();
	}

	public DayUnfixedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DayUnfixedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DayUnfixedException(String message) {
		super(message);
	}

	public DayUnfixedException(Throwable cause) {
		super(cause);
	}

}
