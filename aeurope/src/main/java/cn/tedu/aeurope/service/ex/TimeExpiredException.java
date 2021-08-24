package cn.tedu.aeurope.service.ex;

/**
 * 驗證碼時效已過
 */
public class TimeExpiredException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public TimeExpiredException() {
		super();
	}

	public TimeExpiredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TimeExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeExpiredException(String message) {
		super(message);
	}

	public TimeExpiredException(Throwable cause) {
		super(cause);
	}

}
