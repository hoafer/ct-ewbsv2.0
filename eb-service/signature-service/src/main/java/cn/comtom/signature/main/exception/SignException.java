package cn.comtom.signature.main.exception;

public class SignException extends RuntimeException {
	
    private String code;
    private String msg;
    
    public SignException(String msg) {
		super();
		this.msg = msg;
	}
	public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
