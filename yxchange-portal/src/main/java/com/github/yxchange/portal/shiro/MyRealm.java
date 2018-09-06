package com.github.yxchange.portal.shiro;

import java.security.SignatureException;

import javax.xml.bind.DatatypeConverter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yxchange.service.UserService;

@Component
public class MyRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return new SimpleAuthorizationInfo();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		JWTToken jwtToken = (JWTToken) token;
        String jwt = (String) jwtToken.getPrincipal();
//        JwtPlayload jwtPlayload;
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRETKEY))
//                    .parseClaimsJws(jwt)
//                    .getBody();
//            jwtPlayload = new JwtPlayload();
//            jwtPlayload.setId(claims.getId());
//            jwtPlayload.setUserId(claims.getSubject());// 用户名
//            jwtPlayload.setIssuer(claims.getIssuer());// 签发者
//            jwtPlayload.setIssuedAt(claims.getIssuedAt());// 签发时间
//            jwtPlayload.setAudience(claims.getAudience());// 接收方
//            jwtPlayload.setRoles(claims.get("roles", String.class));// 访问主张-角色
//            jwtPlayload.setPerms(claims.get("perms", String.class));// 访问主张-权限
//        } catch (ExpiredJwtException e) {
//            throw new AuthenticationException("JWT 令牌过期:" + e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            throw new AuthenticationException("JWT 令牌无效:" + e.getMessage());
//        } catch (MalformedJwtException e) {
//            throw new AuthenticationException("JWT 令牌格式错误:" + e.getMessage());
//        } catch (SignatureException e) {
//            throw new AuthenticationException("JWT 令牌签名无效:" + e.getMessage());
//        } catch (IllegalArgumentException e) {
//            throw new AuthenticationException("JWT 令牌参数异常:" + e.getMessage());
//        } catch (Exception e) {
//            throw new AuthenticationException("JWT 令牌错误:" + e.getMessage());
//        }
        // 如果要使token只能使用一次，此处可以过滤并缓存jwtPlayload.getId()
        // 可以做签发方验证
        // 可以做接收方验证
//        return new SimpleAuthenticationInfo(jwtPlayload, Boolean.TRUE, getName());
        return new SimpleAuthenticationInfo();

	}

}
