package com.hd.modules.sys.shiro;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义 shiro密码比对器
 * by eric 2019-06-21 22:14:15
 */
public class BHCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String inPassword = new String(utoken.getPassword());
        inPassword = DigestUtils.md5Hex(inPassword);
        String dbPassword = (String) info.getCredentials();
        if(dbPassword.equals(inPassword)){
            return true;
        }
        return  false;
    }
}
