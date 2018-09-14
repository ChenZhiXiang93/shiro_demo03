package czx.wt.service;

import czx.wt.pojo.User;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 10:59
 * @Version: 1.0
 */
public interface UserService {

    User loginUserByLoninName(String username);
}
