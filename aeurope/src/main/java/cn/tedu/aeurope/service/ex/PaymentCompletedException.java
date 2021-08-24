package cn.tedu.aeurope.service.ex;

	/**
	 * 已付款完成
	 */
public class PaymentCompletedException extends ServiceException {


	private static final long serialVersionUID = 1L;

	public PaymentCompletedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentCompletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PaymentCompletedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentCompletedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaymentCompletedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
