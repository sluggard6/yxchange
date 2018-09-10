package com.github.yxchange.portal.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auth0.client.auth.AuthAPI;
import com.github.yxchange.portal.annotation.AuthRequired;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	AuthAPI auth = new AuthAPI("", "", "");
	
	private static final String authKeyName = "Authorization";
	
	private String getAccessToken(HttpServletRequest request) {
		String accessToken = request.getHeader(authKeyName);
		return  accessToken == null ? getAccessTokenFromCookies(request) : accessToken;
	}
	
	private String getAccessTokenFromCookies(HttpServletRequest request) {
		for(Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals(authKeyName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String source = request.getHeader("source");
//		if(!StringUtils.isEmpty(source) && (source.equalsIgnoreCase("IOS") || source.equals("android")))
//			request.getSession().setMaxInactiveInterval(A_WEEK);
		
		
//		securityManager.setSession(request.getSession());
//		auth.us
//		auth.
		if (handler instanceof HandlerMethod) {
			AuthRequired authRequired = ((HandlerMethod) handler).getMethodAnnotation(AuthRequired.class);
			if(authRequired != null) {
				String jetToken = getAccessToken(request);
				
//				if(securityManager.getPrincipal() == null) {
//					if(!StringUtils.isEmpty(source) && (source.equalsIgnoreCase("IOS") || source.equals("android"))) {
//						request.getSession().setMaxInactiveInterval(A_WEEK);
//						response.setCharacterEncoding("UTF-8");  
//						response.setContentType("application/json; charset=utf-8");
//						PrintWriter out = null ;
//						try{
//						    JSONObject res = new JSONObject();
//						    res.put("code", 401);
//						    res.put("msg","no login");
//						    res.put("data","");
//						    out = response.getWriter();
//						    out.append(res.toString());
//						    return false;
//						}
//						catch (Exception e){
//						    e.printStackTrace();
//						    response.sendError(500);
//						    return false;
//						}
//					}
//					
//					response.sendError(401,"用户未登陆");
//					return false;
//				}
//				if (!securityManager.hasPermission(request)) {
//					response.setCharacterEncoding("UTF-8");  
//					response.setContentType("application/json; charset=utf-8");
//					PrintWriter out = null ;
//					try{
//					    JSONObject res = new JSONObject();
//					    res.put("code",403);
//					    res.put("msg","no auth");
//					    res.put("data","");
//					    out = response.getWriter();
//					    out.append(res.toString());
//					    return false;
//					}
//					catch (Exception e){
//					    e.printStackTrace();
//					    response.sendError(500);
//					    return false;
//					}
//				}
//				//判断安全验证
//				int verifyType = securityManager.hasVerify(request);
//				System.out.println("verifyType:"+verifyType);
//				if(verifyType > 0) {
//					if(securityManager.getVerifyState(request.getRequestURI(), verifyType)) {
//						response.sendError(600+verifyType, "需进行安全验证");
//						return false;
//					}
//				}
//					
			}
		}
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

}
