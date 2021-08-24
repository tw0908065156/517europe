package cn.tedu.aeurope.service.ex;

/**
 * 刪除數據庫資料時發生未知錯誤，刪除操作未完成
 */
public class DeleteException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super();

	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public DeleteException(String message) {
		super(message);

	}

	public DeleteException(Throwable cause) {
		super(cause);
		
	}

}
