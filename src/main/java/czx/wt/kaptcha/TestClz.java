package czx.wt.kaptcha;

import java.io.FileOutputStream;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/14 0014 15:22
 * @Version: 1.0
 */
public class TestClz {
    public static void main(String[] args) {
        try{
            /*Captcha captcha = new SpecCaptcha(150,40,5);// png格式验证码*/
            /**captcha.out(new FileOutputStream("E:/1.png"));*/
            Captcha captcha = new GifCaptcha(150,40,5);//   gif格式动画验证码
            captcha.out(new FileOutputStream("E:/1.gif"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
