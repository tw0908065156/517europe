package cn.tedu.aeurope.service.ex;

	/**
	 * 驗證碼還在有效期，不能重覆發送
	 */
public class TimeNotExpiredException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public TimeNotExpiredException() {
		super();
	}

	public TimeNotExpiredException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TimeNotExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeNotExpiredException(String message) {
		super(message);
	}

	public TimeNotExpiredException(Throwable cause) {
		super(cause);
	}

}
