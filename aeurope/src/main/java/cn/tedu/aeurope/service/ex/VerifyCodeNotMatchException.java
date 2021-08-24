package cn.tedu.aeurope.service.ex;

	/**
	 * 驗證碼不匹配
	 */
public class VerifyCodeNotMatchException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public VerifyCodeNotMatchException() {
		super();
	}

	public VerifyCodeNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VerifyCodeNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public VerifyCodeNotMatchException(String message) {
		super(message);
	}

	public VerifyCodeNotMatchException(Throwable cause) {
		super(cause);
	}

}
