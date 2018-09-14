package czx.wt.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 16:11
 * @Version: 1.0
 */
@Controller
public class TestController {

    @GetMapping("/t")
    @RequiresPermissions("addUser")
    public String t()throws UnauthorizedException {
        return "hello";
    }

    @GetMapping("/s")
    @RequiresRoles("经理")
    public String s()throws UnauthorizedException{
        return "word";
    }
}
