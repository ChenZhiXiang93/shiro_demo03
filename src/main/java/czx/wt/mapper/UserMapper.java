package czx.wt.mapper;

import czx.wt.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 用户接口
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 10:54
 * @Version: 1.0
 */
public interface UserMapper {

    User loginUserByLoninName(@Param("username") String username);
}
