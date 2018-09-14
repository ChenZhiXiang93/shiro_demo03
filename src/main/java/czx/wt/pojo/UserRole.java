package czx.wt.pojo;

import java.io.Serializable;

/**
 * 
 * @author auto create
 * @since 1.0,2018-06-16 15:44:13
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID = 8052121928693943L;

    private Long id;//主键id

    private Long userId;//用户id

    private Long roleId;//角色id

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}
