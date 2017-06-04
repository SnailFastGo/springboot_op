package com.myspringboot.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.entity.ApiResult;
import com.myspringboot.utils.ApiResultGenerator;

/**
 * @author snailfast
 *顾名思义，@ControllerAdvice注解是用来配置控制器通知的，
 *我们可以配置过滤拦截具体一种或者多种类型的注解，添加annotations属性即可.
 *因为我们全局返回的都是Json格式的字符串，
 *所以需要再类上配置@ResponseBody注解，该注解熟知SpringMvc的开发人员都知道就不做过多的解释了.
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

	/**
	 * @ExceptionHandler注解用来配置需要拦截的异常类型，默认是全局类型。
	 * @ResponseStatus注解用于配置遇到该异常后返回数据时的StatusCode的值，我们这里默认使用值500。
	 * 在类的上方我们配置了@ControllerAdvice的annotations属性值为RestController.class，
	 * 也就是只有添加了@RestController注解的控制器才会进入全局异常处理
	 */
	@ExceptionHandler
	@ResponseStatus
	public ApiResult exceptionHandler(Exception e){
		System.out.println("拦截到异常 : " + e.getMessage());
//		e.printStackTrace();
		return ApiResultGenerator.errorResult(e.getMessage(), e);
	}
}
