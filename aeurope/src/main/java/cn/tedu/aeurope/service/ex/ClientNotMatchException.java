package cn.tedu.aeurope.service.ex;
	/**
	 * 登入用戶名與存取數據不匹配
	 */
public class ClientNotMatchException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public ClientNotMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ClientNotMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClientNotMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ClientNotMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
