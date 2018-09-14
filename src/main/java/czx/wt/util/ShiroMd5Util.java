package czx.wt.util;

import czx.wt.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description: user的密码加密方法
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/12 0012 9:23
 * @Version: 1.0
 */
public class ShiroMd5Util {

    public static String SysMd5(String loginName,String password) {
        //加密方式
        String hashAlgorithmName = "MD5";
        //密码原值
        /*Object crdentials =user.getPassword();*/
        //以账号作为盐值
        ByteSource salt = ByteSource.Util.bytes(loginName);
        //加密1024次
        int hashIterations = 1024;
        SimpleHash hash = new SimpleHash(hashAlgorithmName,password,salt,hashIterations);
        return hash.toString();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setLoginName("wt");
        user.setName("wt");
        user.setPassword("123456");
       /* System.out.println(ShiroMd5Util.SysMd5(user));*/
    }
}
