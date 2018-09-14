package czx.wt.service.impl;

import czx.wt.mapper.UserMapper;
import czx.wt.pojo.User;
import czx.wt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 10:59
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUserByLoninName(String username) {
        return userMapper.loginUserByLoninName(username);
    }
}
