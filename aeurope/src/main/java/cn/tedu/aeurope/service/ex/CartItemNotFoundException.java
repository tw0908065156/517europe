package cn.tedu.aeurope.service.ex;
	/**
	 * 購物車數據cartid未找到
	 */
public class CartItemNotFoundException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public CartItemNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CartItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CartItemNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CartItemNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
