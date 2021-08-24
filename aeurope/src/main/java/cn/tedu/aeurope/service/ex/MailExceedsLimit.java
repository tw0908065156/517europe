package cn.tedu.aeurope.service.ex;

	/**
	 * 發送郵件次數超過限制
	 */
public class MailExceedsLimit extends ServiceException {

	private static final long serialVersionUID = 1L;

	public MailExceedsLimit() {
		super();
	}

	public MailExceedsLimit(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MailExceedsLimit(String message, Throwable cause) {
		super(message, cause);
	}

	public MailExceedsLimit(String message) {
		super(message);
	}

	public MailExceedsLimit(Throwable cause) {
		super(cause);
	}

}
