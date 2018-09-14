package czx.wt.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author auto create
 * @since 1.0,2018-06-16 15:44:13
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1842563148799866L;

    private Integer rid;//主键id

    private String rname;//角色名

    private String description;//简介

    private Integer status;//状态

    private Set<Resource> resources;

    public Integer getId() {
        return this.rid;
    }

    public void setId(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
