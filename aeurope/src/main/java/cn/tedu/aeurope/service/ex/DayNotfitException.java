package cn.tedu.aeurope.service.ex;

	/**
	 * 天數與所選景點不匹配異常(天數<城市數2倍)
	 */
public class DayNotfitException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public DayNotfitException() {
		super();
	}

	public DayNotfitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DayNotfitException(String message, Throwable cause) {
		super(message, cause);
	}

	public DayNotfitException(String message) {
		super(message);
	}

	public DayNotfitException(Throwable cause) {
		super(cause);
	}

}
