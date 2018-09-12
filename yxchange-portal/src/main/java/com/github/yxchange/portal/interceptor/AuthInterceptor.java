package com.github.yxchange.portal.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.auth0.client.auth.AuthAPI;

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
		getAccessToken(request);
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
	}

}
