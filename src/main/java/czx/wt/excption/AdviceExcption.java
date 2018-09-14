package czx.wt.excption;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 21:05
 * @Version: 1.0
 */
@ControllerAdvice
public class AdviceExcption {

    //密码异常捕捉
    @ExceptionHandler(value = IncorrectCredentialsException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String passException(IncorrectCredentialsException e) throws JsonProcessingException {
        System.out.println("---------------------->" + e);
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("respCode","1001");
        respMap.put("msg","密码错误");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(respMap);
    }

    //用户异常捕捉
    @ExceptionHandler(value = UnknownAccountException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String accountException(UnknownAccountException e) throws JsonProcessingException {
        System.out.println("---------------------->" + e);
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("respCode","1002");
        respMap.put("msg","用户名不存在");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(respMap);
    }

    //用户异常捕捉
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String accountException(UnauthorizedException e) throws JsonProcessingException {
        System.out.println("---------------------->" + e);
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("respCode","1003");
        respMap.put("msg","无权限");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(respMap);
    }

    //验证码异常捕捉
    @ExceptionHandler(value = ValidException.class)
    @ResponseBody // 在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public String imageCodeException(ValidException e) throws JsonProcessingException {
        Map<String,Object> respMap = new HashMap<>();
        respMap.put("respCode","1004");
        respMap.put("msg","验证码错误");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(respMap);
    }
}
