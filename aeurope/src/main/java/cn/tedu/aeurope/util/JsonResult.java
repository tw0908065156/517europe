package cn.tedu.aeurope.util;

//@JsonInclude(Include.NON_NULL)
public class JsonResult<T> {
	
	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer state) {
		super();
		this.state = state;
	}
	
	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	private Integer state;
	private String message;
	private T data;
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	

}
