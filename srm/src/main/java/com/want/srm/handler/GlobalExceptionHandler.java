package com.want.srm.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.want.srm.vo.WResult;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public WResult<?> violationException(MethodArgumentNotValidException exception) {
        // 不带任何参数访问接口,会抛出 BindException
        // 因此，我们只需捕获这个异常，并返回我们设置的 message 即可
		StringBuffer sb = new StringBuffer();
		for(ObjectError objectError :exception.getBindingResult().getFieldErrors()) {
			sb.append(objectError.getDefaultMessage()).append(",");
		}
        //String message = exception.getAllErrors().get(0).getDefaultMessage();
		String message = sb.toString();
        return new WResult(HttpStatus.BAD_REQUEST.value(), message);
    }
}
