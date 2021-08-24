package cn.tedu.aeurope.service.ex;

/**
 * Email帳號重覆
 *
 */
public class ClientEmailDuplicateException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ClientEmailDuplicateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientEmailDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ClientEmailDuplicateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClientEmailDuplicateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ClientEmailDuplicateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
