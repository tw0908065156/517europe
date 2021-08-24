package cn.tedu.aeurope.service.ex;

/**
 * 更新數據庫資料時發生未知錯誤，更新操作未完成
 */
public class UpdateException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
