package czx.wt.shiro;

import czx.wt.util.ShiroMd5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @Description: 自定义密码加密
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 14:14
 * @Version: 1.0
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String loginName = utoken.getUsername();
        //获得用户输入的密码
        String inPassword = new String(utoken.getPassword());
        inPassword = ShiroMd5Util.SysMd5(loginName,inPassword);
        String dbPassword = (String) info.getCredentials();
        System.out.println(inPassword+" "+dbPassword);
        if (!this.equals(inPassword,dbPassword)){
            throw new IncorrectCredentialsException();
        }
        return true;
    }
}
