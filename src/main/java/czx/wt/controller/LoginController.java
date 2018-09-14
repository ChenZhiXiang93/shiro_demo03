package czx.wt.controller;

import czx.wt.excption.ValidException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String toLogin()throws Exception{
        return "login";
    }

    @RequestMapping("/loginUser")
    @ResponseBody
    public Object loginUser(@RequestParam(name = "username", required = true, defaultValue = "") String username,
                            @RequestParam(name = "password", required = true, defaultValue  = "") String password,
                            @RequestParam(name = "imageCode", required = true, defaultValue  = "") String imageCode,
                             boolean rememberMe) throws RuntimeException{

        Session session = SecurityUtils.getSubject().getSession();
        String code = (String) session.getAttribute("gifCode");
        if(!imageCode.equalsIgnoreCase(code)){
            throw new ValidException();
        }

        if (username.equals("") || username == null){
            return 1;
        } else {
            if (password.equals("") || password == null){
                return 2;
            } else {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
                subject.login(token);
                if (subject.isAuthenticated()) {

                    /**
                     * 此处保存Session 或者Redis
                     */

                    return 3;
                } else {
                    return 4;
                }
            }
        }
    }

    @RequestMapping("/index")
    public String index() throws Exception{
        return "index";
    }

    @RequestMapping("/zhuce")
    public String zhuce(){
        return "zhuce";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response) throws Exception{
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
        }
        response.reset();
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setIntHeader("Refresh", 2);
       /* SecurityUtils.getSubject().logout();*/
        return "redirect:/login";
    }
}
