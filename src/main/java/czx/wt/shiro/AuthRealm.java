package czx.wt.shiro;

import czx.wt.pojo.Resource;
import czx.wt.pojo.Role;
import czx.wt.pojo.User;
import czx.wt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description: 自定义验证和授权
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 11:36
 * @Version: 1.0
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
      * @Description: 登录验证
      * @Author: ChenZhiXiang
      * @CreateDate: 2018/9/13 0013 11:39
      * @Version: 1.0
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户名
        String username = token.getUsername();
        //根据用户名获得用户
        User user = userService.loginUserByLoninName(username);
        if (user == null){
            throw new UnknownAccountException();
        }
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());
        //放入shiro调用CredentialsMatcher检验密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),
                ByteSource.Util.bytes(user.getLoginName()),this.getClass().getName());
        return info;
    }
    /**
      * @Description: 授权
      * @Author: ChenZhiXiang
      * @CreateDate: 2018/9/13 0013 12:59
      * @Version: 1.0
      **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取缓存中的用户
        User user = (User) principalCollection.getPrimaryPrincipal();
        //用户的角色集合
        Set<String> roles = new HashSet<>();
        //用户的权限集合
        Set<String> resources = new HashSet<>();
        //获得用户的角色
        Set<Role> roles1 = user.getRoles();
        Iterator<Role> iterator = roles1.iterator();
        //遍历角色
        while (iterator.hasNext()){
            Role role = iterator.next();
            roles.add(role.getRname());
            Set<Resource> resources1 = role.getResources();
            Iterator<Resource> iterator1 = resources1.iterator();
            //遍历权限
            while (iterator1.hasNext()){
                Resource resource = iterator1.next();
                resources.add(resource.getRename());
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //把角色和权限加进去
        info.addRoles(roles);
        info.addStringPermissions(resources);
        return info;
    }
}
