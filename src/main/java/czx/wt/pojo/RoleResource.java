package czx.wt.pojo;

import java.io.Serializable;

/**
 * 
 * @author auto create
 * @since 1.0,2018-06-16 15:44:13
 */
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1933763625279714L;

    private Long id;//主键id

    private Long roleId;//角色id

    private Long resourceId;//资源id

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}
