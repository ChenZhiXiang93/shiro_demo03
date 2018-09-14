package czx.wt.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
  * @Description: 方法作用描述
  * @Author: ChenZhiXiang
  * @CreateDate: 2018/9/13 0013 10:53
  * @Version: 1.0
* */
public class Resource implements Serializable {

    private static final long serialVersionUID = 8103117310956838L;

    private BigInteger reid;//主键

    private String rename;//资源名称

    private String url;//资源路径

    private String redescription;//资源介绍

    public BigInteger getId() {
        return reid;
    }

    public void setId(BigInteger reid) {
        this.reid = reid;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return this.redescription;
    }

    public void setDescription(String redescription) {
        this.redescription = redescription;
    }
}
