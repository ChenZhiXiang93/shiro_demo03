package czx.wt.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author auto create
 * @since 1.0,2018-06-16 15:44:13
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6615714890586185L;

    private Integer id;//主键id

    private String loginName;//登陆名

    private String name;//用户名

    private String password;//密码

    private Set<Role> roles;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
