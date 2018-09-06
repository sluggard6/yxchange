package com.github.yxchange.portal.shiro;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

import com.github.yxchange.portal.util.JWTUtil;

public class JWTToken implements  HostAuthenticationToken, RememberMeAuthenticationToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2263178881966209301L;
	
	// 密钥
    private String token;
    /**
     * Whether or not 'rememberMe' should be enabled for the corresponding login attempt;
     * default is <code>false</code>
     */
    private boolean rememberMe = false;

    /**
     * The location from where the login attempt occurs, or <code>null</code> if not known or explicitly
     * omitted.
     */
    private String host;

	@Override
	public Object getPrincipal() {
		return JWTUtil.getUserId(token);
	}

	@Override
	public Object getCredentials() {
		return token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
