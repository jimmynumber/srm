package com.want.exception;


//@ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR,reason="600")
public class BusinessException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//自定义错误码
    private Integer code;
    //自定义构造器，必须输入错误码及内容
    public BusinessException(int code,String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(ResultEnum enum1) {
        super(enum1.getMsg());
        this.code = enum1.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}


/*
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private Integer code;  //错误码

    public BusinessException() {}

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
*/
