package cn.tedu.aeurope.service.ex;

	/**
	 * 飯店等級未指定異常
	 */
public class HotelUnfixedException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public HotelUnfixedException() {
		super();
	}

	public HotelUnfixedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HotelUnfixedException(String message, Throwable cause) {
		super(message, cause);
	}

	public HotelUnfixedException(String message) {
		super(message);
	}

	public HotelUnfixedException(Throwable cause) {
		super(cause);
	}

}
