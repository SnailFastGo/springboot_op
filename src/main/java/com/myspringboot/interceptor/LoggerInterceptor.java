package com.myspringboot.interceptor;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.myspringboot.entity.LoggerEntity;
import com.myspringboot.repository.user.LoggerRepository;
import com.myspringboot.utils.LoggerUtils;

public class LoggerInterceptor implements HandlerInterceptor{
	
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	    //创建日志实体
        LoggerEntity loggerEntity = new LoggerEntity();
        
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //设置sessionId
        loggerEntity.setSessionId(sessionId);
        
        //设置请求方法
        String method = request.getMethod();
        loggerEntity.setMethod(method);
        
        //设置访问协议
        String protocol = request.getProtocol();
        loggerEntity.setProtocol(protocol);
        
        //请求路径
        String url = request.getRequestURI();
        //设置请求地址
        loggerEntity.setUrl(url);
        
        //获取请求参数信息
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置请求参数内容json字符串
        loggerEntity.setParamData(paramData);
        
        //设置客户端ip
        loggerEntity.setClientIp(LoggerUtils.getCliectIp(request));
        
        long requestTime = System.currentTimeMillis();
        loggerEntity.setTime(new Timestamp(requestTime));
        
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, requestTime);
        request.setAttribute(LOGGER_ENTITY, loggerEntity);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	       //获取响应状态码
        int status = response.getStatus();
        
        //当前时间
        long currentTime = System.currentTimeMillis();
        
        //请求开始时间
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        
        //获取本次请求日志实体
        LoggerEntity loggerEntity = (LoggerEntity) request.getAttribute(LOGGER_ENTITY);
        
        //设置请求时间差
        loggerEntity.setTimeConsuming(String.valueOf(currentTime - time));
        
        //设置返回时间
        loggerEntity.setReturnTime(currentTime + "");
        
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status + "");
        
        //设置返回值,返回值需要配置AOP拦截，待完善
//        String returnData = null;
        
        LoggerRepository loggerDAO = getDAO(LoggerRepository.class, request);
        loggerDAO.save(loggerEntity);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
    private <T> T getDAO(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
	
}
